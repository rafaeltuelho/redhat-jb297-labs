package br.net.rafaeltuelho.jb297.unit3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.net.rafaeltuelho.jb297.unit3.model.Ticket;
import br.net.rafaeltuelho.jb297.unit3.model.Ticket_;

@RunWith(Arquillian.class)
public class TicketEntityTest {

	@Deployment
	public static Archive<?> createDeployment() {
		// You can use war packaging...
		@SuppressWarnings("unused")
		WebArchive war = ShrinkWrap
				.create(WebArchive.class, "test.war")
				.addPackage(Ticket.class.getPackage())
//				.addAsManifestResource(
//						new File("src/main/resources/META-INF",
//								"persistence.xml"))
//				.addAsManifestResource("test-persistence.xml", "persistence.xml")
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource("arquillian-ds.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

		// or jar packaging...
		JavaArchive jar = ShrinkWrap
				.create(JavaArchive.class)
				.addPackage(Ticket.class.getPackage())
				.addAsManifestResource("test-persistence.xml", "persistence.xml")
				.addAsManifestResource("arquillian-ds.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

		// choose your packaging here
		return war;
	}

	private static final String ENTITY_NAME = Ticket.class
			.getSimpleName();

	private static final String[] MOCK_DATA = { "Ticket 1", "Ticket 2", "Ticket 3" };
	private static List<String> licenceNumbers;

	@PersistenceContext
	EntityManager em;

	@Inject
	UserTransaction utx;

	@Before
	public void preparePersistenceTest() throws Exception {
		licenceNumbers = new ArrayList<String>();
		clearData();
		insertData();
		startTransaction();
	}

	private void clearData() throws Exception {
		utx.begin();
		em.joinTransaction();
		System.out.println("Dumping old records...");
		em.createQuery("delete from " + ENTITY_NAME).executeUpdate();
		utx.commit();
	}

	private void insertData() throws Exception {
		utx.begin();
		em.joinTransaction();
		System.out.println("Inserting records...");
		long id = 0L;

		for (String name : MOCK_DATA) {
			Ticket entity = new Ticket();
			
			entity.setLicensenbr(UUID.randomUUID().toString());	
			entity.setFine_amt(BigDecimal.TEN);

			em.persist(entity);
			licenceNumbers.add(entity.getLicensenbr());
			
			id++;
		}
		utx.commit();
		// reset the persistence context (cache)
		em.clear();
	}

	private void startTransaction() throws Exception {
		utx.begin();
		em.joinTransaction();
	}

	@After
	public void commitTransaction() throws Exception {
		utx.commit();
	}

	@Test
	public void shouldFindAllUsingJpqlQuery() throws Exception {
		// given
		String fetchingAllInJpql = "select e from " + ENTITY_NAME
				+ " e order by e.id";

		// when
		System.out.println("Selecting (using JPQL)...");
		List<Ticket> entities = em.createQuery(fetchingAllInJpql,
				Ticket.class).getResultList();

		// then
		System.out.println("Found " + entities.size()
				+ " entities (using JPQL):");
		assertContainsAllEntity(entities);
	}

	@Test
	public void shouldFindAllUsingCriteriaApi() throws Exception {
		// given
		CriteriaBuilder builder = em.getCriteriaBuilder();

		CriteriaQuery<Ticket> criteria = builder
				.createQuery(Ticket.class);

		Root<Ticket> entity = criteria.from(Ticket.class);
		criteria.select(entity);
		// TIP: If you don't want to use the JPA 2 Metamodel,
		// you can change the get() method call to get("id")
		criteria.orderBy(builder.asc(entity.get(Ticket_.ticketnbr)));
		// No WHERE clause, which implies select all

		// when
		System.out.println("Selecting (using Criteria)...");
		List<Ticket> entities = em.createQuery(criteria).getResultList();

		// then
		System.out.println("Found " + entities.size()
				+ " entities (using Criteria):");
		assertContainsAllEntity(entities);
	}
	
	@Test
	public void updateEntity() throws Exception{
		
		// given
		CriteriaBuilder builder = em.getCriteriaBuilder();

		CriteriaQuery<Ticket> criteria = builder
				.createQuery(Ticket.class);

		Root<Ticket> entity = criteria.from(Ticket.class);
		criteria.where(builder.equal(entity.get(Ticket_.licensenbr), licenceNumbers.get(0)));

		Ticket ticket = em.createQuery(criteria).getSingleResult();

		// then
		System.out.println("Found Licence Number: " + ticket.getLicensenbr());
		System.out.println("Found Ticket Number: " + ticket.getTicketnbr());	
		System.out.println("Ticket fine amount: " + ticket.getFine_amt());
		
		ticket.setFine_amt(BigDecimal.ONE);
		
		em.merge(ticket);
		System.out.println("Ticket fine amount: " + ticket.getFine_amt());		
		
		utx.commit();
	}

	private static void assertContainsAllEntity(
			Collection<Ticket> retrievedEntities) {
		
		assertEquals(MOCK_DATA.length, retrievedEntities.size());
		
		final Set<String> retrievedData = new HashSet<String>();
		
		for (Ticket entity : retrievedEntities) {
			System.out.println("* " + entity);
			retrievedData.add(entity.getLicensenbr());
		}
		assertTrue(retrievedData.containsAll(licenceNumbers));
	}

}

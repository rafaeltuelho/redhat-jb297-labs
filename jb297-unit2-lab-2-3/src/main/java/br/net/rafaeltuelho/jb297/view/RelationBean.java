package br.net.rafaeltuelho.jb297.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.net.rafaeltuelho.jb297.unit2.model.Relation;

/**
 * Backing bean for Relation entities.
 * <p>
 * This class provides CRUD functionality for all Relation entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class RelationBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Relation entities
    */

   private String id;

   public String getId()
   {
      return this.id;
   }

   public void setId(String id)
   {
      this.id = id;
   }

   private Relation relation;

   public Relation getRelation()
   {
      return this.relation;
   }

   @Inject
   private Conversation conversation;

   @PersistenceContext(type = PersistenceContextType.EXTENDED)
   private EntityManager entityManager;

   public String create()
   {

      this.conversation.begin();
      return "create?faces-redirect=true";
   }

   public void retrieve()
   {

      if (FacesContext.getCurrentInstance().isPostback())
      {
         return;
      }

      if (this.conversation.isTransient())
      {
         this.conversation.begin();
      }

      if (this.id == null)
      {
         this.relation = this.example;
      }
      else
      {
         this.relation = findById(getId());
      }
   }

   public Relation findById(String id)
   {

      return this.entityManager.find(Relation.class, id);
   }

   /*
    * Support updating and deleting Relation entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.relation);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.relation);
            return "view?faces-redirect=true&id=" + this.relation.getType();
         }
      }
      catch (Exception e)
      {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
         return null;
      }
   }

   public String delete()
   {
      this.conversation.end();

      try
      {
         Relation deletableEntity = findById(getId());

         this.entityManager.remove(deletableEntity);
         this.entityManager.flush();
         return "search?faces-redirect=true";
      }
      catch (Exception e)
      {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
         return null;
      }
   }

   /*
    * Support searching Relation entities with pagination
    */

   private int page;
   private long count;
   private List<Relation> pageItems;

   private Relation example = new Relation();

   public int getPage()
   {
      return this.page;
   }

   public void setPage(int page)
   {
      this.page = page;
   }

   public int getPageSize()
   {
      return 10;
   }

   public Relation getExample()
   {
      return this.example;
   }

   public void setExample(Relation example)
   {
      this.example = example;
   }

   public void search()
   {
      this.page = 0;
   }

   public void paginate()
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

      // Populate this.count

      CriteriaQuery<Long> countCriteria = builder.createQuery(Long.class);
      Root<Relation> root = countCriteria.from(Relation.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Relation> criteria = builder.createQuery(Relation.class);
      root = criteria.from(Relation.class);
      TypedQuery<Relation> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Relation> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      String type = this.example.getType();
      if (type != null && !"".equals(type))
      {
         predicatesList.add(builder.like(root.<String> get("type"), '%' + type + '%'));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Relation> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Relation entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Relation> getAll()
   {

      CriteriaQuery<Relation> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Relation.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Relation.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final RelationBean ejbProxy = this.sessionContext.getBusinessObject(RelationBean.class);

      return new Converter()
      {

         @Override
         public Object getAsObject(FacesContext context,
               UIComponent component, String value)
         {

            return ejbProxy.findById(String.valueOf(value));
         }

         @Override
         public String getAsString(FacesContext context,
               UIComponent component, Object value)
         {

            if (value == null)
            {
               return "";
            }

            return String.valueOf(((Relation) value).getType());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Relation add = new Relation();

   public Relation getAdd()
   {
      return this.add;
   }

   public Relation getAdded()
   {
      Relation added = this.add;
      this.add = new Relation();
      return added;
   }
}
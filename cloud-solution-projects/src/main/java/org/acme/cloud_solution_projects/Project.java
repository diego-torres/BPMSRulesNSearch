package org.acme.cloud_solution_projects;

/**
 * This class was automatically generated by the data modeler tool.
 */

@javax.persistence.Entity
@org.kie.api.definition.type.Label("Project Data Object")
@org.kie.api.definition.type.Description("A project is a description unit to the job request.")
public class Project implements java.io.Serializable
{

   static final long serialVersionUID = 1L;

   @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "PROJECT_ID_GENERATOR")
   @javax.persistence.Id
   @javax.persistence.SequenceGenerator(sequenceName = "PROJECT_ID_SEQ", name = "PROJECT_ID_GENERATOR")
   @org.kie.api.definition.type.Label("Project Id")
   private java.lang.Long id;

   @org.kie.api.definition.type.Label("Title")
   private java.lang.String title;

   @org.kie.api.definition.type.Label("Email")
   private java.lang.String email;

   @org.kie.api.definition.type.Label(value = "Price")
   private java.lang.Double price;

   @org.kie.api.definition.type.Label(value = "Information Completed")
   private java.lang.Boolean informationCompleted = false;

   public Project()
   {
   }

   public java.lang.Long getId()
   {
      return this.id;
   }

   public void setId(java.lang.Long id)
   {
      this.id = id;
   }

   public java.lang.String getTitle()
   {
      return this.title;
   }

   public void setTitle(java.lang.String title)
   {
      this.title = title;
   }

   public java.lang.String getEmail()
   {
      return this.email;
   }

   public void setEmail(java.lang.String email)
   {
      this.email = email;
   }

   public java.lang.Double getPrice()
   {
      return this.price;
   }

   public void setPrice(java.lang.Double price)
   {
      this.price = price;
   }

   public java.lang.Boolean getInformationCompleted()
   {
      return this.informationCompleted;
   }

   public void setInformationCompleted(java.lang.Boolean informationCompleted)
   {
      this.informationCompleted = informationCompleted;
   }

   public Project(java.lang.Long id, java.lang.String title,
         java.lang.String email, java.lang.Double price,
         java.lang.Boolean informationCompleted)
   {
      this.id = id;
      this.title = title;
      this.email = email;
      this.price = price;
      this.informationCompleted = informationCompleted;
   }

}
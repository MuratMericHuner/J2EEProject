package myprojet.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity()
@Table(name="activity")
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue(strategy =GenerationType.IDENTITY)
	 int id;
	 
	 @Column(name="year")
	 @NotNull
	 private int year;
	 
	 @Column(name="nature")
	 @NotNull
	 private String nature;
	 
	 @Column(name="titre")
	 @NotNull
	 private String titre;
	 
	 @Column(name="description")
	 private String description;
	 
	 @Column(name="site")
	 private String siteweb;
	 
	 public Activity() {
			super();
		}
	 
	 public Activity(String titre, String nature, int year, String description, String site) {
			this.year = year;
			this.nature = nature;
			this.titre = titre;
			this.description= description;
			this.siteweb =site;
	    }

	 public int getId() {
		 return id;
	 }
	 public int getYear() {
	        return year;
	    }
	 
	 public String getSiteweb() {
	        return siteweb;
	    }
	 public String getTitre() {
	        return titre;
	    }
	 
	 public String getDesc() {
	        return description;
	    }
	 
	 public String getNature() {
	        return nature;
	    }
	 
	 public void setId(int id) {
		 this.id = id;
	 }
	 
	 public void setYear(int year) {
	        this.year = year;
	    }
	 
	 public void setNature(String n) {
	        this.nature = n;
	    }
	 
	 public void setTitre(String t) {
	        this.titre = t;
	    }
	 
	 public void setDesc(String d) {
	        this.description = d;
	    }
	 
	 public void setSiteweb(String s) {
	        this.siteweb = s;
	    }
}

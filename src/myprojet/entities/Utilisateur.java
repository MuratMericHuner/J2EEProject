package myprojet.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity()
@Table(name="user")
public class Utilisateur implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	int id;

    @Column(name="surname")
    @NotNull
    private String nom;
    
    @Column(name="name")
    @NotNull
    private String prenom;
    
    @Column(name="mail")
    @NotNull
    private String mail;
    
    @Column(name="site")
    private String siteweb;
    
    @Column(name="naissance")
    private Date naissance;
    
    @Column(name="mdp")
    @NotNull
    private String mdp;
    
    public Utilisateur() {
		super();
	}
    
    public Utilisateur(String nom, String prenom, String mail, String web, Date naissance, String mdp) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.siteweb =web;
		this.naissance= naissance;
		this.mdp = mdp;
    }
    
    public int getId() {
    	return id;
    }
    
    public String getsurname() {
        return nom;
    }
    
    public String getname() {
        return prenom;
    }
    
    public String getmail() {
        return mail;
    }
    
    public String getsite() {
        return siteweb;
    }
    
    public Date getnaissance() {
        return naissance;
    }
    
    public String getmdp() {
        return mdp;
    }
    
    public void setId(int id) {
    	this.id=id;
    }
    
    public void setsurname(String surname) {
        this.nom = surname;
    }
    
    public void setname(String name) {
        this.prenom = name;
    }
    
    public void setmail(String mail) {
        this.mail = mail;
    }
    
    public void setsite(String site) {
        this.siteweb = site;
    }
    
    public void setnaissance(Date n) {
        this.naissance = n;
    }
    
    public void setmdp(String mdp) {
        this.mdp = mdp;
    }

}

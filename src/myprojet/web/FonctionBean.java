package myprojet.web;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import myprojet.entities.Activity;
import myprojet.entities.Utilisateur;
import myprojet.services.FonctionManager;
import myprojet.services.UserLogin;

@Named("beanManager")
@SessionScoped
public class FonctionBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
			
	@EJB
	FonctionManager fonction;
	
	@EJB
	UserLogin login;
	
	Utilisateur user;
	Activity activity;
	
	private String mail;
	private String mdp;
	
	public FonctionBean() {
		
	}
	
	@PostConstruct
	public void init(){
		user =new Utilisateur();
		activity =  new Activity();
	}
	
	@PreDestroy
    void close() {
        System.err.println("Close " + this);
    }
	
	public List<Utilisateur> getAllUsers() {
		return fonction.findallUsers();
	}
	
	public List<Activity> getAllActivities() {
		return fonction.findallActivities();
	}
	
	public Utilisateur gettheUser() {
		return this.user;
	}
	
	public void settheUser(Utilisateur u) {
		this.user= u;
	}
	
	public void settheActivity(Activity a) {
		this.activity= a;
	}
	public Activity gettheActivity() {
		return activity;
	}
	
	 public String ModifyUser(int id) {
	        user = fonction.getUser(id);
	        return "Adduser?faces-redirect=true";
	    }
	 
	 public String ModifyActivity(int id) {
	        activity = fonction.getActivity(id);
	        return "AddActivity?faces-redirect=true";
	    }
	 public String saveUser(){
			 fonction.saveUtilisateur(user);
		        return "Users?faces-redirect=true";
	    }
	 public String saveActivity(){
			 fonction.saveActivity(activity);
		        return "Activities?faces-redirect=true";
	    }
	 
	 public String newUser() {
		 	this.user = new Utilisateur();
	        return "Adduser?faces-redirect=true";
	    }
	 public String newActivity() {
		 	this.activity = new Activity();
	        return "AddActivity?faces-redirect=true";
	    }
	 
	 public void deleteUser(int id){
		 	 user = fonction.getUser(id);
			 this.fonction.deleteUtilisateur(user);
	 }
	 
	 public void deleteActivity(int id) {
		 	activity = fonction.getActivity(id);
		 	fonction.deleteActivity(activity);
	 }
	 
	 public String getMail() {
	        return this.user.getmail();
	    }

	 public void setMail(String mail) {
	        this.user.setmail(mail);
	    }
	 public String getSurname() {
	        return this.user.getsurname();
	    }
	 public void setSurname(String name) {
	        this.user.setsurname(name);
	    }
	  
	 public String getmdp() {
	        return this.user.getmdp();
	    }

	 public void setmdp(String mdp) {
	        this.user.setmdp(mdp);;
	    }
	 public int getid() {
	        return this.user.getId();
	    }

	 public void setid(int id) {
	        this.user.setId(id);;
	    }
	 public String getname() {
	        return this.user.getname();
	    }

	 public void setname(String name) {
	        this.user.setname(name);;
	    }
	 public String getsite() {
	        return this.user.getsite();
	    }

	 public void setsite(String site) {
	        this.user.setsite(site);;
	    }
	 public Date getnaissance() {
	        return this.user.getnaissance();
	    }

	 public void setnaissance(Date naissance) {
	        this.user.setnaissance(naissance);
	    }
	 
	 public void setthemail(String mail) {
		 this.mail = mail;
	 }
	 
	 public void setthemdp(String mdp) {
		 this.mdp= mdp;
	 }
	 
	 public String getthemail() {
		 return this.mail;
	 }
	 
	 public String getthemdp() {
		 return this.mdp;
	 }
	 
	 public String logged() {		 
		 if(login.login(mail, mdp)) {
			 return "Logged";
		 }
		 return null;
	 }
	 public String logout() {
		 login.logout();
		 return "Main";
	 }
	 public String showUsers() {
		 return "Users";
	 }
	 public String showUsersVisit() {
		 return "UsersVisit";
	 }
	 public String showActivities() {
		 return "Activities";
	 }
	 public String showActivitiesVisit() {
		 return "ActivitiesVisit";
	 }
	 
	 public int getYear() {
	        return this.activity.getYear();
	    }
	 
	 public String getNature() {
	        return this.activity.getNature();
	    }
	 
	 public String getTitre() {
	        return this.activity.getTitre();
	    }
	 
	 public String getDesc() {
	        return this.activity.getDesc();
	    }
	 
	 public String getSiteweb() {
	        return this.activity.getSiteweb();
	    }
	 
	 public void setYear(int year) {
		 	this.activity.setYear(year);;
	    }
	 
	 public void setNature(String nature) {
		 this.activity.setNature(nature);;
	    }
	 
	 public void setTitre(String titre) {
		 this.activity.setTitre(titre);;
	    }
	 
	 public void setDesc(String desc) {
		 	this.activity.setDesc(desc);;
	    }
	 
	 public void setSiteweb(String site) {
		 this.activity.setSiteweb(site);;
	    }
}

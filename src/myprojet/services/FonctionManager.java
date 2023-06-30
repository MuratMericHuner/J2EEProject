package myprojet.services;

import java.util.Date;
import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import myprojet.entities.Activity;
import myprojet.entities.Utilisateur;

@LocalBean
@Stateless(name="fonctionmanager")
public class FonctionManager {
	@PersistenceContext(unitName = "myBase")
	EntityManager em;

	 public List<Utilisateur> findUsersurname(String s) {
	        return em.createQuery("SELECT u FROM Utilisateur u WHERE u.nom='"+s+"'", Utilisateur.class)
	                .getResultList();
	    }
	 
	 public List<Utilisateur> findUsername(String s) {
	        return em.createQuery("SELECT u FROM Utilisateur u WHERE u.prenom='"+s+"'", Utilisateur.class)
	                .getResultList();
	    }
	
	public List<Utilisateur> findallUsers(){
		return em.createQuery("SELECT u FROM Utilisateur u", Utilisateur.class)
                .getResultList();
	}
	
	 public Utilisateur getUser(int id) {
	        return em.find(Utilisateur.class, id);
	    }
	
	public Utilisateur saveUtilisateur(Utilisateur u) {
			if (u==null) {
	            em.persist(u);
	        } else {
	            u = em.merge(u);
	        }
	            return u;
    }
	
	public void deleteUtilisateur(Utilisateur u){
			u = em.merge(u);
			em.remove(u);
    }
	
    public Utilisateur createUtilisateur(String nom, String prenom, String mail, String site, Date n, String mdp) {
			Utilisateur u = new Utilisateur();
	    	u.setsurname(nom);
	    	u.setname(prenom);
	    	u.setmail(mail);
	    	u.setsite(site);
	    	u.setnaissance(n);
	    	u.setmdp(mdp);
	    	em.persist(u);
	    	return u;
    }
    
    public Utilisateur updateUtilisateur(Utilisateur u, String nom, String prenom, String mail, String site, Date n, String mdp){
			u.setsurname(nom);
	    	u.setname(prenom);
	    	u.setmail(mail);
	    	u.setsite(site);
	    	u.setnaissance(n);
	    	u.setmdp(mdp);
	    	u = em.merge(u);
	    	return u;
    }
    
    public List<Activity> findActivitytitre(String t) {
        return em.createQuery("Select a From Activity a "+" where a.titre='"+t+"'", Activity.class)
                .getResultList();
    }
	
	public List<Activity> findallActivities(){
		return em.createQuery("Select a From Activity a", Activity.class)
                .getResultList();
	}
	
	 public Activity getActivity(int id) {
	        return em.find(Activity.class, id);
	    }
	
	public Activity saveActivity(Activity a) {
        if (a==null) {
            em.persist(a);
        } else {
            a = em.merge(a);
        }
        return a;
    }
	
	public void deleteActivity(Activity a){
		a = em.merge(a);
		em.remove(a);
    }
		
	public Activity createActivity(String titre, String nature, int year, String description, String site) {
		Activity a = new Activity();
		a.setTitre(titre);
		a.setNature(nature);
		a.setYear(year);
		a.setDesc(description);
		a.setSiteweb(site);
		em.persist(a);
		return a;
	}
	
	public Activity updateActivity(Activity a,String titre, String nature, int year, String description, String site) {
		a.setTitre(titre);
		a.setNature(nature);
		a.setYear(year);
		a.setDesc(description);
		a.setSiteweb(site);
		a= em.merge(a);
		return a;
	}

}

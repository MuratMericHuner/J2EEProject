package myprojet.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import myprojet.entities.Utilisateur;

@LocalBean
@Stateful(name="login")
public class UserLogin {
	
	 @Inject
	 private Utilisateur user;
	 
	 @PersistenceContext(unitName = "myBase")
	 EntityManager em;

	 	
	  public List<Utilisateur> findMail(String mail, String mdp) {
	        return em.createQuery("SELECT u FROM Utilisateur u WHERE u.mail='"+mail+"' AND u.mdp='"+mdp+"' ", Utilisateur.class)
	                .getResultList();
	    }
	 
	    public boolean login(String mail, String mdp) {
	        try {
	        	List<Utilisateur> users = findMail(mail, mdp);
	        	if(users.size()==1) {
		        		System.out.printf("Login user %s on %s\n", user, this);
			            return true;
	        	}
	        	else {
	        		return false;
	        	}
	        	}catch (Exception e) {
	        		return false;
	        }	        
	    }

	    @Remove
	    public void logout() {
	    	user = new Utilisateur();
	        System.out.printf("Logout on %s\n", this);
	    }
}

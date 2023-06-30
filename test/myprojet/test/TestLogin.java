package myprojet.test;

import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myprojet.entities.Utilisateur;
import myprojet.services.FonctionManager;
import myprojet.services.UserLogin;

public class TestLogin {
	@BeforeEach
    public void setUp() throws Exception {
        EJBContainer.createEJBContainer().getContext().bind("inject", this);
    }

    @AfterEach
    public void tearDown() throws Exception {
        EJBContainer.createEJBContainer().close();
    }
    
    @Inject
    UserLogin login;
    
    @Inject
    FonctionManager fonction;
    
    Utilisateur user = new Utilisateur();
    
    @Test
    public void testlogin() {
    	user = fonction.getUser(1);
    	login.login("murat@gmail.com", "1234");
    }
}

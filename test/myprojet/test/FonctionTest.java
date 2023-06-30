package myprojet.test;

import java.sql.Date;

import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myprojet.entities.Utilisateur;
import myprojet.services.FonctionManager;
import myprojet.web.FonctionBean;

public class FonctionTest{
	
	@Inject
	FonctionBean fonction;
	
	Utilisateur user = new Utilisateur();
	
	static EJBContainer container;
	
	@BeforeAll
    static public void beforeAll() throws Exception {
        container = EJBContainer.createEJBContainer();
    }

    @AfterAll
    static public void afterAll() throws Exception {
        container.close();
    }
	
	@BeforeEach
    public void setUp() throws Exception {
        EJBContainer.createEJBContainer().getContext().bind("inject", this);
    }

    @AfterEach
    public void tearDown() throws Exception {
        EJBContainer.createEJBContainer().close();
    }
	
	/*@Test
    public void testadduser(){
		user.setsurname("Isableu");
		user.setname("Jeremy");
		user.setmail("jeremy@gmail.com");
		user.setmdp("1234");
		user.setnaissance(new Date(97,01,16));
		user.setsite("www.jerermy.com");
		fonction.settheUser(user);
		fonction.saveUser();
    }*/
	
	/*@Test
	public void testfinduser(){
		user = fonction.getUser(1);
		System.out.println(user.getname());
	}*/
	
	/*@Test
	public void deleteuser() throws Exception {
		fonction.deleteUser(5);
	}*/
	
}

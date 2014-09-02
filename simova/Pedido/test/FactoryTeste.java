/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author debug_3
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({})
public class FactoryTeste {

    private static EntityManagerFactory em = Persistence.createEntityManagerFactory("CadastroPedidoPU");
    
   @Test
    public static void setUpClass() throws Exception {
        em.createEntityManager();
    }

    @Test
    public static void tearDownClass() throws Exception {
        em.close();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}

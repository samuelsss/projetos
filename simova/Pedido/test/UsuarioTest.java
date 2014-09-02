/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.simova.entity.Usuario;
import br.com.simova.util.JPAUtil;
import br.com.torlife.dao.UsuarioDao;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author debug_3
 */
public class UsuarioTest {
    UsuarioDao usuarioDao = lookupUsuarioDaoBean();
    
     private static EntityManager em = new JPAUtil().getEntityManager();
     Usuario usuario = new Usuario();
    
    public UsuarioTest() {
    }

    @Before
    public void setUp() {
        inserirUsuario();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
     @Test
    public void inserirUsuario() {
        usuario.setLogin("Samuel");
        usuario.setSenha("Samuel");
        usuario.setDataCriacao(new Date());
        usuarioDao.gravar(usuario);
    }

    private UsuarioDao lookupUsuarioDaoBean() {
        try {
            Context c = new InitialContext();
            return (UsuarioDao) c.lookup("java:global/SistemaPedido/UsuarioDao!br.com.torlife.dao.UsuarioDao");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}

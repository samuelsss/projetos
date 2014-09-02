/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.torlife.dao;

import br.com.simova.entity.Usuario;
import br.com.simova.util.JPAUtil;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Samuel Santos Silva
 */
@Stateless
public class UsuarioDao  {

    private EntityManager em =  new JPAUtil().getEntityManager();
 
    public boolean gravar(Usuario usuario){
        boolean sucesso = false;
        try {
            em.persist(usuario);
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sucesso;
    }
 
    public Usuario selecionar(Long codigo){
        Usuario usuario = null;
        try {
            usuario = em.find(Usuario.class, codigo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
 
    public boolean remover(Usuario usuario){
        boolean sucesso = false;
        try {
            usuario = em.find(Usuario.class, usuario.getId());
            em.remove(usuario);
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sucesso;
    }
 
    public List<Usuario> listar() {
        List<Usuario> usuarios = null;
        try {
            Query query = em.createQuery("Select u from Usuario u");
            usuarios = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return usuarios;
    }
    
}
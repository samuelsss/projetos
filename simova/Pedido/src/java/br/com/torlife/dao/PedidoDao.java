/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.torlife.dao;

import br.com.simova.entity.Pedido;
import br.com.simova.entity.Usuario;
import br.com.simova.util.JPAUtil;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Samuel Santos Silva
 */
@Stateless
public class PedidoDao {
    
    private EntityManager em =  new JPAUtil().getEntityManager();
 
    public boolean gravar(Pedido Pedido){
        boolean sucesso = false;
        try {
            em.persist(Pedido);
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sucesso;
    }
 
    public Pedido selecionar(Long codigo){
        Pedido pedido = null;
        try {
            pedido = em.find(Pedido.class, codigo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pedido;
    }
 
    public boolean remover(Pedido pedido){
        boolean sucesso = false;
        try {
            pedido = em.find(Pedido.class, pedido.getId());
            em.remove(pedido);
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sucesso;
    }
 
    public List<Pedido> listar() {
        List<Pedido> pedidos = null;
        try {
            Query query = em.createQuery("Select p from Pedido p");
            pedidos = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return pedidos;
    }
}

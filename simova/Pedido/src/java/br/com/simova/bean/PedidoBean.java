package br.com.simova.bean;

import br.com.simova.entity.Pedido;
import br.com.torlife.dao.PedidoDao;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;



/**
 *
 * @author Samuel Santos Silva
 */

@Named()
@SessionScoped
public class PedidoBean implements Serializable{
    
    @EJB
    private PedidoDao  pedidoDao;
    private Pedido pedido = new Pedido();
    private List<Pedido> pedidos;

    public void novo(){
        pedido = new Pedido();
    }
 
    public void gravar() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = pedidoDao.gravar(pedido);
 
        if (resultado) {
            pedido = new Pedido();
            context.addMessage(null, new FacesMessage("Pedido gravado com sucesso"));
        } else {
            context.addMessage(null, new FacesMessage("Falha ao gravar Pedido!"));
        }
    }
 
    public void selecionar(ActionEvent evento) {
        Long codigo = (Long) evento.getComponent().getAttributes().get("id");
        pedido = pedidoDao.selecionar(codigo);
    }
 
    public void remover() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = pedidoDao.remover(pedido);
 
        if (resultado) {
            pedido = new Pedido();
            context.addMessage(null, new FacesMessage("Pedido removido com sucesso"));
        } else {
            context.addMessage(null, new FacesMessage("Falha ao remover Pedido!"));
        }
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}

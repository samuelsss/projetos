package br.com.simova.entity;

import br.com.simova.entity.Iten;
import br.com.simova.entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-02T01:12:45")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Long> id;
    public static volatile SingularAttribute<Pedido, Usuario> usuario;
    public static volatile ListAttribute<Pedido, Iten> itens;
    public static volatile SingularAttribute<Pedido, Date> dataPedido;

}
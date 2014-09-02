package br.com.simova.entity;

import br.com.simova.entity.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-02T01:12:45")
@StaticMetamodel(Iten.class)
public class Iten_ { 

    public static volatile SingularAttribute<Iten, Long> id;
    public static volatile SingularAttribute<Iten, Pedido> pedido;
    public static volatile SingularAttribute<Iten, String> nome;
    public static volatile SingularAttribute<Iten, String> descricao;

}
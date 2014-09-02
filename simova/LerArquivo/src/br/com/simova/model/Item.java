package br.com.simova.model;


import java.beans.Transient;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Samuel Santos Silva
 */
public class Item implements Serializable{
    
    private String nomeProduto;
    private Float valor;
    
    private Float valorTotalCompra;

    public Item(){}
    
    public Item(String nomeProduto, Float valor) {
        this.nomeProduto = nomeProduto;
        this.valor = valor;
    }
    
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Float getValorTotalCompra() {
        return valorTotalCompra;
    }

    public void setValorTotalCompra(Float valorTotalCompra) {
        this.valorTotalCompra = valorTotalCompra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.nomeProduto);
        hash = 79 * hash + Objects.hashCode(this.valor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.nomeProduto, other.nomeProduto)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        return true;
    }
    
}

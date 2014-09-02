/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simova.view;

import br.com.simova.business.LerArquivoBO;
import br.com.simova.model.Cliente;
import br.com.simova.model.Item;
import br.com.simova.util.Util;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Samuel Santos Silva
 */
public class PedidoView {

    public static void main(String[] args) throws UnsupportedEncodingException {
        try {
            Scanner scanner = new Scanner(System.in);
            LerArquivoBO lerArquivoBO = new LerArquivoBO();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Util.PATH_ARQUIVO_TXT_LOCAL), "UTF-8"));

            float valorTotal = 0;

            Cliente cliente;

            System.out.println("--------------- Sistema Pedidos SIMOVA ---------------");
            cliente = lerArquivoBO.lerPorNomeCliente(bufferedReader);

        if (cliente.getNome() != null) {
                System.out.println("------------ Dados Cadastrais ------------");
                System.out.println("Nome Cliente:" + cliente.getNome());
                System.out.println("CPF:" + cliente.getCpf());
                System.out.println("Telefone:" + cliente.getTelefone());

                System.out.println("------------ Pedidos Cliente -------------");
                for (Item item : cliente.getItems()) {
                    System.out.println("Produto:" + item.getNomeProduto() + "Valor: R$" + item.getValor());
                    valorTotal += item.getValor();
                }
                System.out.println("Total da compra: R$" + valorTotal);
            } else {
                System.out.println("Cliente não encontrado");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PedidoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

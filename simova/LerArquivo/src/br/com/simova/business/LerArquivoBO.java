/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simova.business;

import br.com.simova.model.Cliente;
import br.com.simova.model.Item;
import br.com.simova.util.Util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Samuel Santos Silva
 */
public class LerArquivoBO {

    public Cliente lerPorNomeCliente(BufferedReader bufferedReader) {

        Cliente cliente = new Cliente();
     
        try {
        
            while (bufferedReader.ready() && nomeClienteValido(bufferedReader)) {

                bufferedReader.reset();
                
                String linha0 = bufferedReader.readLine();
                String linha1 = bufferedReader.readLine();
                String linha2 = bufferedReader.readLine();
                String linha3 = bufferedReader.readLine();
                String linha4 = bufferedReader.readLine();

                cliente.setNome(linha0.substring(0, linha0.indexOf("\t")).trim());
                cliente.setCpf(linha0.substring(linha0.indexOf('\t') + 1, linha0.lastIndexOf('\t')).trim());
                cliente.setTelefone(linha0.substring(linha0.indexOf('\t') + 16).trim());

                cliente.getItems().add(new Item(linha1.substring(0, linha1.indexOf("\t")), Float.parseFloat(linha1.substring(linha1.lastIndexOf('\t')).replaceAll(",", ".").trim())));
                cliente.getItems().add(new Item(linha2.substring(0, linha2.indexOf("\t")), Float.parseFloat(linha2.substring(linha2.lastIndexOf('\t')).replaceAll(",", ".").trim())));
                cliente.getItems().add(new Item(linha3.substring(0, linha3.indexOf("\t")), Float.parseFloat(linha3.substring(linha3.lastIndexOf('\t')).replaceAll(",", ".").trim())));
                cliente.getItems().add(new Item(linha4.substring(0, linha4.indexOf("\t")), Float.parseFloat(linha4.substring(linha4.lastIndexOf('\t')).replaceAll(",", ".").trim())));

            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            System.out.println("Falha ao ler o arquivo! " + e.getMessage());
        }
        return cliente;
    }

    private Boolean nomeClienteValido(BufferedReader bufferedReader) {
      
        try {
            bufferedReader.mark(1);
            return bufferedReader.readLine().contains(Util.NOME_VALIDO_PROCESSAMENTOARQUIVO);

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            System.out.println("Falha ao ler o arquivo! " + e.getMessage());
        }
        return null;
        }
    }
 


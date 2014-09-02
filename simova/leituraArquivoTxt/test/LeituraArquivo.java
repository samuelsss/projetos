/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.simova.business.LerArquivoBO;
import br.com.simova.util.Util;
import java.io.BufferedReader;
import java.io.FileReader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Samuel Santos Silva
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({})
public class LeituraArquivo {
    
   

    @BeforeClass
    public static void setUpClass() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(Util.PATH_ARQUIVO_TXT_LOCAL));
        LerArquivoBO lerArquivoBO = new LerArquivoBO();
        lerArquivoBO.lerPorNomeCliente(bufferedReader);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}

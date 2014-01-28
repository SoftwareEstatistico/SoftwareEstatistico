/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.List;
import model.Amostra;
import model.ValorAmostra;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Ana
 */
public class SalvarCSVTest {
    private Amostra amostra=new Amostra();
    private ValorAmostra v1=new ValorAmostra();
    private ValorAmostra v2=new ValorAmostra();
    private ValorAmostra v3=new ValorAmostra();
    private ValorAmostra v4=new ValorAmostra();
    public SalvarCSVTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        amostra=new Amostra();
        v1.setValor(12.9);
        v2.setValor(11.6);
        v3.setValor(13.8);
        v4.setValor(15.8);
        
        amostra.setDados(v1);
        amostra.setDados(v2);
        amostra.setDados(v3);
        amostra.setDados(v4);
       
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createCsvFile method, of class SalvarCSV.
     */
    @Test
    public void testCriarFile() {
        System.out.println("createCsvFile");
        SalvarCSV instance = new SalvarCSV();
        List<String>vlrs=new ArrayList<>();
        for (Double d : amostra.valores_ordenados_amostra()) {
            vlrs.add(""+d);
        }
        instance.criarFile(vlrs,SalvarCSV.class.getResource("/csv").getPath()+"/amostra.csv");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of readCsvFile method, of class SalvarCSV.
     */
    @Test
    public void testLerFile() {
        System.out.println("readCsvFile");
        SalvarCSV instance = new SalvarCSV();
        instance.LerFile(SalvarCSV.class.getResource("/xml").getPath()+"/amostra.csv");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
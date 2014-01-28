/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import calculo.Calculo;
import calculo.CalculoImpl;
import model.Amostra;
import model.ValorAmostra;
import static org.easymock.EasyMock.createStrictMock;
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
    private Amostra amostra;
    private ValorAmostra v1;
    private ValorAmostra v2;
    private ValorAmostra v3;
    private ValorAmostra v4;
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
        for (ValorAmostra v : amostra.getDados()) {
            instance.criarFile(v.getDate().toString(),SalvarCSV.class.getResource("/xml").getPath()+"/amostra.csv");
            instance.criarFile(v.getValor().toString(),SalvarCSV.class.getResource("/xml").getPath()+"/amostra.csv");
        }
        
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
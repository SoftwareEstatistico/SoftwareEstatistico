/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jcsv;

import java.util.ArrayList;
import java.util.List;
import model.ValorAmostra;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ana
 */
public class CsvControllerTest {
    ValorAmostra v1=new ValorAmostra();
    ValorAmostra v2=new ValorAmostra();
    ValorAmostra v3=new ValorAmostra();
    ValorAmostra v4=new ValorAmostra();
    public CsvControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of read method, of class CsvController.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        String arqname = "novoteste.csv";
        CsvController instance = new CsvController();
        v1.setValor(12.9);
        v2.setValor(11.6);
        v3.setValor(13.8);
        v4.setValor(15.8);
        List<ValorAmostra> vlrs = new ArrayList<>();
        List result = instance.read(arqname);
        assertEquals(vlrs, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValorAmostra method, of class CsvController.
     */
    @Test
    public void testGetValorAmostra() {
        System.out.println("getValorAmostra");
        CsvController instance = new CsvController();
        ValorAmostra expResult = null;
        ValorAmostra result = instance.getValorAmostra();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class CsvController.
     */
    @Test
    public void testWrite() throws Exception {
        System.out.println("write");
        String arqnome = "novoteste.csv";
        v1.setValor(12.9);
        v2.setValor(11.6);
        v3.setValor(13.8);
        v4.setValor(15.8);
        List<ValorAmostra> vlrs = new ArrayList<>();
        vlrs.add(v1);
        vlrs.add(v2);
        vlrs.add(v3);
        vlrs.add(v4);
        CsvController instance = new CsvController();
        instance.write(arqnome, vlrs);
//        instance.add(arqnome, v1);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        
    }
}
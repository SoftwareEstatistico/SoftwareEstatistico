/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digester;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Ana
 */
public class ReadTest {
    
    public ReadTest() {
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
     * Test of leitura method, of class Read.
     */
    @Test
    public void testLeitura() throws Exception {
        System.out.println("leitura");
        File file = new File("C:\\Users\\Ana\\Documents\\NetBeansProjects\\SoftwareEstatisticoDigester\\SoftwareEstatisticoMaster\\xml\\amostra.xml");
        if(file.exists()){
            System.out.println("Existe");
            Read.leitura(file);
        }else{
            System.out.println("Não Existe");
        }
        
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
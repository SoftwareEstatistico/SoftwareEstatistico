/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareestatistico.view;

import javafx.stage.Stage;
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
public class SoftwareEstatisticoTest {
    
    public SoftwareEstatisticoTest() {
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
     * Test of start method, of class SoftwareEstatistico.
     */
    @Test
    public void testStart() throws Exception {
        System.out.println("start");
        Stage stage = new Stage();
        SoftwareEstatistico instance = new SoftwareEstatistico();
        instance.start(stage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class SoftwareEstatistico.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        SoftwareEstatistico.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
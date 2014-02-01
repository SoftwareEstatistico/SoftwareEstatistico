/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cli;

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
public class CommandLineParametersTest {
    
    public CommandLineParametersTest() {
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
     * Test of cmd method, of class CommandLineParameters.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("cmd");
        String[] args = {"12.3","14.5","14.5","14.5","12.3","12"};
        CommandLineParameters.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
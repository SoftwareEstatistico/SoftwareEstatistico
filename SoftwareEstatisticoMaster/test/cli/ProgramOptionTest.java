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
public class ProgramOptionTest {
    
    public ProgramOptionTest() {
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
     * Test of default_options method, of class ProgramOption.
     */
    @Test
    public void testDefault_options() {
        System.out.println("default_options");
        ProgramOption instance = new ProgramOption();
        instance.default_options();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of create_option method, of class ProgramOption.
     */
    @Test
    public void testCreate_option() {
        System.out.println("create_option");
        String nome = "teste";
        boolean hasarg = false;
        String descricao = "testando";
        ProgramOption instance = new ProgramOption();
        instance.create_option(nome, hasarg, descricao);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of cmd_behavior method, of class ProgramOption.
     */
    @Test
    public void testCmd_behavior() {
        System.out.println("cmd_behavior");
        String[] args = {"--moda=20"};
        String option = "moda";
        ProgramOption instance = new ProgramOption();
        instance.cmd_behavior(args, option);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
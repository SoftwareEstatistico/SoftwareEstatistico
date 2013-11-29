/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareestatistico.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.easymock.EasyMock.createNiceMock;
import static org.junit.Assert.*;

/**
 *JUNIT + EasyMock
 * @author Ana
 */
public class CalculoImplTest {
    private Calculo calculo; 
    private CalculoImpl instance; 
    private List<Double> amostra;
    @Before
    public void setUp() {
        //criando a mock
        calculo=createNiceMock(Calculo.class);
        instance=new CalculoImpl();
        //pego amostra uma vez pelo set e utiliso nos calculos
        testSetAmostra();
    }
    
    @Test
    public void testGetFrequencia_Absoluta() {
        System.out.println("getFrequencia_Absoluta");
        Map expResult = null;
        Map result = instance.getFrequencia_Absoluta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFrequencia_String_Absoluta method, of class CalculoImpl.
     */
    @Test
    public void testGetFrequencia_String_Absoluta() {
        System.out.println("getFrequencia_String_Absoluta");
        Map expResult = null;
        Map result = instance.getFrequencia_String_Absoluta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmostra_String method, of class CalculoImpl.
     */
    @Test
    public void testGetAmostra_String() {
        System.out.println("getAmostra_String");
        List expResult = null;
        List result = instance.getAmostra_String();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAmostra_String method, of class CalculoImpl.
     */
    @Test
    public void testSetAmostra_String() {
        System.out.println("setAmostra_String");
        List<String> amostra_String = null;
        instance.setAmostra_String(amostra_String);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmostra method, of class CalculoImpl.
     */
    @Test
    public void testGetAmostra() {
        System.out.println("getAmostra");
        List expResult = this.amostra;
        List result = instance.getAmostra();
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setAmostra method, of class CalculoImpl.
     */
    @Test
    public void testSetAmostra() {
        System.out.println("setAmostra");
        this.amostra = new ArrayList<Double>();
        this.amostra.add(12.0);
        this.amostra.add(12.0);
        this.amostra.add(14.0);
        this.amostra.add(13.0);
        this.amostra.add(15.0);
        this.amostra.add(16.0);
        this.amostra.add(17.0);
        this.amostra.add(17.0);
        this.amostra.add(15.0);
        this.amostra.add(12.0);
        this.amostra.add(12.0);
        this.amostra.add(11.0);
        this.amostra.add(12.0);
        this.amostra.add(13.0);
        this.amostra.add(98.0);
        this.amostra.add(0.0);
        instance.setAmostra(this.amostra);
        
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of media method, of class CalculoImpl.
     */
    @Test
    public void testMedia() {
        System.out.println("media");
        double expResult = 18.062500;
        double result = instance.media();
        assertEquals(expResult, result, expResult);
// TODO review the generated test code and remove the default call to fail.
//        fail("Teste"+instance.getAmostra());
    }

    /**
     * Test of moda method, of class CalculoImpl.
     */
    @Test
    public void testModa() {
        System.out.println("moda");
        double expResult = 12;
        double result = instance.moda();
        assertEquals(expResult, result, 12);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mediana method, of class CalculoImpl.
     */
    @Test
    public void testMediana() {
        System.out.println("mediana");
        double expResult = 13;
        double result = instance.mediana();
        assertEquals(expResult, result, 13);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of variancia method, of class CalculoImpl.
     */
    @Test
    public void testVariancia() {
        System.out.println("variancia");
        double expResult = 469.5291666667;
        double result = instance.variancia();
        assertEquals(expResult, result,469.5291666667);
        // TODO review the generated test code and remove the default call to fail.
//        fail("não bate os calculos");
    }

    /**
     * Test of desvio_padrao method, of class CalculoImpl.
     */
    @Test
    public void testDesvio_padrao() {
        System.out.println("desvio_padrao");
        double expResult = 21.6686217067;
        double result = instance.desvio_padrao();
        assertEquals(expResult, result, 21.6686217067);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of amplitude method, of class CalculoImpl.
     */
    @Test
    public void testAmplitude() {
        System.out.println("amplitude");
        double expResult = 98;
        double result = instance.amplitude();
        assertEquals(expResult, result, 98);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of coeficiente_variacao method, of class CalculoImpl.
     */
    @Test
    public void testCoeficiente_variacao() {
        System.out.println("coeficiente_variacao");
        double expResult = 1.161553;
        double result = instance.coeficiente_variacao();
        assertEquals(expResult, result, 1.161553);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of simetrica method, of class CalculoImpl.
     */
    @Test
    public void testSimetrica() {
        System.out.println("simetrica");
        boolean expResult = false;
        boolean result = instance.simetrica();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of max method, of class CalculoImpl.
     */
    @Test
    public void testMax() {
        System.out.println("max");
        double expResult = 98;
        double result = instance.max();
        assertEquals(expResult, result, 98);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of min method, of class CalculoImpl.
     */
    @Test
    public void testMin() {
        System.out.println("min");
        double expResult = 0.0;
        double result = instance.min();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of histograma method, of class CalculoImpl.
     */
    @Test
    public void testHistograma() {
        System.out.println("histograma");
        double expResult = 0.0;
        double result = instance.histograma();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of curtose method, of class CalculoImpl.
     */
    @Test
    public void testCurtose() {
        System.out.println("curtose");
        double expResult = 14.7979922396;
        double result = instance.curtose();
        assertEquals(expResult, result, 14.7979922396);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of obliquidade method, of class CalculoImpl.
     */
    @Test
    public void testObliquidade() {
        System.out.println("obliquidade");
        double expResult = 3.7671673147;
        double result = instance.obliquidade();
        assertEquals(expResult, result, 3.7671673147);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of frequencia_relativa method, of class CalculoImpl.
     */
    @Test
    public void testFrequencia_relativa() {
        System.out.println("frequencia_relativa");
        Map expResult = null;
        Map result = instance.frequencia_relativa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of frequencia_String_relativa method, of class CalculoImpl.
     */
    @Test
    public void testFrequencia_String_relativa() {
        System.out.println("frequencia_String_relativa");
        Map expResult = null;
        Map result = instance.frequencia_String_relativa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of q2 method, of class CalculoImpl.
     */
    @Test
    public void testQ2() {
        System.out.println("q2");
        double expResult = 13;
        double result = instance.q2();
        assertEquals(expResult, result, 13);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of q1 method, of class CalculoImpl.
     */
    @Test
    public void testQ1() {
        System.out.println("q1");
        double expResult = 12;
        double result = instance.q1();
        assertEquals(expResult, result, 12);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of q3 method, of class CalculoImpl.
     */
    @Test
    public void testQ3() {
        System.out.println("q3");
        double expResult = 15.25;
        double result = instance.q3();
        assertEquals(expResult, result, 15.25);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
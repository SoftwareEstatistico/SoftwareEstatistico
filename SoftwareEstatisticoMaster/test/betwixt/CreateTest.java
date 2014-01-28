/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package betwixt;

import calculo.CalculoImpl;
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
public class CreateTest {
    CalculoImpl calculoImpl;
    public CreateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        calculoImpl=new CalculoImpl();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createxml method, of class Create.
     */
    @Test
    public void testCreatexml() throws Exception {
        System.out.println("createxml");
        Amostra amostra=new Amostra();
//        amostra.setAmplitude(1);
//        amostra.setCurtose(1);
//        amostra.setDesvio_padrao(1);
//        amostra.setMax(1);
//        amostra.setMedia(1);
//        amostra.setMediana(1);
//        amostra.setMin(1);
//        amostra.setModa(12);
//        amostra.setNome("Venda de Carros");
//        amostra.setObliquidade(1);
//        amostra.setVariancia(1);
//        FrequenciaAbsoluta1 fa=new FrequenciaAbsoluta1();
//        fa.setKey(1.6);
//        fa.setValue(1);
//        FrequenciaRelativa1 fr=new FrequenciaRelativa1();
//        fr.setKey(2.4);
//        fr.setValue(2.3);
//        amostra.setFa(fa);
//        amostra.setFr(fr);
        ValorAmostra v1=new ValorAmostra();
        ValorAmostra v2=new ValorAmostra();
        ValorAmostra v3=new ValorAmostra();
        ValorAmostra v4=new ValorAmostra();
        v1.setValor(12.9);
        v2.setValor(11.6);
        v3.setValor(13.8);
        v4.setValor(15.8);
        amostra.setDados(v1);
        amostra.setDados(v2);
        amostra.setDados(v3);
        amostra.setDados(v4);
        calculoImpl.amplitude(amostra);
//        calculoImpl.curtose(amostra);
        calculoImpl.desviopadrao(amostra);
        calculoImpl.frequenciaAbsoluta(amostra);
        calculoImpl.frequenciaRelativa(amostra);
        calculoImpl.max(amostra);
        calculoImpl.min(amostra);
        calculoImpl.obliquidade(amostra);
        calculoImpl.variancia(amostra);
        Create.createxml("amostra.xml",amostra);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
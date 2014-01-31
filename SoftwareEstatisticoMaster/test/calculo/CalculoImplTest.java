/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculo;

import java.text.DecimalFormat;
import model.Amostra;
import model.ValorAmostra;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

/**
 *
 * @author Ana
 */
public class CalculoImplTest {
    
    //ok media e desvio padrao e variancia e max e min
    private  Amostra amostra=new Amostra();
    ValorAmostra v1=new ValorAmostra();
    ValorAmostra v2=new ValorAmostra();
    ValorAmostra v3=new ValorAmostra();
    ValorAmostra v4=new ValorAmostra();

    private Calculo calculo;
    private CalculoImpl calculoImpl;
    private CalculoServico calcserv;
            
    public CalculoImplTest() {
        
        
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
       
        calculo=createStrictMock(Calculo.class);
        calculoImpl=new CalculoImpl();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calcular method, of class CalculoImpl.
     */
    //@Test
    public void testCalcular() {
        System.out.println("calcular");
        CalculoImpl instance = new CalculoImpl();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmostra method, of class CalculoImpl.
     */
    //@Test
    public void testGetAmostra() {
        System.out.println("getAmostra");
        CalculoImpl instance = new CalculoImpl();
        Amostra expResult = amostra;
        Amostra result = instance.getAmostra();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of media method, of class CalculoImpl.
     */
    @Test
    public void testMedia() {
        System.out.println("media");
        //easymock
        replay(calculo);
        
        DecimalFormat decimal = new DecimalFormat( "0.000" ); 
       //junit       msg        objexp                                      objatual
        assertEquals("13,525", decimal.format(calculoImpl.media(amostra)),"13,525");
       //easymock 
        verify(calculo);
    }
    @Test
    public void testMediana() {
        System.out.println("mediana");
        //easymock
        replay(calculo);
       //junit 
        DecimalFormat decimal = new DecimalFormat( "0.00" ); 
        assertEquals("13,35", decimal.format(calculoImpl.mediana(amostra)),"13,35");
        //easymock
        verify(calculo);
    }
    @Test
    public void testVariancia() {
        System.out.println("variancia");
        //easymock
        replay(calculo);
        DecimalFormat decimal = new DecimalFormat( "0.000000" );
       //junit 
        assertEquals("2,336875", decimal.format(calculoImpl.variancia(amostra)),"2,336875");
        //easymock
        verify(calculo);
    }
    @Test
    public void testDesvioPadrao() {
       System.out.println("desvio_padrao");
        //easymock
       replay(calculo);
       DecimalFormat decimal = new DecimalFormat( "0.000000" );
       //junit
       assertEquals("1,528684", decimal.format(calculoImpl.desviopadrao(amostra)),"1,528684");
       //easymock
       verify(calculo);
    }
    @Test
    public void testAmplitude() {
       System.out.println("amplitude");
        //easymock
       replay(calculo);
       calcserv=new CalculoServico(calculo);
       DecimalFormat decimal = new DecimalFormat( "0.0" );
       //junit
       assertEquals(4.2, calculoImpl.amplitude(amostra),4.2);
       //easymock
      // verify(calculo);
    }
    @Test
    public void testMax() {
       System.out.println("max");
        //easymock
       replay(calculo);
       DecimalFormat decimal = new DecimalFormat( "0.0" );
       //junit
       assertEquals("15,8", decimal.format(calculoImpl.max(amostra)),"15,8");
       //easymock
       verify(calculo);
    }
    //12 fev
    @Test
    public void testMin() {
       System.out.println("min");
       
        //easymock
       replay(calculo);
       DecimalFormat decimal = new DecimalFormat( "0.0" );
       //junit
       assertEquals("11,6", decimal.format(calculoImpl.min(amostra)),"11,6");
       //easymock
       verify(calculo);
    }
    @Test
    public void testCurtose() {
       System.out.println("curtose");
       
        //easymock
       replay(calculo);
       DecimalFormat decimal = new DecimalFormat( "0.000" );
       //junit 11,3288904891
       assertEquals("0.030", decimal.format(calculoImpl.curtose(amostra)),"0.030");
       //easymock
       verify(calculo);
    }
    @Test
    public void testObliquidade() {
       System.out.println("obliquidade ou assimetria");
       
        //easymock
       replay(calculo);
       DecimalFormat decimal = new DecimalFormat( "0.000" );
      
       //junit 0,8244587678
       assertEquals("0,343", decimal.format(calculoImpl.obliquidade(amostra)),"0,343");
       //easymock
       verify(calculo);
    }
    @Test
    public void testModa() {
       System.out.println("moda");
       
        //easymock
       replay(calculo);
//       DecimalFormat decimal = new DecimalFormat( "0.000" );
       //junit
       assertEquals(Double.NaN, calculoImpl.moda(amostra),Double.NaN);
       //easymock
       verify(calculo);
    }
    //resultados de população todos os dados mudar o nome da classe amostra para população
}
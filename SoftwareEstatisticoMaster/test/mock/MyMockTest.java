/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import calculo.Calculo;
import java.text.DecimalFormat;
import model.Amostra;
import model.ValorAmostra;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ana
 */
public class MyMockTest {
    
    private MyMock mymock;
    private Calculo calculoOmock;
    private  Amostra amostra=new Amostra();
    ValorAmostra v1=new ValorAmostra();
    ValorAmostra v2=new ValorAmostra();
    ValorAmostra v3=new ValorAmostra();
    ValorAmostra v4=new ValorAmostra();
    
    @Before
    public void setUp() {
        mymock=new MyMock();
        amostra=new Amostra();
        v1.setValor(12.9);
        v2.setValor(11.6);
        v3.setValor(13.8);
        v4.setValor(15.8);
        
        amostra.setDados(v1);
        amostra.setDados(v2);
        amostra.setDados(v3);
        amostra.setDados(v4);
        mymock.setAmostra(amostra);
        calculoOmock= EasyMock.createMock(Calculo.class);
        mymock.setCalculo(calculoOmock);
        
    }
    
    
     @Test
     public void max() {
        EasyMock.expect(calculoOmock.max(amostra)).andReturn(15.8);
        EasyMock.replay(calculoOmock);

        Amostra amostra2 = new Amostra();
        mymock.setAmostra(amostra);
        DecimalFormat decimal = new DecimalFormat( "0.0" );
        mymock.max();
        assertEquals("15,8", decimal.format(mymock.getAmostra().getMax()));
     }
     @Test
     public void min() {
        EasyMock.expect(calculoOmock.min(amostra)).andReturn(11.6);
        EasyMock.replay(calculoOmock);

        Amostra amostra2 = new Amostra();
        mymock.setAmostra(amostra);
        DecimalFormat decimal = new DecimalFormat( "0.0" );
        mymock.min();
        assertEquals("11,6", decimal.format(mymock.getAmostra().getMin()));
     }
     @Test
     public void Amplitude() {
        EasyMock.expect(calculoOmock.amplitude(amostra)).andReturn(4.3);
        EasyMock.replay(calculoOmock);

        Amostra amostra2 = new Amostra();
        mymock.setAmostra(amostra);
        DecimalFormat decimal = new DecimalFormat( "0.0" );
        mymock.amplitude();
        assertEquals("4,2", decimal.format(mymock.getAmostra().getAmplitude()));
     }
     @Test
     public void AmplitudeFalharUmMais() {
        EasyMock.expect(calculoOmock.amplitude(amostra)).andReturn(4.3);
        EasyMock.replay(calculoOmock);

        Amostra amostra2 = new Amostra();
        mymock.setAmostra(amostra);
        DecimalFormat decimal = new DecimalFormat( "0.0" );
        mymock.amplitude();
        assertEquals("4,3", decimal.format(mymock.getAmostra().getAmplitude()));
     }
     @Test
     public void AmplitudeFalharUmMenos() {
        EasyMock.expect(calculoOmock.amplitude(amostra)).andReturn(4.3);
        EasyMock.replay(calculoOmock);

        Amostra amostra2 = new Amostra();
        mymock.setAmostra(amostra);
        DecimalFormat decimal = new DecimalFormat( "0.0" );
        mymock.amplitude();
        assertEquals("4,1", decimal.format(mymock.getAmostra().getAmplitude()));
     }
     
}
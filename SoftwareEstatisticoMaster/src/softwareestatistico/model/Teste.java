/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareestatistico.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ana
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Double> amostra=new ArrayList<>();
        amostra.add(12.0);
        amostra.add(12.0);
        amostra.add(12.1);
        amostra.add(13.3);
        amostra.add(13.3);
        amostra.add(12.4);
        amostra.add(15.3);
        amostra.add(15.3);
        amostra.add(15.3);
        amostra.add(16.3);
        amostra.add(25.7);
        amostra.add(15.3);
        amostra.add(12.3);
        Calculo c=new CalculoImpl();
        c.setAmostra(amostra);
        System.out.println("moda:"+c.moda());
        System.out.println("mediana:"+c.mediana());
        System.out.println("média:"+c.media());
        System.out.println("variancia:"+c.variancia());
        System.out.println("desvio_padrao:"+c.desvio_padrao());
        System.out.println("amplitude:"+c.amplitude());
        System.out.println("amostra:"+c.getAmostra());
    }
}

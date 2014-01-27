/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import model.Amostra;

/**
 *
 * @author Ana
 */
public class Quartil implements Runnable{
    private List<Double> quartis=new ArrayList<>();
    private Amostra amostra;
    private Mediana mediana;
   

    public Quartil(Amostra amostra) {
        this.amostra = amostra;
        mediana=new Mediana(amostra);
        mediana.run();
    }
    
    @Override
    public void run() {
        DecimalFormat decimal = new DecimalFormat( "0" );
        double aux=Math.round(0.25*(amostra.getDados().size()));
        double q1=amostra.valores_ordenados_amostra().get(Integer.parseInt(decimal.format(aux)));
        aux=Math.round(0.75*(amostra.getDados().size()));
        double q3=amostra.valores_ordenados_amostra().get(Integer.parseInt(decimal.format(aux)));
                
        double q2=q3-q1;
        quartis.add(q1);
        quartis.add(q2);
        quartis.add(q3);
    }

    public List<Double> getQuartis() {
        return quartis;
    }
    
}

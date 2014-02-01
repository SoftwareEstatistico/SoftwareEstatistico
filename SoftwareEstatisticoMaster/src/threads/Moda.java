/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Amostra;
import model.ValorAmostra;


/**
 *
 * @author Ana
 */
public class Moda implements Runnable{
  
    private Amostra amostra;
    private int maxfreq=0;
    
    public Moda(Amostra amostra) {
        this.amostra = amostra;
    }
    @Override
    public void run() {
        double mo=Double.NaN;
        List<Double> dd=new ArrayList<>();
        for(ValorAmostra d: amostra.getDados()){
            dd.add(d.getValor());
        } 
        for (Double d : dd) {
            if(Collections.frequency(dd, d)>maxfreq){
                mo=d;
                maxfreq=Collections.frequency(dd, d);
            }
        }
        amostra.setModa(mo);
        
    }

    
}

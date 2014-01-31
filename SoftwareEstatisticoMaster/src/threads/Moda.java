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
        List<Double> dd=new ArrayList<>();
        double mo=0.0;
        for(ValorAmostra d: amostra.getDados()){
            dd.add(d.getValor());
        } 
        for (Double d : dd) {
            if(Collections.frequency(dd, d)>maxfreq){
                maxfreq=Collections.frequency(dd, d);
                System.out.println(maxfreq);
                amostra.setModa(d);
            }
            else if(Collections.frequency(dd, d)==maxfreq){
                amostra.setModa(Double.NaN);
            }
           
        }
         
       
    }

    
}

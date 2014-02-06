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
    private int maxfreq=1;
    
    public Moda(Amostra amostra) {
        this.amostra = amostra;
    }
    @Override
    public void run() {
        double mo=Double.NaN;
//        List<Double> dd=new ArrayList<>();
//        for(ValorAmostra d: amostra.getDados()){
//            dd.add(d.getValor());
//        } 
        for (Double d : amostra.valores_ordenados_amostra()) {
            if(Collections.frequency(amostra.valores_ordenados_amostra(), d)>maxfreq){
                mo=d;
                maxfreq=Collections.frequency(amostra.valores_ordenados_amostra(), d);
            }
        }
        amostra.setModa(mo);
        
    }

    
}

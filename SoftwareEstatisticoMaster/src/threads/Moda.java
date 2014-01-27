/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.Collections;
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
        for(ValorAmostra d: amostra.getDados()){
            if(Collections.frequency(amostra.getDados(), d.getValor())>maxfreq){
                amostra.setModa(d.getValor());
            }
        } 
    }

    
}

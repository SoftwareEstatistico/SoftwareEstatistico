/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Amostra;
import model.ValorAmostra;

/**
 *
 * @author Ana
 */
public class OrdenarAmostra implements Runnable{
    private Amostra amostra;
    public OrdenarAmostra(Amostra amostra) {
       this.amostra=amostra;
    }
    @Override
    public void run() {
        ordenarAmostra(amostra.getDados());
    }
    private List ordenarAmostra(List<ValorAmostra> amostra){
         Collections.sort (amostra, new Comparator() {  
            public int compare(Object o1, Object o2) {  
                Double p1 = (Double) o1;  
                Double p2 = (Double) o2;  
                return p1 < p2 ? -1 : (p1 > p2 ? +1 : 0);  
            }
         }); return amostra; 
    }
    
}
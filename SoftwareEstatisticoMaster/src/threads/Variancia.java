/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.ArrayList;
import java.util.List;
import model.Amostra;



/**
 *
 * @author Ana
 */
public class Variancia implements Runnable{
    private Amostra amostra;
//    private List<Double> desvio=new ArrayList();
    private  double r=0;
    private Desvio desvio;
    public Variancia(Amostra amostra) {
        this.amostra = amostra;
        desvio=new Desvio(amostra);
        desvio.run();
    }
    
    @Override
    public void run() {
      amostra.setVariancia(soma_desvio_ao_quadrado()/(amostra.getDados().size()));
    }
     private double soma_desvio_ao_quadrado(){
        r=0;
        for(int x=0;x<desvio.getDesvio().size();x++){
            r+=Math.pow(desvio.getDesvio().get(x),2);
        }
        return r;
    }
}

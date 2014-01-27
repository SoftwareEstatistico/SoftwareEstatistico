/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.ArrayList;
import java.util.List;
import model.Amostra;
import model.ValorAmostra;



/**
 *
 * @author Ana
 */
public class Desvio implements Runnable{
   
    private Amostra amostra;
    private Media media;
    private List<Double> desvio=new ArrayList<>();
    
    public List<Double> getDesvio() {
        return desvio;
    }

    public Desvio(Amostra amostra) {
        this.amostra = amostra;
        media=new Media(amostra);
        media.run();
    }
    

    @Override
    public void run() {
        for(int i=0;i<amostra.getDados().size();i++){
            desvio.add(amostra.getDados().get(i).getValor()-amostra.getMedia());
        }
    }
   
   
    
}

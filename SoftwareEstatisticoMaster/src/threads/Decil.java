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
public class Decil implements Runnable{
    //divide o conjunto em 10 partes iguais
    private List<Double>decil=new ArrayList<>();
    private Amostra amostra;

    public Decil(Amostra amostra) {
        this.amostra = amostra;
    }
    
    @Override
    public void run() {
        double d9=0.9*(amostra.getDados().size()+1);
        double d1=0.1*(amostra.getDados().size()+1);
        decil.add(d1);
        decil.add(d9);
    }

    public List<Double> getDecil() {
        return decil;
    }
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import model.Amostra;

/**
 *
 * @author Ana
 */
public class Soma implements Runnable{
   
    private Amostra amostra;
    private Double soma;

    public Soma(Amostra amostra) {
        this.amostra = amostra;
        this.soma=0.0;
    }

    @Override
    public void run() {
        for(int i=0;i<amostra.getDados().size();i++){
            soma+=amostra.getDados().get(i).getValor();
        }
    }

    public Double getSoma() {
        return soma;
    }

   
}

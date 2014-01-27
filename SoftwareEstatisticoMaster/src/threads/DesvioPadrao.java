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
public class DesvioPadrao implements Runnable{

    
    private Amostra amostra;
    private Variancia variancia;

    public DesvioPadrao(Amostra amostra) {
        this.amostra = amostra;
        variancia=new Variancia(amostra);
        variancia.run();
    }
    

    @Override
    public void run() {
        amostra.setDesvio_padrao(Math.sqrt(amostra.getVariancia()));
    }
    
}
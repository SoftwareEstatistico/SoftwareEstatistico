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
public class Media implements Runnable{
   private Amostra amostra;
   private Soma soma;
    public Media(Amostra amostra) {
        this.amostra = amostra;
        this.soma=new Soma(amostra);
    }
   
    @Override
    public void run() {
         
         soma.run();
         double Tsoma=soma.getSoma();
         amostra.setMedia( Tsoma/amostra.getDados().size());
    }

}

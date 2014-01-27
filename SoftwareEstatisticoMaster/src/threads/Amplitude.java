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
public class Amplitude implements Runnable{
   
    private Amostra amostra;
    private Max max;
    private Min min;

    public Amplitude(Amostra amostra) {
        this.amostra = amostra;
        max=new Max(amostra);
        max.run();
        min=new Min(amostra);
        min.run();
    }
    
    @Override
    public void run() {
        amostra.setAmplitude(amostra.getMax()-amostra.getMin());
    }
}

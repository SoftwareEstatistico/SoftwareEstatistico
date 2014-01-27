/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.Collections;
import model.Amostra;


/**
 *
 * @author Ana
 */
public class Max implements Runnable{
    private Amostra amostra;
    public Max(Amostra amostra) {
        this.amostra = amostra;
    }
    
    @Override
    public void run() {
        amostra.setMax(Collections.max(amostra.valores_ordenados_amostra()));
    }

}

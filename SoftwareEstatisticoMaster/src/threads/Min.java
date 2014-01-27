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
public class Min implements Runnable{
    private Amostra amostra;

    public Min(Amostra amostra) {
        this.amostra = amostra;
    }
    
    @Override
    public void run() {
        amostra.setMin(Collections.min(amostra.valores_ordenados_amostra()));
    }


}

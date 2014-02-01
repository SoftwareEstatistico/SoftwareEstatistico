/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.Collections;
import model.Amostra;
import model.FrequenciaAbsoluta1;
import model.ValorAmostra;


/**
 *
 * @author Ana
 */
public class FrequenciaAbsoluta implements Runnable{
    private Amostra amostra;

    public FrequenciaAbsoluta(Amostra amostra) {
        this.amostra = amostra;
    }
    
    @Override
    public void run() {
        for(Double d:amostra.valores_ordenados_amostra()){
                FrequenciaAbsoluta1 fa=new FrequenciaAbsoluta1();
                fa.setKey(d);
                fa.setValue(Collections.frequency(amostra.valores_ordenados_amostra(), d));
                amostra.setFa(fa);
        }
      
    }

}

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
        for (ValorAmostra dado : amostra.getDados()) {
              FrequenciaAbsoluta1 fa=new FrequenciaAbsoluta1();
              fa.setKey(dado.getValor());
              fa.setValue(Collections.frequency(amostra.getDados(), dado));
              amostra.setFa(fa);
        }
      
    }

}

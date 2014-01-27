/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import model.Amostra;
import model.FrequenciaRelativa1;


/**
 *
 * @author Ana
 */
public class FrequenciaRelativa implements Runnable{
   
    private Amostra amostra;

    public FrequenciaRelativa(Amostra amostra) {
        this.amostra = amostra;
    }
  
    
    @Override
    public void run() {
         for(int i=0;i<amostra.getDados().size();i++){
            double r=0;
            double a=0;
            double b=0;
            Double key=amostra.getFa().get(i).getKey();
            a=amostra.getFa().get(i).getValue();
            b=amostra.getDados().size();
            r=a/b;
            FrequenciaRelativa1 fr=new FrequenciaRelativa1();
            fr.setKey(key);
            fr.setValue(a);
            amostra.setFr(fr);
        }
    }

}

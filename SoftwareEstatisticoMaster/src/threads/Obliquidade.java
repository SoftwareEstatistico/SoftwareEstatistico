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
public class Obliquidade implements Runnable{
    private Amostra amostra;
    private Media media;
    private Mediana mediana;
    private DesvioPadrao desviopadrao;

    public Obliquidade(Amostra amostra) {
        this.amostra = amostra;
        media=new Media(amostra);
        media.run();
        mediana=new Mediana(amostra);
        mediana.run();
        desviopadrao=new DesvioPadrao(amostra);
        desviopadrao.run();       
        
    }
    
    @Override
    public void run() {
       double media=amostra.getMedia();
       double mediana=amostra.getMediana();
       double dp=amostra.getDesvio_padrao();
       amostra.setObliquidade((3*(media-mediana))/dp);
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareestatistico.multithread;

import softwareestatistico.model.Calculo;
import softwareestatistico.model.CalculoImpl;

/**
 *
 * @author Ana
 */
public class CalculoRunnable implements Runnable{

    static Thread threadModa;
    static Thread threadMediana;
    static Thread threadMedia;
    static Thread threadDesvio_Padrao;
    static Thread threadVariancia;
    static Thread threadFrequencia_Absoluta;
    static Thread threadFrequenciaString_Absoluta;
    static Thread threadFrequencia_Relativa;
    static Thread threadFrequenciaString_Relativa;
    static Thread threadMax;
    static Thread threadMin;
    static Thread threadCurtose;
    static Thread threadObliquidade;
    static Thread threadHistograma;
    Calculo calculo=new CalculoImpl();
    @Override
    public void run() {
        Thread currente_thread=Thread.currentThread();
       
        if(currente_thread.equals(threadDesvio_Padrao))
            calculo.desvio_padrao();
        else if(currente_thread.equals(threadMax))
            calculo.max();
        else if(currente_thread.equals(threadMin))
            calculo.min();
        else if(currente_thread.equals(threadMedia))
            calculo.media();
        else if(currente_thread.equals(threadMediana))
            calculo.mediana();
        else if(currente_thread.equals(threadModa))
            calculo.moda();
        else if(currente_thread.equals(threadVariancia))
            calculo.variancia();
        else if(currente_thread.equals(threadFrequencia_Absoluta))
            calculo.getFrequencia_Absoluta();
        else if(currente_thread.equals(threadFrequenciaString_Absoluta))
            calculo.getFrequencia_String_Absoluta();
        else if(currente_thread.equals(threadFrequencia_Relativa))
            calculo.frequencia_relativa();
        else if(currente_thread.equals(threadFrequenciaString_Relativa))
            calculo.frequencia_String_relativa();
        else if(currente_thread.equals(threadHistograma))
            calculo.histograma();
        else if(currente_thread.equals(threadCurtose))
            calculo.curtose();
        else if(currente_thread.equals(threadObliquidade))
            calculo.obliquidade();
            
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import calculo.Calculo;
import java.text.DecimalFormat;
import java.util.List;
import model.Amostra;
import model.FrequenciaAbsoluta1;
import model.FrequenciaRelativa1;
import threads.Amplitude;
import threads.Curtose;
import threads.DesvioPadrao;
import threads.FrequenciaAbsoluta;
import threads.FrequenciaRelativa;
import threads.Max;
import threads.Media;
import threads.Mediana;
import threads.Min;
import threads.Moda;
import threads.Obliquidade;
import threads.Variancia;

/**
 *
 * @author Ana
 */
public class MyMock {
    private Amostra amostra;
    private Calculo calculo;

    public void setAmostra(Amostra amostra) {
        this.amostra = amostra;
    }

    public Amostra getAmostra() {
        return amostra;
    }
    
    public void setCalculo(Calculo calculo) {
        this.calculo = calculo;
    }
    public Double media() {
        calculo.media(amostra);
        Media media=new Media(amostra);
        media.run();
        return amostra.getMedia();
    }

    public Double mediana() {
        calculo.mediana(amostra);
        Mediana mediana=new Mediana(amostra);
        mediana.run();
        return amostra.getMediana();
    }

    public Double variancia() {
        calculo.variancia(amostra);
        Variancia variancia=new Variancia(amostra);
        variancia.run();
        return amostra.getVariancia();
    }

    public Double desviopadrao() {
        calculo.desviopadrao(amostra);
        DesvioPadrao desvioPadrao=new DesvioPadrao(amostra);
        desvioPadrao.run();
        return amostra.getDesvio_padrao();
    }

    public Double amplitude() {
        calculo.amplitude(amostra);
        Amplitude amplitude=new Amplitude(amostra);
        amplitude.run();
        DecimalFormat decimal = new DecimalFormat( "0.0" );
        return Double.parseDouble(decimal.format(amostra.getAmplitude()).replace(",", "."));
    }

    public Double max() {
        calculo.max(amostra);
        Max max=new Max(amostra);
        max.run();
        return amostra.getMax();
    }

    public Double min() {
        calculo.min(amostra);
        Min min=new Min(amostra);
        min.run();
        return amostra.getMin();
    }
    //testar os abaixo
    public Double curtose(){
        calculo.curtose(amostra);
        Curtose curtose=new Curtose(amostra);
        curtose.run();
        System.out.println(amostra.getCurtose());
        return amostra.getCurtose();
    }
    public Double obliquidade(){
        calculo.obliquidade(amostra);
        Obliquidade obliquidade=new Obliquidade(amostra);
        obliquidade.run();
        return amostra.getObliquidade();
    }
    public List<FrequenciaRelativa1> frequenciaRelativa(Amostra amostra){
        FrequenciaRelativa fr=new FrequenciaRelativa(amostra);
        fr.run();
        return amostra.getFr();
    }
    public List<FrequenciaAbsoluta1> frequenciaAbsoluta(Amostra amostra){
        FrequenciaAbsoluta fa=new FrequenciaAbsoluta(amostra);
        fa.run();
        return amostra.getFa();
    }
    public Double moda(){
        calculo.moda(amostra);
        Moda moda=new Moda(amostra);
        moda.run();
        return amostra.getModa();
    }
}

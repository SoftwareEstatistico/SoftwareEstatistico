/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculo;

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
public class CalculoImpl implements Calculo{
    private Amostra amostra;
    public Amostra getAmostra() {
        return amostra;
    }

    @Override
    public Double media(Amostra amostra) {
        Media media=new Media(amostra);
        media.run();
        return amostra.getMedia();
    }

    @Override
    public Double mediana(Amostra amostra) {
        Mediana mediana=new Mediana(amostra);
        mediana.run();
        return amostra.getMediana();
    }

    @Override
    public Double variancia(Amostra amostra) {
        Variancia variancia=new Variancia(amostra);
        variancia.run();
        return amostra.getVariancia();
    }

    @Override
    public Double desviopadrao(Amostra amostra) {
        DesvioPadrao desvioPadrao=new DesvioPadrao(amostra);
        desvioPadrao.run();
        return amostra.getDesvio_padrao();
    }

    @Override
    public Double amplitude(Amostra amostra) {
        Amplitude amplitude=new Amplitude(amostra);
        amplitude.run();
        DecimalFormat decimal = new DecimalFormat( "0.0" );
        return Double.parseDouble(decimal.format(amostra.getAmplitude()).replace(",", "."));
    }

    @Override
    public Double max(Amostra amostra) {
        Max max=new Max(amostra);
        max.run();
        return amostra.getMax();
    }

    @Override
    public Double min(Amostra amostra) {
        Min min=new Min(amostra);
        min.run();
        return amostra.getMin();
    }
    //testar os abaixo
    public Double curtose(Amostra amostra){
        Curtose curtose=new Curtose(amostra);
        curtose.run();
        System.out.println(amostra.getCurtose());
        return amostra.getCurtose();
    }
    public Double obliquidade(Amostra amostra){
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
    public Double moda(Amostra amostra){
        Moda moda=new Moda(amostra);
        moda.run();
        return amostra.getModa();
    }
    
}

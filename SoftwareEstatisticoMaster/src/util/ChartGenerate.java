/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.Amostra;
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

/**
 *
 * @author Ana
 */
public class ChartGenerate implements IChartGenerate{
    private static ChartGenerate instance;
    private Amostra amostra;
    private StringBuilder sb=new StringBuilder();
    private ChartGenerate() {
    }

    public static ChartGenerate getInstance() {
        if(instance==null)
            if(instance==null)
                instance=new ChartGenerate();
        return instance;
    }

    @Override
    public void stringstatica(Amostra amostra) {
        FrequenciaAbsoluta fa=new FrequenciaAbsoluta(amostra);
        fa.run();
        FrequenciaRelativa fr=new FrequenciaRelativa(amostra);
        fr.run();
        sb.append("RESULTADO DA AMOSTRA:");
        sb.append("\n");
        sb.append("Frequência Absoluta:");
        sb.append(amostra.getFa());
        sb.append("\n");
        sb.append("Frequência Relativa:");
        sb.append(amostra.getFr());
        sb.append("\n");
        this.amostra=amostra;
        System.out.println("Entra"+amostra);
    }

    @Override
    public void stringsmax(boolean mostrar) {
         if(mostrar){
            Max ma=new Max(amostra);
            ma.run();
            sb.append("Max:");
            sb.append(amostra.getMax());
            sb.append("\n");
         }
    }

    @Override
    public void stringsmin(boolean mostrar) {
         if(mostrar){
            Min mi=new Min(amostra);
            mi.run();
            sb.append("Min:");
            sb.append(amostra.getMin());
            sb.append("\n");    
         }
    
    }

    @Override
    public void stringsmedia(boolean mostrar) {
         if(mostrar){
            Media me=new Media(amostra);
            me.run();
            sb.append("Media:");
            sb.append(amostra.getMedia());
            sb.append("\n");
         }
    }

    @Override
    public void stringsmediana(boolean mostrar) {
         if(mostrar){
            Mediana md=new Mediana(amostra);
            md.run();
            sb.append("Mediana:");
            sb.append(amostra.getMediana());
            sb.append("\n");
         }
    }

    @Override
    public void stringsmoda(boolean mostrar) {
         if(mostrar){
            Moda mo=new Moda(amostra);
            mo.run();
            sb.append("Moda:");
            sb.append(amostra.getModa());
            sb.append("\n");
         }
    }

    @Override
    public void stringscurtose(boolean mostrar) {
         if(mostrar){
            Curtose cu=new Curtose(amostra);
            cu.run();
            sb.append("Curtose:");
            sb.append(amostra.getCurtose());
            sb.append("\n");
         }
    }

    @Override
    public void stringsobliquidade(boolean mostrar) {
         if(mostrar){
            Obliquidade ob=new Obliquidade(amostra);
            ob.run();
            sb.append("Obliquidade:");
            sb.append(amostra.getObliquidade());
            sb.append("\n");
         }
    }

    @Override
    public void stringsdesviopadrao(boolean mostrar) {
        if(mostrar){
         DesvioPadrao desvioPadrao=new DesvioPadrao(amostra);
         desvioPadrao.run();
         sb.append("Desvio Padrão:");
         sb.append(amostra.getDesvio_padrao());
         sb.append("\n");
        }
    }

    @Override
    public String getstrings() {
        return sb.toString();
    }
    
}

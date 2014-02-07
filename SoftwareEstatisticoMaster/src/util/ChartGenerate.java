/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import model.Amostra;
import model.FrequenciaAbsoluta1;
import model.FrequenciaRelativa1;
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
public class ChartGenerate implements IChartGenerate{
    private static ChartGenerate instance;
    private Amostra amostra;
    private StringBuilder sb=new StringBuilder();
    private  Set<FrequenciaAbsoluta1> s=new LinkedHashSet<FrequenciaAbsoluta1>();
    private  Set<FrequenciaRelativa1> s2=new LinkedHashSet<FrequenciaRelativa1>();
    private ChartGenerate() {
    }

    public static ChartGenerate getInstance() {
        if(instance==null)
            if(instance==null)
                instance=new ChartGenerate();
        return instance;
    }
    public void frToset(List<FrequenciaRelativa1> fas){
        s2.addAll(fas);
    }
    public String makeStringViewFr(){
        StringBuilder sb=new StringBuilder();
        sb.append("Frequência Relativa");
        sb.append("\n");
        //sao objetos diferentes por isso o set não funciona para keys duplicadas
        for (FrequenciaRelativa1 fr1 : s2) {
                sb.append("chave:"+fr1.getKey());
                sb.append("\n");
                sb.append("valor:"+fr1.getValue());
                sb.append("\n");
            
        }
        return sb.toString();
    }
    public void faToset(List<FrequenciaAbsoluta1> fas){
        s.addAll(fas);
    }
    public String makeStringViewFa(){
        StringBuilder sb=new StringBuilder();
        sb.append("Frequência Absoluta");
        sb.append("\n");
        //sao objetos diferentes por isso o set não funciona para keys duplicadas
        for (FrequenciaAbsoluta1 fa1 : s) {
                sb.append("chave:"+fa1.getKey());
                sb.append("\n");
                sb.append("valor:"+fa1.getValue());
                sb.append("\n");
            }
        return sb.toString();
    }
    @Override
    public void stringstatica(Amostra amostra) {
        FrequenciaAbsoluta fa=new FrequenciaAbsoluta(amostra);
        fa.run();
        FrequenciaRelativa fr=new FrequenciaRelativa(amostra);
        fr.run();
        sb.append("RESULTADO DA AMOSTRA:");
        sb.append("\n");
        faToset(amostra.getFa());
        sb.append(makeStringViewFa());
        sb.append("\n");
        frToset(amostra.getFr());
        sb.append(makeStringViewFr());
        sb.append("\n");
        this.amostra=amostra;
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
    public void stringsvariancia(boolean mostrar) {
         if(mostrar){
            Variancia ob=new Variancia(amostra);
            ob.run();
            sb.append("Variancia:");
            sb.append(amostra.getVariancia());
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

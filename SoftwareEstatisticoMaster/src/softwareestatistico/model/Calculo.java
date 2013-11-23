/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareestatistico.model;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Ana
 */
public interface Calculo {
    public List<Double> getAmostra();
    public void setAmostra(List<Double> amostra);
    public double media();
    public double moda();
    public double mediana();
    public double amplitude();
    public double variancia();
    public double desvio_padrao();
    public double coeficiente_variacao();
    public boolean simetrica();
    public double max();
    public double min();
    public Map<Double, Integer> getFrequencia_Absoluta();
    public Map<String, Integer> getFrequencia_String_Absoluta();
    public List<String> getAmostra_String();
    public void setAmostra_String(List<String> amostra);
    public Map<Double,Integer> frequencia_relativa();
    public Map<String,Integer> frequencia_String_relativa();
    public double histograma();
    public double curtose();
    public double obliquidade();
}

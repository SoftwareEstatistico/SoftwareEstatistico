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
    public double q1();
    public double q2();
    public double q3();
    public double amplitude();
    public double variancia();
    public double desvio_padrao();
    public double coeficiente_variacao();
    public boolean simetrica();
}

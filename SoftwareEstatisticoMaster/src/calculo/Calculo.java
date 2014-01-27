/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculo;

import model.Amostra;

/**
 *
 * @author Ana
 */
public interface Calculo {
    public Double media(Amostra amostra);
    public Double mediana(Amostra amostra);
    public Double variancia(Amostra amostra);
    public Double desviopadrao(Amostra amostra);
    public Double amplitude(Amostra amostra);
    public Double max(Amostra amostra);
    public Double min(Amostra amostra);
}

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
public class CalculoServico {
    private Calculo calculo;
    
    public CalculoServico(Calculo calculo) {
        this.calculo = calculo;
    }
    public Double media(Amostra amostra) {
        return calculo.media(amostra);
    }

    public Double mediana(Amostra amostra) {
        return calculo.mediana(amostra);
    }

    public Double variancia(Amostra amostra) {
        return calculo.variancia(amostra);
    }

    public Double desviopadrao(Amostra amostra) {
        return calculo.desviopadrao(amostra);
    }

    public Double amplitude(Amostra amostra) {
        return calculo.amplitude(amostra);
    }

    public Double max(Amostra amostra) {
       return calculo.max(amostra);
    }

    public Double min(Amostra amostra) {
        return calculo.min(amostra);
    }
}

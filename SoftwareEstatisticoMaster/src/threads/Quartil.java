/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import model.Amostra;

/**
 *
 * @author Ana
 */
public class Quartil implements Runnable{
    private List<Double> quartis=new ArrayList<>();
    private Amostra amostra;
    private Mediana mediana;
   

    public Quartil(Amostra amostra) {
        this.amostra = amostra;
        mediana=new Mediana(amostra);
        mediana.run();
    }
    
    @Override
    public void run() {
        quartis.add(esq());
        quartis.add(amostra.getMediana());
        quartis.add(dir());
        System.out.println(quartis.get(0));
        System.out.println(quartis.get(1));
        System.out.println(quartis.get(2));
    }
    public double esq(){
        List<Double> aux=new ArrayList<>();
        aux.addAll(amostra.valores_ordenados_amostra().subList(0, mediana.getIndex1()+1));
        System.out.println(aux);
        return md(aux);
    }
    public double md(List<Double> aux){
        double md=0.0;
        int i=0;
        int j=aux.size()-1;
        while(i!=(aux.size()-1)||j!=0||j==i||j>i){
             if(j==i){
                    md=aux.get(i);
                    return md;
                }else if(j<i){
                    md=(aux.get(i)+amostra.valores_ordenados_amostra().get(j))/2;
                    return md;
                }
            i++;
            j--;
        }return md;
    }
    public double dir(){
        List<Double> aux=new ArrayList<>();
        aux.addAll(amostra.valores_ordenados_amostra().subList(mediana.getIndex2()-1,amostra.valores_ordenados_amostra().size()-1));
        System.out.println(aux);
        return md(aux);
    }
    public List<Double> getQuartis() {
        return quartis;
    }
    
}

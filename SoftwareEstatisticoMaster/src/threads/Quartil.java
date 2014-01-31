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
    }
    public double esq(){
        List<Double> aux=new ArrayList<>();
        aux.addAll(amostra.valores_ordenados_amostra().subList(0, mediana.getIndex1()));
         double md=0.0;
        int count=0;
        for(int i=0;i<aux.size();i++){
            for(int j=0;j>aux.size();j--){
                if(j==i){
                    md=aux.get(i);
                }else if(j>i){
                    md=(aux.get(i)+aux.get(j))/2;
                }
            }
        }return md;
    }
    public double dir(){
        List<Double> aux=new ArrayList<>();
        aux.addAll(amostra.valores_ordenados_amostra().subList(mediana.getIndex2(),amostra.valores_ordenados_amostra().size()));
        double md=0.0;
        int count=0;
        for(int i=0;i<aux.size();i++){
            for(int j=0;j>aux.size();j--){
                if(j==i){
                    md=aux.get(i);
                }else if(j>i){
                    md=(aux.get(i)+aux.get(j))/2;
                }
            }
        }return md;
    }
    public List<Double> getQuartis() {
        return quartis;
    }
    
}

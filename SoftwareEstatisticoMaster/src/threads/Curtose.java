/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.ArrayList;
import java.util.List;
import model.Amostra;



/**
 *
 * @author Ana
 */
public class Curtose implements Runnable{
    private Amostra amostra;
    private Soma soma;
    private Mediana mediana;
    
    
    public Curtose(Amostra amostra) {
        this.amostra = amostra;
        this.soma=new Soma(amostra);
        this.mediana=new Mediana(amostra);
        mediana.run();
        soma.run();
    }
    
            
    @Override
    public void run() {
        double result=0;
        result=(mediana.q3()-mediana.q1())/(2*(percent_90()-percent_10()));
        amostra.setCurtose(result);
//        amostra.setCurtose((quartil.getQuartis().get(0)-quartil.getQuartis().get(2))/(2*(decil.getDecil().get(1)-decil.getDecil().get(0))));
    }
   //percentil=numero de valores inferiores a x /total de valores*100
    public double percent_10(){
        double p10=((soma.getSoma()-1)*10)/(100+1);
        return p10;
    }
  
    public double percent_90(){
        double p90=((soma.getSoma()-1)*90)/(100+1);
        return p90;
    }

//    public double q1() {
//        //mediana superior
//        double q1;
//        List<Double> s=new ArrayList();
//        for(int i=0;i<amostra.getDados().size()/2;i++){
//            s.add(amostra.getDados().get(i).getValor());
//        }
//        int posicao=s.size()/2;
//        q1= s.get(posicao);
//        return q1;
//    }
//
//    public double q3() {
//        //mediana inferior
//        double q3;
//         List<Double> i=new ArrayList();
//        for(int s=amostra.getDados().size()/2;s<amostra.getDados().size();s++){
//            i.add(amostra.getDados().get(s).getValor());
//        }
//        int posicao=i.size()/2;
//        q3= i.get(posicao);
//        return q3;
//    }

    
}

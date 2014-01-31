/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Amostra;

/**
 *
 * @author Ana
 */
public class Mediana implements Runnable{
    private Amostra amostra;
    private int index1;
    private int index2;

    public int getIndex1() {
        return index1;
    }

    public int getIndex2() {
        return index2;
    }
    
    public Mediana(Amostra amostra) {
        this.amostra = amostra;
    }
    
    

    @Override
    public void run() {
//       int posicao=(amostra.getDados().size())/2;
//       if((amostra.getDados().size())%2!=0){
//           amostra.setMediana(amostra.getDados().get(posicao).getValor());
//       }else{
////            List<Double> aux1=new ArrayList<>();
////            List<Double> aux2=new ArrayList<>();
//            aux1.addAll(amostra.valores_ordenados_amostra().subList(0, posicao));
//            aux2.addAll(amostra.valores_ordenados_amostra().subList(posicao,amostra.getDados().size()));
//            double md=0;
//            double n1=Collections.max(aux1);
//            double n2=Collections.min(aux2);
//            md=(n2+n1)/2;
//            amostra.setMediana(md);
//       }
        amostra.setMediana(mediana());
    }
    public double mediana(){
        double md=0.0;
        int count=0;
        for(int i=0;i<amostra.valores_ordenados_amostra().size();i++){
            for(int j=0;j>amostra.valores_ordenados_amostra().size();j--){
                if(j==i){
                    md=amostra.valores_ordenados_amostra().get(i);
                    index1=j;
                    index2=i;
                }else if(j>i){
                    index1=j;
                    index2=i;
                    md=(amostra.valores_ordenados_amostra().get(i)+amostra.valores_ordenados_amostra().get(j))/2;
                }
            }
        }return md;
    }
//    //mediana inferior
//    public double q3(){
//        double mdi=0;
//        int posicao=(aux2.size())/2;
//       if((aux2.size())%2!=0){
//           int p=(aux2.size()-1)/2;
//           mdi=aux2.get(p);
//       }else{
//            List<Double> x1=new ArrayList<>();
//            List<Double> x2=new ArrayList<>();
//            x1.addAll(aux2.subList(0, posicao));
//            x2.addAll(aux2.subList(posicao,aux2.size()));
//            double n1=Collections.max(x1);
//            double n2=Collections.min(x2);
//            mdi=(n2+n1)/2;
//            System.out.println("q3-"+mdi);
//            
//       }return mdi;
//    }
//    //mediana superior
//    public double q1(){
//        double mds=0;
//        int posicao=(aux1.size())/2;
//       if((aux1.size())%2!=0){
//           int p=(aux2.size()-1)/2;
//           mds=aux1.get(p);
//       }else{
//            List<Double> x1=new ArrayList<>();
//            List<Double> x2=new ArrayList<>();
//            x1.addAll(aux1.subList(0, posicao));
//            x2.addAll(aux1.subList(posicao,aux1.size()));
//            
//            double n1=Collections.max(x1);
//            double n2=Collections.min(x2);
//            mds=(n2+n1)/2;
//            System.out.println("q1-"+mds);
//            
//       }return mds;
//    }

}

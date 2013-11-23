/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareestatistico.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Ana
 */
public class CalculoImpl implements Calculo{
    private double moda;
    private double media;
    private double mediana;
    private Map<Double,Integer> frequencia=new TreeMap<>();
    private Map<String,Integer> frequencia_String=new TreeMap<>();
    private double variancia;
    private double desvio_padrao;
    private double amplitude;
    private double coeficiente_variacao;
    private List<Double> amostra;
    private List<String> amostra_String;
     @Override
    public Map<Double, Integer> getFrequencia_Absoluta() {
        return frequencia;
    }
     @Override
    public Map<String, Integer> getFrequencia_String_Absoluta() {
        return frequencia_String;
    }
    @Override
    public List<String> getAmostra_String() {
        return amostra_String;
    }
     @Override
    public void setAmostra_String(List<String> amostra_String) {
        this.amostra_String = amostra_String;
    }
    
    @Override
    public List<Double> getAmostra() {
        return amostra;
    }
    //seta a lista ordenada
    @Override
    public void setAmostra(List<Double> amostra) {
        this.amostra = ordenarAmostra(amostra);
    }

    //ordena a lista
    private List ordenarAmostra(List<Double> amostra){
         Collections.sort (amostra, new Comparator() {  
            public int compare(Object o1, Object o2) {  
                Double p1 = (Double) o1;  
                Double p2 = (Double) o2;  
                return p1 < p2 ? -1 : (p1 > p2 ? +1 : 0);  
            }
         }); return amostra; 
    }
    
    @Override
    public double media() {//ok
        double soma=soma();
        media= soma/amostra.size();
        return media;
    }
    private double soma(){
        double soma=0;
        for(int i=0;i<amostra.size();i++){
            soma+=amostra.get(i);
        }return soma; 
    }
    @Override
    public double moda() {//ok
        frequencia();
        Integer max=0;
        for(Integer max_frequencia:frequencia.values()){
            if(max_frequencia>max)
                 max=max_frequencia;
        }
        Set set=frequencia.entrySet();
        Iterator i=set.iterator();
        while(i.hasNext()){
            Map.Entry me=(Map.Entry) i.next();
            if(me.getValue().equals(max))
                moda=(double) me.getKey();
        }
        return moda;
    }

    @Override
    public double mediana() {//ok
        int posicao=amostra.size()/2;
        mediana= amostra.get(posicao);
        return mediana;
    }

    @Override
    public double variancia() {//ok
        variancia=Math.pow(soma(),2)/amostra.size();
        return variancia;
    }

    @Override
    public double desvio_padrao() {//ok
        desvio_padrao=Math.sqrt(variancia);
        return desvio_padrao;
    }

    private void frequencia() {//ok
        for(Double dado:amostra){
            Integer count=frequencia.get(dado);
            if(count==null)
                count=0;
            frequencia.put(dado, count+1);
        }
    }
    private void frequencia_String() {//ok
        for(String dado:amostra_String){
            Integer count=frequencia.get(dado);
            if(count==null)
                count=0;
            frequencia_String.put(dado, count+1);
        }
    }

    @Override
    public double amplitude() {
        amplitude=amostra.get(amostra.size()-1)-amostra.get(0);
        return amplitude;
    }

    @Override
    public double coeficiente_variacao() {
        coeficiente_variacao=desvio_padrao/media;
        return media;
    }

    @Override
    public boolean simetrica() {
        //distribuicao simetrica quando moda,media e mediana sao iguais
        if(moda==media&&media==mediana){
            return true;
        }else{
            return false;
        }
        
    }
    //amostra esta em ordem crescente
    //por tanto primeiro elemento é o menor
    //ultmimo é o maior
    @Override
    public double max() {
        return amostra.get(amostra.size()-1);
    }

    @Override
    public double min() {
       return amostra.get(0); 
    }

    @Override
    public double histograma() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double curtose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double obliquidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Double, Integer> frequencia_relativa() {
        Map<Double,Integer> fr_relativa=new TreeMap<>();
         for(Double dado:amostra){
            Integer count=frequencia.get(dado);
            if(count==null)
                count=0;
            fr_relativa.put(dado, count+1/amostra.size());
        }
        return fr_relativa;
    }

    @Override
    public Map<String, Integer> frequencia_String_relativa() {
         Map<String,Integer> fr_relativa=new TreeMap<>();
         for(String dado:amostra_String){
            Integer count=frequencia.get(dado);
            if(count==null)
                count=0;
            fr_relativa.put(dado, count+1/amostra.size());
        }
        return fr_relativa;
    }
    
}

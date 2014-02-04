/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Ana
 */
public class FrequenciaRelativa1 {
    private Double key;
    private Double value;
    private  Set<FrequenciaRelativa1> s=new HashSet<FrequenciaRelativa1>();

    public Double getKey() {
        return key;
    }

    public void setKey(Double key) {
        this.key = key;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
     public void faToset(List<FrequenciaRelativa1> fas){
        s.addAll(fas);
    }
    public String makeStringView(){
        StringBuilder sb=new StringBuilder();
        sb.append("Frequência Absoluta");
        sb.append("/n");
        for (FrequenciaRelativa1 fr1 : s) {
            sb.append("chave:"+fr1.getKey());
            sb.append("/n");
            sb.append("valor:"+fr1.getValue());
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return makeStringView();
    }
    
}

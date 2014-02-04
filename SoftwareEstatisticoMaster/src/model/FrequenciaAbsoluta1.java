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
public class FrequenciaAbsoluta1 {
    private Double key;
    private Integer value;
    private  Set<FrequenciaAbsoluta1> s=new HashSet<FrequenciaAbsoluta1>();

    public Double getKey() {
        return key;
    }

    public void setKey(Double key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    public void faToset(List<FrequenciaAbsoluta1> fas){
        s.addAll(fas);
    }
    public String makeStringView(){
        StringBuilder sb=new StringBuilder();
        sb.append("Frequência Absoluta");
        sb.append("/n");
        for (FrequenciaAbsoluta1 fa1 : s) {
            sb.append("chave:"+fa1.getKey());
            sb.append("/n");
            sb.append("valor:"+fa1.getValue());
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return makeStringView();
    }
    
}

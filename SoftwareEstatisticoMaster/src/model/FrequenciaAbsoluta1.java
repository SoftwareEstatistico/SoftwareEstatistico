/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ana
 */
public class FrequenciaAbsoluta1 {
    private Double key;
    private Integer value;

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

    @Override
    public String toString() {
        return "Frequência Absoluta Para Todos os Dados da Amostra: "
                + "\n" + "key=" + key + "\n value=" + value + '\n';
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashSet;
import javax.naming.ldap.HasControls;

/**
 *
 * @author Ana
 */
public class FrequenciaRelativa1 {
    private Double key;
    private Double value;

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

    @Override
    public String toString() {
        return "Frequencia Relativa Para Todos os números da Amostra:"
                + " \n " + "key=" + key + " \n  value=" + value + '\n';
    }
    
}

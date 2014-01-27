/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Ana
 */
public class ValorAmostra {
    private Double valor;
    private Date date=new Date();

    public ValorAmostra() {
        long dt=date.getTime();
        date=new Timestamp(dt);
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "ValorAmostra{" + "valor=" + valor + ", date=" + date + '}';
    }
    
}

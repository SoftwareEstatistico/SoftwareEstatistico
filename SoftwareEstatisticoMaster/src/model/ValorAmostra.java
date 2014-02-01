/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.googlecode.jcsv.annotations.MapToColumn;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Ana
 */
public class ValorAmostra  {
    @MapToColumn(column = 0)
    private Double valor;
    @MapToColumn(column = 1)
    private Date date=new Date();

    public ValorAmostra() {
        long dt=date.getTime();
        date=new Timestamp(dt);
    }

    public ValorAmostra(Double valor,Date date) {
        this.valor = valor;
        this.date = date;
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
        return  valor + "-" + date;
    }
    
}

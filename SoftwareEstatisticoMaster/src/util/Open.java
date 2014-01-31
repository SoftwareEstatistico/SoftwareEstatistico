/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;
import javafx.collections.ObservableList;
import model.ValorAmostra;

/**
 *
 * @author Ana
 */
public class Open implements Runnable{
    private List<ValorAmostra> vrls;
    private ObservableList ol;

    public Open(List<ValorAmostra> vrls,ObservableList ol) {
        this.vrls = vrls;
        this.ol = ol;
    }
    
    @Override
    public void run() {
        for (ValorAmostra valorAmostra : vrls) {
            ol.addAll(vrls);
        }
    }
    
}

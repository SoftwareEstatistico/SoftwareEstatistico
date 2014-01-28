/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Ana
 */
public class ChartGenerate {
    private static ChartGenerate instance;

    private ChartGenerate() {
    }

    public static ChartGenerate getInstance() {
        if(instance==null)
            if(instance==null)
                instance=new ChartGenerate();
        return instance;
    }
    
    
    
}

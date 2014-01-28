/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.Amostra;
import model.ValorAmostra;

/**
 *
 * @author Ana
 */
public class SalvarCSV {
     private Amostra amostra; 
     private ValorAmostra valorAmostra;
     //valor e date intercalados
     public void criarFile(List<String> vlrs, String filepath){ 
        try{
            File file=new File(filepath);
            if(file.exists()){
            //; coluna /n muda de linha
                BufferedWriter StrW = new BufferedWriter(new FileWriter(filepath));
                for (String vlr : vlrs) {
                    StrW.write(vlr+";");//corrigir
                }

                StrW.close(); 
            }
        }catch (FileNotFoundException ex)
        {
        ex.printStackTrace(); 
        }catch (IOException e)
        {
        e.printStackTrace(); } 
        }
     public Amostra LerFile(String filepath){
        String Str; 
        Amostra amostra=new Amostra();
        
        try {
            BufferedReader StrR = new BufferedReader(new FileReader(filepath));
            
            String[] TableLine;
           
            while((Str = StrR.readLine())!= null){
                TableLine = Str.split(";");

            for (String cell : TableLine) { 
                valorAmostra=new ValorAmostra();
                valorAmostra.setValor(Double.parseDouble(cell));
                amostra.setDados(valorAmostra);
                }
                }
            StrR.close();
            
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        } catch (IOException ex){
        ex.printStackTrace();
        }
         return amostra;

    }
     
}

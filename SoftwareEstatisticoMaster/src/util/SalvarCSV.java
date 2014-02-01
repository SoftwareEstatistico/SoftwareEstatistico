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

/**
 *Não uso mais
 * @author Ana
 */
public class SalvarCSV {
 
     public void criarFile(List<String> vlrs, String filepath){ 
        try{
            File file=new File(filepath);
            if(file.exists()){
            //; coluna /n muda de linha
                BufferedWriter StrW = new BufferedWriter(new FileWriter(filepath));
                for (String vlr : vlrs) {
                    StrW.write(vlr+";");
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
     public String LerFile(String filepath){
        String Str,s; 
        s="";
        try {
            BufferedReader StrR = new BufferedReader(new FileReader(filepath));
            
            String[] TableLine;
           
            while((Str = StrR.readLine())!= null){
                TableLine = Str.split(";");

            for (String cell : TableLine) { 
                s+=cell+" "; 
                }
                s+="\n";
                }
            StrR.close();
            
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        } catch (IOException ex){
        ex.printStackTrace();
        }
         return s;

    }
     
}

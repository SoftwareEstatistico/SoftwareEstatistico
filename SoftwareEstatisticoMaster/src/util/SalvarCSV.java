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
 *
 * @author Ana
 */
public class SalvarCSV {
//     public static String leArquivo(String arquivo) throws FileNotFoundException, IOException {  
//  
//            File file = new File(arquivo);  
//
//            if (! file.exists()) {  
//                return null;  
//            }  
//                BufferedReader br = new BufferedReader(new FileReader(arquivo));  
//                StringBuilder bufSaida = new StringBuilder();  
//
//                String linha;  
//
//                while( (linha = br.readLine()) != null ){  
//
//                   bufSaida.append(linha).append("\n");  
//                 }  
//
//               br.close();  
//               return bufSaida.toString();  
//                // return bufSaida.toString();  
//            }  
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
     public void LerFile(String filepath){
        try {

            BufferedReader StrR = new BufferedReader(new FileReader(filepath));

            String Str;
            String[] TableLine;

            while((Str = StrR.readLine())!= null){
                TableLine = Str.split(";");

            for (String cell : TableLine) { 
                System.out.print(cell+" "); 
                }
                System.out.println("\n");
                }
            StrR.close();
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        } catch (IOException ex){
        ex.printStackTrace();
        }

    }
     
}

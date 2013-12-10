/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package betwixt;

import amostra.Amostra;
import amostra.Dado_Amostra;
import java.beans.IntrospectionException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.betwixt.io.BeanWriter;
import org.xml.sax.SAXException;

/**
 *cria um xml a partir de um objeto
 * @author Ana
 */
public class Create {

    /**
     * @param args the command line arguments
     */
    
    public static void createxml() throws IOException, SAXException, IntrospectionException {
      
        StringWriter outputWriter = new StringWriter(); 
        
     
        outputWriter.write("<?xml version='1.0' ?>");
        
    
        BeanWriter beanWriter = new BeanWriter(outputWriter);
        
     
        beanWriter.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(false);
        beanWriter.getBindingConfiguration().setMapIDs(false);
        beanWriter.enablePrettyPrint();

        Amostra amostra=new Amostra();
        amostra.setAmplitude(1);
        amostra.setCurtose(1);
        amostra.setDesvio_padrao(1);
        amostra.setF_absoluta(1);
        amostra.setF_relativa(1);
        amostra.setMax(1);
        amostra.setMedia(1);
        amostra.setMediana(1);
        amostra.setMin(1);
        amostra.setModa(12);
        amostra.setNome("Venda de Carros");
        amostra.setObliquidade(1);
        amostra.setVariancia(1);
        Dado_Amostra d1=new Dado_Amostra();
        Dado_Amostra d2=new Dado_Amostra();
        Dado_Amostra d3=new Dado_Amostra();
        Dado_Amostra d4=new Dado_Amostra();
        Dado_Amostra d5=new Dado_Amostra();
        Dado_Amostra d6=new Dado_Amostra();
        d1.setDescricao("Ford");
        d2.setDescricao("Fiat");
        d3.setDescricao("Renault");
        d4.setDescricao("Ferrarri");
        d5.setDescricao("Lamburguini");
        d6.setDescricao("GM");
        d1.setValor(12);
        d2.setValor(12);
        d3.setValor(12);
        d4.setValor(13);
        d5.setValor(10);
        d6.setValor(10);
        
        amostra.setDados(d1);
        amostra.setDados(d2);
        amostra.setDados(d3);
        amostra.setDados(d4);
        amostra.setDados(d5);
        amostra.setDados(d6);

        beanWriter.write("amostra", amostra);
        
        System.out.println(outputWriter.toString());
        
        File f=new File(Create.class.getResource("/xml").getPath()+"/amostra.xml");
        if(!f.exists())
             f.createNewFile();
        else
            f.delete();
       OutputStream bytes = new FileOutputStream(f, true); // passado "true" para gravar no mesmo arquivo  
       OutputStreamWriter chars = new OutputStreamWriter(bytes);  
       BufferedWriter strings = new BufferedWriter(chars);  
  
       strings.write(outputWriter.toString());  
  
       strings.close();  
       outputWriter.close();
    }
}

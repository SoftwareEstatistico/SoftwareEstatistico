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

        List<Dado_Amostra> dados=new ArrayList<>();
        Dado_Amostra d1=new Dado_Amostra();
        d1.setDescricao("Ford");
        d1.setValor(54.90);
        Dado_Amostra d2=new Dado_Amostra();
        d2.setDescricao("Fiat");
        d2.setValor(32.0);
        dados.add(d1);
        dados.add(d2);
        beanWriter.write("amostra", new Amostra("Venda",dados,20,20,20,20,20,02,20,20,20,20,20,20));
        
        System.out.println(outputWriter.toString());
        File f=new File("C:\\Users\\Ana\\Documents\\NetBeansProjects\\SoftwareEstatisticoDigester\\SoftwareEstatisticoMaster\\xml\\amostra.xml");
        if(!f.exists())
             f.createNewFile();
        else
            f.delete();
       OutputStream bytes = new FileOutputStream("C:\\Users\\Ana\\Documents\\NetBeansProjects\\SoftwareEstatisticoDigester\\SoftwareEstatisticoMaster\\xml\\amostra.xml", true); // passado "true" para gravar no mesmo arquivo  
       OutputStreamWriter chars = new OutputStreamWriter(bytes);  
       BufferedWriter strings = new BufferedWriter(chars);  
  
       strings.write(outputWriter.toString());  
  
       strings.close();  
       outputWriter.close();
    }
}

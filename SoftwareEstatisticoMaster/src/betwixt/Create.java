/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package betwixt;

import model.Amostra;
import java.beans.IntrospectionException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
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
    
    public static void createxml(String nome_arquivo,Amostra amostra) throws IOException, SAXException, IntrospectionException {
      
        StringWriter outputWriter = new StringWriter(); 
        
     
        outputWriter.write("<?xml version='1.0' ?>");
        
    
        BeanWriter beanWriter = new BeanWriter(outputWriter);
        
     
        beanWriter.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(false);
        beanWriter.getBindingConfiguration().setMapIDs(false);
        beanWriter.enablePrettyPrint();

        beanWriter.write("amostra", amostra);
        
        System.out.println(outputWriter.toString());
        
        File f=new File(Create.class.getResource("/xml").getPath()+"/"+nome_arquivo);
        if(!f.exists())
             f.createNewFile();
        else// dar opção de renomear
            f.delete();
       System.out.println(f.getAbsolutePath()); 
       OutputStream bytes = new FileOutputStream(Create.class.getResource("/xml").getPath()+"/"+nome_arquivo, true); // passado "true" para gravar no mesmo arquivo  
       OutputStreamWriter chars = new OutputStreamWriter(bytes);  
       BufferedWriter strings = new BufferedWriter(chars);  
  
       strings.write(outputWriter.toString());  
  
       strings.close();  
       outputWriter.close();
    }
}

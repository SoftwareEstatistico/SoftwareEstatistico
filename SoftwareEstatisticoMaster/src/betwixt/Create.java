/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package betwixt;

import amostra.Amostra;
import amostra.Dado_Amostra;
import java.beans.IntrospectionException;
import java.io.IOException;
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
    public static void main(String[] args) throws IOException, SAXException, IntrospectionException {
        // Start by preparing the writer
        // We'll write to a string 
        StringWriter outputWriter = new StringWriter(); 
        
        // Betwixt just writes out the bean as a fragment
        // So if we want well-formed xml, we need to add the prolog
        outputWriter.write("<?xml version='1.0' ?>");
        
        // Create a BeanWriter which writes to our prepared stream
        BeanWriter beanWriter = new BeanWriter(outputWriter);
        
        // Configure betwixt
        // For more details see java docs or later in the main documentation
        beanWriter.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(false);
        beanWriter.getBindingConfiguration().setMapIDs(false);
        beanWriter.enablePrettyPrint();

        // If the base element is not passed in, Betwixt will guess 
        // But let's write example bean as base element 'person'
        List<Dado_Amostra> dados=new ArrayList<>();
        Dado_Amostra d1=new Dado_Amostra();
        d1.setDescricao("Ford");
        d1.setValor(54.90);
        Dado_Amostra d2=new Dado_Amostra();
        d2.setDescricao("Fiat");
        d2.setValor(32.0);
        dados.add(d1);
        dados.add(d2);
        beanWriter.write("person", new Amostra("Venda de Automóveis",dados,20,20,20,20,20,02,20,20,20,20,20,20));
        
        // Write to System.out
        // (We could have used the empty constructor for BeanWriter 
        // but this way is more instructive)
        System.out.println(outputWriter.toString());
        
        // Betwixt writes fragments not documents so does not automatically close 
        // writers or streams.
        // This example will do no more writing so close the writer now.
        outputWriter.close();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digester;

import amostra.Amostra;
import amostra.Dado_Amostra;
import java.io.File;
import java.io.IOException;
import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.xml.sax.SAXException;

/**
 *
 * @author Ana
 */
public class Read {
    public static Amostra leitura(File file) throws IOException, SAXException{
        Digester digester=new Digester();
        digester.setValidating(false);
        digester.addObjectCreate( "amostra", Amostra.class );
//        digester.addSetProperties("amostra");
        digester.addBeanPropertySetter("amostra/amplitude", "amplitude" );
        digester.addBeanPropertySetter("amostra/curtose", "curtose" );
        digester.addBeanPropertySetter("amostra/desvio_padrao", "desvio_padrao" );
        digester.addBeanPropertySetter("amostra/f_absoluta", "f_absoluta" );
        digester.addBeanPropertySetter("amostra/max", "max" );
        digester.addBeanPropertySetter("amostra/min", "min" );
        digester.addBeanPropertySetter("amostra/media", "media" );
        digester.addBeanPropertySetter("amostra/mediana", "mediana" );
        digester.addBeanPropertySetter("amostra/moda", "moda" );
        digester.addBeanPropertySetter("amostra/nome", "nome" );
        digester.addBeanPropertySetter("amostra/obliquidade", "obliquidade" );
        digester.addBeanPropertySetter("amostra/variancia", "variancia" );
        
        digester.addBeanPropertySetter("amostra/dados", "dados" );
        digester.addObjectCreate( "amostra/dados/Dado_Amostra", Dado_Amostra.class );
        digester.addSetProperties("amostra/dados/Dado_Amostra");
        digester.addBeanPropertySetter("amostra/dados/Dado_Amostra/descricao", "descricao" );
        digester.addBeanPropertySetter("amostra/dados/Dado_Amostra/valor", "valor" );
        digester.addSetNext( "amostra/dados/Dado_Amostra", "setDados");
//        DigesterLoader loader = DigesterLoader.newLoader(new Rules());
//        Digester digester=loader.newDigester();
        Amostra amostra=(Amostra)digester.parse(file);
        
        System.out.println(amostra);
        return amostra;
    }
}

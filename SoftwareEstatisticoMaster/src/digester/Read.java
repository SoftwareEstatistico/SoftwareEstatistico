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
import org.xml.sax.SAXException;

/**
 *
 * @author Ana
 */
public class Read {
    public static void leitura(File file) throws IOException, SAXException{
        Digester digester=new Digester();
        digester.setValidating(false);
        digester.addObjectCreate( "amostra", Amostra.class );
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
        digester.addObjectCreate( "amostra/dados_amostra", Dado_Amostra.class );
        digester.addBeanPropertySetter("amostra/dados_amostra/descricao", "descricao" );
        digester.addBeanPropertySetter("amostra/dados_amostra/valor", "valor" );
        digester.addSetNext( "amostra/dados_amostra", "setDados_Amostra" );

        Amostra amostra=(Amostra)digester.parse(file);
        System.out.println(amostra.getNome());
    }
}

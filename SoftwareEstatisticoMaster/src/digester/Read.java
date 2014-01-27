/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digester;

import model.Amostra;
import java.io.File;
import java.io.IOException;
import model.FrequenciaAbsoluta1;
import model.FrequenciaRelativa1;
import model.ValorAmostra;
import org.apache.commons.digester3.Digester;
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
        
//        digester.addBeanPropertySetter("amostra/dados", "dados" );
//        digester.addObjectCreate( "amostra/dados/Dado_Amostra", Dado_Amostra.class );
//        digester.addSetProperties("amostra/dados/Dado_Amostra");
//        digester.addBeanPropertySetter("amostra/dados/Dado_Amostra/descricao", "descricao" );
//        digester.addBeanPropertySetter("amostra/dados/Dado_Amostra/valor", "valor" );
        
        digester.addBeanPropertySetter("amostra/dados", "dados" );
        digester.addObjectCreate( "amostra/dados/ValorAmostra", ValorAmostra.class );
        digester.addSetProperties("amostra/dados/ValorAmostra");
        digester.addBeanPropertySetter("amostra/dados/ValorAmostra/date", "date" );
        digester.addBeanPropertySetter("amostra/dados/ValorAmostra/valor", "valor" );
        
        
        digester.addBeanPropertySetter("amostra/fr", "fr" );
        digester.addObjectCreate( "amostra/fr/FrequenciaRelativa1", FrequenciaRelativa1.class );
        digester.addSetProperties("amostra/fr/FrequenciaRelativa1");
        digester.addBeanPropertySetter("amostra/fr/FrequenciaRelativa1/key", "key" );
        digester.addBeanPropertySetter("amostra/fr/FrequenciaRelativa1/value", "value" );
        
        digester.addBeanPropertySetter("amostra/fa", "fa" );
        digester.addObjectCreate( "amostra/fa/FrequenciaAbsoluta1", FrequenciaAbsoluta1.class );
        digester.addSetProperties("amostra/fa/FrequenciaAbsoluta1");
        digester.addBeanPropertySetter("amostra/fa/FrequenciaAbsoluta1/key", "key" );
        digester.addBeanPropertySetter("amostra/fa/FrequenciaAbsoluta1/value", "value" );
        //super importante para adicionar os outros da lista
        digester.addSetNext( "amostra/dados/ValorAmostra", "setDados");
        digester.addSetNext( "amostra/fa/FrequenciaAbsoluta1", "setFa");
        digester.addSetNext( "amostra/fr/FrequenciaRelativa1", "setFr");
        
        Amostra amostra=(Amostra)digester.parse(file);
        
        System.out.println(amostra);
        return amostra;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digester;

import amostra.Amostra;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.xml.sax.SAXException;

/**
 *
 * @author Ana
 */
public class Create {

    /**
     * @param args the command line arguments
     */
    public static Amostra createnew(String src) throws IOException, SAXException {
        Amostra result=new Amostra();
        InputStream inputStream=Amostra.class.getClassLoader().getResourceAsStream(src);
        DigesterLoader digesterLoader=DigesterLoader.newLoader(new Regras());
        Digester digester=digesterLoader.newDigester();
        result=digester.parse(inputStream);
        return result;
    }
}

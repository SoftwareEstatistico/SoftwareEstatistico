/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digester;

import java.io.File;
import org.apache.commons.digester3.xmlrules.FromXmlRulesModule;

/**
 *
 * @author Ana
 */
public class Rules extends FromXmlRulesModule{

    @Override
    protected void loadRules() {
        loadXMLRules(new File("C:\\Users\\Ana\\Documents\\NetBeansProjects\\SoftwareEstatisticoDigester\\SoftwareEstatisticoMaster\\xml\\amostra.xml"));
    }
    
}

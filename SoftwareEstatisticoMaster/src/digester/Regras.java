/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digester;

import amostra.Amostra;
import amostra.Dado_Amostra;
import org.apache.commons.digester3.binder.AbstractRulesModule;

/**
 *
 * @author Ana
 */
public class Regras extends AbstractRulesModule{

    @Override
    protected void configure() {
        forPattern("amostra").createObject().ofType(Amostra.class)
                .then().setProperties();
        forPattern("amostra/f_relativa").setBeanProperty();
        forPattern("amostra/f_absoluta").setBeanProperty();
        forPattern("amostra/moda").setBeanProperty();
        forPattern("amostra/mediana").setBeanProperty();
        forPattern("amostra/media").setBeanProperty();
        forPattern("amostra/curtose").setBeanProperty();
        forPattern("amostra/obliquidade").setBeanProperty();
        forPattern("amostra/variancia").setBeanProperty();
        forPattern("amostra/desvio_padrao").setBeanProperty();
        forPattern("amostra/amplitude").setBeanProperty();
        forPattern("amostra/max").setBeanProperty();
        forPattern("amostra/min").setBeanProperty();
        forPattern("amostra/dados_amostra").createObject().ofType(Dado_Amostra.class)
                .then().setProperties().then().setNext("setAdress");
        forPattern("amostra/dados_amostra/descricao").setBeanProperty();
        forPattern("amostra/dados_amostra/valor").setBeanProperty();
        
    }
    
}

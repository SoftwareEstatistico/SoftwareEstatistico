/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digester;

import amostra.Amostra;
import amostra.Dado_Amostra;
import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

/**
 *
 * @author Ana
 */
public class CreateTest {
//    private static Amostra amostra=new Amostra();
    private static Amostra amostra=null;
    
    public void setUp() throws IOException, SAXException {
        amostra=Create.createnew("amostra.xml");
    }
    @Test
    public void testFamily() {
//        amostra.setNome("Venda de Carros");
        Assert.assertNotNull("Family was not created.", amostra);
         
        Assert.assertEquals("Incorrect family last name", "Venda de Carros", amostra.getNome());
    }
     
     
    @Test
    public void testDado_Amostra() {
//        List<Dado_Amostra> l=new ArrayList<>();
//        Dado_Amostra d1=new Dado_Amostra();
//        Dado_Amostra d2=new Dado_Amostra();
//        d1.setDescricao("Ford");
//        d1.setValor(20);
//        d2.setDescricao("Renault");
//        d2.setValor(54);
//        l.add(d1);
//        l.add(d2);
//        amostra.setAmostra(l);
        List<Dado_Amostra> dados= amostra.getAmostra();
        Assert.assertNotNull("Family dados were not created.", dados);
         
        Assert.assertEquals("Incorrect qtd_dados count.", 2, dados.size());
         
        Dado_Amostra dado = dados.get(1);
        Assert.assertEquals("Incorrect descricao", "Renault",dado.getDescricao());
        Assert.assertEquals(54,0, dado.getValor());
    }
   
}
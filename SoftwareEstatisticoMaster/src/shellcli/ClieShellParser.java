/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shellcli;

import asg.cliche.Command;
import asg.cliche.ShellFactory;
import cli.CommandLineParameters;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Amostra;
import model.ValorAmostra;
import util.ChartGenerate;

/**
 *
 * @author Ana
 */
public class ClieShellParser {
    private Amostra amostra;
    private List<Double> vlrs;
    private CommandLineParameters clp=new CommandLineParameters();
    
    @Command
    public String novaAmostra(){
        vlrs=new ArrayList<>();
        return "nova amostra";
    } 
    @Command
    public String add(double v){
       vlrs.add(v);
       return "Adicionado";
    }

    private void gerarString(){
        ChartGenerate.getInstance().stringstatica(amostra);
        ChartGenerate.getInstance().stringsdesviopadrao(true);
        ChartGenerate.getInstance().stringscurtose(true);
        ChartGenerate.getInstance().stringsmax(true);
        ChartGenerate.getInstance().stringsmin(true);
        ChartGenerate.getInstance().stringsmedia(true);
        ChartGenerate.getInstance().stringsmediana(true);
        ChartGenerate.getInstance().stringsmoda(true);
        ChartGenerate.getInstance().stringsobliquidade(true);
        ChartGenerate.getInstance().stringsvariancia(true);
    }
    @Command
    public String calculo(){
        try{
            for(Double d:vlrs){
                ValorAmostra v=new ValorAmostra();
                v.setValor(d);
                amostra.setDados(v);
            }
            gerarString();
            return ChartGenerate.getInstance().getstrings();
        }catch(Exception e){
            return e.toString();
        }
    } 
    @Command
    public String help(){
        return clp.getOptions().getOption("h").getDescription();
    }
    @Command
    public String sair(){
        return clp.getOptions().getOption("h").getDescription();
    }
    public static void exec() throws IOException {
             ShellFactory.createConsoleShell("clieShell>", "ClieShellParser", new ClieShellParser())
            .commandLoop(); // and three.
    }
}

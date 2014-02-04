/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shellcli;

import asg.cliche.Command;
import asg.cliche.ShellFactory;
import asg.cliche.example.HelloWorld;
import cli.CommandLineParameters;
import java.io.IOException;

/**
 *
 * @author Ana
 */
public class Shellcli {
    //Exemplo
     @Command // One,
    public String hello() {
        return "Hello, World!";
    }

    @Command // two,
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws IOException {
        ShellFactory.createConsoleShell("hello", "", new CommandLineParameters())
            .commandLoop(); // and three.
    }
}

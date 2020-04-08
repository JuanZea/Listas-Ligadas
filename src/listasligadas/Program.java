package listasligadas;

import java.awt.SystemColor;
import java.util.Random;
import java.util.Scanner;
import listasligadas.LSL;

/**
 *
 * @author JuanZea
 */
public class Program {

    

    public static void main(String[] args) {
        Menu menu = new Menu();
        Boolean working = true;
        while (working) {
            working = menu.principal();
        }    
    }
}

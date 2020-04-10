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

//            LSL lsl = new LSL();
//            LSLC lslc = new LSLC();
//            LSLCNC lslcnc = new LSLCNC();
//        NodoSimple y = null;
//        lsl.insertar(1, y);
//        lsl.insertar(4, y);
//        lsl.insertar(2, y);
//        NodoSimple x = new NodoSimple(23);
//        y = lsl.anterior(x);
//        System.out.println(x);
//        lsl = menu.construirLista(menu, true, false, lsl, 3);
//        lsl.recorre();
//        
//        lslc = menu.construirLista(menu, true, true, lslc, 9);
//        lslc.recorre();
        }
    }

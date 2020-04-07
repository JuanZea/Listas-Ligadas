package listasligadas;

import java.util.Random;
import java.util.Scanner;
import listasligadas.LSL;

/**
 *
 * @author JuanZea
 */
public class Program {

    static Scanner entry = new Scanner(System.in);
    static Random rnd = new Random();

    public static LSL construirAleatoriaLSL(int tamaño) {
        int dato;
        LSL lsl = new LSL();
        NodoSimple y = null;
        if (tamaño <= 100) {    //Contruir lista sin datos repetidos cuando el tamaño sea menor o igual a 100
            for (int i = 0; i < tamaño; i++) {
                dato = rnd.nextInt(101);
                while (lsl.buscarDato(dato, y) != null) {
                    dato = rnd.nextInt(101);
                }
                lsl.insertar(dato, y);
            }
        } else {    //Construir lista con datos que pueden ser repetidos entre 0 y 999 si el tamaño es mayor a 100
            for (int i = 0; i < tamaño; i++) {
                dato = rnd.nextInt(1000);
                lsl.insertar(dato, y);
            }
        }
        return lsl;
    }

    public static void main(String[] args) {
//        Menu menu = new Menu();
//        Boolean aleatoria = menu.PedirManeraContruir();
//        String tipo = menu.PedirTipoDeLista();
//        Integer tamaño = menu.PedirTamaño(tipo);

        LSL lsl = new LSL();
        LSLC lslc = new LSLC();
//        if (aleatoria) {
//            lsl = construirAleatoriaLSL(tamaño);
//        }
        lsl = construirAleatoriaLSL(10);
        lsl.recorre();
    }
}

package listasligadas;

import java.util.Scanner;

/**
 *
 * @author JuanZea
 */
public class Program {
    static Scanner entry = new Scanner(System.in);
    public static void main(String[] args) { 
        //Construcción de listas simplemente ligadas
        //Seleccione "true" en forma de contrucción deseada:
        boolean build1 = false;
        boolean build2 = true;
        boolean build3 = false;
        
        //Los datos se van añadiendo de forma ordenada
        if(build1){
            LSL a = new LSL();
            boolean nuevoDato = true;
            while(nuevoDato){
                System.out.println("Ingrese el dato (char) a añadir o '*' para finalizar:");
                char ans = entry.next().charAt(0);
                if(ans != '*'){
                    NodoSimple y = a.buscaDondeInsertar(ans);
                    a.insertar(ans, y);
                }
                else
                    nuevoDato = false;
            }
        }
        //Los datos se van añadiendo siempre al final de la lista (en el orden en que se van leyendo)
        if (build2) {
            LSL a = new LSL();
            boolean nuevoDato = true;
            while (nuevoDato) {                
                System.out.println("Ingrese el dato(char) a añadir o '*' para finalizar:");
                char ans = entry.next().charAt(0);
                if(ans != '*'){
                    NodoSimple y = a.ultimoNodo();
                    a.insertar(ans, y);
                }
                else
                    nuevoDato = false;
            }
        }
        //Los datos se van añadiendo siempre al principio de la lista
        if (build3) {
            LSL a = new LSL();
            boolean nuevoDato = true;
            while (nuevoDato) {                
                System.out.println("Ingrese el dato(char) a añadir o '*' para finalizar:");
                char ans = entry.next().charAt(0);
                if(ans != '*'){
                    a.insertar(ans, null);
                }
                else
                    nuevoDato = false;
            }
        }
    }  
}

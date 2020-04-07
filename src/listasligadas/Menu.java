/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasligadas;

import java.util.Scanner;

/**
 *
 * @author JuanZea
 */
public class Menu {

    public Boolean PedirManeraContruir() {
        Scanner sc = new Scanner(System.in);
        String ansS;
        int ansI;
        System.out.println("Ingrese la opción que quiera:\n"
                + "0. Constuir lista de manera definida.\n"
                + "1. Constuir lista de manera aleatoria.\n"
                + "C. Cancelar.");
        ansS = sc.nextLine();
        if (ansS.toLowerCase().equals("c")) {
            return null;
        }
        try {
            ansI = Integer.parseInt(ansS);
        } catch (NumberFormatException e) {
            System.out.println("El valor es demasiado grande o no es numerico.");
            return PedirManeraContruir();
        }
        if (ansI < 0 || ansI > 1) {
            System.out.println("El valor debe estar entre 0 y 1");
            return PedirManeraContruir();
        }
        return ansI == 1;
    }

    public Integer PedirTamaño(String tipo) {
        Scanner sc = new Scanner(System.in);
        String ansS;
        int tamaño;
        System.out.println("Ingrese el tamaño de la " + tipo + ":\n"
                + "C. Cancelar");
        ansS = sc.nextLine();
        if (ansS.toLowerCase().equals("c")) {
            return null;
        }
        try {
            tamaño = Integer.parseInt(ansS);
        } catch (NumberFormatException e) {
            System.out.println("El valor es demasiado grande o no es numerico.");
            return PedirTamaño(tipo);
        }
        if (tamaño < 0) {
            System.out.println("El tamaño no puede ser negativo.");
            return PedirTamaño(tipo);
        }
        return tamaño;
    }

    public String PedirTipoDeLista() {
        Scanner sc = new Scanner(System.in);
        String ansS;
        int ansI;
        String tipo = null;
        System.out.println("Seleccione la opción que quiera:\n"
                + "1. (LSL): Lista simplemente ligada.\n"
                + "2. (LSLC): Lista simplemente ligada circular.\n"
                + "3. (LSLCNC): Lista simplemente ligada con nodo cabeza.\n"
                + "4. (LSLCCNC): Lista simplemente ligada circular con nodo cabeza.\n"
                + "5. (LDL): Lista doblemente ligada.\n"
                + "6. (LDLC): Lista doblemente ligada circular.\n"
                + "7. (LDLCNC): Lista doblemente ligada con nodo cabeza.\n"
                + "8. (LDLCCNC): Lista doblemente ligada circular con nodo cabeza.\n"
                + "C. Cancelar.");
        ansS = sc.next();
        if (ansS.toLowerCase().equals("c")) {
            return tipo;
        }
        try {
            ansI = Integer.parseInt(ansS);
        } catch (NumberFormatException e) {
            System.out.println("El valor es demasiado grande o no es numerico.");
            return PedirTipoDeLista();
        }
        if (ansI < 0 || ansI > 8) {
            System.out.println("El valor debe estar entre 0 y 8.");
            return PedirTipoDeLista();
        }
        switch (ansI) {
            case 1:
                tipo = "lista simplemente ligada";
                break;
            case 2:
                tipo = "lista simplemente ligada circular";
                break;
            case 3:
                tipo = "lista simplemente ligada con nodo cabeza";
                break;
            case 4:
                tipo = "lista simplemente ligada circular con nodo cabeza";
                break;
            case 5:
                tipo = "lista doblemente ligada";
                break;
            case 6:
                tipo = "lista doblemente ligada circular";
                break;
            case 7:
                tipo = "lista doblemente ligada con nodo cabeza";
                break;
            case 8:
                tipo = "lista doblemente ligada circular con nodo cabeza";
                break;
        }
        return tipo;
    }
}

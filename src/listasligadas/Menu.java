package listasligadas;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author JuanZea
 */
public class Menu {

    public Boolean principal() {
        Scanner sc = new Scanner(System.in);
        String ans;
        System.out.println("MENU PRINCIPAL\n"
                + "Seleccione la opción que quiera:\n"
                + "1. Crear listas.\n"
                + "0. Salir.");
        ans = sc.nextLine();
        switch (ans) {
            default:
                System.out.println("Respuesta no válida.");
                return principal();
            case "0":
                return false;
            case "1":
                op1();
        }
        return true;
    }

    public void op1() {
        Menu menu = new Menu();
        String variacion = pedirVariacion();
        if (variacion == null) {
            return;
        }
        Boolean aleatoria = pedirAleatoria();
        if (aleatoria == null) {
            return;
        }
        Boolean ordenada = pedirOrdenada();
        if (ordenada == null) {
            return;
        }
        Integer tamaño = null;
        if (aleatoria) {
            tamaño = pedirTamaño();
            if (tamaño == null) {
                return;
            }
        }

        LSL lsl = new LSL();
        LSLC lslc = new LSLC();
        LSLCNC lslcnc = new LSLCNC();
        switch (variacion) {
            case "LSL":
                lsl = construirLista(menu, aleatoria, ordenada, lsl, tamaño);
                System.out.println("Su " + traducirVariacion(variacion) + " se ha "
                        + "creado correctamente.");
                lsl.recorre();
                break;
            case "LSLC":
                lslc = construirLista(menu, aleatoria, ordenada, lslc, tamaño);
                lslc.recorre();
                break;
            case "LSLCNC":
                lslcnc = construirLista(menu, aleatoria, ordenada, lslcnc, tamaño);
                lslcnc.recorre();
                break;
        }
    }

    public LSL construirLista(Menu menu, Boolean aleatoria,
            Boolean ordenada, LSL lsl, Integer tamaño) {
        NodoSimple y = null;
        Integer dato;
        if (aleatoria) {
            Random rnd = new Random();
            if (tamaño <= 100) {    //Contruir lista sin datos repetidos cuando el tamaño sea menor o igual a 100
                for (int i = 0; i < tamaño; i++) {
                    dato = rnd.nextInt(101);
                    while (lsl.buscarDato(dato, y) != null) {
                        dato = rnd.nextInt(101);
                    }
                    if (ordenada) {
                        y = lsl.buscaDondeInsertar(dato);
                    } else {
                        y = lsl.ultimoNodo();
                    }
                    lsl.insertar(dato, y);
                }
            } else {    //Construir lista con datos que pueden ser repetidos entre 0 y 999 si el tamaño es mayor a 100
                for (int i = 0; i < tamaño; i++) {
                    dato = rnd.nextInt(1000);
                    if (ordenada) {
                        y = lsl.buscaDondeInsertar(dato);
                    } else {
                        y = lsl.ultimoNodo();
                    }
                    lsl.insertar(dato, y);
                }
            }
        } else {
            System.out.println("Ingrese \"C\" para dejar de entrar datos.");
            int i = 1;
            while (true) {
                dato = menu.pedirDato(i);
                if (dato == null) {
                    break;
                }
                if (ordenada) {
                    y = lsl.buscaDondeInsertar(dato);
                } else {
                    y = lsl.ultimoNodo();
                }
                lsl.insertar(dato, y);
                i++;
            }
        }
        return lsl;
    }

    public LSLC construirLista(Menu menu, Boolean aleatoria,
            Boolean ordenada, LSLC lslc, Integer tamaño) {
        NodoSimple y = null;
        Integer dato;
        if (aleatoria) {
            Random rnd = new Random();
            if (tamaño <= 100) {    //Contruir lista sin datos repetidos cuando el tamaño sea menor o igual a 100
                for (int i = 0; i < tamaño; i++) {
                    dato = rnd.nextInt(101);
                    while (lslc.buscarDato(dato, y) != null) {
                        dato = rnd.nextInt(101);
                    }
                    if (ordenada) {
                        y = lslc.buscaDondeInsertar(dato);
                    } else {
                        y = lslc.ultimoNodo();
                    }
                    lslc.insertar(dato, y);
                }
            } else {    //Construir lista con datos que pueden ser repetidos entre 0 y 999 si el tamaño es mayor a 100
                for (int i = 0; i < tamaño; i++) {
                    dato = rnd.nextInt(1000);
                    if (ordenada) {
                        y = lslc.buscaDondeInsertar(dato);
                    } else {
                        y = lslc.ultimoNodo();
                    }
                    lslc.insertar(dato, y);
                }
            }
        } else {
            System.out.println("Ingrese \"C\" para dejar de entrar datos.");
            int i = 1;
            while (true) {
                dato = menu.pedirDato(i);
                if (dato == null) {
                    break;
                }
                if (ordenada) {
                    y = lslc.buscaDondeInsertar(dato);
                } else {
                    y = lslc.ultimoNodo();
                }
                lslc.insertar(dato, y);
                i++;
            }
        }
        return lslc;
    }

    public LSLCNC construirLista(Menu menu, Boolean aleatoria,
            Boolean ordenada, LSLCNC lslcnc, Integer tamaño) {
        NodoSimple y = null;
        Integer dato;
        if (aleatoria) {
            Random rnd = new Random();
            if (tamaño <= 100) {    //Contruir lista sin datos repetidos cuando el tamaño sea menor o igual a 100
                for (int i = 0; i < tamaño; i++) {
                    dato = rnd.nextInt(101);
                    while (lslcnc.buscarDato(dato, y) != null) {
                        dato = rnd.nextInt(101);
                    }
                    if (ordenada) {
                        y = lslcnc.buscaDondeInsertar(dato);
                    } else {
                        y = lslcnc.ultimoNodo();
                    }
                    lslcnc.insertar(dato, y);
                }
            } else {    //Construir lista con datos que pueden ser repetidos entre 0 y 999 si el tamaño es mayor a 100
                for (int i = 0; i < tamaño; i++) {
                    dato = rnd.nextInt(1000);
                    if (ordenada) {
                        y = lslcnc.buscaDondeInsertar(dato);
                    } else {
                        y = lslcnc.ultimoNodo();
                    }
                    lslcnc.insertar(dato, y);
                }
            }
        } else {
            System.out.println("Ingrese \"C\" para dejar de entrar datos.");
            int i = 1;
            while (true) {
                dato = menu.pedirDato(i);
                if (dato == null) {
                    break;
                }
                if (ordenada) {
                    y = lslcnc.buscaDondeInsertar(dato);
                } else {
                    y = lslcnc.ultimoNodo();
                }
                lslcnc.insertar(dato, y);
                i++;
            }
        }
        return lslcnc;
    }

    public Integer pedirDato(int i) {
        Scanner sc = new Scanner(System.in);
        String ansS;
        int ansI;
        System.out.print("Ingrese el dato N°" + i + ": ");
        ansS = sc.nextLine();
        if (ansS.toLowerCase().equals("c")) {
            return null;
        }
        try {
            ansI = Integer.parseInt(ansS);
        } catch (NumberFormatException e) {
            System.out.println("El valor es demasiado grande o no es numerico.");
            return pedirDato(i);
        }
        return ansI;
    }

    public Boolean pedirOrdenada() {
        Scanner sc = new Scanner(System.in);
        String ansS;
        System.out.println("¿Quiere que la lista se genere de manera ordenada?\n"
                + "Responda \"S\" o \"N\":");
        ansS = sc.nextLine();
        if (ansS.toLowerCase().equals("s") || ansS.toLowerCase().equals("si") || ansS.toLowerCase().equals("szs")) {
            return true;
        }
        if (ansS.toLowerCase().equals("n") || ansS.toLowerCase().equals("no")) {
            return false;
        }
        if (ansS.toLowerCase().equals("c")) {
            return null;
        }
        System.out.println("Respuesta no válida.");
        return pedirOrdenada();
    }

    public Boolean pedirAleatoria() {
        Scanner sc = new Scanner(System.in);
        String ansS;
        System.out.println("¿Quiere que la lista se genere de manera aleatoria?\n"
                + "Responda \"S\" o \"N\":");
        ansS = sc.nextLine();
        if (ansS.toLowerCase().equals("s") || ansS.toLowerCase().equals("si") || ansS.toLowerCase().equals("szs")) {
            return true;
        }
        if (ansS.toLowerCase().equals("n") || ansS.toLowerCase().equals("no")) {
            return false;
        }
        if (ansS.toLowerCase().equals("c")) {
            return null;
        }
        System.out.println("Respuesta no válida.");
        return pedirAleatoria();
    }

    public Integer pedirTamaño() {
        Scanner sc = new Scanner(System.in);
        String ansS;
        int tamaño;
        System.out.println("Ingrese el tamaño de la lista:\n"
                + "C. Cancelar");
        ansS = sc.nextLine();
        if (ansS.toLowerCase().equals("c")) {
            return null;
        }
        try {
            tamaño = Integer.parseInt(ansS);
        } catch (NumberFormatException e) {
            System.out.println("El valor es demasiado grande o no es numerico.");
            return pedirTamaño();
        }
        if (tamaño < 0) {
            System.out.println("El tamaño no puede ser negativo.");
            return pedirTamaño();
        }
        return tamaño;
    }

    public String pedirVariacion() {
        Scanner sc = new Scanner(System.in);
        String[] var = new String[9];
        var[1] = "LSL";
        var[2] = "LSLC";
        var[3] = "LSLCNC";
        var[4] = "LSLCCNC";
        var[5] = "LDL";
        var[6] = "LDLC";
        var[7] = "LDLCNC";
        var[8] = "LDLCCNC";
        String ansS;
        int ansI;
        String variacion = null;
        System.out.println("Seleccione la opción que quiera:");
        for (int i = 1; i < var.length; i++) {
            System.out.println(i + ". " + "(" + var[i] + "): " + traducirVariacion(var[i]) + ".");
        }
        System.out.println("C. Cancelar.");
        ansS = sc.next();
        if (ansS.toLowerCase().equals("c")) {
            return variacion;
        }
        try {
            ansI = Integer.parseInt(ansS);
        } catch (NumberFormatException e) {
            System.out.println("El valor es demasiado grande o no es numerico.");
            return pedirVariacion();
        }
        if (ansI < 0 || ansI > 8) {
            System.out.println("El valor debe estar entre 0 y 8.");
            return pedirVariacion();
        }
        variacion = var[ansI];
        return variacion;
    }

    public String traducirVariacion(String variacion) {
        switch (variacion) {
            case "LSL":
                return "lista simplemente ligada";
            case "LSLC":
                return "lista simplemente ligada circular";
            case "LSLCNC":
                return "lista simplemente ligada con nodo cabeza";
            case "LSLCCNC":
                return "lista simplemente ligada circular con nodo cabeza";
            case "LDL":
                return "lista doblemente ligada";
            case "LDLC":
                return "lista doblemente ligada circular";
            case "LDLCNC":
                return "lista doblemente ligada con nodo cabeza";
            case "LDLCCNC":
                return "lista doblemente ligada circular con nodo cabeza";
        }
        return null;
    }
}

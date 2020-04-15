package listasligadas;

/**
 *
 * @author JuanZea
 */
public class LDL {

    private NodoDoble primero, ultimo;

    public LDL() {
        primero = ultimo = null;
    }

    public boolean esVacio() {
        return primero == null;
    }

    public NodoDoble primerNodo() {
        return primero;
    }

    public NodoDoble ultimoNodo() {
        return ultimo;
    }

    public NodoDoble anterior(NodoDoble x) {
        return x.retornaLigaI();
    }

    public boolean finDeRecorrido(NodoDoble p) {
        return p == null;
    }

    public void recorre() {
        NodoDoble p;
        p = primerNodo();
        while (!finDeRecorrido(p)) {
            System.out.print(p.retornaDato() + "\t");
            p = p.retornaLigaD();
        }
        System.out.println();
    }

    public NodoDoble buscaDondeInsertar(int d) {
        if (esVacio()) {
            return null;
        }
        NodoDoble p, y;
        p = primerNodo();
        y = anterior(p);
        while (!finDeRecorrido(p) && p.retornaDato() < d) {
            y = p;
            p = p.retornaLigaD();
        }
        return y;
    }

    public void insertar(int d, NodoDoble y) {
        NodoDoble x;
        x = new NodoDoble(d);
        conectar(x, y);
    }

    public void conectar(NodoDoble x, NodoDoble y) {
        if (y != null) {
            x.asignaLigaD(y.retornaLigaD());
            x.asignaLigaI(y);
            y.asignaLigaD(x);
            if (y == ultimo) {
                ultimo = x;
            } else {
                x.retornaLigaD().asignaLigaI(x);
            }
        } else {
            x.asignaLigaD(primerNodo());
            if (primerNodo() == null) {
                ultimo = x;
            } else {
                primerNodo().asignaLigaI(x);
            }
            primero = x;
        }
    }

    public NodoDoble buscarDato(int d, NodoDoble y) {
        if (esVacio()) {
            return null;
        }
        NodoDoble x;
        x = primerNodo();
        y = anterior(x);
        while (!finDeRecorrido(x) && x.retornaDato() != d) {
            y = x;
            x = x.retornaLigaD();
        }
        return x;
    }

    public void borrar(NodoDoble x, NodoDoble y) {
        if (x == null) {
            System.out.println("El dato no existe");
        }
        desconectar(x, y);
    }

    public void desconectar(NodoDoble x, NodoDoble y) {
        if (x != primerNodo()) {
            y.asignaLigaD(x.retornaLigaD());
            if (x == ultimo) {
                ultimo = y;
            } else {
                y.retornaLigaD().asignaLigaI(y);
            }
        } else {
            primero = primerNodo().retornaLigaD();
            if (primerNodo() == null) {
                ultimo = null;
            }
        }
    }
}

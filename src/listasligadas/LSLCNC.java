package listasligadas;

/**
 *
 * @author JuanZea
 */
public class LSLCNC {

    private NodoSimple primero, ultimo;

    public LSLCNC() {
        primero = new NodoSimple(null);
        primero.asignaLiga(null);
        ultimo = primero;
    }

    public boolean esVacio() {
        return primero.retornaLiga() == null;
    }

    public NodoSimple nodoCabeza() {
        return primero;
    }

    public NodoSimple primerNodo() {
        return primero.retornaLiga();
    }

    public NodoSimple ultimoNodo() {
        return ultimo;
    }

    public NodoSimple anterior(NodoSimple x) { // Error si x no esta en la lista
        NodoSimple p, y;
        p = primerNodo();
        y = nodoCabeza();
        while (p != x) {
            y = p;
            p = p.retornaLiga();
        }
        return y;
    }

    public boolean finDeRecorrido(NodoSimple p) {
        return p == null;
    }

    public void recorre() {
        NodoSimple p;
        p = primerNodo();
        while (!finDeRecorrido(p)) {
            System.out.print(p.retornaDato() + "\t");
            p = p.retornaLiga();
        }
        System.out.println();
    }

    public NodoSimple buscaDondeInsertar(int d) {
        NodoSimple p, y;
        p = primerNodo();
        y = anterior(p);
        while (!finDeRecorrido(p) && p.retornaDato() < d) {
            y = p;
            p = p.retornaLiga();
        }
        return y;
    }

    public void insertar(int d, NodoSimple y) {
        NodoSimple x;
        x = new NodoSimple(d);
        conectar(x, y);
    }

    public void conectar(NodoSimple x, NodoSimple y) {
        if(esVacio()){
            x.asignaLiga(null);
            y.asignaLiga(x);
            ultimo = x;
            return;
        }
        x.asignaLiga(y.retornaLiga());
        y.asignaLiga(x);
        if (y == ultimo) {
            ultimo = x;
        }
    }

    public NodoSimple buscarDato(int d, NodoSimple y) {
        if (this.esVacio()) {
            return null;
        }
        NodoSimple x;
        x = primerNodo();
        y = anterior(x);
        while (!finDeRecorrido(x) && x.retornaDato() != d) {
            y = x;
            x = x.retornaLiga();
        }
        return x;
    }

    public void borrar(NodoSimple x, NodoSimple y) {
        if (x == null) {
            System.out.println("El dato no existe");
        }
        desconectar(x, y);
    }

    public void desconectar(NodoSimple x, NodoSimple y) {
        y.asignaLiga(x.retornaLiga());
        if (x == ultimo) {
            ultimo = y;
        }
        if (x == primerNodo()) {
            primero = x.retornaLiga();
        }
    }
}

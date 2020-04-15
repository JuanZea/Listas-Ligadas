package listasligadas;

/**
 *
 * @author JuanZea
 */
public class LSLCCNC {

    private NodoSimple primero;
    private NodoSimple ultimo;

    public LSLCCNC() {
        primero = new NodoSimple(null);
        primero.asignaLiga(primero);
        ultimo = primero;
    }

    public boolean esVacio() {
        return primero == primero.retornaLiga();
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
        return p == nodoCabeza();
    }

    public void recorre() {
        if (this.esVacio()) {
            return;
        }
        NodoSimple p;
        p = primerNodo();
        do {
            System.out.print(p.retornaDato() + "\t");
            p = p.retornaLiga();
        } while (!finDeRecorrido(p));
        System.out.println();
    }

    public NodoSimple buscaDondeInsertar(int d) {
        if (this.esVacio()) {
            return null;
        }
        NodoSimple p, y;
        p = primerNodo();
        y = nodoCabeza();
        if (primerNodo().retornaDato() > d) {
            return y;
        }
        do {
            y = p;
            p = p.retornaLiga();
        } while (!finDeRecorrido(p) && p.retornaDato() < d);
        return y;
    }

    public void insertar(int d, NodoSimple y) {
        NodoSimple x;
        x = new NodoSimple(d);
        conectar(x, y);
    }

    public void conectar(NodoSimple x, NodoSimple y) {
        if (this.esVacio()) {
            nodoCabeza().asignaLiga(x);
            ultimo = x;
            x.asignaLiga(nodoCabeza());
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
        NodoSimple p;
        p = primerNodo();
        y = nodoCabeza();
        if (primerNodo().retornaDato() == d) {
            return p;
        }
        do {
            y = p;
            p = p.retornaLiga();
        } while (!finDeRecorrido(p) && p.retornaDato() != d);
        if (p == nodoCabeza()) {
            return null;
        }
        return p;
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
    }
}

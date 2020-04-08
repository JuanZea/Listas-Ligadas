package listasligadas;

/**
 *
 * @author JuanZea
 */
public class LSLC {

    private NodoSimple primero;
    private NodoSimple ultimo;

    public LSLC() {
        primero = ultimo = null;
    }

    public boolean esVacio() {
        return primero == null;
    }

    public NodoSimple primerNodo() {
        return primero;
    }

    public NodoSimple ultimoNodo() {
        return ultimo;
    }

    public NodoSimple anterior(NodoSimple x) {
        NodoSimple p, y;
        p = primero;
        y = ultimo;
        while (p != x) {
            y = p;
            p = p.retornaLiga();
        }
        return y;
    }

    public boolean finDeRecorrido(NodoSimple p) {
        return p == primero;
    }

    public void recorre() {
        if (this.esVacio()) {
            return;
        }
        NodoSimple p;
        p = primero;
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
        p = primero;
        y = null;
        if (primero.retornaDato() > d) {
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
            primero = x;
            ultimo = x;
            x.asignaLiga(x);
            return;
        }
        if (y == null) {
            primero = x;
            x.asignaLiga(ultimo.retornaLiga());
            ultimo.asignaLiga(x);
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
        p = primero;
        y = ultimo;
        if (primero.retornaDato() == d) {
            return p;
        }
        do {
            y = p;
            p = p.retornaLiga();
        } while (!finDeRecorrido(p) && p.retornaDato() != d);
        if (p == primero) {
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
        if (x == primero) {
            primero = primero.retornaLiga();
            return;
        }
        if (x == ultimo) {
            ultimo = y;
            return;
        }
    }
}

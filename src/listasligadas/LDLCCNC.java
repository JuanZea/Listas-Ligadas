package listasligadas;

/**
 *
 * @author JuanZea
 */
public class LDLCCNC {

    private NodoDoble primero, ultimo;

    public LDLCCNC() {
        primero = new NodoDoble(null);
        primero.asignaLigaD(primero);
        primero.asignaLigaI(primero);
        ultimo = primero;
    }

    public boolean esVacio() {
        return primero == primero.retornaLigaD();
    }

    public NodoDoble nodoCabeza() {
        return primero;
    }

    public NodoDoble primerNodo() {
        return primero.retornaLigaD();
    }

    public NodoDoble ultimoNodo() {
        return ultimo;
    }

    public NodoDoble anterior(NodoDoble x) {
        return x.retornaLigaI();
    }

    public boolean finDeRecorrido(NodoDoble p) {
        return p == nodoCabeza();
    }

    public void recorre() {
        NodoDoble p;
        p = primerNodo();
        do {
            System.out.print(p.retornaDato() + "\t");
            p = p.retornaLigaD();
        } while (!finDeRecorrido(p));
        System.out.println();
    }

    public NodoDoble buscaDondeInsertar(int d) {
        if (esVacio()) {
            return nodoCabeza();
        }
        NodoDoble p, y;
        p = primerNodo();
        y = anterior(p);
        if (primerNodo().retornaDato() > d) {
            return y;
        }
        do {
            y = p;
            p = p.retornaLigaD();
        } while (!finDeRecorrido(p) && p.retornaDato() < d);
        return y;
    }

    public void insertar(int d, NodoDoble y) {
        NodoDoble x;
        x = new NodoDoble(d);
        conectar(x, y);
    }

    public void conectar(NodoDoble x, NodoDoble y) {
        x.asignaLigaD(y.retornaLigaD());
        x.asignaLigaI(y);
        y.asignaLigaD(x);
        if (y == ultimo) {
            ultimo = x;
            primero.asignaLigaI(x);
        }
    }

    public NodoDoble buscarDato(int d, NodoDoble y) {
        if (this.esVacio()) {
            return null;
        }
        NodoDoble x;
        x = primerNodo();
        y = anterior(x);
        if (x.retornaDato() == d) {
            return x;
        }
        do {            
            y = x;
            x = x.retornaLigaD();
        } while (!finDeRecorrido(x) && x.retornaDato() != d);
        if(x==nodoCabeza()){
            return null;
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
        y.asignaLigaD(x.retornaLigaD());
        if (x == ultimo) {
            ultimo = y;
            primero.asignaLigaI(y);
        }
    }
}

package listasligadas;

/**
 *
 * @author JuanZea
 */
public class LDLCNC {
    private NodoDoble primero, ultimo;

    public LDLCNC() {
        primero = new NodoDoble(null);
        primero.asignaLigaD(null);
        primero.asignaLigaI(null);
        ultimo = primero;
    }

    public boolean esVacio() {
        return primero.retornaLigaD() == null;
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
        if(esVacio()){
            return nodoCabeza();
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
            x.asignaLigaD(y.retornaLigaD());
            x.asignaLigaI(y);
            y.asignaLigaD(x);
            if(y == ultimo){
                ultimo = x;
            }
    }

    public NodoDoble buscarDato(int d, NodoDoble y) {
        if (this.esVacio()) {
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
        y.asignaLigaD(x.retornaLigaD());
        if (x == ultimo) {
            ultimo = y;
        }
    }
}

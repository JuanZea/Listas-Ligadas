package listasligadas;

/**
 *
 * @author JuanZea
 */
public class LDLC {

    private NodoDoble primero, ultimo;
    
    public LDLC() {
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
        return p == primerNodo();
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
            return null;
        }
        NodoDoble p, y;
        p = primerNodo();
        y = anterior(p);
        if (p.retornaDato() > d) {
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
        if (y != null) {
            x.asignaLigaD(y.retornaLigaD());
            x.asignaLigaI(y);
            y.asignaLigaD(x);
            if (y == ultimo) {
                ultimo = x;
                primerNodo().asignaLigaI(ultimoNodo());
            } else {
                x.retornaLigaD().asignaLigaI(x);
            }
        } else {
            x.asignaLigaD(primerNodo());
            if (primerNodo() == null) {
                ultimo = x;
                x.asignaLigaD(x);
                x.asignaLigaI(x);
            } else {
                primerNodo().asignaLigaI(x);
                primerNodo().asignaLigaD(x);
                x.asignaLigaI(primerNodo());
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
        if (x.retornaDato() == d) {
            return x;
        }
        do {            
            y = x;
            x = x.retornaLigaD();
        } while (!finDeRecorrido(x) && x.retornaDato() != d);
        if (x == primerNodo()) {
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
        if (x != primerNodo()) {
            y.asignaLigaD(x.retornaLigaD());
            if (x == ultimo) {
                ultimo = y;
            } else {
                y.retornaLigaD().asignaLigaI(y);
            }
        } else {
            primero = primerNodo().retornaLigaD();
            if (primerNodo() == primero) {
                primero = null;
                ultimo = null;
            } else {
                ultimoNodo().asignaLigaD(primerNodo());
                primerNodo().asignaLigaI(ultimoNodo());
            }
        }
    }
}

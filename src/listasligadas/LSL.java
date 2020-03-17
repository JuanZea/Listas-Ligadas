package listasligadas;

/**
 *
 * @author JuanZea
 */
public class LSL {
    private NodoSimple primero, ultimo;
    
    public LSL(){
        primero = ultimo = null;
    }
    public boolean isEmpty(){
        return primero == null;
    }
    public NodoSimple primerNodo(){
        return primero;
    }
    public NodoSimple ultimoNodo(){
        return ultimo;
    }
    public NodoSimple anterior(NodoSimple x){
        NodoSimple p, y;
        p = primerNodo();
        y = null;
        while(p != x){
            y = p;
            p = p.retornaLiga();
        }
        return  y;
    }
    public boolean finDeRecorrido(NodoSimple p){
        return p == null;
    }
    public void recorre(){
        NodoSimple p;
        p = primerNodo();
        while(!finDeRecorrido(p)){
            System.out.println(p.retornaDato());
            p = p.retornaLiga();
        }
    }
    public NodoSimple buscaDondeInsertar(char d){
        NodoSimple p, y;
        p = primerNodo();
        y = anterior(p);
        while(!finDeRecorrido(p) && p.retornaDato() < d){
            y = p;
            p = p.retornaLiga();
        }
        return y;
    }
    public void insertar(char d, NodoSimple y){
        NodoSimple x;
        x = new NodoSimple(d);
        conectar(x, y);
    }
    public void conectar(NodoSimple x, NodoSimple y){
        if(y != null){
            x.asignaLiga(y.retornaLiga());
            y.asignaLiga(x);
            if(y == ultimo)
                ultimo = x;
        }
        else{
            x.asignaLiga(primero);
            if(primero == null)
                ultimo = x;
            primero = x;
        }
    }
}

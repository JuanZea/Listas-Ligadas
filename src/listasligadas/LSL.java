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
    public boolean esVacio(){
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
    public NodoSimple buscarDato(char d, NodoSimple y){
        NodoSimple x;
        x = primero;
        y = anterior(x);
        while(!finDeRecorrido(x) && x.retornaDato() != d){
            y = x;
            x = x.retornaLiga();
        }
        return x;
    }
    public void borrar(NodoSimple x, NodoSimple y){
        if(x == null){
            System.out.println("El dato no existe");
        }
        desconectar(x, y);
    }
    public void desconectar(NodoSimple x, NodoSimple y){
        if(x != primero){
            y.asignaLiga(x.retornaLiga());
            if(x == ultimo)
                ultimo = y;
        }
        else{
            primero = primero.retornaLiga();
            if(primero == null)
                ultimo = null;
        }
    }
    public void ordenaAscendentemente(){
        //Método de ordenamiento por selección
        NodoSimple p, ap, menor, amenor, q, aq;
        p = primerNodo();
        ap = anterior(p);
        while(p != ultimoNodo()){
            menor = p;
            amenor = ap;
            q = p.retornaLiga();
            aq = p;
            while(!finDeRecorrido(q)){
                if(q.retornaDato() < menor.retornaDato()){
                    menor = q;
                    amenor = aq;
                }
                aq = q;
                q = q.retornaLiga();
            }  
            if(menor == p){
                ap = p;
                p = p.retornaLiga();
            }
            else{
                desconectar(menor, amenor);
                conectar(menor, ap);
                ap = menor;
            }
        }
    }
}

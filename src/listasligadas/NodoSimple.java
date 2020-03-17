package listasligadas;

/**
 *
 * @author JuanZea
 */
public class NodoSimple {
    private char dato;
    private NodoSimple liga;
    
    public NodoSimple(){
    }
    public NodoSimple(char pDato) {
        dato = pDato;
        liga = null;
    }
    
    public char retornaDato(){
        return dato;
    }
    public NodoSimple retornaLiga(){
        return  liga;
    } 
    public void asignaDato(char pDato){
        dato = pDato;
    }
    public void asignaLiga(NodoSimple p){
        liga = p;
    }
}

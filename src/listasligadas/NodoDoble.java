package listasligadas;

/**
 *
 * @author JuanZea
 */
public class NodoDoble {

    private Integer dato;
    private NodoDoble ligaI, ligaD;

    public NodoDoble() {
    }

    public NodoDoble(Integer pDato) {
        ligaI = ligaD = null;
        dato = pDato;
    }

    public int retornaDato() {
        return dato;
    }

    public NodoDoble retornaLigaI() {
        return ligaI;
    }

    public NodoDoble retornaLigaD() {
        return ligaD;
    }

    public void asignaDato(int pDato) {
        dato = pDato;
    }

    public void asignaLigaI(NodoDoble pLigaI) {
        ligaI = pLigaI;
    }

    public void asignaLigaD(NodoDoble pLigaD) {
        ligaD = pLigaD;
    }
}

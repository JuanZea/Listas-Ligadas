package listasligadas;

/**
 *
 * @author JuanZea
 */
public class Program {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Boolean working = true;
        while (working) {
            working = menu.principal();
        }
    }
}
// Falta reparar errores con LDLCNC y LDLCCNC
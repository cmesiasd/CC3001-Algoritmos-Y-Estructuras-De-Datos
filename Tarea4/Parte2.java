import java.util.Scanner;
import java.util.Random;

public class Parte2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArbolCartesiano arbol = new ArbolCartesiano();
        System.out.println("Cantidad de nodos: ");
        int nodos = scan.nextInt();
        int i = 1;
        while(i <= nodos){
            arbol.insertar(i,(float)(Math.random()*nodos));
            i++;
        }
        System.out.print("\nCosto Promedio: " + arbol.costoPromedio());
    }

}

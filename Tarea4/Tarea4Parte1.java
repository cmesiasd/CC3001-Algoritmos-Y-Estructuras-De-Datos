import java.util.Scanner;
import java.io.*;

public class Tarea4Parte1{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArbolCartesiano arbol = new ArbolCartesiano();
        char ch;
        do {
            System.out.println("Ingrese el directorio donde está trabajando: ");
            System.out.println("Ej: C:\\Users\\Usuario\\Desktop");
            String dir = scan.nextLine();
            System.out.println("Ingrese nombre del archivo a leer: ");
            System.out.println("Ej: Arbol.txt");
            String input = scan.nextLine();
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;
            try {
                archivo = new File (dir+"\\"+input);
                fr = new FileReader (archivo);
                br = new BufferedReader(fr);
                String linea;
                while ((linea=br.readLine())!=null) {
                    String[] numeros= linea.split(" ");
                    int X = Integer.parseInt(numeros[0]);
                    float Y = Float.parseFloat(numeros[1]);
                    arbol.insertar(X, Y);
                }
            } catch (FileNotFoundException e){
                System.out.println("No se encontro el archivo en el directorio indicado");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Agregar otro arbol? (Escribe Y para continuar o N para terminar)");
            ch = scan.nextLine().charAt(0);
        } while (ch == 'Y' || ch == 'y');
        System.out.print("\nImpresión en PostOrden: ");
        arbol.imprimir();
        System.out.print("\nCosto Promedio: " + arbol.costoPromedio());
    }
}


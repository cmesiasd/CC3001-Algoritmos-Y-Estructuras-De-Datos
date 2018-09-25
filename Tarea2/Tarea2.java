import java.util.Scanner;

public class Tarea2 {

    public static int ProductoOP(int[] p, int[][] m, int[][] s) { //Función que optimiza la cantidad de multiplicaciones y la posicion de esta
        int n = p.length - 1; //largo a utilizar para las dim de las matrices
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0; //Diagonal de la matriz, si representa la misma matriz a multiplicar, la multiplicacion es 0
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j]; //Calculo de la cantidad de multiplicaciones necesarias
                    if (q < m[i][j]) {
                        m[i][j] = q; //Número mínimo de multiplicaciones desde la matriz i a la j
                        s[i][j] = k; //Posición óptima para comenzar a multiplicar entre la matriz i a la j.
                    }
                }
            }
        }
        return m[1][n];
    }

    public static String Ordenar(int ini, int fin, int[][] s) {
        if (ini == fin) { //Si el valor inicial es igual al final, es la misma matriz
            return ".";
        }
        else if (ini + 1 == fin) { //Si las matrices están contiguas, representan la multiplicación de estas.
            return "(..)";
        }
        else {
            int k = s[ini][fin];//Valor óptimo donde ubicar el primer paréntesis, éste viene dado por la matriz s
            String LadoIzq = Ordenar(ini, k, s); //Recursión lado izq
            String LadoDer = Ordenar(k + 1, fin, s); //Recursión lado der
            return "(" + LadoIzq + LadoDer + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("Ingrese tamaño de la matriz:");
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){ //Mientras haya next line ejecuta el programa
            String string=sc.nextLine();
            String [] valores=string.split(" "); //Lee y separa los espacios vacios guardando un arreglo de string
            int [] largo= new int[valores.length];
            for(int i=0; i<largo.length;i++) {
                largo[i]=Integer.parseInt(valores[i]); //Convierte el arreglo de string a uno de enteros
            }
            int [][] m=new int [largo.length][largo.length];
            int [][] s=new int [largo.length][largo.length]; //Crea dos matrices vacias
            ProductoOP(largo, m, s); //Entra el arreglo de enteros y ejecuta la optimización
            String resultado = Ordenar(1,largo.length-1,s); //Aplica el algoritmo de ordenar los parentesis
            System.out.println(resultado);
        }
        System.out.println("Se terminó el programa"); //Al salir del while, imprime en pantalla que ya no lee.
    }
}

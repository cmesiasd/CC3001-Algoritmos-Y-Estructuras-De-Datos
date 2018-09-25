import java.util.Scanner;
public class Tarea3 {
    Lista top;

    public Tarea3(){
        top = null;
    }

    public boolean estaVacio(){
        return top == null;
    }

    public void apilar(Arbol x){
        Lista newtop = new Lista(x);
        newtop.sig = top;
        top = newtop;
    }

    public Arbol desapilar(){
        if(estaVacio()){
            return top.val = null; //error
        }

        Arbol ans = top.val;
        top = top.sig;
        return ans;
    }

    public static boolean esNumero(String s){
        for(int i = 0; i<s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean esVariable(String s){
        for(int i = 0; i<s.length(); i++){
            if(!Character.isLetter(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static Arbol input(String expresion){

        String[] expr = expresion.split(" ");
        Tarea3 stack = new Tarea3();

        for(String str : expr){
            //si el string es un numero, entonces se apila
            if(esNumero(str)){
                Arbol arbol = new Arbol(str);
                stack.apilar(arbol);
            }
            else if(esVariable(str)){
                Arbol arbol = new Arbol(str);
                stack.apilar(arbol);
            }
            else{
                //si no lo es, entonces se sacan los ultimos 2 numeros de la pila,
                //se operan segun corresponda y luego se apila el resultado
                Arbol op2 = stack.desapilar();
                Arbol op1 = stack.desapilar();
                if(str.equals("+")){
                    Arbol op = new Arbol(str,op1,op2);
                    stack.apilar(op);
                }
                if(str.equals("-")){
                    Arbol op = new Arbol(str,op1,op2);
                    stack.apilar(op);
                }
                if(str.equals("*")){
                    Arbol op = new Arbol(str,op1,op2);
                    stack.apilar(op);
                }
                if(str.equals("/")){
                    Arbol op = new Arbol(str,op1,op2);
                    stack.apilar(op);
                }
            }
        }
        //el resultado de toda la operacion es el ultimo elemento que queda en la pila al
        //terminar de revisar el string
        return stack.desapilar();
    }


    public static String mostrarArbol(Arbol arbol) {
        if (arbol.izq == null && arbol.der == null) {
            return arbol.valor;
        }
        else {
            return " (" + mostrarArbol(arbol.izq) + arbol.valor + mostrarArbol(arbol.der) + ") ";
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese función en notación polaca inversa: ");
        while(sc.hasNextLine()) {

            String funcion = sc.nextLine();
            System.out.println("Variable a derivar: ");
            String var = sc.nextLine();
            Arbol arbol = input(funcion);
            System.out.println(mostrarArbol(arbol.derivada(var)));
            System.out.println("Ingrese función en notación polaca inversa: ");

        }
    }
}

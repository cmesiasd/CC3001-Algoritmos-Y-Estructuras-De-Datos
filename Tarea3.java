import java.util.Scanner;
public class Tarea3 {

    Lista top;

    public Tarea3(){
        top = null;
    }

    public boolean estaVacio(){
        return top == null;
    }


    public void apilar(String x){
        Lista newtop = new Lista(x);
        newtop.sig = top;
        top = newtop;
    }


    public String desapilar(){
        if(estaVacio()){
            return "-"; //error
        }

        String ans = top.val;
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

    public static String input(String expresion){

        String[] expr = expresion.split(" ");
        Tarea3 stack = new Tarea3();

        for(String str : expr){
            //si el string es un numero, entonces se apila
            if(esNumero(str)){
                stack.apilar(str);
                Arbol arbol = new Arbol(str);
            }
            else if(esVariable(str)){
                Arbol arbol = new Arbol(str);
                stack.apilar(str);
            }
            else{
                String op2 = stack.desapilar();
                String op1 = stack.desapilar();
                String ans = " ";
                if(str.equals("+")){
                    ans = "(" + op1 + " + " + op2 + ")";
                    Arbol rama_izq = new Arbol(op1);
                    Arbol rama_der = new Arbol(op2);
                    Arbol op = new Arbol(str,rama_izq,rama_der);
                }
                if(str.equals("-")){
                    ans = "(" + op1 + " - " + op2 + ")";
                    Arbol rama_izq = new Arbol(op1);
                    Arbol rama_der = new Arbol(op2);
                    Arbol op = new Arbol(str,rama_izq,rama_der);
                }
                if(str.equals("*")){
                    ans = "(" + op1 + " * " + op2 + ")";
                    Arbol rama_izq = new Arbol(op1);
                    Arbol rama_der = new Arbol(op2);
                    Arbol op = new Arbol(str,rama_izq,rama_der);
                }
                if(str.equals("/")){
                    ans = "(" + op1 + " / " + op2 + ")";
                    Arbol rama_izq = new Arbol(op1);
                    Arbol rama_der = new Arbol(op2);
                    Arbol op = new Arbol(str,rama_izq,rama_der);
                }
                stack.apilar(ans);

            }
        }
        //si no lo es, entonces se sacan los ultimos 2 numeros de la pila,
        //se operan segun corresponda y luego se apila el resultado

        //el resultado de toda la operacion es el ultimo elemento que queda en la pila al
        //terminar de revisar el string
        return stack.desapilar();
    }

    public static void main(String[] args){
        Tarea3 holi = new Tarea3();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(input(s));
        }
    }
}

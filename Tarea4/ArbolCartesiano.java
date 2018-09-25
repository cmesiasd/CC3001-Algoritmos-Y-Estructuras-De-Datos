class ArbolCartesiano {

    private NodoCartesiano raiz;
    private static NodoCartesiano vacio = new NodoCartesiano();

    public ArbolCartesiano(){
        raiz = vacio;
    }
    public void insertar(int X, float Y){
            raiz = insertar(X,Y,raiz);
    }

    private NodoCartesiano insertar(int X, float Y, NodoCartesiano arb){
        if(arb == vacio){
            return new NodoCartesiano(X,Y,vacio,vacio);
        }
        else if(X < arb.x){ //Rotación Izq
            arb.izq = insertar(X,Y,arb.izq);
            if (arb.izq.y < arb.y){
                NodoCartesiano Izq = arb.izq;
                arb.izq = Izq.der;
                Izq.der = arb;
                return Izq;
            }
        }
        else if (X > arb.x){ //Rotación Der
            arb.der = insertar(X,Y,arb.der);
            if (arb.der.y < arb.y){
                NodoCartesiano Der = arb.der;
                arb.der = Der.izq;
                Der.izq = arb;
                return Der;
            }
        }
        return arb;
    }

    public void imprimir() {
        imprimir(raiz);
    }
    private void imprimir(NodoCartesiano r) {
        if (r != vacio) {
            imprimir(r.izq);
            imprimir(r.der);
            System.out.print("(" + r.x + "," + r.y +")");
        }
        else {
            System.out.print("[]");
        }
    }

    public int contadorNodos(){
        return contadorNodos(raiz);
    }
    private int contadorNodos(NodoCartesiano r){
        if (r == vacio){
            return 0;
        }
        else {
            int i = 1;
            i += contadorNodos(r.izq);
            i += contadorNodos(r.der);
            return i;
        }
    }

    int altura = 0;
    public int alturaNodo() {
        return alturaNodo(raiz, 1);
    }
    private int alturaNodo(NodoCartesiano r, int nivel) {
        if (r != vacio) {
            altura += nivel;
            alturaNodo(r.izq, nivel + 1);
            alturaNodo(r.der, nivel + 1);
        }
        return altura;
    }


    public float costoPromedio(){
        return costoPromedio(alturaNodo(),contadorNodos());
    }
    private float costoPromedio(int x, int y){
        return (float)x / y;
    }


}

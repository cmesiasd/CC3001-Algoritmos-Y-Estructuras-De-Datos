class NodoCartesiano {
    int x;
    float y;
    NodoCartesiano izq,der;

    public NodoCartesiano(){
        this.x = 0;
        this.y = 0;
        this.izq = null;
        this.der = null;
    }
    public NodoCartesiano(int x, float y){
        this(x,y,null,null);

    }

    public NodoCartesiano(int x, float y, NodoCartesiano izq, NodoCartesiano der){
        this.x = x;
        this.y = y;
        this.izq = izq;
        this.der = der;
    }

}

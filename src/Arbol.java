public class Arbol {
    public Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    //insertar
    public void insertar(int x) {
        raiz = insertarRecursivo(raiz, x);
    }

    private Nodo insertarRecursivo(Nodo nodo, int x) {
        if (nodo == null) {
            return new Nodo(x);
        }
        if (x < nodo.elem) {
            nodo.izq = insertarRecursivo(nodo.izq, x);
        } else {
            nodo.der = insertarRecursivo(nodo.der, x);
        }
        return nodo;
    }

    //recorrido Inorden
    public void recInOrden() {
        recInOrdenRecursivo(raiz);
    }

    private void recInOrdenRecursivo(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        recInOrdenRecursivo(nodo.izq);
        System.out.print(nodo.elem + " ");
        recInOrdenRecursivo(nodo.der);
    }

    //ejer1 --> se encuentra
    public boolean seEncuentra(int x) {
        return seEncuentraRecursivo(raiz,x);
    }

    private boolean seEncuentraRecursivo(Nodo nodo, int x) {
        if (nodo == null) {
            return false;
        }
        if (nodo.elem == x) {
            return true;
        }
        if (x < nodo.elem) {
            return seEncuentraRecursivo(nodo.izq, x);
        } else {
            return seEncuentraRecursivo(nodo.der, x);
        }
    }
    //2 --> metodo de que devuelve la cantidad de nodos en el arbol
    public int cantidad(){
        return cantidadRecursivo(raiz);
    }
    private int cantidadRecursivo(Nodo nodo){
        if (nodo == null){
            return 0;
        }
        return cantidadRecursivo(nodo.izq) + cantidadRecursivo(nodo.der) + 1;
    }
    //3-> metodo que devuelve la cantidad de nodo terminales en el arbol
    public int cantidadTerm(){
        return cantidadTermRecursivo(raiz);
    }
    private int cantidadTermRecursivo(Nodo nodo){
        if (nodo == null){
            return 0;
        }
        if ((nodo.izq == null) && (nodo.der == null)){
            return 1;
        }
        return cantidadTermRecursivo(nodo.izq) + cantidadTermRecursivo(nodo.der);
    }

}

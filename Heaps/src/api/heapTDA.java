package api;

public interface heapTDA {
	void InicializarHeap(boolean maxHeap); //recibe true si es max-heap o false si es min-heap
	int Primero(); //heap inicializado y no vacio
	void Insertar(int x);	//heap inicializado
	void Eliminar();	//heap inicializado
	boolean HeapVacio(); //heap inizializado
}

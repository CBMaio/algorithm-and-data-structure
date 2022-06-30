package impl;
import api.heapTDA;

public class heap implements heapTDA {
	boolean isMax;
	int[] arr;
	int cant;
	
	public void InicializarHeap(boolean maxHeap) {
		isMax= maxHeap;
		arr = new int[100];
		cant = 0;
	}
	
	public void Insertar(int x) {
		arr[cant] = x;
		cant++;
		SubirNodo(cant-1);
	}
	
	public void Eliminar() {
		//tomo el utimo valor y lo coloco en la raiz
		int ultimo = arr[cant - 1];
		arr[0] = ultimo;
		cant--;
		BajarNodo(arr[0], 0);
	}

	
	public int Primero() {
		return arr[0];
	}
	
	public boolean HeapVacio() {
		return cant == 0;
	}

	//recibe el numero e indice del elemento y lo acomoda donde corresponda
	private void BajarNodo(int x, int indice) {
		int hijoSeleccionado;
		int izq = this.HijoIzq(indice);
		int der = this.HijoDer(indice);
		
		//caso base: si no tiene hijos, retorno.
		if(izq > (cant - 1) && der > (cant - 1)) {
			return;
		}
		
		if( der > cant - 1 || ( 
					(isMax && arr[izq] > arr[der]) || (!isMax && arr[izq] < arr[der])
				)
			){
			hijoSeleccionado = izq;
		} else {
			hijoSeleccionado = der;
		}
		
		
		if ( (isMax && arr[hijoSeleccionado] > x) || (!isMax && arr[hijoSeleccionado] < x) ){
			int aux = arr[indice];
			arr[indice] = arr[hijoSeleccionado];
			arr[hijoSeleccionado] = aux;
			
			int posicion = hijoSeleccionado;
			BajarNodo(x, posicion);
			
		}
		
	}
	
	private int HijoIzq (int index) {
			return (2 * index) + 1;
	}
	
	private int HijoDer(int index) {
		return (2 * index) + 2;
	}
	
	private void SubirNodo(int i) {
		//caso base, ya estamos en la raiz
		if (i == 0) {
			return;
		}
		
		// si es max heap y el nuevo elemento es mayor que el nodo padre, o
		// si e min heap y el nuevo elemento es menor que el nodo padre
		if ((isMax && (arr[this.Padre(i)] < arr[i])) || (!isMax && (arr[this.Padre(i)] > arr[i]))) {
			//intercambiar el elemento que recien ingresó con el padre
			int indicePadre = this.Padre(i);
			int aux = arr[indicePadre];
			arr[indicePadre] = arr[i];
			arr[i] = aux;
			int posicion = this.Padre(i);
			
			//se llama recursivamente hasta que este en el orden correcto
			SubirNodo(posicion);
		}
		
	}
		  
	private int Padre (int index) {
		return (index-1)/2;
	}
	
}

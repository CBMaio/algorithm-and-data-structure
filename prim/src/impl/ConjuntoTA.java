package impl;
import api.ConjuntoTDA;

public class ConjuntoTA implements ConjuntoTDA{
	int[] a;
	int cant;
	
	public void InicializarConjunto() {
		a = new int[100];
		cant = 0; 
	}
	
	public boolean Pertenece(int x) {
		int i = cant - 1;
		while (i >= 0 && a[i] != x ) {
			i--;
		}
		
		return i >= 0;
	}
	
	public void Agregar (int x) {
		if(!this.Pertenece(x)) {
			a[cant]	 = x;
			cant++;
		}
	}
	
	public void Sacar (int x) {
		int indice = cant - 1;
		while (indice >= 0 && a[indice] != x) {
			indice--;
		}
		
		if (indice >= 0) {
			a[indice] = a[cant - 1];
			cant--;
		}	
	}
	
	public int Elegir() {
		return a[cant - 1];
	}
	
	public boolean ConjuntoVacio() {
		return cant == 0;
	}
}

package impl;
import api.GrafoNDTDA;
import api.ConjuntoTDA;

public class GrafoND implements GrafoNDTDA {
	int n = 100;
	int[][] mAdy;
	int cantNodos;
	int [] elementos;
	
	public void InicializarGrafo() {
		mAdy = new int [n][n];
		elementos = new int [n];
		cantNodos = 0;
	}
	
	public void AgregarVertice(int v) {
		elementos[cantNodos] = v;
		for(int i = 0; i < cantNodos; i++) {
			//creamos una fila y columna en cero para el nuevo vertice
			mAdy[cantNodos][i] = 0;
			mAdy[i][cantNodos] = 0;
		}
		
		cantNodos++;
	}
	
	public void EliminarVertice(int v) {
		int ind = Vertice2Indice(v);
		for (int i = 0; i < cantNodos; i++) {
			mAdy[ind][i] = mAdy[cantNodos - 1][i];
		}
		for (int i = 0; i < cantNodos; i++) {
			mAdy[i][ind] = mAdy[i][cantNodos - 1];
		}
		
		elementos[ind] = elementos[cantNodos - 1];
		cantNodos--;
	}
	
	private int Vertice2Indice(int v) {
		//busco en que indice esta el vertice recibido
		int ind = cantNodos - 1;
		while(ind >= 0 && elementos[ind] != v) {
			ind--;
		}
		
		return ind;
	}
	
	public void AgregarArista(int v1, int v2, int p) { 
		int n1 = Vertice2Indice(v1);
		int n2 = Vertice2Indice(v2);
		
		mAdy[n1][n2] = p;
		mAdy[n2][n1] = p;
	}
	
	public void EliminarArista(int v1, int v2) {
		int n1 = Vertice2Indice(v1);
		int n2 = Vertice2Indice(v2);
		
		mAdy[n1][n2] = 0;
		mAdy[n2][n1] = 0;
	}
	
	public int PesoArista(int v1, int v2) {
		int n1 = Vertice2Indice(v1);
		int n2 = Vertice2Indice(v2);
		
		return mAdy[n1][n2];
	}
	
	public boolean ExisteArista(int v1, int v2) {
		int n1 = Vertice2Indice(v1);
		int n2 = Vertice2Indice(v2);
		
		return (mAdy[n1][n2] != 0);
	}
	
	public ConjuntoTDA Vertices() {
		ConjuntoTDA vertices = new ConjuntoTA();
		vertices.InicializarConjunto();
		for (int i =  0 ; i < cantNodos; i++) {
			vertices.Agregar(elementos[i]);
		}
		
		return vertices;
	}
	
	public void MostrarGrafo() {
		for (int i = 0; i < cantNodos; i++) {
			System.out.print(elementos[i] + "   ");
		}
		
		System.out.println();
		System.out.println();
		
		for(int i = 0; i < cantNodos; i++) {
			for(int j = 0; j < cantNodos; j++) {
				System.out.print(mAdy[i][j] + "   ");
			}
			
			System.out.println();
		}
	}
}

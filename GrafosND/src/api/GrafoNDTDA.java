package api;

public interface GrafoNDTDA {
	void InicializarGrafo(); //sin precondiciones
	void AgregarVertice(int v); //grafo inicializado y vertice no existente
	void AgregarArista(int v1, int v2, int p);	//grafo inicializado. v1 y v2 existentes
	void EliminarVertice(int v);	//grafo inicializado y v existente 
	void EliminarArista(int v1, int v2); //v1 y v2 existentes
	int PesoArista(int v1, int v2);		
	ConjuntoTDA Vertices();
	boolean ExisteArista(int v1, int v2);
	void MostrarGrafo();
}

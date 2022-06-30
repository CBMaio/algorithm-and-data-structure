package api;

public interface GrafoNDTDA {
	void InicializarGrafo();
	void AgregarVertice(int v);
	void AgregarArista(int v1, int v2, int p);
	void EliminarVertice(int v);
	void EliminarArista(int v1, int v2);
	int PesoArista(int v1, int v2);
	ConjuntoTDA Vertices();
	boolean ExisteArista(int v1, int v2);
	void MostrarGrafo();
}

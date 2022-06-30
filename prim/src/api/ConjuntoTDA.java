package api;

public interface ConjuntoTDA {
	void InicializarConjunto();	//sin precondiciones
	void Agregar(int x);		//conjunto inicializado
	void Sacar(int x);	//conjunto inicializado
	int Elegir();	//conjunto inicializado y no vacío
	boolean ConjuntoVacio();	//conjunto inicializado
	boolean Pertenece(int x);	//conjunto inicializado
}

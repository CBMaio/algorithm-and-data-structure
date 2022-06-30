package prin;
import api.GrafoNDTDA; 
import impl.GrafoND;
import api.ConjuntoTDA;

public class principal {

	public static void main(String[] args) {
		GrafoNDTDA g = new GrafoND();
		g.InicializarGrafo();
		g.AgregarVertice(1);
		g.AgregarVertice(2);
		g.AgregarVertice(3);
		g.AgregarVertice(4);
		g.AgregarVertice(5);
		g.AgregarArista(2, 1, 1);
		g.AgregarArista(1, 4, 1);
		g.AgregarArista(1, 5, 1);
		g.AgregarArista(2, 3, 1);
		g.AgregarArista(3, 4, 1);
		g.AgregarArista(4, 5, 1);

		g.MostrarGrafo();
	}

}

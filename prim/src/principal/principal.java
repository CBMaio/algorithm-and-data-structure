package principal;
import api.GrafoNDTDA;
import api.ConjuntoTDA;
import impl.GrafoND;
import impl.ConjuntoTA;

public class principal {
	
	public static ConjuntoTDA Adyacentes (GrafoNDTDA g, int vertice) {
		ConjuntoTDA adyacentes = new ConjuntoTA();
		adyacentes.InicializarConjunto();
		
		ConjuntoTDA vertices = g.Vertices();
		vertices.Sacar(vertice);
		int aux_vertice;
		
		//creo un nuevo conjunto y agrego los vertices que tengan aristas con el vertice parametro
		while(!vertices.ConjuntoVacio()) {
			aux_vertice = vertices.Elegir();
			vertices.Sacar(aux_vertice);
			if(g.ExisteArista(aux_vertice, vertice)) {
				adyacentes.Agregar(aux_vertice);
			}
		}
		
		return adyacentes;
	}
	
	public static GrafoNDTDA AlgoritmoPrim (GrafoNDTDA g) {
			//inicializo el grafo resultado (salida) 
			GrafoNDTDA resultado = new GrafoND();
			resultado.InicializarGrafo();
			
			ConjuntoTDA pendientes = g.Vertices();
			ConjuntoTDA aux_pendientes = g.Vertices();
			
			//se selecciona el vertice del que se va a partir 
			int vertice = pendientes.Elegir();
			pendientes.Sacar(vertice);
			aux_pendientes.Sacar(vertice);
			
			resultado.AgregarVertice(vertice);
			ConjuntoTDA adyacentes = Adyacentes(g, vertice);
			
			int aux_vertice;
			int vertice_seleccionado = vertice;
			int menor_arista = 0;
			
			//busco el mejor adyacente del primer vertice seleccionado
			while (!adyacentes.ConjuntoVacio()) {
				aux_vertice = adyacentes.Elegir(); //tomo otro vertice para compararlo con el vertice
				
				//si es la primer arista o es menor a la anterior
				if (menor_arista == 0 || g.PesoArista(aux_vertice, vertice) < menor_arista) {						
					menor_arista = g.PesoArista(aux_vertice, vertice);
					vertice_seleccionado = aux_vertice;
				}
				
				adyacentes.Sacar(aux_vertice);
			}
			
			if (menor_arista != 0) {
				resultado.AgregarVertice(vertice_seleccionado);
				resultado.AgregarArista(vertice, vertice_seleccionado, menor_arista);
				pendientes.Sacar(vertice_seleccionado);
				aux_pendientes.Sacar(vertice_seleccionado);
			}
			
			ConjuntoTDA vertices_restantes = new ConjuntoTA();
			
			while (!aux_pendientes.ConjuntoVacio()) {
				ConjuntoTDA vertices_resultado; 
				vertices_restantes.InicializarConjunto();
				vertices_resultado = resultado.Vertices();
				
				menor_arista = 0;
				int mejor_adyacente = vertices_resultado.Elegir();
				
				while(!pendientes.ConjuntoVacio()) {
					
					aux_vertice = pendientes.Elegir(); 
					
					ConjuntoTDA adyacentes_aux = Adyacentes(g, aux_vertice);
					
					//veo si el nuevo vertice elegido tiene adyacencia con alguno de los vertices del g resultado
					//en caso de que si, selecciono la menor arista
					

					while(!adyacentes_aux.ConjuntoVacio()) {
						int adyacente = adyacentes_aux.Elegir();
						if(vertices_resultado.Pertenece(adyacente)) {
							if(menor_arista == 0 || g.PesoArista(adyacente, aux_vertice) < menor_arista ) {
								mejor_adyacente = adyacente;
								menor_arista = g.PesoArista(adyacente, aux_vertice);		
								vertice_seleccionado = aux_vertice;
							}
						}
						
						adyacentes_aux.Sacar(adyacente);
					}
					                                    
					pendientes.Sacar(aux_vertice);
					vertices_restantes.Agregar(aux_vertice);
					
				}
				
				if(menor_arista != 0 ) {						
					resultado.AgregarVertice(vertice_seleccionado);
					resultado.AgregarArista(vertice_seleccionado, mejor_adyacente, menor_arista);
				}
				
				vertices_restantes.Sacar(vertice_seleccionado);
				aux_pendientes.Sacar(vertice_seleccionado);
				
				while (!vertices_restantes.ConjuntoVacio()) {
					int n = vertices_restantes.Elegir();
					vertices_restantes.Sacar(n);
					pendientes.Agregar(n);
				}
				
				
			}
			
			return resultado;
			
	}

	public static void main(String[] args) {
		GrafoNDTDA g = new GrafoND();
		g.InicializarGrafo();
		g.AgregarVertice(1);
		g.AgregarVertice(2);
		g.AgregarVertice(3);
		g.AgregarVertice(4);
		g.AgregarArista(2, 1, 1);
		g.AgregarArista(1, 3, 2);
		g.AgregarArista(1, 4, 6);
		g.AgregarArista(2, 3, 3);
		g.AgregarArista(2, 4, 4);
		g.AgregarArista(3, 4, 5);
		
		GrafoNDTDA resultado = AlgoritmoPrim(g);
		System.out.println("Grafo original");
		g.MostrarGrafo();
		System.out.println();
		System.out.println("Grafo resultante");
		resultado.MostrarGrafo();
		
	}

}

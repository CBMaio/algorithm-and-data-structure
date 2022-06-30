package principal;
import api.heapTDA;
import impl.heap;

public class prin {	
	

	public static void main(String[] args) {
		heapTDA heap1 = new heap();
		heap1.InicializarHeap(false);
		heap1.Insertar(40);  
		heap1.Insertar(79);
		heap1.Insertar(66);
		heap1.Insertar(30);
		
		heap1.Eliminar();
	}
}

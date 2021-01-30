import java.util.concurrent.ThreadLocalRandom;

public class bichota extends Thread {
	
	private final static int maximo = 105345;
	
	private final static int dim = 3;
	
	private static int[][] matriz = new int[dim][dim];
	
	private static int mayor = -1;
	
	private int mayorFila = -1;
	
	private int id;
	
	private int fila;
	
	private bichota(int pId, int pFila) {
		id = pId;
		fila = pFila;
	}
	
	private static void crearMatriz() {
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				matriz[i][j] = ThreadLocalRandom.current().nextInt(0, maximo);
			}
		}
		System.out.println("matriz");
		imprimir();
	}
	
	private static void imprimir() {
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				System.out.println(matriz[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public void run() {
		for (int i = 0; i < dim; i++) {
			if(this.mayorFila < matriz[this.fila][i]) {
				this.mayorFila = matriz[this.fila][i];
			}
		}
		if(this.mayorFila > mayor) {
			try {
				Thread.sleep(250);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			mayor = this.mayorFila;
			System.out.println("Nuevo maximo: id: " + this.id + " maximo local: " + this.mayorFila + " maximo global: " + mayor);
		}
		
		System.out.println("Resultados: Id: " + this.id + " maximo local: " + this.mayorFila + " maximo global: " + mayor);
		
	}
	
	public static void main(String[] args) {
		bichota.crearMatriz();
		System.out.println();
		System.out.println("COMIENZA AAAAAAAAAA");
		
		bichota[] bichines = new bichota[dim];
		for (int i = 0; i < dim; i++) {
			bichines[i] = new bichota(i, i);
			bichines[i].start();
		}
	}
}

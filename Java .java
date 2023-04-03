
package TP7;
import java.util.Random;
public class Tp_primera_parte_2 {
	public static final int MAX = 10;
	public static final int MAXVALOR = 10;
	public static final int MINVALOR = 1;
	public static void main(String[] args) {
		int [] arrenteros = new int [MAX];
		int pares;
		cargar_arreglo_aleatorio(arrenteros);
		imprimir_arreglo_aleatorio(arrenteros);
		pares = obtener_pares(arrenteros);
		System.out.println(pares);

	}
	
	public static void cargar_arreglo_aleatorio(int [] arr){
		Random r = new Random();
		for (int pos = 0; pos < MAX; pos++){
			arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
		}
	}
	public static void imprimir_arreglo_aleatorio(int [] arr){
		for (int pos = 0; pos < MAX; pos++){
			System.out.println("nombre_arreglo["+pos+"]=>: "+arr[pos]);
		}
	}
	public static int obtener_pares(int [] arr){
		int aux = 0; 
		for(int pos= 0; pos < MAX; pos++){
			if(arr[pos]% 2 == 0){
				aux++;
			}
		}
		return aux;
	}

}

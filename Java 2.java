package TP7;
import java.util.Random;
public class Tp_primera_parte_1 {
	public static int MAX = 10;
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	
	public static void main(String[] args) {
		int [] arrenteros = new int[MAX];		
		try{ 
			cargar_arreglo_aleatorio(arrenteros);
			imprimir_arreglo_aleatorio(arrenteros);
			System.out.println("----------------------------------------------");
			alternar_arreglos(arrenteros);
			imprimir_arreglo_aleatorio(arrenteros);
		}
		catch(Exception exc){
			System.out.println(exc);
		}
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
	public static void alternar_arreglos(int[] arr){
		int aux;
		for(int pos = 0; pos < MAX /2; pos++){
			aux = arr[pos];
			arr[pos]= arr[MAX - 1 - pos];
			arr[MAX-1-pos] = aux; 
			
		}
	}

}
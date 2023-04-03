package TP7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
public class Tp_primera_parte_3 {
	public static final int MAX=10;
	public static final int MIN=0;
	public static final int MAXVALOR=10;
	public static final int MINVALOR=1;
	public static void main(String[] args) {
		int [] arrenteros = new int [MAX];
		int pos;
		BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
		try{
			cargar_arreglo_aleatorio(arrenteros);
			imprimir_arreglo_aleatorio(arrenteros);
			System.out.println("ingrese un valor int pos:");
			pos = Integer.valueOf(entrada.readLine());
			corrimiento_izq(arrenteros,pos);
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
	public static void corrimiento_izq(int []arr , int pos){
			for(int i = 0; i < pos ; i++){
				arr[i] = arr[i +1];
			}
	}

}

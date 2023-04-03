	package TP7;

	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.Random;
	public class Tp_primera_parte_4 {
		
		public static int MAXVALOR = 10;
		public static int MINVALOR = 1;
		public static int MAX = 10;
		public static void main(String[] args) {
			
			int [] arrenteros;
			arrenteros = new int[MAX];
			int pos, valor;
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			try{
				cargar_arreglo_aleatorio_int(arrenteros);
				imprimir_arreglo_int(arrenteros);
				System.out.println("Ingrese un valor para la pos 0:");
				valor = Integer.valueOf(entrada.readLine());
				agregar_valor(arrenteros,valor);
				
				System.out.println("Ingrese un numero entero pos:");
				pos = Integer.valueOf(entrada.readLine());
				
				corrimiento_der(arrenteros,pos);
				imprimir_arreglo_int(arrenteros);
			}
			catch(Exception exc){
				System.out.println(exc);
			}
		}
		
		public static void agregar_valor(int [] arr, int valor){
			int i = 0;
			arr[i]= valor;
			
		}
	
		public static void corrimiento_der(int [] arr, int pos){
				for(int i = 9; i > pos ; i--){
				arr[i] = arr[i -1];
				} 
		}
		public static void cargar_arreglo_aleatorio_int(int [] arr){
			Random r = new Random();
			for (int pos = 0; pos < MAX; pos++){
				arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
			}
		}
		public static void imprimir_arreglo_int(int [] arr){
			for (int pos = 0; pos < MAX; pos++){
				System.out.println("nombre_arreglo["+pos+"]=>: "+arr[pos]);
			}
		}
	}

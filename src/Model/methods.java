package Model;

import java.util.Random;

//classe com os métodos usados no projeto
public class methods {

	//gerar string de números aleatórios
	public static String geraRandom(int tamanhoDoInt, int quantidadeDeInt) {
		Random gera = new Random();	
		String aux = "";

		for (int i = 0; i < quantidadeDeInt; i++) {
			aux += Integer.toString(gera.nextInt(tamanhoDoInt));
			aux += ";";
		}

		return aux;
	}

	//converter a string selecionada em vetor de inteiros
	public static int[] stringToInt(String texto) {
		try {
			String[] aux = texto.split(";");
			int[] valores = new int[aux.length];

			for(int i = 0; i < aux.length; ++i) {
				valores[i] = Integer.parseInt(aux[i]);
			}
			return valores;
		} catch (Exception e) {
		}
		return null;
	}

	//converter um vetor de inteiros em string
	public static String intToString(int[] vetor) {
		String aux = "";

		for(int i=0; i<vetor.length; i++) {
			aux += vetor[i] +";";
		}
		return aux;
	}

	//ordenação por quick sort
	public static void quick_sort(int []v) {
		quick_sort(v, 0, v.length);
	}

	private static void quick_sort(int []v,int ini, int fim){
		int meio;

		if(ini<fim){
			meio = partition(v,ini,fim);
			quick_sort(v,ini,meio);
			quick_sort(v,meio+1,fim);
		}
	}

	private static int partition(int []v, int ini, int fim){
		int pivo, topo,i;
		pivo = v[ini];
		topo = ini;

		for(i=ini+1;i<fim;i++){
			if(v[i]<pivo){
				v[topo]=v[i];
				v[i]=v[topo+1];
				topo++;}
		}
		v[topo]=pivo;
		return topo;
	}

	//ordenação por bubble sort
	public static void bubble_sort(int[] vet) {
		int[] ord = new int[vet.length];
		int aux = 0;
		int i = 0;

		for(i = 0; i < vet.length; i++){
			for(int j = 0; j < (vet.length - 1); j++){
				if(vet[j] > vet[j + 1]){
					aux = vet[j];
					vet[j] = vet[j+1];
					vet[j+1] = aux;
				}
			}
		}

		for(i = 0; i < vet.length; i++){
			ord[i] = vet[i];
		}
	}

	//ordenação por insertion sort
	public static void insertion_sort(int[] vet) {
		for (int j = 1; j < vet.length; j++) {
			int current = vet[j];
			int i = j-1;
			while ((i > -1) && (vet[i] > current)) {
				vet[i+1] = vet[i];
				i--;
			}
			vet[i+1] = current;
		}
	}

	//ordenação por heap sort
	public static void heap_sort(int[] v){  
		int n = v.length;

		for (int i = n / 2 - 1; i >= 0; i--)  
			heap_sort(v, n, i);  

		for (int i = n - 1; i >= 0; i--) {  
			int temp = v[0];  
			v[0] = v[i];  
			v[i] = temp;  

			heap_sort(v, i, 0);  
		}  
	}

	private static void heap_sort(int[] v, int n, int i) {  
		int largest = i;
		int left = 2 * i + 1;  
		int right = 2 * i + 2;

		if (left < n && v[left] > v[largest])  
			largest = left;  

		if (right < n && v[right] > v[largest])  
			largest = right;  

		if (largest != i) {  

			int temp = v[i];  
			v[i] = v[largest];  
			v[largest] = temp;  

			heap_sort(v, n, largest);  
		}  
	}
}
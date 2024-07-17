import java.util.Scanner;

public class SomaArrayRecursivo {

	private int somaElementos(int[] sequencia, int i) {
		

	if(i == sequencia.length) {
		return 0;
	}else {
		return sequencia[i] + somaElementos(sequencia, i+1);
	}
		
	
	}

	public int soma(int[] sequencia) {
		return somaElementos(sequencia, 0);
	}


	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
 	SomaArrayRecursivo s = new SomaArrayRecursivo();

	String[] sequenciaStr = sc.nextLine().split(" ");
	int[] sequencia = new int[sequenciaStr.length];

	for(int i = 0; i < sequenciaStr.length; i++) {
		sequencia[i] = Integer.parseInt(sequenciaStr[i]);
	}

	int resultado = s.soma(sequencia);
	
	System.out.println(resultado);
	
	}


}

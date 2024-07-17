import java.util.Scanner;

public class PotenciaRecursiva {
	
	private int calculaPotencia(int base, int expoente) {
		
		if(expoente == 0) {
			return 1;
		}else {
			return base * calculaPotencia(base, expoente-1);
			
		}		
	}

	
	public int potencia(int base, int expoente) {
		return calculaPotencia(base, expoente);
	}


	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	PotenciaRecursiva pr = new PotenciaRecursiva();
	
	int base = sc.nextInt();
	sc.nextLine();
	int expoente = sc.nextInt();
	
	int resultado = pr.potencia(base, expoente);
	System.out.println(resultado);
	}

}

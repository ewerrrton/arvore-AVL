import java.util.Scanner;

public class BuscaBinariaRecursiva {
	
    private int buscaBinaria(int[] v, int chave, int ini, int fim) {
        
        if(ini <= fim) {
            int meio = (ini + fim)/2;
            
            if(v[meio] == chave) {
                return meio;
            }

            if(v[meio] > chave) {
                System.out.println(meio);
                return buscaBinaria(v, chave, ini, meio-1);

            }else {
                System.out.println(meio);
                return buscaBinaria(v, chave, meio+1, fim);
            }            
        }

        return -1;
    }

    public int buscaBinariaRecursiva(int[]v, int chave) {
        return buscaBinaria(v, chave, 0, v.length-1);
    }

    public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    BuscaBinariaRecursiva bb = new BuscaBinariaRecursiva();    

    String[] sequenciaStr = sc.nextLine().split(" ");
    int n = sc.nextInt();
    int[] sequencia = new int[sequenciaStr.length];

    for(int i = 0; i < sequenciaStr.length; i++) {
        sequencia[i] = Integer.parseInt(sequenciaStr[i]);
    }

    int resultado = bb.buscaBinariaRecursiva(sequencia, n);
    System.out.println(resultado);

    }
		
}

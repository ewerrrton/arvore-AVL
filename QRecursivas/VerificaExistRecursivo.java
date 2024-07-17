import java.util.Scanner;

public class VerificaExistRecursivo {

    private boolean procuraN(int[] v, int n, int ini) {
    
    if(ini >= 0 && ini < v.length) {
        
        if(v[ini] == n) {
            return true;
        }

        else{
            return procuraN(v, n, ini+1);

        }

    }

    return false;

    }



    public boolean procuraNumber(int[]v, int n) {
        return procuraN(v, n, 0);

    }


    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    VerificaExistRecursivo v = new VerificaExistRecursivo();

  
    String[] sequenciaStr = sc.nextLine().split(" ");
    int[] sequencia = new int[sequenciaStr.length];
    int n = sc.nextInt();
    
    for(int i =0; i < sequenciaStr.length; i++) {
        sequencia[i] = Integer.parseInt(sequenciaStr[i]);
    }

    boolean resultado = v.procuraNumber(sequencia, n);
    System.out.println(resultado);

    }


}

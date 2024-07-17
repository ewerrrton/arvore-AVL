import java.util.Scanner;

public class WarmUpRecursiva {

    private String warmUp(int n, String[] sequencia, int ini, StringBuilder sb) {

    if(ini < sequencia.length) {
        sb.append(n * Integer.parseInt(sequencia[ini]) + " ");
        return warmUp(n, sequencia, ini + 1, sb);

    }

    return sb.toString().trim();
    }

    
    public String warmUP(int n, String[] sequencia) {
        return warmUp(n, sequencia, 0, new StringBuilder());

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        String[] sequencia = sc.nextLine().split(" ");

        WarmUpRecursiva w = new WarmUpRecursiva();
        String resultado = w.warmUP(n, sequencia);

        System.out.println(resultado);
    }
}

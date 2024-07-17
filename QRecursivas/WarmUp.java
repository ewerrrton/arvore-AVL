import java.util.Scanner;

public class WarmUp{


    private String warmUp(int n, String[] sequencia) {
    
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < sequencia.length; i++) {
            sb.append(Integer.parseInt(sequencia[i]) * n + " ");  
        }

        return sb.toString().trim();

    }


    public String warmUP(int n, String[] sequencia) {
        return warmUp(n, sequencia);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] sequencia = sc.nextLine().split(" ");
        
        WarmUp w = new WarmUp();

        String resultado = w.warmUp(n, sequencia);
        System.out.println(resultado);
    }

}

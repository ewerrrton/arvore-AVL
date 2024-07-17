import java.util.Scanner;

public class PosicoesElementosRecursivo {
    

    private static String posicoesElementos(int n, String[] sequencia, int ini, StringBuilder sb) {
        if(ini < sequencia.length) {
            if(Integer.parseInt(sequencia[ini]) == n) {
                sb.append(ini + " ");
           }
                return posicoesElementos(n, sequencia, ini+1, sb);
        }
       
        return sb.length() > 0 ? sb.toString().trim() : "-1";
    
    }


    public static String posicoesElementos(int n, String[] sequencia) {
        return posicoesElementos(n, sequencia, 0, new StringBuilder());

    }


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] sequencia = sc.nextLine().split(" ");
        

        System.out.println(posicoesElementos(n, sequencia));
    }

}

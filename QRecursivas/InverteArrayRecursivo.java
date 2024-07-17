import java.util.Scanner;

public class InverteArrayRecursivo {
    
    private static void inverteArray(String[] array, int ini, int fim) {

        if(ini < fim) {
            String varAux = array[ini];
            array[ini] = array[fim];
            array[fim] = varAux;
            inverteArray(array, ini+1, fim-1);
       }

    }


    public static String inverteArray(String[] array) {
        inverteArray(array, 0, array.length-1);

        StringBuilder sb = new StringBuilder();

        for(String i : array) {
            sb.append(i + " ");
        }

        return sb.toString().trim();
    }


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String[] sequencia = sc.nextLine().split(" ");
        
        System.out.println(inverteArray(sequencia));


    }

    

}

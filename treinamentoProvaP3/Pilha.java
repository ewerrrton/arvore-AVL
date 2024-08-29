public class Pilha {
    
    private int[] pilha;
    private int topo;
    
    //public int getMax() {
//
  //      int indexMaior = topo;
      //  int maiorValor = this.pilha[topo];

    //    Pilha temp = new Pilha(this.size);
      //  int posicaoAtual = topo;

        //while(!isEmpty()) {
          //  int elemento = pop();
            //temp.addLast(elemento);

            //if(elemento > maiorValor) {
              //  maiorValor = elemento;
               // indexMaior = posicaoAtual;
          //  }
            //posicaoAtual--;
        //}

        //while(!temp.isEmpty()) {
          //  int elemento = temp.pop();
            //addLast(elemento);
        //}

      //  return indexMaior;
    //}

    //public int inverte(int index) {

    //}i

    public Pilha(int capacidade) {
        this.pilha = new int[capacidade];
        this.topo = -1;
    }

    public boolean contains(int v) {
       if(isEmpty()) {
           return throw new RuntimeException();
       }

       Pilha temp = new Pilha(this.topo+1);
       boolean existe = false;

       while(!isEmpty) {
           int compara = pop();
           temp.push(compara);

           if(compara == v) {
               existe = true;
           }
        }

       while(!temp.isEmpty) {
           int guarda = temp.pop();
           push(guarda);
       }

       return existe;
    }


    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return this.topo+1 == this.pilha.length;
    }



    public void push(int v){
        if(isFull()) {
            throw new RuntimeException("pilha cheia");
        }
        this.pilha[++topo] = v;
    }

    public int pop() {
        if(isEmpty()) {
            return throw new RuntimeException("Pilha vazia");
        }
        
        int vRemovido = this.pilha[topo];
        this.topo--;
        return vRemovido;
    }

       
    
}

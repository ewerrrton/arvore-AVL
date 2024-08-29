public class Fila {

    private int[] fila;
    private int head;
    private int tail;
    private int size;

    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer que adições e remoções são O(1).
    public Fila(int capacidade) {
        this.fila = new int[capacidade];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == -1;
    }

    public boolean isFull() {
        return this.size == this.fila.length;
    }

    // deve lançar exceção caso a fila esteja cheia.
    public void addLast(int valor) {
        if(isFull()) {
            throw new RuntimeException("Fila cheia");
        }

        if(isEmpty()) {
            this.head = 0;
            this.tail = 0;
        }

        this.fila[tail] = valor;
        this.tail = (this.tail+1) % fila.length;
        this.size++;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if(isEmpty()) {
            throw new RuntimeException("Fila vazia");
        }

        int elementoRemovido = this.fila[this.head];
        if(this.size == 1) {
            this.head = -1;
            this.tail = -1;

        }else {
            this.head = (this.head+1) % fila.length;
        }

        this.size--;
        return elementoRemovido;
            
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem remover.
    public int getFirst() {
        if(isEmpty()){
            return throw new RuntimeException("fila vazia");
        }

        return this.fila[this.head];
      
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem remover.
    public int getLast() {
        if(isEmpty()) {
            return throw new RuntimeException("fila vazia");
        }
        return this.fila[this.tail];
    }

    // deve retornar uma string representando a fila.
    public String toString() {
        if(isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int i = this.head;

        while(true) {
            sb.append(this.fila[i]);
            if(i == this.tail) {
                break;

            }
            sb.append(", ");
            i = (i+1) % fila.length;
        }

      

        return sb.toString();

    }

    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro.
    public int indexOf(int valor) {
        if(isEmpty()) {
            return -1;
        }

        int i = this.head;
        int posicaoRelativa = 0;

        while(true) {
            if(this.fila[i] == valor) {
                return posicaoRelativa;
            }

            posicaoRelativa++;
            i = (i+1)% fila.length;

            if(i == this.tail) {
                break;
            }
        }

        return posicaoRelativa;


        // Retorna a posição da primeira ocorrência de um valor na fila
    }

    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro.
    public int lastIndexOf(int valor) {
        // Retorna a posição da última ocorrência de um valor na fila
    }

    public int size() {
        // Retorna o tamanho atual da fila
    }
}


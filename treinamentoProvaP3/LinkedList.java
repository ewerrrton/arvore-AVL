import java.util.NoSuchElementException;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.size = 0;
    }
    
    public trocaVizinhos(int index) {
        Node a = this.head;

        for(int i = 0; i <= index; i++){
            a = a.next;
        }
        
        Node prevA = a.prev;
        Node b = current.next;
        Node nextB = b.next;
       
        if(b == null) {
            throw new RuntimeException();
        }

        prevA.next = b;
        b.prev = prevA;

        a.next = nextB;
        nextB.prev = a;

    }
        

    }
    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addFirst(int valor) {
        Node newNode = new Node(valor);

        if(isEmpty()) {
            this.tail = newNode;
            this.head = newNode;

        }else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }

        this.size++;

    }

    public void addLast(int valor) {
        Node newNode = new Node(valor);
        
        if(isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        }

        else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.size++;
    }

    // Adiciona um valor na posição passada como parâmetro
    public void add(int index, int valor) {
        Node newNode = new Node(valor);
        if(index < 0 || index > this.size) {
            throw new RuntimeException("indice inválido");
        }

        if(index == 0) {
            addFirst(valor);

        }else if(index == this.size) {
            addLast(valor);

        }else {
            Node current = this.head;

            for(int i = 0; i < index; i++) {
                current = current.next;
            }

            newNode.prev = current.prev;
            newNode.next = current;

            current.prev.next = newNode;
            current.prev = newNode;

        }
        this.size++;
    
    }

    public int getFirst() {
        if(isEmpty()) {
            throw new RuntimeException();
        }
        
        return this.head.value;
        
    }

    public int getLast() {
        if(isEmpty()) {
            throw new RuntimeException();
        }

        return this.tail.value;
    }

    // Retorna o elemento na posição passada como parâmetro
    // Deve lançar IndexOutOfBoundsException se o índice não for válido
    public int get(int index) {
        if(index < 0 || index >= this.size) {
            throw new RuntimeException("indice inválido");
        }

        Node current = this.head;

        for(int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;

    }

    // Remove o primeiro elemento da lista
    // Deve lançar exceção caso a lista esteja vazia
    public int removeFirst() {
        if(isEmpty()) {
            throw new RuntimeException("lista vazia!");
        }
        
        int noRemovido = this.head.value;

        if(this.head.next == null) {
            this.head = null;
            this.tail = null;

        }else {
            this.head = this.head.next;
            this.head.prev = null;
        }

        this.size--;
        return noRemovido;
        
    }

    // Remove o último elemento da lista
    // Deve lançar exceção caso a lista esteja vazia
    public int removeLast() {
        if(isEmpty()) {
            throw new RuntimeException();
        }
        
        int noRemovido = this.tail.value;

        if(this.head.next = null) {
            this.head = null;
            this.tail = null;

        }else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }

        this.size--;
        return noRemovido;

    }

    // Remove o valor no índice passado como parâmetro
    // Retorna o valor removido e lança exceção se o índice não for válido
    public int remove(int index) {
        if(index < 0 || index >= this.size) {
            throw new RuntimeException();
        }

        if(index == 0) {
            return removeFirst();
        }

        if(index == this.size-1) {
            return removeLast();
        }

        Node current = this.head;

        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        int noRemovido = current.value;
        current.prev.next = current.next;
        current.next.prev = current.prev;

        this.size--; 
        return noRemovido;
    }

    // Remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro
    // True se remover, false se não remover
      public boolean removeByValue(int value) {
        
        Node aux = this.head;
        for(int i = 0; i < this.size; i++) {
            if(aux.value == value) {
                if(i == 0) {
                    removeFirst();

                }else if(i == this.size-1) {
                    removeLast();

                }else {
                    aux.prev.next = aux.next;
                    aux.next.prev = aux.prev;
                }
                return true;
            }
            aux = aux.next;
        }
        return false;
    }


    // Retorna a posição da primeira ocorrência do valor passado como parâmetro
    public int indexOf(int value) {
        Node current = this.head;

        for(int i = 0; i < this.size; i++) {
            if(current.value == value) {
                return i;
            }

            current = current.next;
        }
        return -1;
    }

    // Verifica se a lista contém o valor passado como parâmetro
    public boolean contain(int v) {
        Node current = this.head;

        for(int i = 0; i < this.size; i++) {
            if(current.value == v) {
                return true;
            }

            current = current.next;
        }
        return false;
    }

    // Retorna a posição da última ocorrência do elemento passado como parâmetro
    public int lastIndexOf(int valor) {
        Node current = this.head;
        
        int index = -1;

        for(int i = 0; i < this.size; i++) {
            if(current.value == valor) {
                index = i;
            }
            current = current.next;
        }

        return index;
    }

    // Retorna uma string representando a lista
    public String toString() {
        if(isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Node current = this.head;

        for(int i = 0; i < this.size; i++) {
            sb.append(current.value);

            if(i < this.size-1) {
                sb.append(", ");
            }

        current = current.next;
        }

        return sb.toString();

    }

    public int size() {
        return this.size;
    }

    public void moveToHead(int index) {
        if(index < 0 || index >= this.size) {
            throw new RuntimeException("indice inválido");
        }

        int noRemovido = remove(index);

        addFirst(noRemovido);
    }

        
    public void insereOrdenado(int v) {
        Node current = this.head;
        int index = 0;

        for(int i = 0; i < this.size; i++) {
            if(current.value < v) {
                index++;
                if(current.next.value >= v ) {
                    break;
                }
            }
            current = current.next;
        }

        if(index == 0) {
            addFirst(v);

        }else if(index == this.size) {
            addLast(v);

        }else {
            Node newNode = new Node(v);

            newNode.prev = current;
            newNode.next = current.next;
            
            current.next = newNode;
            current.next.prev = newNode;

        }
    }

    
    //public void swap(Node n1, Node n2) {
        
        //if(n1 == this.head && n2 == this.tail) {
            //n1.prev = n2.prev;
            //n2.prev.next = n1;
            //n2.next = n1.next;
            //n1.next.prev = n2;

        //}else if(n1 == this.head) {
            
        //}
        
       
    //public void inverte() {
        //Node current = this.head;
        //Node temp = null;

        //for(int i = 0; i < this.size; i++) {
            //temp = current.prev;
           // current.prev = current.next;
            //current.next = temp;

          //  current = current.prev;
        //}

      //  if(this.head != null) {
    //        this.head = temp.prev;
  //      }
        
//    }
    

    
}

class Node {
    int value;
    Node prev;
    Node next;

    public Node(int v) {
        // Construtor para o nó
    }
}


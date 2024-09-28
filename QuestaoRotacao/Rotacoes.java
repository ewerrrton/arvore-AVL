import java.util.Scanner;
import java.util.Arrays;

public class Rotacoes {

    private int index;
    private Node root;
    private int size;
    private int[] preOrder;

    public Rotacoes() {
        this.size =0;
        this.index = 0;
        this.preOrder = new int[3];
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Rotacoes rotacao = new Rotacoes();

        String[] valores = sc.nextLine().split(" ");

        for(int i = 0; i < valores.length; i++) {
            rotacao.add(Integer.parseInt(valores[i]));
        }

        rotacao.Order();
        System.out.println(Arrays.toString(rotacao.preOrder));

    }

    public void Order() {
        Order(this.root);
    }

    private void Order(Node node) {
        if(node == null) {
            return;
        }
        this.preOrder[this.index++] = node.value;
        
        Order(node.left);
        Order(node.right);
    }

    public void add(int element) {
        this.size++;
        if(isEmpty()) {
            this.root = new Node(element);
            return;
        }

        else {
            Node aux = this.root;
            while(aux != null) {
                if(element < aux.value) {
                    if(aux.left == null) {
                        Node newNode = new Node(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        rebalance(newNode);
                        return;
                    }
                    aux = aux.left;

                } else {
                    if(aux.right == null) {
                        Node newNode = new Node(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        rebalance(newNode);
                        return;
                    }
                    aux = aux.right;
                }
            }
        }
    }

    public Node rotacaoParaDireita(Node pai) {
        Node novoPai = pai.left;
        pai.left = novoPai.right;

        if(novoPai.right != null) {
            novoPai.right.parent = pai;
        }
        novoPai.right = pai;
        novoPai.parent = pai.parent;

        if(pai == this.root) {
            this.root = novoPai;
        
        } else {
            if(pai == pai.parent.left) {
                pai.parent.left = novoPai;
            }
            else {
                pai.parent.right = novoPai;
            }
        }

        pai.parent = novoPai;
        return novoPai;
    }

    public Node rotacaoParaEsquerda(Node pai) {
        Node novoPai = pai.right;
        pai.right = novoPai.left;

        if(novoPai.left != null) {
            novoPai.left.parent = pai;
        }
        novoPai.left = pai;
        novoPai.parent = pai.parent;

        if(pai == this.root) {
            this.root = novoPai;
        }

        else {
            if(pai == pai.parent.left) {
                pai.parent.left = novoPai;
            }
            else {
                pai.parent.right = novoPai;
            }
        }
        pai.parent = novoPai;
        return novoPai;
    }

    public void rotacaoEsquerdaDireita(Node node) {
        Node filho = node.left;
        node.left = rotacaoParaEsquerda(filho);
        rotacaoParaDireita(node);
    }

    public int height(Node node) {
        if(node == null) {
            return -1;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public void rebalance(Node node) {
        if(node == null) {
            return;
        }

        int balanceamento = height(node.left) - height(node.right);
        
        if(balanceamento > 1) {
            if(node.left.left != null) {
                rotacaoParaDireita(node);
            
            } else {
                rotacaoEsquerdaDireita(node);
            }
        }
           
    }



}

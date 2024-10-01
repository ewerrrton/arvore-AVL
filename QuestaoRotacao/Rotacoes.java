import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Rotacoes {

    private Node root;

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

    }

    public ArrayList<Integer> order() {
        ArrayList<Integer> preOrder = new ArrayList<Integer>();
        preOrder.clear();
        this.order(this.root, preOrder);
        return preOrder;
    }

    private ArrayList<Integer> order(Node node, ArrayList<Integer> preOrder) {
        if(node == null) {
            return preOrder;
        }
        preOrder.add(node.value);

        order(node.left, preOrder);
        order(node.right, preOrder);

        return preOrder;
    }

    public void add(int element) {
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
        print("rot_esq(" + filho.value + ")");
        node.left = rotacaoParaEsquerda(filho);
        System.out.println(order());
        print("rot_dir(" + node.value + ")");
        rotacaoParaDireita(node);
        System.out.println(order());
    }

    public void rotacaoDireitaEsquerda(Node node) {
        Node filho = node.right;
        print("rot_dir(" + filho.value + ")");
        node.right = rotacaoParaDireita(filho);
        System.out.println(order());
        print("rot_esq(" + node.value +")");
        rotacaoParaEsquerda(node);
        System.out.println(order());
    }

    public int height(Node node) {
        if(node == null) {
            return -1;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    private void rebalance(Node node) {
        if(node == null) {
            return;
        }

        int balanceamento = height(node.left) - height(node.right);

        if(balanceamento == 1 || balanceamento == -1) {
            rebalance(node.parent);
        }

        else if(balanceamento == 0) {
            if(node.parent == null) {
                print("balanceada");
                return;

            } else {
                rebalance(node.parent);
            }
        }

        else if(balanceamento > 1) {
            if(node.left.left != null) {
                print("rot_dir(" + node.value + ")");
                rotacaoParaDireita(node);
                System.out.println(order());

            } else {
                rotacaoEsquerdaDireita(node);
            }
        }

        else {
            if(node.right.right != null) {
                print("rot_esq(" + node.value + ")");
                rotacaoParaEsquerda(node);
                System.out.println(order());

            } else {
                rotacaoDireitaEsquerda(node);
            }

        }
    }

    private void print(String s) {
        System.out.println(s);
    }



}

import java.util.Stack;

public class Demo {

    static class Node {
        int data;
        Node left , right;

        public Node(int item, Node left, Node right){
             this.data = item;
             this.left = left;
             this.right = right;
        }
    }

    public static class Pair{
        Node node;
        int state;
        public Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        Integer[] arr = {50,25,12,null,null,37,30,null,null,40,null,null,75,62,null,70,null,null,87,null,null};

         Node root = new Node(arr[0],null,null);

        Pair rpr = new Pair(root,1);

        Stack<Pair> st = new Stack<>();
        st.push(rpr);



        
    }
}
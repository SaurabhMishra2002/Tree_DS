import java.util.ArrayList;
import java.util.Stack;

public class Inorder {

    public static class Node {
    int data;
    Node left;
    Node right;

    public Node(int item, Node left, Node right){
             this.data = item;
             this.left = left;
             this.right = right;
        }
}
    //Pair Class for Note of state whether left, right or pop
    public static class Pair{
        Node node;
        int state;
        public Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void Display(Node node){
        if(node == null){
            return;
        }
        String str = "";
        str += node.left == null ? "L" : node.left.data + "L";
        str += "M" + node.data + "M";
        str += node.right == null ? "R" : node.right.data + "R";
        System.out.println(str);
        Display(node.left);
        Display(node.right);
    }

    public static void Inorder(Node node,ArrayList<Integer> res){
        if (node == null)
            return;
        
        // Traverse the left subtree first
        Inorder(node.left, res);
        
        // Visit the current node
        res.add(node.data);
        
        // Traverse the right subtree last
        Inorder(node.right, res);
    }


    public static ArrayList<Integer> inorderIter(Node root, ArrayList<Integer> res){
        ArrayList<Integer> ans = new ArrayList<>();
                
        Node Curr = root;
        Stack<Node> st = new Stack<>();

        while(Curr != null || !st.isEmpty()){


            while(Curr != null){
                st.push(Curr);

                Curr = Curr.left;
            }

            Curr = st.pop();
            ans.add(Curr.data);


            Curr = Curr.right;
        }

        return ans;
    }

      //Printing the ArrayList

     static void printList(ArrayList<Integer> v) {
        for (int i : v) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr = {50,25,12,null,null,37,30,null,null,40,null,null,75,62,null,70,null,null,87,null,null};

         Node root = new Node(arr[0],null,null);

        Pair rpr = new Pair(root,1);

        Stack<Pair> st = new Stack<>();
        st.push(rpr);

        int idx = 0;
        while(!st.isEmpty()){

            Pair top = st.peek();
            if(top.state == 1){
                idx++;
                if(arr[idx] != null){
                    Node ln = new Node(arr[idx],null,null);
                    top.node.left = ln;

                    Pair lp = new Pair(ln,1);
                    st.push(lp);
                }else{
                    top.node.left = null;
                }
                top.state++;
            }else if(top.state == 2){
                idx++;
                if(arr[idx] != null){
                    Node rn = new Node(arr[idx],null,null);
                    top.node.right = rn;

                    Pair rp = new Pair(rn,1);
                    st.push(rp);
                }else{
                    top.node.right = null;
                }
                top.state++;
            }else{
                st.pop();
            }
            
        
    }

    Display(root);

    System.out.println("Inorder Traversal (Iterative): ");
    ArrayList<Integer> result = inorderIter(root, new ArrayList<>());
    printList(result);

    }
}

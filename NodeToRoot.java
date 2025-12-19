import java.util.ArrayList;
import java.util.Stack;

public class NodeToRoot {
    //Node Class
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

    static ArrayList<Node> path ;
    public static boolean Find(Node node, int data){
        if(node == null){
            return false;
        }

        if(node.data == data){
            //System.out.println(node.data);
            path.add(node);        
            return true;
        }

        boolean filc  = Find(node.left,data);
        if(filc){
            path.add(node);
            return true;
        }


        boolean firc = Find(node.right, data);
        if(firc){
            path.add(node);
            return true;
        }

        return false;
    }


    public static void KlevelDown(Node node , int k){
        if(node == null || k < 0){
            return ;
        }
        if(k == 0){
            System.out.println(node.data);
            return;
        }
        KlevelDown(node.left,k-1);
        KlevelDown(node.right,k-1);
    }
    
    // public PrintKLevelFar(){

    // }
    
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
        //Display(root);

        path = new ArrayList<>();

        Find(root,87);
    }
}

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

    public static int size(Node node){
        if (node == null){
            return 0;
        }

        int ls = size(node.left);
        int rs = size(node.right);

        return ls+rs+1;
    }

    public static int sum(Node node){
        if (node == null){
            return 0;
        }

        int ls = sum(node.left);
        int rs = sum(node.right);

        return ls+rs+node.data;
    }
    
    public static int Max(Node node){
            if (node == null){
                return Integer.MIN_VALUE;
            }

            int ans1 = Max(node.left);
            int ans2 = Max(node.right);
            
            int max = Math.max(node.data,Math.max(ans1,ans2));

            return max;
    }

    public static int height(Node node){
            if(node == null){
                return -1; // -1 ----> edge OR 0 --- for Node 
            }

            int lh = height(node.left);
            int rh = height(node.right);

         return Math.max(lh,rh)+1;
    }
    
    public static void Traversal(Node node){
        if(node == null){
            return ;
        }

        System.out.println(node.data +"-> PRE");
        Traversal(node.left);
        System.out.println(node.data +"-> IN");
        Traversal(node.right);
        System.out.println(node.data +"-> POS");
 }
    public static void main(String[] args) {


        // System.out.println("Hello, World!");

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

    // int Size =size(root);
    // int max = Max(root);
    // int height = height(root);
    // int sum  = sum(root);

    // System.out.println(Size);
    // System.out.println(max);
    // System.out.println(height);
    // System.out.println(sum); 
    
    Traversal(root);
}
}   
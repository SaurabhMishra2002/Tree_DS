import java.util.Stack;

public class IsTreeBST {
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

    public static class info{
        boolean isBST;
        int min;
        int max;


        public info(boolean isBST, int min, int max){
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    public static boolean isValidBST(Node root){
        return checkBST(root).isBST;
    }

    public static info checkBST(Node node){
        if(node == null){
            return new info(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
       
        info left = checkBST(node.left);
        info right = checkBST(node.right);


        //Check BEST condition
        boolean isBST = left.isBST && right.isBST && (node.data >= left.max && node.data <= right.min);


        //Update min and max
        int min = Math.min(node.data, Math.min(left.min, right.min));
        int max = Math.max(node.data, Math.max(left.max, right.max));

        return new info(isBST, min, max);
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
    public static void main(String[] args) {

    Integer[] arr = {50,25,78,null,null,37,30,null,null,40,null,null,75,62,null,70,null,null,87,null,null};

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
        System.out.println(isValidBST(root));
    }   
}

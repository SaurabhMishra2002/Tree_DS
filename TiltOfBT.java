import java.util.Stack;



public class TiltOfBT {

    //Node Classpublic class NodeToRoot {
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


    public static int TiltOfBTS(Node node){
        if(node == null){
            return 0;
        }

        int lt = TiltOfBTS(node.left);
        int rt = TiltOfBTS(node.right);

        int tilt = Math.abs(lt - rt);

        int totalTilt = lt + rt + tilt;

        return totalTilt + node.data;
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
        System.out.println(TiltOfBTS(root));
    }    
}

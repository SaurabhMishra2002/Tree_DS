public class BSTEx1 {

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


    public static Node buildBST(int []arr,int lo, int hi){
        if(lo > hi){
            return null;
        }

        int mid = lo+ (hi-lo)/2;
        int data = arr[mid];
        Node left = buildBST(arr, lo, mid -1);
        Node right = buildBST(arr, mid +1, hi);


        Node node = new Node(data, left, right);
        return node;
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
        int [] arr = {12,25,37,50,62,75,87};

        Node root = buildBST(arr,0,arr.length -1);
        Display(root);  
    }
}

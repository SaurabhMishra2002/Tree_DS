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

    public static int size(Node node){
        if(node == null){
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);
        return ls + rs + 1;
    }

    public static int  height(Node node){
        if(node == null){
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        return Math.max(lh, rh) + 1;
    }


    public static int sum(Node node){
        if(node == null){
            return 0;
        }

        int ls = sum(node.left);
        int rs = sum(node.right);

        return ls + rs + node.data;
    }

 public static int maxBST(Node node){
    if(node.right != null){
        return maxBST(node.right);
    }else{
        return node.data;
    }

 }

 public static int minBST(Node node){
    if(node.left != null){
        return minBST(node.left);
    }else{
        return node.data;
    }
 }

//How to find node in BST
    public static boolean find(Node node, int data){

        if(node == null){
            return false;
        }

        if(data < node.data){
            return find(node.left, data);
        }else if(data > node.data){
            return find(node.right, data);
        }else{
            return true;
        }
    }

    public static void insert(Node node , int data){
        
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

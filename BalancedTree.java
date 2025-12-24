public class BalancedTree {

   static class Node{
        int data;
        Node left, right;

        public Node(int item){
            this.data = item;
            this.left = this.right = null;
        }
    }


        public static class Info{
            boolean isBal;
            int ht;

            public Info(boolean isBal, int ht){
                this.isBal = isBal;
                this.ht = ht;
            }
        }



        public static Info isBalancedTree(Node node){
            if (node == null){
                return new Info(true,0);
            }
            Info left = isBalancedTree(node.left);
            Info right  = isBalancedTree(node.right);

            boolean isBal = left.isBal && right.isBal && Math.abs(left.ht - right.ht) <= 1;

            int ht = Math.max(left.ht, right.ht) + 1;


            return new Info(isBal, ht);
        }

        public static boolean isBalanced(Node root) {
    return isBalancedTree(root).isBal;
}

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.right = new Node(18);

        
        System.out.println("Is Balanced: " + isBalanced(root));
    }
}

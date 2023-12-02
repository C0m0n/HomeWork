public class BinarySearchTree {
    private Node root;

    private class Node {
    
        private String key;
        private Node left, right;
        private int count;

        public Node(String key){
            this.key = key;
            this.left = null;
            this.right = null; 
            this.count = 1;
        }
    }

    BinarySearchTree(){
        root = null;
    }

    // private Node delete(Node root, String key){
    //     if (root == null) return root;

    //     if (0 > root.key.compareTo(key)){
    //         root.left = delete(root.left, key); 
    //     } else if (0 < root.key.compareTo(key)) {
    //         root.right = delete(root.right, key);
    //     } else {
    //         if (root.left == null){
    //             return root.right;
    //         } else if (root.right == null){
    //             return root.left;
    //         }

    //         root.key = minValue(root.right);

    //         root.right = delete(root.right, root.key);
    //     }
    //     return root;
    // }

    // private String minValue(Node root){
    //     String minString = root.key;

    //     while (root.left != null) {
    //         minString = root.left.key;
    //         root = root.left;
    //     }
    //     return minString;
    // }
    public void instert_node(String key){
        instert(root, key);
    }

    private Node instert(Node root, String key){
        if (root == null){
            root = new Node(key);
            return root;
        }
        if (0 > root.key.compareTo(key)){
            root.left = instert(root.left, key);
        } else if (0 < root.key.compareTo(key)){
            root.right = instert(root.right, key);
        } else {
            root.count++;
        }
        return root;
    }

    public void traverseTree(){
        traverse(root);
    }


    private void traverse(Node root){
        if (root != null) {
            traverse(root.left);
            System.out.println(root.key + " :"+ root.count);
            traverse(root.right);
        }
    }

}

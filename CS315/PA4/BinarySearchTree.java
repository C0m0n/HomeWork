import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private Node root;
    public List<Node> nodelist;

    public class Node {
    
        public String key;
        private Node left, right;
        public int count;

        public Node(String key){
            this.key = key;
            this.left = null;
            this.right = null; 
            this.count = 1;
        }
    }

    BinarySearchTree(){
        root = null;
        nodelist = new ArrayList<Node>();
    }

 
    public void instert_node(String key){
        root = instert(root, key);
    }

    private Node instert(Node root, String key){
        if (root == null){
            root = new Node(key);
            nodelist.add(root);
            return root;
        }
        if (0 < root.key.compareTo(key)){
            root.left = instert(root.left, key);
        } else if (0 > root.key.compareTo(key)){
            root.right = instert(root.right, key);
        } else {
            root.count++;
        }
        return root;
    }

    public void traverseTree(){
        traverse(root);
    }

    public int getCount(String key){
        return search(root, key).count;
    }

    private Node search(Node root, String key){
        if (root == null) return root;
        if (root.key == key) return root;
        if (root.key.compareTo(key) > 0) return search(root.left, key);
        return search(root.right, key);

    }

    private void traverse(Node root){
        if (root != null) {
            traverse(root.left);
            System.out.println(root.key + " : "+ root.count);
            traverse(root.right);
        }
    }

}

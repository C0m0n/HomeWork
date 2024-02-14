import java.util.PriorityQueue;
import java.util.List;

public class Heap {
    
    private PriorityQueue<BinarySearchTree.Node> pq;
    //Constructor
    public Heap(){
        pq = new PriorityQueue<BinarySearchTree.Node>((a, b) -> Integer.compare(b.count, a.count)); //https://www.geeksforgeeks.org/priority-queue-of-pair-in-java-with-examples/
    }

    //Add all nodes
    public void addAll(List<BinarySearchTree.Node> nodeList){
        pq.addAll(nodeList);
    }
    //print out the heap
    public void print(){
        while (!pq.isEmpty()) {
            BinarySearchTree.Node node = pq.poll();
            System.out.println(node.key + " : " + node.count);
        }
    }
    

}

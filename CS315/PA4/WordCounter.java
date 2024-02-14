/**
 * Implements a word frequency counter using a binary search tree and a heap.
 */

public class WordCounter {

    // DECLARE CLASS VARIABLES HERE
    private BinarySearchTree bst;
    private Heap hp;
    //Create the wordcounter class
    public WordCounter() {
        bst = new BinarySearchTree();
        hp = new Heap();
    }

    public void countWords(String[] words) {
        // Implement your solution here
        //Add all words to the bst
        for (int i = 0; i < words.length; i++) {
            bst.instert_node(words[i]);
        }
        System.out.println("Alphabetical Order");
        //print out the bst
        bst.traverseTree();
        System.out.println();
        System.out.println("Decending order");
        //add nodes to the heap
        hp.addAll(bst.nodelist);
        //print heap
        hp.print();


    
    }

    public static void main(String[] args) {
        String input = "input.txt";
        WordCounter wordCounter = new WordCounter();
        wordCounter.countWords(InputReader.parseInputFile(input));
    }
}

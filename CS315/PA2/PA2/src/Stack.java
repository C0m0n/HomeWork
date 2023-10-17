public class Stack<Item> {
    
    //Create the node class
    public class Node{
        Item info;
        Node next;
    }

    //Create the variables
    private int numOfItems;
    private Node head;

    //Contructor
    public Stack(){
        head = null;
        numOfItems = 0;
    }


    //Push an item to the top of the stack
    public void push(Item item){
        //Create a new node 
        Node newNode = new Node();
        //Assign info to the new node
        newNode.info = item;
        //Assign the old head to the new node.next
        newNode.next = head;
        //make the new node the head
        head = newNode;
        //Increase the number of items
        numOfItems++;
    }

    //Take the item off the top of the stack
    public Item pop(){
        //If there are no items return null
        if (numOfItems == 0){
            return null;
        }

        //If there are items copy the data to info
        Item info = head.info;
        head = head.next;
        //Decrease the number of items
        numOfItems--;

        //If that was the last item in the list set head and tail to null
        if (numOfItems == 0){
            head = null;
        }

        return info;
    }

    //Check if the stack is empty
    public boolean isEmpty(){

        //Check if the stack is empty 
        if (numOfItems == 0){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        StackTest.testStack(new Stack<String>());
        
    }
}

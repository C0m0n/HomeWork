public class Queue<Item>{


    //Create vatiables
    private int numOfItems;
    private Node head;
    private Node tail;

    //Create the node class
    private class Node{
        Item info;
        Node next;
    }

    //Constructor
    public Queue(){
        head = tail = null;
        numOfItems = 0;
    }

    //Add an item to the bacl of the queue
    public void enqueue(Item item){
        //Create a new node 
        Node newNode = new Node();
        newNode.info = item;
        //Check if there are nodes
        if(numOfItems == 0){
            //If there are no nodes add it to the head and tail
            head = tail = newNode;
        } else{
            tail.next = newNode;
            tail = newNode;
        }
        //Increase the number of items
        numOfItems++;
    }

    //Remove the first item added
    public Item dequeue(){
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
            tail = head = null;
        }

        return info;
    }
    //Check if empty
    public boolean isEmpty(){

        //Check if the queue is empty 
        if (numOfItems == 0){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        //Call the testing function
        QueueTest.testQueue(new Queue<String>());

    }
}

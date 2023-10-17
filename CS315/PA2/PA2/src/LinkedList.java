public class LinkedList<Item> implements List<Item> {

    private class Node{
        Item info; 
        Node next;
    }

    private Node head;
    private Node tail;

    public LinkedList(){
        head = tail = null;
    }

    public Item getAt(int loc){
        //if the list is empty or the input is less than 0 return null
        if (head == null || loc < 0){
            return null;
        }

        //Create the current node variable and set it to the head of the list
        Node current = head;

        //If the list isnt empty move through the list to the location that the user inputs
        for (int i = 0; i < loc; i++){
            //Check if the list is empty
            if (current == null){
                //return null
                return null;
            }
            //Set the current node to the next node
            current = current.next;
        }
        //Return the current node 
        return current.info;
    }

    public Item deleteAt(int loc){
        //If the list is empty do not delete
        if (head == null || loc < 0){
            return null;
        }

        //Create the current node and previous node variables
        Node current = head;
        Node prevNode = null;

        //If there is something in the list then itterate through and delete the node at that location
        for (int i = 0; i < loc; i++){
            if (current == null){
                return null;
            }
            //Assign the previous node to the current node and step to the next node
            prevNode = current;
            current = current.next;
        }

        //If there is only one node and it is the head and tail set them to null
        if (current == head && current == tail){
            head = tail = null;
        }
        //If the node is the head
        else if (current == head){ 
            head = head.next;
        }
        //If the current is the tail
        else if (current == tail){
            tail = prevNode;
            tail.next = null;
        }
        //Normal case
        else {
            prevNode.next = current.next;
        }
        //Return the current info
        return current.info; 
    }
    public void addToHead(Item item){
        //Create the node
        Node newNode = new Node();

        //Assign the item to the info
        newNode.info = item;

        //Link the new node
        newNode.next = head;

        //Change the head
        head = newNode;

        //If the tail is empty then the new node will be the head and the tail
        if (tail == null){
            tail = newNode;
        }
    }

    public void addToTail(Item item){

        //Create the new node 
        Node newNode = new Node();

        //Assign the info
        newNode.info = item;
        newNode.next = null;

        //If the list is empty add it to head and tail else add it to the tail
        if (head == null){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addAt(int loc, Item item){
        //Check if the location is valid
        if (loc <= 0 || head == null){
            addToHead(item);
            return;
        }

        //Create the current node
        Node current = head;

        //Loop through the list
        for (int i  = 0; i < (loc-1); i++){

            //If the current node is null return
            if (current.next == null ){
                break;
            }
            //Itterate through
            current = current.next; 
        }

        //if the current node is the tail use add to tail
        if (current == tail){
            addToTail(item);
        } else {

            //Create the new node
            Node newNode = new Node();
            
            //Assign the info
            newNode.info = item;

            //Assign the new node.next to be the current node.next and change the current.next to the new node
            newNode.next = current.next;
            current.next = newNode;

        }
    }

    public void printFwd(){

        //Create the current node to print out the list
        Node current = head;

        //Loop throught
        while (current != null){
            System.out.print(current.info + " ");
            current = current.next;
        }

    }

    public void printRev(){
        //Print from the tail
        printRev(head);
    }

    public void printRev(Node node){
        if (node == null){
            return;
        }else {
            printRev(node.next);
            System.out.print(node.info + " ");
        }
    }
    public boolean isEmpty(){
        if(head == null && tail == null){
            return true;
        } else {
            return false; 
        }
    }

    public static void main(String[] args) {
        //This will create a test and run the tests
        LinkedListTest.TestList(new LinkedList<String>());
    }
}
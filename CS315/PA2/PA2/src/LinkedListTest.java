public class LinkedListTest {

    public static void TestList(List<String> list){

        //Test if the list is empty expected true
        System.out.println("Is the list Empty? " + list.isEmpty());

        //Add some nodes to the head
        list.addToHead("Is my list");
        list.addToHead("This");
        list.addToHead("Hello");

        //Test add to tail functions
        list.addToTail("3");
        list.addToTail("2");
        list.addToTail("1");

        //Print out the list Expected: Hello This Is my list 1 2 3
        list.printFwd();
        
        System.out.println("");

        //print out the list backward Expected: 3 2 1 Is my list This Hello
        list.printRev();
        System.out.println("");

        //Get some items Expected: "Hello" "1"
        System.out.println("Item: " + list.getAt(0));
        System.out.println("Item: " + list.getAt(5));
        //These should return null
        System.out.println("Item: " + list.getAt(-500));
        System.out.println("Item: " + list.getAt(1000));

        //Test the delete at functions
        list.deleteAt(0);
        list.deleteAt(1);
        list.deleteAt(1000);
        list.deleteAt(-3);

        //Test add at functions
        list.addAt(2, "Between 3and2");
        list.addAt(500, "End");
        list.addAt(-4, "Start");

        list.printFwd();
        System.out.println("");


        System.out.println("Is the list empty? " + list.isEmpty());

        System.out.println("All conditions passed for linked list!");
        
    }
}

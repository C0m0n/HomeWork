public class QueueTest {
    
    public static void testQueue(Queue<String> q){


        //Create the variables for the test cases
        String first = "First";
        String second = "Second";
        String third = "Third";

        //Test if the queue is empty
        if (q.isEmpty() == true){
            System.out.println("Is empty: PASSED");
        } else {
            System.out.println("Is empty: FAILED");
        }

        //Add the items to the queue
        q.enqueue(first);
        q.enqueue(second);
        q.enqueue(third);

        //Remove the items and store them for verification
        String firstDQ = q.dequeue();
        String secondDQ = q.dequeue();
        String thirdDQ = q.dequeue();


        // Test if the items came out correctly
        if(firstDQ.equals(first)){
            System.out.println("1 Dequeue : PASSED");
        } else {
            System.out.println("1 Dequeue : FAILED");
        }
        if(secondDQ.equals(second)){
            System.out.println("2 Dequeue : PASSED");
        } else {
            System.out.println("2 Dequeue : FAILED");
        }
        if(thirdDQ.equals(third)){
            System.out.println("3 Dequeue : PASSED");
        } else {
            System.out.println("3 Dequeue : FAILED");
        }
        if(q.dequeue() == null){
            System.out.println("4 Dequeue : PASSED");
        } else {
            System.out.println("4 Dequeue : FAILED");
        }
        if (q.isEmpty() == true){
            System.out.println("Is empty: PASSED");
        } else {
            System.out.println("Is empty: FAILED");
        }

    }

}

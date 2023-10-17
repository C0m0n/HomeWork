public class StackTest {
    
    public static void testStack(Stack<String> s){

        //Create the variables for the test cases
        String first = "First";
        String second = "Second";
        String third = "Third";

        //Test if the stack is empty
        if (s.isEmpty() == true){
            System.out.println("Is empty: PASSED");
        } else {
            System.out.println("Is empty: FAILED");
        }

        //Add the items to the stack
        s.push(first);
        s.push(second);
        s.push(third);

        //Pop the items and store them for verification
        String firstDQ = s.pop();
        String secondDQ = s.pop();
        String thirdDQ = s.pop();

        // Test if the items came out correctly
        if(firstDQ.equals(third)){
            System.out.println("1 pop : PASSED");
        } else {
            System.out.println("1 pop : FAILED");
        }
        if(secondDQ.equals(second)){
            System.out.println("2 pop : PASSED");
        } else {
            System.out.println("2 pop : FAILED");
        }
        if(thirdDQ.equals(first)){
            System.out.println("3 pop : PASSED");
        } else {
            System.out.println("3 pop : FAILED");
        }
        if(s.pop() == null){
            System.out.println("4 pop : PASSED");
        } else {
            System.out.println("4 pop : FAILED");
        }
        if (s.isEmpty() == true){
            System.out.println("Is empty: PASSED");
        } else {
            System.out.println("Is empty: FAILED");
        }

    }

}


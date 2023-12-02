//Test Cases for Bubble Sort:
//  1. Array of 5 elements in reverse order
//  2. Array of 5 elements in order
//  3. Array of 5 elements with duplicates
//  4. Array of 5 elements with random numbers
//  5. Array of 5 elements with negative numbers

import java.util.Random;

public class TestSort {


    public static void TestBsort1A(BubbleSort b){
        boolean passed = true;
        int array[] = {5, 4, 3, 2, 1};
        int soretedArray[] = {1, 2, 3, 4, 5};

        b.bSort(array, array.length);

        for (int i = 0; i < array.length; i++){
            if (array[i] != soretedArray[i]){
                passed = false;
            }
        }
        
        if (passed){
            System.out.println("Test 1A: PASSED");
        } else{
            System.out.println("Test 1A: FAILED");;
        }
     
    }

    public static void TestBsort1B(BubbleSort b){
        boolean passed = true;
        int array[] = {1, 2, 3, 4, 5};
        int soretedArray[] = {1, 2, 3, 4, 5};

        b.bSort(array, array.length);

        for (int i = 0; i < array.length; i++){
            if (array[i] != soretedArray[i]){
                passed = false;
            }
        }
        
        if (passed){
            System.out.println("Test 1B: PASSED");
        } else{
            System.out.println("Test 1B: FAILED");;
        }
    }

    public static void TestBsort1C(BubbleSort b){
        boolean passed = true;
        int array[] = {1, 2, 3, 3, 4};
        int soretedArray[] = {1, 2, 3, 3, 4};

        b.bSort(array, array.length);

        for (int i = 0; i < array.length; i++){
            if (array[i] != soretedArray[i]){
                passed = false;
            }
        }
        
        if (passed){
            System.out.println("Test 1C: PASSED");
        } else{
            System.out.println("Test 1C: FAILED");;
        }
    }

    public static void TestBsort1D(BubbleSort b){
        int array[] = {5, 2, 3, 1, 4};
        boolean passed = true;
        int soretedArray[] = {1, 2, 3, 4, 5};

        b.bSort(array, array.length);

        for (int i = 0; i < array.length; i++){
            if (array[i] != soretedArray[i]){
                passed = false;
            }
        }
        
        if (passed){
            System.out.println("Test 1D: PASSED");
        } else{
            System.out.println("Test 1D: FAILED");;
        }
    }

    public static void TestBsort1E(BubbleSort b){
        int array[] = {-5, -2, -3, -1, -4};

        boolean passed = true;
        int soretedArray[] = {-5, -4, -3, -2, -1};

        b.bSort(array, array.length);

        for (int i = 0; i < array.length; i++){
            if (array[i] != soretedArray[i]){
                passed = false;
            }
        }
        
        if (passed){
            System.out.println("Test 1E: PASSED");
        } else{
            System.out.println("Test 1E: FAILED");;
        }
    }

    public static void TestQsort2A(QuickSort q){
        boolean passed = true;
        int array[] = {5, 4, 3, 2, 1};
        int soretedArray[] = {1, 2, 3, 4, 5};

        q.quickSort(array, 0, array.length- 1);

        for (int i = 0; i < array.length; i++){
            if (array[i] != soretedArray[i]){
                passed = false;
            }
        }
        
        if (passed){
            System.out.println("Test 2A: PASSED");
        } else{
            System.out.println("Test 2A: FAILED");;
        }
     
    }

    public static void TestQsort2B(QuickSort q){
        boolean passed = true;
        int array[] = {1, 2, 3, 4, 5};
        int soretedArray[] = {1, 2, 3, 4, 5};

        q.quickSort(array, 0, array.length- 1);

        for (int i = 0; i < array.length; i++){
            if (array[i] != soretedArray[i]){
                passed = false;
            }
        }
        
        if (passed){
            System.out.println("Test 2B: PASSED");
        } else{
            System.out.println("Test 2B: FAILED");;
        }
    }

    public static void TestQsort2C(QuickSort q){
        boolean passed = true;
        int array[] = {1, 2, 3, 3, 4};
        int soretedArray[] = {1, 2, 3, 3, 4};

        q.quickSort(array, 0, array.length- 1);

        for (int i = 0; i < array.length; i++){
            if (array[i] != soretedArray[i]){
                passed = false;
            }
        }
        
        if (passed){
            System.out.println("Test 2C: PASSED");
        } else{
            System.out.println("Test 2C: FAILED");;
        }
    }

    public static void TestQsort2D(QuickSort q){
        int array[] = {5, 2, 3, 1, 4};
        boolean passed = true;
        int soretedArray[] = {1, 2, 3, 4, 5};

        q.quickSort(array, 0, array.length- 1);

        for (int i = 0; i < array.length; i++){
            if (array[i] != soretedArray[i]){
                passed = false;
            }
        }
        
        if (passed){
            System.out.println("Test 2D: PASSED");
        } else{
            System.out.println("Test 2D: FAILED");;
        }
    }

    public static void TestQsort2E(QuickSort q){
        int array[] = {-5, -2, -3, -1, -4};

        boolean passed = true;
        int soretedArray[] = {-5, -4, -3, -2, -1};

        q.quickSort(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++){
            if (array[i] != soretedArray[i]){
                passed = false;
            }
        }
        
        if (passed){
            System.out.println("Test 2E: PASSED");
        } else{
            System.out.println("Test 2E: FAILED");;
        }
    }

    //Bubble sort with random 
    public static long experiment1A(int[] array, BubbleSort b){
        //
        long start1 = System.nanoTime();

        int numOfItems = array.length;
        b.bSort(array, numOfItems);
        long end1 = System.nanoTime();
        long totalTime = end1 - start1;
        System.out.println("Bubble sort items sorted: " + numOfItems + " Time elapsed: "+ totalTime);
        return totalTime;
    }

    public static long experiment1B(int[] array, QuickSort q){
        //
        long start1 = System.nanoTime();

        int numOfItems = array.length;
        q.quickSort(array, 0, numOfItems - 1);
        long end1 = System.nanoTime();
        long totalTime = end1 - start1;
        System.out.println("Quick sort items sorted: " + numOfItems + " Time elapsed: "+ totalTime);
        return totalTime;
    }

    //Run all the test cases
    public static void main(String[] args) {

        Random r = new Random();

        //Make array for tests
        int array1A[] = new int[2000];
        int array1B[] = new int[2000];
        int array2A[] = new int[4000];
        int array2B[] = new int[4000];
        int array3A[] = new int[8000];
        int array3B[] = new int[8000];

        int array4A[] = new int[2000];
        int array4B[] = new int[2000];
        int array5A[] = new int[4000];
        int array5B[] = new int[4000];
        int array6A[] = new int[8000];
        int array6B[] = new int[8000];

        int array7A[] = new int[2000];
        int array7B[] = new int[2000];
        int array8A[] = new int[4000];
        int array8B[] = new int[4000];
        int array9A[] = new int[8000];
        int array9B[] = new int[8000];


        //Fill array with random items
        for(int i = 0; i < array1A.length; i++){
            array1A[i] = array1B[i] = r.nextInt(5000);
        }
        for(int i = 0; i < array2A.length; i++){
            array2A[i] = array2B[i] = r.nextInt(5000);
        }
        for(int i = 0; i < array3A.length; i++){
            array3A[i] = array3B[i] = r.nextInt(5000);
        }
        //Already sorted
        for(int i = 0; i < array4A.length; i++){
            array4A[i] = array4B[i] = i;
        }
        for(int i = 0; i < array5A.length; i++){
            array5A[i] = array5B[i] = i;
        }
        for(int i = 0; i < array6A.length; i++){
            array6A[i] = array6B[i] = i;
        }
        //Reverse order
        for(int i = 0; i < array7A.length; i++){
            array7A[i] = array7B[i] = array7A.length - i;
        }
        for(int i = 0; i < array8A.length; i++){
            array8A[i] = array8B[i] = array8A.length - i;
        }
        for(int i = 0; i < array9A.length; i++){
            array9A[i] = array9B[i] = array9A.length - i;
        }

        QuickSort q = new QuickSort();
        BubbleSort b = new BubbleSort();

        TestBsort1A(b);
        TestBsort1B(b);
        TestBsort1C(b);
        TestBsort1D(b);
        TestBsort1E(b);
        TestQsort2A(q);
        TestQsort2B(q);
        TestQsort2C(q);
        TestQsort2D(q);
        TestQsort2E(q);

        System.out.println();
        System.out.println("------------Experiment 1-3 are done with random arrays------------");
        System.out.println();
        long time1 = experiment1A(array1A, b);
        long time2 = experiment1B(array1B, q);
        System.out.println("Experiment 1 results Quick sort was faster by: " + (time1 - time2) + " nano seconds.");
        long time3 = experiment1A(array2A, b);
        long time4 = experiment1B(array2B, q);
        System.out.println("Experiment 2 results Quick sort was faster by: " + (time3 - time4) + " nano seconds.");
        long time5 = experiment1A(array3A, b);
        long time6 = experiment1B(array3B, q);
        System.out.println("Experiment 3 results Quick sort was faster by: " + (time5 - time6) + " nano seconds.");

        System.out.println();
        System.out.println("------------Experiment 4-6 are done with sorted arrays------------");
        System.out.println();

        long time7 = experiment1A(array4A, b);
        long time8 = experiment1B(array4B, q);
        System.out.println("Experiment 4 results Quick sort was faster by: " + (time7 - time8) + " nano seconds.");
        long time9 = experiment1A(array5A, b);
        long time10 = experiment1B(array5B, q);
        System.out.println("Experiment 5 results Quick sort was faster by: " + (time9 - time10) + " nano seconds.");
        long time11 = experiment1A(array6A, b);
        long time12 = experiment1B(array6B, q);
        System.out.println("Experiment 6 results Quick sort was faster by: " + (time11 - time12) + " nano seconds.");

        System.out.println();
        System.out.println("------------Experiment 7-9 are done with reverse arrays------------");
        System.out.println();

        long time13 = experiment1A(array7A, b);
        long time14 = experiment1B(array7B, q);
        System.out.println("Experiment 7 results Quick sort was faster by: " + (time13 - time14) + " nano seconds.");
        long time15 = experiment1A(array8A, b);
        long time16 = experiment1B(array8B, q);
        System.out.println("Experiment 8 results Quick sort was faster by: " + (time15 - time16) + " nano seconds.");
        long time17 = experiment1A(array9A, b);
        long time18 = experiment1B(array9B, q);
        System.out.println("Experiment 9 results Quick sort was faster by: " + (time17 - time18) + " nano seconds.");
    }
}

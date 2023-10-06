/**
 * Author: David Greni (2526610)
 * Project: Programming assingnment 1
 * 
 * This class defines a Binary Search algorithm that takes in a key and an array of integers from the command line.
 **/
public class BinarySearch {

	public static void main(String[] args) {
		
		int key = Integer.parseInt(args[0]);
        int[] data = new int[args.length-1];
        for(int i = 0; i < args.length-1; i++){
            data[i] = Integer.parseInt(args[i+1]);
        }
        int low = 0;
        int hi = data.length-1;
        int index = Binarysearch(key, data, low, hi);
        System.out.println(index);
	}
    public static int Binarysearch(int key, int[] data, int low, int hi){
        if(low > hi) return -1;
        int mid = (low+hi)/2;
        if(key < data[mid]) {
            return Binarysearch(key, data, low, mid-1);
        } else if(key > data[mid]) {
            return Binarysearch(key, data, mid+1, hi);
        } else {
            return mid;
        }
    }

}
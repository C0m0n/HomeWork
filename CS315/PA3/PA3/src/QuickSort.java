//Written by David Greni
//This is the quick sort algorithem
//The pivot point will be the first element in the array. 

public class QuickSort {
    
    //Swap helper function takes in an array and some indexes and swaps the values in that array
    public void swap(int[] nums, int i, int j){
        int temp = 0; 
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //Partition the array
    public int partition(int nums[], int low, int high){
        //Chose the pivot
        int pivot = nums[low];

        //Assign i
        int i = low;

        for(int j = low + 1; j <= high; j++){
            //Check if the current j is greater than the pivot
            if(nums[j] < pivot){
                //Swap the numbers
                i++;
                swap(nums, i, j);
            }
        
        }
        //Swap the pivot into the correct place
        swap(nums, low, i);
        return (i);
    }

    public void quickSort(int[] nums, int low, int high){
        //If the low and high are not the same
        if(low < high){
            
            //Make the new partition 
            int part = partition(nums, low, high);
            //Recurse on the left and the right of the partition
            quickSort(nums, low, part-1);
            quickSort(nums, part + 1, high);
        }
    }

}

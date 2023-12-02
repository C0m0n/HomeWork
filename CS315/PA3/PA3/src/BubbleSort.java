//Written by Haskel Cappers

public class BubbleSort {
    public void bSort(int array [], int x){
        if (x == 1){
            return;
        }
        int count = 0;
        for (int i = 0; i < x - 1; i++){
            if (array[i] > array[i + 1]){
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                count += 1;
            }
            
        }
        if (count == 0){
            return;
        }
        bSort(array, x - 1);
    }
}

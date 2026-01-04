package pack;

public class MyQuickSort_671725 {
    public void qSort(int[] arr) {  
        qSort_lumoto(arr, 0, arr.length-1);
    }
    private void qSort_lumoto(int[] arr, int low, int high) {
        if (low < high) {
            int pivot_index = partition_lomuto(arr, low, high);
            qSort_lumoto(arr, low, pivot_index - 1); // left side
            qSort_lumoto(arr, pivot_index + 1, high); // right side
        }
    } 
    private int partition_lomuto(int[] arr, int low, int high) { 
        int pivot_v = arr[high];
        int i = low, tmp;
        /* your code */

        for (int j = low; j < high; j++) {
            // if smaller than pivot, put it left side
            if(arr[j] < pivot_v){
                tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                i++;
            }
        }
        
        // Place the pivot in correct position
        tmp = arr[i];
        arr[i] = arr[high];
        arr[high] = tmp;

        return i;
    }
}
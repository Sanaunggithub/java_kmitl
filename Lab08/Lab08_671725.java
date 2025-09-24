import java.util.Arrays;

import pack.*;

public class Lab08_671725 {
    // int[] arr = {42,17,-5,88,23,91,-12,65,7,30,55,-9,2,48,76,1,-22,99,14,61,37,83,-18,50,29,72,6,40,-3,95,11,68};
    static void task_1() {
        int[] arr = {42,17,-5,88,23,91,-12,65,7,30,55,-9,2,48,76,1,-22,99,14,61,37,83,-18,50,29,72,6,40,11,68}; // -3, 95
        MyMergeSort_671725 sol = new MyMergeSort_671725();
        sol.mSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void task_2() {
        int[] arr = {42,17,-5,88,23,91,-12,65,7,30,55,-9,2,48,76,1,-22,99,14,61,37,83,-18,50,29,72,6,40,11,68}; // -3, 95
        MyQuickSort_671725 sol = new MyQuickSort_671725();
        sol.qSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void dutch_national_flag(int[] arr) {
        int left_value = arr[0];    // min
        int right_value = arr[0];   // max
        for (int i = 1; i < arr.length; i++) {
            left_value = Math.min(left_value, arr[i]);
            right_value = Math.max(right_value, arr[i]);
        }
        /* your code */  
        
        // find mid
        int mid_value = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != left_value && arr[i] != right_value){
                mid_value = arr[i];
                break;
            }
        }

        int low = 0, mid = 0, tmp= 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == left_value) {
                tmp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = tmp;
                mid++;
                low++;
            } else if(arr[mid] == mid_value){
                mid++;
            } else {
                tmp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = tmp;
                high--;
            }
        }

        
    }
    static void task_3() {
                  // R B W W B B R W W R R W R B W
        int[] arr = {1,0,2,2,0,0,1,2,2,1,1,2,1,0,2};
        dutch_national_flag(arr);
        System.out.println(Arrays.toString(arr));
    }
    static int k_th_min_element(int[] arr, int k) {
        int min = arr[0];    
        int max = arr[0];   
        
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int[] count = new int[max - min + 1];
        /* your code */


        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        int numCount = 0;
        for (int i = 0; i < count.length; i++) {
            numCount += count[i];
            if (numCount >= k) {
                return i + min; // found k-th min
            }
        }
        return -1; // exception
    }
    static void task_4() {
        int[] arr = {-1,0,-2,-2,0,0,-1,-2,-2,-1,-1,-2,-1,0,-2};
        System.out.println(k_th_min_element(arr,2));        
    }
    public static void main(String[] args) {
        // task_1();
        // task_2();
        // task_3();
        // task_4();
    }
}
package pack;

public class MyMergeSort_671725 {
    public void mSort(int[] arr) {
        mSort(arr,0,arr.length-1);
    }
    private void mSort(int[] arr, int low, int high) {
        if (low >= high)    return;
        int mid = low + ((high - low) >> 1); // >> right shift same as divide by 2
        mSort(arr,low,mid);
        mSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    private void merge(int[] arr, int low, int mid, int high) { 
        int[] tmp = new int[high - low + 1];
        /* your code */

        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high ) {
            if(arr[i] <= arr[j]){
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }

        while(i <= mid){
            tmp[k++] = arr[i++];
        }

        while (j <= high) {
            tmp[k++] = arr[j++];
        }

        for (int c = 0; c < tmp.length; c++) {
            arr[low + c] = tmp[c];
        }
    }
}


// Call: mSort(arr,0,2) → [3,2,4]

// low = 0, high = 2, mid = 1

// First, recursive call left: mSort(arr,0,1) → [3,2]

// Call: mSort(arr,0,1) → [3,2]

// low = 0, high = 1, mid = 0

// First, recursive call left: mSort(arr,0,0) → [3]

// Call: mSort(arr,0,0) → [3]

// Base case: low >= high → return immediately

// ❌ At this point, we don’t merge yet.

// Back to mSort(arr,0,1)

// After left returns, now call right: mSort(arr,1,1) → [2]

// Base case: low >= high → return [2]

// ✅ Now both left [3] and right [2] are ready → merge happens → [2,3]

// Back to mSort(arr,0,2)

// After left [0,1] returns merged [2,3], now call right: mSort(arr,2,2) → [4]

// Base case: low >= high → return [4]

// ✅ Now merge [2,3] and [4] → [2,3,4]

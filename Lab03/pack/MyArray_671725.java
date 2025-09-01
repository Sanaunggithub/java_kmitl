package pack;

public class MyArray_671725 extends MyArrayBasic {
    public MyArray_671725(){
        MAX_SIZE = 100_000;
        data = new int[MAX_SIZE];
    }

    public MyArray_671725(int max){
        MAX_SIZE = max;
        data = new int[MAX_SIZE];
    }

    public boolean isFull(){
        return size == MAX_SIZE;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    
    public int[] expendByK(int k){
        MAX_SIZE = MAX_SIZE * k;

        int newData[] = new int[MAX_SIZE];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;

        return data;
    }

    public int[] expand(){
        return expendByK(2);
    }

    public void add(int d){
        if (isFull()){
            expand();
        }

        data[size++] = d;
    }

    public void insert_unordered(int index, int value){
        if(index < 0 || index > size){
            System.out.println("Invalid Index");
            return;
        }

        if(isFull()){
            expand();
        }

        data[size++] = data[index]; // move data[index] to the end
        data[index] = value;
    }

    public void delete(int index){
        if (!isEmpty()){
            for (int i = index; i< size-1; i++){
                data[i]  = data[i+1];
            }
            size--;
        }
    }

    
    public int binarySearch(int target){
        int left = 0; 
        int right = size - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(data[mid] == target) return mid;

            if(target < data[mid]) right = mid - 1;
            else left = mid + 1;
        }

        return -(left + 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

}


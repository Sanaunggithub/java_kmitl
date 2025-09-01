package pack;

public class MyArrayBasic{
    protected int MAX_SIZE = 5; 
    protected int data[]; 
    protected int size = 0;

    public MyArrayBasic() {
        this.MAX_SIZE = 5;
        this.data = new int[this.MAX_SIZE];
        this.size = 0;
    }

    public void add(int d){
        if(size >= MAX_SIZE){
            System.out.println("Array is Full.");
            return;
        }
        else {
            data[size++] = d;
        }
    }

    public void insert_unordered(int index, int value){
        if(index < 0 || index > size){
            System.out.println("Invalid Index");
            return;
        }

        if(size >= MAX_SIZE){
            System.out.println("Array is full.");
            return;
        }

        data[size++] = data[index]; // move data[index] to the end
        data[index] = value; // overwrite with new value

    }

    public int find(int d){
        for(int i = 0; i < size; i++){
            if(data[i] == d){
                return i;
            }
        }

        return -1;
    }

    public void delete(int index){
        if (index < 0 || index >= size) {
            System.out.println("Invalid index. Cannot delete.");
            return;
        }

        for(int i = index ; i < size - 1; i++){
            data[i] = data[i + 1];
        }

        size--;
    }


    public MyArrayBasic(int... a){
        this.MAX_SIZE = a.length;
        this.size = a.length;
        this.data = new int[this.MAX_SIZE];
        for (int i = 0; i < a.length; i++) {
            this.data[i] = a[i];
        }
    }

    public int getAt(int index){
        if(index < 0 || index >= size){
            System.out.println("Invalid index");
            return -1;
        }

        return data[index];
    }

    public void setAt(int index, int value){
        if(index < 0 || index >= size){
            System.out.println("Invalid index");
            return;
        }

        data[index] = value;
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
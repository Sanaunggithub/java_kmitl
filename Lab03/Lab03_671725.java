import pack.*;

public class Lab03_671725 {
    static private void arrayBasic_demo_1() {
        MyArrayBasic demo = new MyArrayBasic(7,6,8,1,2,3);
        System.out.println( demo );
    }
    static private void arrayBasic_demo_2() {
        MyArrayBasic demo = new MyArrayBasic();
        demo.insert_unordered(0,9);
        demo.insert_unordered(0,7);
        demo.insert_unordered(0,5);
        System.out.println( demo );
        System.out.println("5 is at " + demo.find(5));
        System.out.println( demo.getAt(1) );              
    }
    static void arrayBasic_demo_3() {
        MyArrayBasic demo = new MyArrayBasic();
        System.out.println("Adding elements to the array");
        demo.add(3);    
        demo.add(7);
        demo.add(5);    
        demo.add(4);
        demo.add(6);
        System.out.println("next add operation trickers ArrayIndexOutOfBoundsException");
        demo.add(1);
    }
    static void array_demo_4() {
        MyArray_671725 demo = new MyArray_671725(5);
        demo.delete(0);
        demo.add(3);    
        demo.add(7);
        demo.add(5);    
        demo.add(4);
        demo.add(6);
        demo.add(1);
        System.out.println( demo );
    }
static void array_demo_5() {
    MyArray_671725 demo = new MyArray_671725();
    demo.insert_unordered(0,9);
    demo.insert_unordered(0,7); 
    demo.insert_unordered(0,8); // illegal skipped
    demo.insert_unordered(0,5);
    System.out.println( demo );
    System.out.println("5 is at " + demo.binarySearch(5));
    System.out.println("4 is at " + demo.binarySearch(4)); // return -1 bec. insertion pos for 4 is (-1 +1 ) * -1 = 0
    int pos = demo.binarySearch(6);
    System.out.println("6 is at " + pos);     // retrurn -2 bec. insertion pos for 6 is (-2 +1) * -1 = 1
    demo.insert_unordered(-(pos+1), 6);               //[5, 6, 7, 9]
    System.out.println( demo );
}
    static void array_demo_6() {
        System.out.println("small size initialized");
        for (int N = 200_000; N <= 10 * 200_000; N += 200_000) {
            long start = System.currentTimeMillis();
            MyArray_671725 mArray = new MyArray_671725(200_000/40_000);
            for (int n = 1; n < N; n++)
                mArray.add((int)(Math.random()*1000));
            long time = System.currentTimeMillis() - start;
            System.out.println(N + "\t\t" + time);        
        }
        System.out.println("large size initialized");
        for (int N = 200_000; N <= 10 * 200_000; N += 200_000) {
            long start = System.currentTimeMillis(); // capacity = 100_000
            MyArray_671725 mArray = new MyArray_671725();
            for (int n = 1; n < N; n++)
                mArray.add((int)(Math.random()*1000));
            long time = System.currentTimeMillis() - start;
            System.out.println(N + "\t\t" + time);        
        }
    }

    public static void main(String[] args) {
        // System.out.println("calling demo_1");
        // arrayBasic_demo_1();
        // System.out.println("calling demo_2");
        // arrayBasic_demo_2();
        // System.out.println("calling demo_3");
        // arrayBasic_demo_3();
        // System.out.println("calling demo_4");
        // array_demo_4();
        System.out.println("calling demo_5");
        array_demo_5();
        System.out.println("calling demo_X");
        array_demo_6();
    }

}
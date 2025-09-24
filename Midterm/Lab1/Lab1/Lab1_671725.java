package Lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

// Make sure these imports are correct
import Lab1.pack.Breed;
import Lab1.pack.Dog_671725;

public class Lab1_671725 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
    }
    
    static void task1() {
        // Given 2 arraylist of same type, Create an arraylist named lis1c which contains all elements
        // from both source lists
        System.out.println("--task1---");
        ArrayList<String> lis1a = new ArrayList<>(Arrays.asList("Lily","Daisy"));
        ArrayList<String> lis1b = new ArrayList<>(Arrays.asList("Tulip","Daisy"));
        ArrayList<String> lis1c;
        /* your code */
        lis1c = new ArrayList<>(lis1a);
        lis1c.addAll(lis1b);
        /* your code end */
        System.out.println(lis1c); // [Lily, Daisy, Tulip, Daisy]
        System.out.println(lis1a); // [Lily, Daisy] - unchanged
        System.out.println(lis1b); // [Tulip, Daisy] - unchanged
    }
    
    static void task2() {
        // shallow copy matter
        System.out.println("--task2---");
        ArrayList<StringBuilder> lis2a = new ArrayList<>(
            Arrays.asList(
                new StringBuilder("Lily"), 
                new StringBuilder("Daisy")));
        ArrayList<StringBuilder> lis2b = new ArrayList<>(lis2a);
        lis2b.add(new StringBuilder("30"));
        // System.out.println(lis2b); 
        // System.out.println(lis2a); // lis2a is unchanged
        StringBuilder sb = lis2a.get(0);
        sb.append("mySuffix");
        // pick your answer what would be the below result
        if (lis2b.get(0).equals(sb)) {
            System.out.println("lis2b[0] also becomes " + sb); //A
        } else {
            System.out.println("copy constructor creates a new copy of lis2a[0] for lis2b"); //B
        }
    }
    
    static void task3() {
        System.out.println("--task3---");
        List<String> lis3 = new ArrayList<>(
            Arrays.asList("Lily","Daisy","Tulip","Daisy"));
        /* your code */
        while (lis3.size() > 1) {
            lis3.remove(1);
        }
        /* your code end */
        System.out.println(lis3); // [Lily]
    }
    
    static void task4() { // set element is unique (class Dog_671725 and enum Breed)
        System.out.println("--task4---");
        ArrayList<String> lis4a = new ArrayList<>(
            Arrays.asList("Lily","Daisy","Tulip","Daisy"));
        HashSet<String> flowers = new HashSet<>(lis4a);
        for (String ele : flowers) {
            System.out.print(ele + " ");
        } 
        System.out.println();
        
        ArrayList<Dog_671725> lis4b = new ArrayList<>(Arrays.asList(
            new Dog_671725(Breed.pomeranian,1200), 
            new Dog_671725(Breed.beagle, 2300), 
            new Dog_671725(Breed.jack, 1440),
            new Dog_671725(Breed.beagle,2300)));
        HashSet<Dog_671725> dogs = new HashSet<>(lis4b);
        for (Dog_671725 ele : dogs) {
            System.out.print(ele + " ");
        }
        System.out.println();
        // Dog_671725(beagle, 2300) Dog_671725(jack, 1440) Dog_671725(pomeranian, 1200)
    }
    
    static void task5() { // number of unique element
        System.out.println("--task5---");
        System.out.print("The number of unique element is ");
        ArrayList<Dog_671725> lis5 = new ArrayList<>(Arrays.asList(
            new Dog_671725(Breed.pomeranian,1200), 
            new Dog_671725(Breed.beagle, 2300), 
            new Dog_671725(Breed.jack, 1440),
            new Dog_671725(Breed.beagle,2300)));
        /* your code */
        HashSet<Dog_671725> uniqueDogs = new HashSet<>(lis5);
        System.out.println(uniqueDogs.size()); // 3
        /* your code end */
    }
    
    static void task6() { // count same elements
        System.out.println("--task6---");
        ArrayList<Dog_671725> lis6 = new ArrayList<>(Arrays.asList(
            new Dog_671725(Breed.pomeranian,1200), 
            new Dog_671725(Breed.beagle, 2300), 
            new Dog_671725(Breed.jack, 1440),
            new Dog_671725(Breed.beagle,2300)));
        HashMap<Breed,Integer> map = new HashMap<>();
        /* your code */
        for (Dog_671725 dog : lis6) {
            Breed breed = dog.getBreed();
            map.put(breed, map.getOrDefault(breed, 0) + 1);
        }
        /* your code end */
        for (Entry<Breed, Integer> ele : map.entrySet()) {
            System.out.println(ele.getKey() + "\t" + ele.getValue());
        } //pomeranian 1    beagle 2    jack 1
    }
    
    static void task7() { // access time
        int N = 10_000;
        ArrayList<Integer> lis = new ArrayList<>();
        Integer [] arr = new Integer[N];
        LinkedList<Integer> llis;

        for (int i = 0; i < N; i++) {
            lis.add(i+1);
        }
        Collections.shuffle(lis);
        lis.toArray(arr);
        llis = new LinkedList<>(lis);

        task7_timer(arr, lis, llis);
    }
    
    static void task7_timer(Integer [] arr, ArrayList<Integer> lis, LinkedList<Integer> llis) {
        int factor = 10;
        int num_iter = 100_000 * factor; // in case your CPU is too powerful
        int [] index = {0, (arr.length/4), (arr.length/2), (3*arr.length/4)};
        long start, stop = System.nanoTime();
        int pos = 0;
        @SuppressWarnings("unused")
        int x;
        for (int i = 0; i < index.length; i++) {
            pos = index[i];
            start = System.nanoTime();
            for (int j = 0; j < num_iter; j++) 
                x = arr[pos];
            stop = System.nanoTime();
            System.out.printf("Array accessing at %d takes %s\n",pos,String.format("%,d",(stop-start)));
            start = System.nanoTime();
            for (int j = 0; j < num_iter; j++) 
                x = lis.get(pos);
            stop = System.nanoTime();
            System.out.printf("ArrayList accessing at %d takes %s\n",pos,String.format("%,d",(stop-start)));
            start = System.nanoTime();
            for (int j = 0; j < num_iter; j++) 
                x = llis.get(pos);
            stop = System.nanoTime();
            System.out.printf("LinkedList accessing at %d takes %s\n",pos,String.format("%,d",(stop-start)));
            System.out.println("-----------------");
        }
    }
}


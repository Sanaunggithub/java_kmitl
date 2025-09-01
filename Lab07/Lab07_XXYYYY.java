import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pack.*;

public class Lab07_XXYYYY { 
    static void task_01() {
        System.out.println("task_01");
        int[] a = {1,5,11,5};
        int[] b = {1,5,30};
        int[] c = {1,2,3,5};
        
        System.out.println( EqualsSubsets_671725.canPartition_Recurse(a) );
        System.out.println( EqualsSubsets_671725.canPartition_Memoiz(a) ); 
        System.out.println( EqualsSubsets_671725.canPartition_DP(a) );
        System.out.println( EqualsSubsets_671725.canPartition_Recurse(b) );
        System.out.println( EqualsSubsets_671725.canPartition_Memoiz(b) );
        System.out.println( EqualsSubsets_671725.canPartition_DP(b) );
        System.out.println( EqualsSubsets_671725.canPartition_Recurse(c) );
        System.out.println( EqualsSubsets_671725.canPartition_Memoiz(c) );
        System.out.println( EqualsSubsets_671725.canPartition_DP(c) );     
    }
    static void task_02() {
        System.out.println("task_02");
        int [][] grid = {  {0,0,0,0},
                            {0,1,0,0},
                            {0,0,0,1},
                            {1,0,0,0} };
        GridPaths_671725 sol = new GridPaths_671725();
        System.out.println("number of paths: " + sol.numberOfPaths(grid) );
    }
    public static void main(String[] args) {
        // task_01();
        task_02();
    }
}
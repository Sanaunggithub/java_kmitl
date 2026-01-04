public class ClimbStairsTopDown {
    static int climbStairsTopDown(int n, int []mem){
        if(n == 0 || n== 1) return 1;

        if(mem[n] != -1){
            return mem[n];
        }

        mem[n] = climbStairsTopDown(n-1, mem)+ climbStairsTopDown(n-2, mem);
        return mem[n];
    }
}
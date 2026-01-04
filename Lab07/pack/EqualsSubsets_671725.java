package pack;

public class EqualsSubsets_671725 {
    public static boolean canPartition_Recurse(int [] arr){
        int sum = 0;

        for(int a : arr) sum += a;

        if(sum % 2 != 0) return false;

        return canPartitionHelper(arr, 0, sum / 2);
    }

    private static boolean canPartitionHelper(int[] arr, int index, int target) {
    // base cases
    if (target == 0) return true;           // found a subset
    if (index >= arr.length || target < 0) return false; // no elements left

    // recursive choice: take or skip current number
    return canPartitionHelper(arr, index + 1, target - arr[index]) ||
           canPartitionHelper(arr, index + 1, target);
    
    } 
    

    public static boolean canPartition_Memoiz(int [] arr){
        int sum = 0;
        for (int num : arr) sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;

        // rows represent the current index in the array.
        // columns represent possible remaining sums from 0 to target.
        Boolean[][] memo = new Boolean[arr.length][target + 1];
        return helperMemo(arr, 0, target, memo);
    }

    private static boolean helperMemo(int[] arr, int index, int target, Boolean[][] memo) {
        if (target == 0) return true;
        if (index == arr.length || target < 0) return false;

        if (memo[index][target] != null) return memo[index][target];

        boolean res = helperMemo(arr, index + 1, target - arr[index], memo) ||
                      helperMemo(arr, index + 1, target, memo);

        return memo[index][target] = res;
    }

    public static boolean canPartition_DP(int [] arr){
        int sum = 0;
        for (int num : arr) sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;

        // rows represent all elements of the array. start from 0 to i - 1.
        // columns represent the target sum we want to achieve.
        boolean[][] dp = new boolean[arr.length + 1][target + 1]; // 5 elements (0-4) target = 11 (0-11)

        // base case: sum = 0 means the total of the numbers you pick is 0. It means there is no target j = 0.
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= target; j++) {
                // current = arr[i - 1], target = j
                // if current is larger than target, ignore the current. Replaces with prev row
                if (j < arr[i - 1]) {
                    // since i is row (the element of the array we swap with i - 1)
                    dp[i][j] = dp[i - 1][j];
                } else {
                              // not pick      pick      target - cuurent
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[arr.length][target];
    }

}

// dp[1][2] “Using the first 1 element of the array, can we make the sum 2?”

// After filling the table, dp[arr.length][target] tells us:

// Can we make the target sum (half of total sum) using all the elements?

// If true → the array can be partitioned into two equal-sum subsets.

// If false → it cannot.
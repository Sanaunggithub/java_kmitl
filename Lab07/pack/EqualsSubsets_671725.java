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

        boolean[][] dp = new boolean[arr.length + 1][target + 1];

        // base case: sum = 0 is always possible
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[arr.length][target];
    }

}

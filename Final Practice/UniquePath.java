class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] memo = new Integer[m][n];
        return helper(0,0, memo);
    }

    public int helper(int m, int n, Integer[][] memo){
        if(m >= memo.length || n >= memo[0].length) return 0;
        if(memo[m][n] != null) return memo[m][n];
        
        if(m == memo.length - 1 && n == memo[0].length - 1) return 1;

        memo[m][n] = helper(m + 1, n, memo) + helper(m, n + 1, memo);

        return memo[m][n];
    }
}
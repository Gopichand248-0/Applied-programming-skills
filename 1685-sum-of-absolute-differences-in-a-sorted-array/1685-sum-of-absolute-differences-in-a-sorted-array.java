class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            int left = nums[i] * i - prefix[i];
            int right = (prefix[n] - prefix[i + 1]) - nums[i] * (n - i - 1);
            res[i] = left + right;
        }
        return res;
    }
}

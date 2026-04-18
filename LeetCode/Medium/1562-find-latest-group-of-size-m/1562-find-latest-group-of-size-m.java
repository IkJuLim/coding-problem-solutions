class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (m == n) return n;

        int[] cnt = new int[n + 2];
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            int idx = arr[i];
            int l = cnt[idx - 1], r = cnt[idx + 1];
            if (l == m || r == m) {
                ans = i;
            }
            cnt[idx - l] = l + r + 1;
            cnt[idx + r] = l + r + 1;
        }
        return ans;
    }
}
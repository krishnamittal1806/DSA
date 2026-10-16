
import java.util.Arrays;

class Solution {
    long M = 1000000007;
    int n;

    long[] squaresumSegTree;
    long[] sumSegTree;
    long[] lazy;

    private void lazyAddition(int i, int l, int r, int val) {
        long len = r - l + 1;
        long oldSum = sumSegTree[i];

        squaresumSegTree[i] = (
            squaresumSegTree[i]
            + 2L * val * oldSum
            + len * val * val
        ) % M;

        sumSegTree[i] = (oldSum + len * val) % M;
    }

    private void updateRange(int start, int end, int i,
                             int l, int r, int val) {

        if (lazy[i] != 0) {
            lazyAddition(i, l, r, (int) lazy[i]);

            if (l != r) {
                lazy[2 * i + 1] =
                    (lazy[2 * i + 1] + lazy[i]) % M;

                lazy[2 * i + 2] =
                    (lazy[2 * i + 2] + lazy[i]) % M;
            }

            lazy[i] = 0;
        }

        // Out of range
        if (l > end || r < start) return;

        // Completely inside range
        if (start <= l && r <= end) {
            lazyAddition(i, l, r, val);

            if (l != r) {
                lazy[2 * i + 1] =
                    (lazy[2 * i + 1] + val) % M;

                lazy[2 * i + 2] =
                    (lazy[2 * i + 2] + val) % M;
            }

            return;
        }

        int mid = l + (r - l) / 2;

        updateRange(start, end, 2 * i + 1, l, mid, val);
        updateRange(start, end, 2 * i + 2, mid + 1, r, val);

        sumSegTree[i] =  (sumSegTree[2 * i + 1] + sumSegTree[2 * i + 2]) % M;

        squaresumSegTree[i] = (squaresumSegTree[2 * i + 1] + squaresumSegTree[2 * i + 2]) % M;
    }

    public int sumCounts(int[] nums) {
        n = nums.length;

        squaresumSegTree = new long[4 * n];
        sumSegTree = new long[4 * n];
        lazy = new long[4 * n];

        int[] lastseenindex = new int[100001];
        Arrays.fill(lastseenindex, -1);

        long result = 0;

        for (int i = 0; i < n; i++) {
            int start = lastseenindex[nums[i]] + 1;

            updateRange(start, i, 0, 0, n - 1, 1);

            result = (result + squaresumSegTree[0]) % M;

            lastseenindex[nums[i]] = i;
        }

        return (int) result;
    }
}

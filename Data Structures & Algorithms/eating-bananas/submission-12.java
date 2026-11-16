class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int num : piles) {
            max = Math.max(max, num);
        }

        int l = 1, r = max;
        int res = max;
        while (l <= r) {
            long currHours = 0;
            int k = l + (r - l) / 2;
            for (int j = 0; j < piles.length; j++) {
                currHours += Math.ceilDiv(piles[j], k);
            }
            if (currHours <= h) {
                res = Math.min(res, k);
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;
    }
}

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = Arrays.stream(piles).max().getAsInt();
        int l = 0;
        int result = r;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (canEatInTime(piles, m, h)) {
                result = Math.min(result, m);
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return result;
    }

    public boolean canEatInTime(int piles[], int eat, int h) {
        int total = 0;
        for (int pile : piles) {
            total += Math.ceil((double) pile / eat);
        }
        return total <= h;
    }
}

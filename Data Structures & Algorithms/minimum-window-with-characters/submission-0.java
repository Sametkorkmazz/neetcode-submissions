class Solution {
    public String minWindow(String s, String t) {
        int[] sChars = new int[128];
        int[] tChars = new int[128];
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < t.length(); i++) {
            tChars[t.charAt(i)]++;
            set.add(t.charAt(i));
        }
        int required = set.size();

        int l = 0, formed = 0;
        int bestStart = 0, bestLen = Integer.MAX_VALUE;

        for (int r = 0; r < s.length(); r++) {
            sChars[s.charAt(r)]++;
            if (sChars[s.charAt(r)] == tChars[s.charAt(r)]) {
                formed++;
            }
            while (formed == required) {
                sChars[s.charAt(l)]--;
                if (sChars[s.charAt(l)] < tChars[s.charAt(l)]) {
                    formed--;
                }
                if (r - l + 1 < bestLen) {
                    bestStart = l;
                    bestLen = r - l + 1;
                }
                l++;
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}
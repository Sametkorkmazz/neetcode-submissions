class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] first = new int[26];
        int[] second = new int[26];
        for (char c : s1.toCharArray()) first[c - 'a']++;
        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            second[s2.charAt(r) - 'a']++;
            if (r - l + 1 > s1.length()) {
                second[s2.charAt(l) - 'a']--;
                l++;
            }
            if (r - l + 1 == s1.length() && Arrays.equals(first, second))
                return true;
        }
        return false;
    }
}
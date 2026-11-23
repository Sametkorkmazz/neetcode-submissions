class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] first = new int[26];
        int[] second = new int[26];
        for (char c : s1.toCharArray())
            first[c - 'a']++;
        for (int i = 0; i < s1.length(); i++) {
            second[s2.charAt(i) - 'a']++;
        }
         if (Arrays.equals(first, second))
                return true;
        for (int r = s1.length(); r < s2.length(); r++) {
            second[s2.charAt(r) - 'a']++;
            second[s2.charAt(r - s1.length()) - 'a']--;
            if (Arrays.equals(first, second))
                return true;
        }
        return false;
    }
}
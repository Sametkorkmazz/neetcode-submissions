class Solution {
    public boolean isPalindrome(String s) {
        String newStr = s.replaceAll("[^a-zA-Z0-9]", "");
        return newStr.toLowerCase().equals(new StringBuilder(newStr).reverse().toString().toLowerCase());
    }
}

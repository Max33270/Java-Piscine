public class Palindrome {
    public static boolean isPalindrome(String s) {
        String reversed = ""; 
        if (s == null) {
            return false; 
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i); 
        }
        if (s.equalsIgnoreCase(reversed)) {
            return true; 
        } 
        return false; 
    }
}


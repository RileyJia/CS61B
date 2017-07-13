public class Palindrome {
    public static Deque<Character> wordToDeque(String word){
        Deque<Character> wordDeque = new ArrayDeque<>();
        for(Character w : word.toCharArray()){
            wordDeque.addlast(w);
        }
        return wordDeque;
    }

    public static boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        } else if (word.charAt(0) == word.charAt(word.length()-1)) {
            return isPalindrome(word.substring(1, word.length() - 1));
        } else return false;
    }

    public static boolean isPalindrome(String word, CharacterComparator cc){
        if (word.length() == 0 || word.length() == 1) {
            return true;
        } else if ( cc.equalChars(word.charAt(0),word.charAt(word.length()-1))) {
            return isPalindrome(word.substring(1, word.length() - 1),cc);
        } else return false;
    }

    public static void main(String[] args) {
        wordToDeque("a").printDeque();
        wordToDeque("").printDeque();
        wordToDeque("abc").printDeque();
        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome("asdsa"));
        System.out.println(isPalindrome("asddsa"));
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("abc"));
    }

 }
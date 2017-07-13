/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("words.txt");
        //OffByOne cc = new OffByOne();
        //OffByN cc = new OffByN(5);

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && Palindrome.isPalindrome(word)) {
            //if (word.length() >= minLength && Palindrome.isPalindrome(word,cc)) {
                    System.out.println(word);
            }
        }
    }
} 

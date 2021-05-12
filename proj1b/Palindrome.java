public class Palindrome {
    /** Given a String, wordToDeque should return a Deque
     * where the characters appear in the same order as in the String. */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    /** The isPalindrome method should return true
     *  if the given word is a palindrome, and false otherwise. */
    public boolean isPalindrome(String word) {
        Deque d = this.wordToDeque(word);
        return this.isPalindromeHelper(d);
    }

    /** A helper function of isPalindrome method. */
    private boolean isPalindromeHelper(Deque<String> d) {
        if (d.size() <= 1) {
            return true;
        } else if (d.removeFirst() != d.removeLast()) {
            return false;
        } else {
            return isPalindromeHelper(d);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque d = wordToDeque(word);
        return isPalindromeHelper(d, cc);
    }

    /** A helper function of isPalindrome method. */
    private boolean isPalindromeHelper(Deque<String> d,  CharacterComparator cc) {
        if (d.size() <= 1) {
            return true;
        } else if (!cc.equalChars((char)d.removeFirst(), (char)d.removeLast())) {
            return false;
        } else {
            return isPalindromeHelper(d, cc);
        }
    }

}

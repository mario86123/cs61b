public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> tmp = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            tmp.addLast(word.charAt(i));
        }
        return tmp;
    }
    public boolean isPalindrome(String word) {
        return isPalindromeHelper(wordToDeque(word));
    }
    private boolean isPalindromeHelper(Deque w) {
        if (w.size() == 0 || w.size() == 1) {
            return true;
        } else if (w.removeFirst() == w.removeLast()) {
            return isPalindromeHelper(w);
        } else {
            return false;
        }
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindromeHelper(wordToDeque(word), cc);
    }
    private boolean isPalindromeHelper(Deque w, CharacterComparator cc) {
        if (w.size() == 0 || w.size() == 1) {
            return true;
        } else if (cc.equalChars((Character) w.removeFirst(), (Character) w.removeLast())) {
            return isPalindromeHelper(w, cc);
        } else {
            return false;
        }
    }
}
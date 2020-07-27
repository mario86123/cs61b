public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> tmp = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            tmp.addLast(word.charAt(i));
        }
        return tmp;
    }
}
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void TestPalindrome() {
        OffByOne obo = new OffByOne();
        assertTrue(palindrome.isPalindrome("abcba"));
        assertTrue(palindrome.isPalindrome("abccba"));
        assertTrue(palindrome.isPalindrome("a"));
        assertFalse(palindrome.isPalindrome("Abcba"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("flake", obo));
        assertFalse(palindrome.isPalindrome("flakf", obo));
    }
}
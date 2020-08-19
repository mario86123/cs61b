import static org.junit.Assert.*;
import org.junit.Test;

public class UnionFindTest {
    @Test
    public void test() {
        UnionFind u1 = new UnionFind(10);
        u1.union(0, 2);
        u1.union(0, 3);
        assertEquals(2, u1.find(3));
        u1.union(7, 6);
        assertEquals(6, u1.find(7));
        u1.union(3, 6); // 0, 2, 3, 6, 7
        assertEquals(2, u1.find(2));
        u1.union(4, 8);
        u1.union(8, 5); // 4, 5, 8
        u1.union(1, 9); // 1, 9
        assertEquals(5, u1.sizeOf(3));
        assertEquals(5, u1.sizeOf(6));
        assertEquals(3, u1.sizeOf(5));
        assertEquals(2, u1.sizeOf(9));
        assertTrue(u1.connected(2, 7));
        assertTrue(u1.connected(4, 5));
    }
}

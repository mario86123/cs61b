public class LinkedListDeque<T> {
    private Node sentinel;
    private int size;
    private class Node {
        public T item;
        public Node prev;
        public Node next;
        public Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
        public Node() {
            item = null;
            prev = this;
            next = this;
        }
    }
    /** Creates an empty linked list deque. */
    public LinkedListDeque() {
        sentinel = new Node();
        size = 0;
    }
    /** Creates a deep copy of other. */
    public LinkedListDeque(LinkedListDeque<T> other){
        sentinel = new Node();
        size = 0;
        Node ptr = other.sentinel.next;
        for (int i = 0; i < other.size; i += 1) {
            addLast(ptr.item);
            ptr = ptr.next;
        }
    }
    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        sentinel.next = new Node(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }
    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
    public int size() {
        return size;
    }
    /** Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line. */
    public void printDeque() {
        Node ptr = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }
    /** Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T tmp = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return tmp;
    }
    /** Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T tmp = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return tmp;
    }
    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *  If no such item exists, returns null. Must not alter the deque! */
    public T get(int index) {
        int i = 0;
        Node ptr = sentinel.next;
        while (i < index) {
            if (ptr == sentinel) {
                return null;
            }
            ptr = ptr.next;
            i += 1;
        }
        return ptr.item;
    }
    /** not finish yet. */
    public T getRecursive(int index) {
        return getRecursiveHelper(sentinel.next, index);
    }
    private T getRecursiveHelper(Node current, int index) {
        if (index == 0) {
            return current.item;
        } else {
            return getRecursiveHelper(current.next, index - 1);
        }
    }
}
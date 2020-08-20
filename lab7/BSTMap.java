import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>{
    private Node root;

    private class Node {
        K key;
        V val;
        Node left, right;
        Node(K k, V v) {
            key = k; val = v;
        }
    }

    /** Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
    }

    /* Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key) {
        return containsKey(root, key);
    }
    private boolean containsKey(Node r, K key) {
        if (r == null) { return false; }
        int cmp = key.compareTo(r.key);
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return containsKey(r.left, key);
        } else {
            return containsKey(r.right, key);
        }
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        return get(root, key);
    }
    private V get(Node r, K key) {
        if (r == null) { return null; }
        int cmp = key.compareTo(r.key);
        if (cmp == 0) {
            return r.val;
        } else if (cmp < 0) {
            return get(r.left, key);
        } else {
            return get(r.right, key);
        }
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size(root);
    }

    private int size(Node r) {
        if (r == null) { return 0; }
        else return size(r.left) + size(r.right) + 1;
    }

    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node r, K key, V value) {
        if (r == null) { r = new Node(key, value); }
        int cmp = key.compareTo(r.key);
        if (cmp == 0) {
            r.val = value;
        } else if (cmp < 0) {
            r.left = put(r.left, key, value);
        } else {
            r.right = put(r.right, key, value);
        }
        return r;
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }
}

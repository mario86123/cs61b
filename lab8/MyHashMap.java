import java.util.*;

public class MyHashMap<K, V> implements Map61B<K, V>{
    private double lf;
    private List<V> map;
    private Set<K> keysWithValue;

    public MyHashMap() {
        this(16, 0.75);
    }

    public MyHashMap(int initialSize) {
        this(initialSize, 0.75);
    }

    public MyHashMap(int initialSize, double loadFactor) {
        lf = loadFactor;
        map = new ArrayList<>();
        map.addAll(Collections.nCopies (initialSize, null));
        keysWithValue = new HashSet<>();
    }

    private int hash(K key) { return (key.hashCode() & 0x7fffffff) % map.size(); }

    /** Removes all of the mappings from this map. */
    @Override
    public void clear() {
        int initialSize = map.size();
        map = new ArrayList<>();
        map.addAll(Collections.nCopies (initialSize, null));
        keysWithValue = new HashSet<>();
    }

    /** Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key) {
        if (map.get(hash(key)) == null) { return false; }
        else { return true; }
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        if (map.get(hash(key)) == null) { return null; }
        else { return map.get(hash(key)); }
    }

    /** Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return keysWithValue.size();
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key,
     * the old value is replaced.
     */
    @Override
    public void put(K key, V value) {
        if ((double)(keysWithValue.size() + 1) / map.size() > lf) {
            MyHashMap tmp = new MyHashMap(map.size() * 2);
            for (K item : keysWithValue) {
                tmp.put(item, get(item));
            }
            this.map = tmp.map;
        }
        keysWithValue.add(key);
        map.set(hash(key), value);
    }

    /** Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        return keysWithValue;
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException.
     */
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    /**
     * Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.
     */
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }
}

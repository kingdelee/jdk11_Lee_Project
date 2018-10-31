package jdk11.map;

public interface Map<K, V> {
    int size();
    V get(Object key);
    V put(K key, V value);

    interface Entry<K, V> {
        K getKey();
        V getValue();
        V setValue(V value);
    }

}

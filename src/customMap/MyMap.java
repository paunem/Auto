package customMap;

import java.util.*;

public class MyMap<K, V> implements java.util.Map<K, V> {
    private ArrayList<K> keys;
    private ArrayList<V> values;

    public MyMap() {
        this.keys = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    public V put(K key, V value){
        int index = keys.indexOf(key);
        if (index == -1) {
            keys.add(key);
            values.add(value);
            return null;
        } else {
            V prevValue = values.get(index);
            keys.remove(index);
            values.remove(index);
            keys.add(key);
            values.add(value);
            return prevValue;
        }
    }

    public V remove(Object key){
        int index = keys.indexOf(key);
        if (index == -1)
            return null;
        else {
            V prevValue = values.get(index);
            keys.remove(index);
            values.remove(index);
            return prevValue;
        }
    }

    public V get(Object key){
        int index = keys.indexOf(key);
        if (index == -1)
            return null;
        else {
            return values.get(index);
        }
    }

    public boolean containsKey(Object key){
        return keys.contains(key);
    }

    public boolean containsValue(Object value){
        return values.contains(value);
    }

    public int size(){
        return keys.size();
    }

    public boolean isEmpty() {
        return keys.isEmpty();
    }

    public void clear() {
        keys.clear();
        values.clear();
    }

    public Set<K> keySet() {
        return new TreeSet<K>(keys);
    }

    public Collection<V> values() {
        return values;
    }

    public void putAll(Map m) {
        throw new UnsupportedOperationException();
    }

    public Set<Map.Entry<K,V>> entrySet(){
        throw new UnsupportedOperationException();
    }
}
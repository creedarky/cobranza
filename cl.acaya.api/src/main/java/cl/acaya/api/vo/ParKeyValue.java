package cl.acaya.api.vo;

import java.io.Serializable;

/**
 * User: Kiosolutions
 */
public class ParKeyValue<K, V> implements Serializable {

    private static final long serialVersionUID = -7074492651462833618L;
    private K key;
    private V value;

    public ParKeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

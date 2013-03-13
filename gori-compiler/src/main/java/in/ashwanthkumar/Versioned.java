package in.ashwanthkumar;

import java.util.HashMap;
import java.util.Map;

public class Versioned<T> {
    private Map<Long, T> versionedMap = new HashMap<Long, T>();

    public T at(long timestamp) {
        return versionedMap.get(timestamp);
    }

    public Versioned<T> add(T value, long at) {
        versionedMap.put(at, value);
        return this;
    }

    public Iterable<T> values() {
        return versionedMap.values();
    }

    public Iterable<Long> timestamps() {
        return versionedMap.keySet();
    }
}

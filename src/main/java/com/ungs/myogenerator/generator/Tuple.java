package com.ungs.myogenerator.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tuple implements Cloneable {
    private List<Float> values;

    Tuple(int size) {
        values = new ArrayList<>(size);
    }

    @Override
    public String toString() {
        return values.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return getValues().equals(tuple.getValues());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValues());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Tuple clone = new Tuple(this.values.size());
        for (Float value : this.values) {
            clone.addValue(value);
        }
        return clone;
    }

    List<Float> getValues() {
        return values;
    }

    void addValue(Float value) {
        this.values.add(value);
    }
}

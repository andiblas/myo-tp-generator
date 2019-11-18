package com.ungs.myogenerator.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tuple {
    private List<Float> values;

    public Tuple(int size) {
        values = new ArrayList<>(size);
    }

    @Override
    public String toString() {
        return "Tuple{" + values + '}';
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

    public List<Float> getValues() {
        return values;
    }

    public void addValue(Float value) {
        this.values.add(value);
    }
}

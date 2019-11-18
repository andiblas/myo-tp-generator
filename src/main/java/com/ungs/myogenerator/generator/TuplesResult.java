package com.ungs.myogenerator.generator;

import java.util.HashSet;
import java.util.Set;

public class TuplesResult {
    private Set<Tuple> inputS = new HashSet<>();
    private Set<Tuple> inputB = new HashSet<>();

    public Set<Tuple> getInputS() {
        return inputS;
    }

    public void setInputS(Set<Tuple> inputS) {
        this.inputS = inputS;
    }

    public Set<Tuple> getInputB() {
        return inputB;
    }

    public void setInputB(Set<Tuple> inputB) {
        this.inputB = inputB;
    }
}

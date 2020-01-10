package com.ungs.myogenerator.commandline;

public class CommandLineOptions {
    private final Integer size;
    private final Integer length;
    private final Integer probability;

    public CommandLineOptions(Integer size, Integer length, Integer probability) {
        this.size = size;
        this.length = length;
        this.probability = probability;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getLength() {
        return length;
    }

    public float getProbability() {
        return probability;
    }
}

package com.ungs.myogenerator.commandline;

public class CommandLineOptions {
    private Integer size;
    private Integer length;

    public CommandLineOptions(Integer size, Integer length) {
        this.size = size;
        this.length = length;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getLength() {
        return length;
    }
}

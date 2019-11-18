package com.ungs.myogenerator.generator;

import com.ungs.myogenerator.commandline.CommandLineOptions;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class SInputGenerator {
    private final List<Float> acceptedSValues = Arrays.asList(0f, 0.5f, 1f);

    void generate(CommandLineOptions options, TuplesResult result) {
        while (result.getInputS().size() != options.getLength()) {
            Tuple tuple = new Tuple(options.getSize());
            for (int i = 0; i < options.getSize(); i++) {
                tuple.addValue(getRandomElement());
            }
            result.getInputS().add(tuple);
        }
    }

    private Float getRandomElement() {
        Random rand = new Random();
        return acceptedSValues.get(rand.nextInt(acceptedSValues.size()));
    }
}

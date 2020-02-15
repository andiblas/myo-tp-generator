package com.ungs.myogenerator.generator;

import com.ungs.myogenerator.commandline.CommandLineOptions;

import java.util.Random;

class SInputGenerator {
    void generate(CommandLineOptions options, TuplesResult result) {
        while (result.getInputS().size() != options.getLength()) {
            Tuple tuple = new Tuple(options.getSize());
            for (int i = 0; i < options.getSize(); i++) {
                tuple.addValue(getRandomElement(options.getProbability()));
            }
            result.getInputS().add(tuple);
        }
    }

    private Float getRandomElement(float probability) {
        Random rand = new Random();
        probability = probability * 100;
        float zeroBound = probability + ((100 - probability) / 2);
        int chosenProb = rand.nextInt(99);
        if (chosenProb <= probability) return 0.5F;
        else if (probability < chosenProb && chosenProb <= zeroBound) return 0F;
        else if (zeroBound < chosenProb && chosenProb <= 100) return 1F;
        return 0F;
    }
}

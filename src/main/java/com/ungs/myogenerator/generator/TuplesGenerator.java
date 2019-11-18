package com.ungs.myogenerator.generator;

import com.ungs.myogenerator.commandline.CommandLineOptions;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TuplesGenerator {

    private final List<Float> acceptedSValues = Arrays.asList(0f, 0.5f, 1f);

    public TuplesResult generate(CommandLineOptions options) {
        TuplesResult result = new TuplesResult();

        while (result.getInputS().size() != options.getLength()) {
            Tuple tuple = new Tuple(options.getSize());
            for (int i = 0; i < options.getSize(); i++) {
                tuple.addValue(getRandomElement());
            }
            result.getInputS().add(tuple);
        }

        


        return result;
    }

    public Float getRandomElement() {
        Random rand = new Random();
        return acceptedSValues.get(rand.nextInt(acceptedSValues.size()));
    }


}

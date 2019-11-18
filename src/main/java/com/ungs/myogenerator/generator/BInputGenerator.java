package com.ungs.myogenerator.generator;

import com.ungs.myogenerator.commandline.CommandLineOptions;

import java.util.ArrayList;
import java.util.List;

class BInputGenerator {
    void generate(CommandLineOptions options, TuplesResult result) {
        for (Tuple sTuple : result.getInputS()) {
            List<Tuple> tupleList = new ArrayList<>();
            tupleList.add(new Tuple(options.getSize()));
            result.getInputB().addAll(createTupleTree(sTuple, tupleList, 0));
        }
    }

    private List<Tuple> createTupleTree(Tuple sTuple, List<Tuple> ongoingBTuples, int currentIndex) {
        // Caso base: terminamos de iterar sobre la tupla S y devolvemos lo que generamos hasta acá.
        if (currentIndex == sTuple.getValues().size())
            return ongoingBTuples;

        Float sValue = sTuple.getValues().get(currentIndex);
        if (sValue == 0.5f) {
            List<Tuple> newTuples = new ArrayList<>();
            for (Tuple tuple : ongoingBTuples) {
                try {
                    Tuple clonedTuple = (Tuple) tuple.clone();
                    tuple.addValue(0f);
                    clonedTuple.addValue(1f);
                    newTuples.add(clonedTuple);
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
            ongoingBTuples.addAll(newTuples);
        } else {
            for (Tuple tuple : ongoingBTuples) {
                tuple.addValue(sValue);
            }
        }

        currentIndex++;
        return createTupleTree(sTuple, ongoingBTuples, currentIndex);
    }
}

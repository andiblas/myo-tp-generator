package com.ungs.myogenerator.printer;

import com.ungs.myogenerator.generator.Tuple;
import com.ungs.myogenerator.generator.TuplesResult;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Set;

public class TuplesPrinter {

    public void printResultToFiles(TuplesResult tuplesResult) {
        printResultToFile("inputS.txt", tuplesResult.getInputS());
        printResultToFile("inputB.txt", tuplesResult.getInputB());
    }

    private void printResultToFile(String filePath, Set<Tuple> tuples) {
        StringBuilder sb = new StringBuilder();
        for (Tuple tuple : tuples) {
            String stringTuple = tuple.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "")
                    .replace(".0", "");
            sb.append(stringTuple).append(System.lineSeparator());
        }

        try {
            Files.write(Paths.get(filePath), Collections.singletonList(sb.toString()), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

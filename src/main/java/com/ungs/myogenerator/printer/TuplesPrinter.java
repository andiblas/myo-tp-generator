package com.ungs.myogenerator.printer;

import com.ungs.myogenerator.commandline.CommandLineOptions;
import com.ungs.myogenerator.generator.Tuple;
import com.ungs.myogenerator.generator.TuplesResult;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Set;

public class TuplesPrinter {

    public void printResultToFiles(TuplesResult tuplesResult, CommandLineOptions options) {
        printResultToFile("inputS.txt", tuplesResult.getInputS(), options);
    }

    private void printResultToFile(String filePath, Set<Tuple> tuples, CommandLineOptions options) {
        StringBuilder sb = new StringBuilder();

        sb.append(options.getSize()).append(System.lineSeparator());

        sb.append("\"<");
        for (int i = 1; i <= options.getSize(); i++) {
            sb.append(i).append("n,");
        }
        sb.deleteCharAt(sb.length() - 1).append(">\"").append(System.lineSeparator());

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

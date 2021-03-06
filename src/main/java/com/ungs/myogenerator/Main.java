package com.ungs.myogenerator;

import com.ungs.myogenerator.commandline.CommandLineOptions;
import com.ungs.myogenerator.commandline.CommandLineParser;
import com.ungs.myogenerator.generator.TuplesGenerator;
import com.ungs.myogenerator.generator.TuplesResult;
import com.ungs.myogenerator.printer.TuplesPrinter;

public class Main {

    public static void main(String[] args) {
        CommandLineParser parser = new CommandLineParser();
        CommandLineOptions options = parser.parse(args);

        TuplesGenerator tuplesGenerator = new TuplesGenerator();
        TuplesResult tuplesResult = tuplesGenerator.generate(options);

        TuplesPrinter printer = new TuplesPrinter();
        printer.printResultToFiles(tuplesResult, options);
    }
}

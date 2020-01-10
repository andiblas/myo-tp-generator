package com.ungs.myogenerator.commandline;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CommandLineParser {

    public CommandLineOptions parse(String[] args) {
        Options options = new Options();

        Option input = new Option("s", "size", true, "Size of the tuple.");
        input.setRequired(true);
        options.addOption(input);

        Option output = new Option("l", "length", true, "Desired output length.");
        output.setRequired(true);
        options.addOption(output);

        Option probability = new Option("p", "probability", true, "Probability of generating '0.5' value in input.");
        probability.setRequired(true);
        options.addOption(probability);

        org.apache.commons.cli.CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("myo-generator", options);

            System.exit(1);
        }

        return new CommandLineOptions(
                Integer.parseInt(cmd.getOptionValue("size")),
                Integer.parseInt(cmd.getOptionValue("length")),
                Integer.parseInt(cmd.getOptionValue("probability"))
        );
    }
}

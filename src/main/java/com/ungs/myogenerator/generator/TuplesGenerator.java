package com.ungs.myogenerator.generator;

import com.ungs.myogenerator.commandline.CommandLineOptions;

public class TuplesGenerator {

    private final SInputGenerator sGenerator = new SInputGenerator();
    private final BInputGenerator bGenerator = new BInputGenerator();

    public TuplesResult generate(CommandLineOptions options) {
        TuplesResult result = new TuplesResult();

        sGenerator.generate(options, result);

        return result;
    }

}

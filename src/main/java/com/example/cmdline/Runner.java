package com.example.cmdline;

import com.example.Greeting;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Runner {
    public static void main(String args[]) {
        CommandLineParser parser = new DefaultParser();
        try {
            Options options = createOptions();
            CommandLine line = parser.parse(options, args);
            if (line.hasOption("h")) {
                new HelpFormatter().printHelp("runner", options);
            } else if (line.hasOption("l")) {
                StringBuilder stringBuilder = new StringBuilder("Hi!");
                for (int i = 0; i < (int)line.getParsedOptionValue("l"); i++) {
                    stringBuilder.append("!");
                }
                System.out.println(stringBuilder.toString());
            } else {
                Greeting.sayHi();
            }
        }
        catch (ParseException exp) {
            System.err.println("Parsing failed.  Reason: " + exp.getMessage());
        }
    }

    private static Options createOptions() {
        Option loudness = Option.builder("l")
                .longOpt("loudness")
                .hasArg()
                .desc("how loud the message is (default is 0)")
                .type(Integer.class)
                .build();

        return new Options().addOption("h", "help", false, "print this message")
                .addOption(loudness);
    }
}

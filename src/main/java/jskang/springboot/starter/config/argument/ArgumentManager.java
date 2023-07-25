package jskang.springboot.starter.config.argument;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * This class determines how to define the arguments to be passed when running the binary.
 *
 * This class makes it easy to determine the type of argument.
 *
 * @author jskang
 * @version 0.1.0
 * @since 0.1.0
 */
public final class ArgumentManager {

    protected static final Options options = new Options();

    /**
     * Settings for parsing the command line.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static void generate() {
        for (Arguments args : Arguments.values()) {
            Option option = new Option(args.getShortName(), args.getFullName(), args.isHasArg(), args.getDescription());
            options.addOption(option);
        }
    }

    /**
     * Parse the argument values entered by the user.
     *
     * @param args input arguments.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static void commandParse(String[] args) {
        CommandLineParser parser = null;
        CommandLine line = null;

        try {
            parser = new DefaultParser();
            line = parser.parse(options, args);
        } catch (ParseException e) {
            System.err.println("Error parsing arguments. Cause: " + e.getMessage());
            System.exit(0);
        }

        for (Arguments option : Arguments.values()) {
            if (line.hasOption(option.getFullName())) {
                option.getFunction().apply(line.getOptionValue(option.getFullName()));
            }
        }
    }
}
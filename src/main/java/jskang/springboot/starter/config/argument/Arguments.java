package jskang.springboot.starter.config.argument;

import java.util.function.Function;
import jskang.springboot.starter.SampleprojectApplication;
import org.apache.commons.cli.HelpFormatter;

public enum Arguments {
    HELP("h", "help", false, "Print argument usage.",
        (v) -> {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("help", ArgumentManager.options);
            System.exit(0);
            return 0;
        }),
    VERSION("v", "version", false, "Print the version of the binary.",
        (v) -> {
            System.out.println(SampleprojectApplication.version);
            System.exit(0);
            return 0;
        }),
    LOG_MODE("lm", "logmode", true, "Run the binary in debug mode.",
        (v) -> {
            SampleprojectApplication.loggingMode = (String) v;
            System.out.println(SampleprojectApplication.loggingMode);
            return 0;
        }),
    CONF("c", "conf", true, "Enter the path to the configuration file to run the binary.",
        (v) -> {
            SampleprojectApplication.configPath = (String) v;
            System.out.println(SampleprojectApplication.configPath);
            return 0;
        });

    private String shortName;
    private String fullName;
    private boolean hasArg;
    private String description;
    private Function function;

    Arguments(String shortName, String fullName, boolean hasArg, String description, Function function) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.hasArg = hasArg;
        this.description = description;
        this.function = function;
    }

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isHasArg() {
        return hasArg;
    }

    public String getDescription() {
        return description;
    }

    public Function getFunction() {
        return function;
    }
}

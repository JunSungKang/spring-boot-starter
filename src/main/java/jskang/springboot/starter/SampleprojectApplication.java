package jskang.springboot.starter;

import jskang.springboot.starter.config.argument.ArgumentManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleprojectApplication {

    public static final String version = "Version. SampleProject 0.0.1-SNAPSHOT";
    public static String loggingMode = "INFO";
    public static String configPath = "";

    public static void main(String[] args) {
        // binary arguments setting.
        ArgumentManager.generate();
        ArgumentManager.commandParse(args);

        SpringApplication.run(SampleprojectApplication.class, args);
    }

}

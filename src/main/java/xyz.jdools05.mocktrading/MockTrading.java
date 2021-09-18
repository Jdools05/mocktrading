package xyz.jdools05.mocktrading;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.ws.rs.Produces;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Named
@QuarkusMain
@ApplicationScoped
public class MockTrading implements QuarkusApplication {
    private static String version = "0.0.0";

    public static void main(String... args) {
        // Set the default version and date variables
        String date = "00/00/0000";

        // Load the application information
        try (InputStream inputStream = MockTrading.class.getClassLoader().getResourceAsStream("pom.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);

            version = properties.getProperty("quarkus.application.version");
            date = properties.getProperty("version-date");
        } catch (IOException ignored) {
        }

        // Display the application banner
        System.out.format("\n" +
                "   ___  ___           _      _____             _ _                      \n" +
                "   |  \\/  |          | |    |_   _|           | (_)                    \n" +
                "   | .  . | ___   ___| | __   | |_ __ __ _  __| |_ _ __   __ _          \n" +
                "   | |\\/| |/ _ \\ / __| |/ /   | | '__/ _` |/ _` | | '_ \\ / _` |      \n" +
                "   | |  | | (_) | (__|   <    | | | | (_| | (_| | | | | | (_| |         \n" +
                "   \\_|  |_/\\___/ \\___|_|\\_\\   \\_/_|  \\__,_|\\__,_|_|_| |_|\\__, |\n" +
                "                                                          __/ |         \n" +
                "                                                         |___/          \n" +
                "   Version: %s     Date: %s                                             \n",
                version, date);

        // Run the main application
        Quarkus.run(MockTrading.class, args);
    }

    @Produces
    @Named("botVersion")
    public String produceVersion() {
        return version;
    }

    @Override
    public int run(String... args) {
        Quarkus.waitForExit();
        return 0;
    }
}
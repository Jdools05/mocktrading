package xyz.jdools05.mocktrading.utilities;

import io.smallrye.config.ConfigSourceInterceptor;
import io.smallrye.config.ConfigSourceInterceptorContext;
import io.smallrye.config.ConfigValue;
import io.smallrye.config.Priorities;

import javax.annotation.Priority;

@Priority(Priorities.LIBRARY + 1000)
public class ConfigInterceptor implements ConfigSourceInterceptor {

    @Override
    public ConfigValue getValue(final ConfigSourceInterceptorContext context, final String name) {
        ConfigValue configValue = context.proceed(name);
        switch (name) {
            case "quarkus.banner.enabled":
                configValue = configValue.withValue("false");
                break;
            case "quarkus.log.level":
                var logLevel = context.proceed("MainSettings.logLevel");
                configValue = logLevel.withName(name);
                break;
            case "quarkus.hibernate-orm.database.generation":
                var generationStrategy = context.proceed("DatabaseSettings.generationStrategy");
                configValue = generationStrategy.withName(name);
                break;
            case "quarkus.datasource.jdbc.url":
                var connectionAddress = context.proceed("DatabaseSettings.address");
                var connectionPort = context.proceed("DatabaseSettings.port");
                var databaseName = context.proceed("DatabaseSettings.name");

                configValue = connectionAddress.withValue("jdbc:mariadb://" +
                        connectionAddress.getValue() + ":" +
                        connectionPort.getValue() + "/" +
                        databaseName.getValue()
                ).withName(name);
                break;
            case "quarkus.datasource.username":
                var username = context.proceed("DatabaseSettings.username");
                configValue = username.withName(name);
                break;
            case "quarkus.datasource.password":
                var password = context.proceed("DatabaseSettings.password");
                configValue = password.withName(name);
                break;
        }

        return configValue;
    }
}
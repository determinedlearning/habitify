package com.habitify.app;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.extern.slf4j.Slf4j;

import java.util.TimeZone;

@Slf4j
public class HabitifyApplication extends Application<HabitifyConfiguration> {
    private ObjectMapper objectMapper;

    public static void main(String[] args) throws Exception {
        new HabitifyApplication().run(args);
    }

    @Override
    public void run(HabitifyConfiguration habitifyConfiguration, Environment environment) throws Exception {
        log.info("Application is up!");
    }

    @Override
    public void initialize(Bootstrap<HabitifyConfiguration> bootstrap) {
        objectMapper = bootstrap.getObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        SimpleModule simpleModule = new SimpleModule();
        objectMapper.registerModule(simpleModule);
        objectMapper.setTimeZone(TimeZone.getDefault());
    }
}

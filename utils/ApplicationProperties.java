package ru.cft.focus.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static ru.cft.focus.constants.LoggingConstants.FAIL;
import static ru.cft.focus.constants.LoggingConstants.SUCCESS;
import static ru.cft.focus.constants.PathConstants.PATH_PROPERTIES;

@Slf4j
public class ApplicationProperties {
    private static int producerCount;
    private static int consumerCount;
    private static int producerTime;
    private static int consumerTime;
    private static int storageSize;

    private ApplicationProperties() {
    }

    public static void loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(PATH_PROPERTIES));
            log.info(SUCCESS);
        } catch (IOException e) {
            log.error(FAIL, e.getMessage());
        }

        producerCount = Integer.parseInt(properties.getProperty("producerCount", "5"));
        producerTime = Integer.parseInt(properties.getProperty("producerTime", "2000"));
        consumerCount = Integer.parseInt(properties.getProperty("consumerCount", "5"));
        consumerTime = Integer.parseInt(properties.getProperty("consumerTime", "3000"));
        storageSize = Integer.parseInt(properties.getProperty("storageSize", "10"));
    }

    public static int getProducerCount() {
        return producerCount;
    }

    public static int getConsumerCount() {
        return consumerCount;
    }

    public static int getProducerTime() {
        return producerTime;
    }

    public static int getConsumerTime() {
        return consumerTime;
    }

    public static int getStorageSize() {
        return storageSize;
    }
}
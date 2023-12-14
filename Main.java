package ru.cft.focus;

import lombok.extern.slf4j.Slf4j;
import ru.cft.focus.utils.ApplicationProperties;

import static ru.cft.focus.constants.LoggingConstants.PROPERTIES_INFO;
import static ru.cft.focus.constants.LoggingConstants.START_PROGRAM;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info(START_PROGRAM);

        ApplicationProperties.loadProperties();

        int producerCount = ApplicationProperties.getProducerCount();
        int consumerCount = ApplicationProperties.getConsumerCount();
        int producerTime = ApplicationProperties.getProducerTime();
        int consumerTime = ApplicationProperties.getConsumerTime();
        int storageSize = ApplicationProperties.getStorageSize();

        log.info(PROPERTIES_INFO, producerCount, consumerCount, producerTime, consumerTime, storageSize);

        Storage storage = new Storage(storageSize);

        for (int i = 1; i <= producerCount; i++) {
            new Thread(new Producer(storage, producerTime)).start();
        }

        for (int i = 1; i <= consumerCount; i++) {
            new Thread(new Consumer(storage, consumerTime)).start();
        }
    }
}

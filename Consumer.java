package ru.cft.focus;

import lombok.extern.slf4j.Slf4j;

import static ru.cft.focus.constants.LoggingConstants.CONSUMER_INTERRUPT_SLEEP;
import static ru.cft.focus.constants.LoggingConstants.CONSUMER_SLEEP;

@Slf4j
public class Consumer implements Runnable {
    private static int counter;
    private final Storage storage;
    private final int consumerTime;
    private final int id;

    public Consumer(Storage storage, int consumerTime) {
        synchronized (Consumer.class) {
            counter++;
            this.id = counter;
        }
        this.storage = storage;
        this.consumerTime = consumerTime;
    }

    @Override
    public void run() {
        while (true) {
            boolean success = false;

            while (!success) {
                success = storage.poll(id);
            }

            try {
                log.info(CONSUMER_SLEEP, id);
                Thread.sleep(consumerTime);
            } catch (InterruptedException e) {
                log.info(CONSUMER_INTERRUPT_SLEEP + e.getMessage());
                break;
            }
        }
    }
}

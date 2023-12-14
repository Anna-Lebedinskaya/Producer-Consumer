package ru.cft.focus;

import lombok.extern.slf4j.Slf4j;

import static ru.cft.focus.constants.LoggingConstants.*;

@Slf4j
public class Producer implements Runnable {
    private static int counter;
    private final Storage storage;
    private final int producerTime;
    private final int id;

    public Producer(Storage storage, int producerTime) {
        synchronized (Producer.class) {
            counter++;
            this.id = counter;
        }
        this.storage = storage;
        this.producerTime = producerTime;
    }

    @Override
    public void run() {
        while (true) {
            Product product = new Product();
            log.info(PRODUCER_INFO, id, product.getId());

            boolean success = false;

            while (!success) {
                success = storage.add(product, id);
            }

            try {
                log.info(PRODUCER_SLEEP, id);
                Thread.sleep(producerTime);
            } catch (InterruptedException e) {
                log.info(PRODUCER_INTERRUPT_SLEEP, e.getMessage());
                break;
            }
        }
    }
}

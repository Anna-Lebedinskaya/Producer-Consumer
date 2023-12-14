package ru.cft.focus;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;

import static ru.cft.focus.constants.LoggingConstants.*;

@Slf4j
public class Storage {
    private final Queue<Product> storage;
    private final int storageSize;

    public Storage(int storageSize) {
        storage = new ArrayDeque<>();
        this.storageSize = storageSize;
    }

    public synchronized boolean add(Product product, int idProducer) {
        if (storage.size() == storageSize) {
            try {
                log.info(PRODUCER_WAIT);
                this.wait();
            } catch (InterruptedException e) {
                log.info(STORAGE_INTERRUPT_ADD_WAIT, e.getMessage());
                throw new RuntimeException();
            }
        }
        if (storage.size() < storageSize) {
            storage.add(product);
            log.info(PRODUCT_INFO, idProducer, product.getId(), storage.size());
            if (storage.size() == 1) {
                log.info(PRODUCT_NOTIFY);
                this.notify();
            }
            return true;
        }
        return false;
    }

    public synchronized boolean poll(int idConsumer) {
        if (storage.isEmpty()) {
            try {
                log.info(CONSUMER_WAIT);
                this.wait();
            } catch (InterruptedException e) {
                log.info(STORAGE_INTERRUPT_POLL_WAIT + e.getMessage());
                throw new RuntimeException();
            }
        }
        if (!storage.isEmpty()) {
            Product product = storage.poll();
            log.info(CONSUMER_INFO, idConsumer, product.getId(), storage.size());
            if (storage.size() == storageSize - 1) {
                log.info(CONSUMER_NOTIFY);
                this.notify();
            }
            return true;
        }
        return false;
    }
}

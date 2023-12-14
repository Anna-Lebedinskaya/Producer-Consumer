package ru.cft.focus.constants;

public final class LoggingConstants {
    public static final String SUCCESS = "Properties loaded successfully";
    public static final String FAIL = "Error in reading properties: {}";
    public static final String START_PROGRAM = "Start";
    public static final String PROPERTIES_INFO = """
            The following parameters are set:
                                                producerCount = {}, consumerCount = {},
                                                producerTime = {}, consumerTime = {},
                                                storageSize = {}.""";
    public static final String PRODUCER_INFO = "Producer id = {} produced product id = {}";
    public static final String PRODUCT_INFO = "Producer id = {} added to the storage product id = {}, storage size = {}";
    public static final String CONSUMER_INFO = "The consumer id = {} removed product id = {} from the storage, storage size = {}";
    public static final String PRODUCER_WAIT = "The storage is full, wait";
    public static final String CONSUMER_WAIT = "The storage is empty, wait";
    public static final String CONSUMER_NOTIFY = "The storage is ready to get new products, notify";
    public static final String PRODUCT_NOTIFY = "The products added to the storage, notify";
    public static final String STORAGE_INTERRUPT_ADD_WAIT = "InterruptedException running add and wait: {}";
    public static final String STORAGE_INTERRUPT_POLL_WAIT = "InterruptedException running poll and wait: {}";
    public static final String PRODUCER_SLEEP = "Producer id = {} is sleeping";
    public static final String PRODUCER_INTERRUPT_SLEEP = "InterruptedException running sleep: {}";
    public static final String CONSUMER_SLEEP = "Consumer id = {} is sleeping";
    public static final String CONSUMER_INTERRUPT_SLEEP = "InterruptedException running sleep: {}";
}

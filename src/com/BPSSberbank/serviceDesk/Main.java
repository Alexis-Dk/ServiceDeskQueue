package com.BPSSberbank.serviceDesk;

import com.BPSSberbank.serviceDesk.queues.SimpleQueueImpl;
import com.BPSSberbank.serviceDesk.threads.Consumer;
import com.BPSSberbank.serviceDesk.threads.Producer;

/**
 * @author Alexey Druzik on 25.08.2020
 * В тестовом задании созданы два потока Producer(добавляет объекты в очередь) и один Consumer(читает из очереди) с
 * разными выдержками.
 */
public class Main {

    private final static String[] words = new String[] {"Саша", "Паша", "Нина", "Леша", "Игорь", "Максим", "Ольга"};
    private final static String[] addition_words = new String[] {"Никон", "Афанасий", "Серафим"};
    private static final int TIME_SLEEP_FOR_FIRST_PRODUCER = 5000;
    private static final int TIME_SLEEP_FOR_SECOND_PRODUCER = 6000;
    private static final int TIME_SLEEP_FOR_FIRST_CONSUMER = 8000;

    public static void main(String[] args) {

        SimpleQueueImpl<String> queue = new SimpleQueueImpl();

        new Producer(queue, words, TIME_SLEEP_FOR_FIRST_PRODUCER);
        new Producer(queue, addition_words, TIME_SLEEP_FOR_SECOND_PRODUCER);
        new Consumer(queue, TIME_SLEEP_FOR_FIRST_CONSUMER);

    }

}

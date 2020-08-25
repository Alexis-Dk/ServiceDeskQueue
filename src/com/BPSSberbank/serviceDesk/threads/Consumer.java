package com.BPSSberbank.serviceDesk.threads;

import com.BPSSberbank.serviceDesk.queues.SimpleQueueImpl;

/**
 * @author Alexey Druzik on 25.08.2020
 */
public class Consumer implements Runnable {

    private SimpleQueueImpl<String> queue;
    private Thread thread;
    private Integer timeSleep;

    public Consumer(SimpleQueueImpl<String> queue, Integer timeSleep) {
        this.queue = queue;
        this.timeSleep = timeSleep;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        synchronized (queue) {
            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(timeSleep);
                    String element = queue.remove();
                    System.out.println("consumer: обработал из очереди " + element + ", число элементов в очереди: " + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
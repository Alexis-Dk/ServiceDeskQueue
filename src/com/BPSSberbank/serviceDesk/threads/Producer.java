package com.BPSSberbank.serviceDesk.threads;

import com.BPSSberbank.serviceDesk.queues.Queue;

/**
 * @author Alexey Druzik on 25.08.2020
 */
public class Producer implements Runnable  {

    private Queue<String> queue;
    private String[] words;
    private Thread thread;
    private Integer timeSleep;

    public Producer(Queue<String> queue, String[] words, Integer timeSleep) {
        this.queue = queue;
        this.words = words;
        this.timeSleep = timeSleep;
        thread = new Thread(this);
        thread.start();
    }


    @Override
    public void run() {
        for (int i = 0; i < words.length && !Thread.interrupted(); ) {
            try {
                Thread.sleep(timeSleep);
                queue.add(words[i]);
                System.out.println("producer: записал в очередь " + words[i] + ", число элементов в очереди: " + queue.size());
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

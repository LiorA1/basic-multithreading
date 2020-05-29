package com.example.myproduconsuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";
    private BlockingQueue<Integer> queue = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = new ArrayBlockingQueue<Integer>(10);


    }

    @Override
    protected void onStart()
    {
        super.onStart();


        Thread t1 = new Thread(
                new Runnable()
                {

                    /**
                     * When an object implementing interface <code>Runnable</code> is used
                     * to create a thread, starting the thread causes the object's
                     * <code>run</code> method to be called in that separately executing
                     * thread.
                     * <p>
                     * The general contract of the method <code>run</code> is that it may
                     * take any action whatsoever.
                     *
                     * @see Thread#run()
                     */
                    @Override
                    public void run()
                    {
                        producer();
                    }
                },
                "ProducerThread");

        Thread t2 = new Thread(
                new Runnable()
                {

                    /**
                     * When an object implementing interface <code>Runnable</code> is used
                     * to create a thread, starting the thread causes the object's
                     * <code>run</code> method to be called in that separately executing
                     * thread.
                     * <p>
                     * The general contract of the method <code>run</code> is that it may
                     * take any action whatsoever.
                     *
                     * @see Thread#run()
                     */
                    @Override
                    public void run()
                    {
                        consumer();
                    }
                },
                "ConsumerThread");

        t1.start();
        t2.start();

        try
        {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

    private void producer()
    {
        Random random = new Random();

        while(true)
        {
            try
            {
                Thread.sleep(850);

                queue.put(random.nextInt(100)); //[0,100)
                //Inserts the specified element into this queue,
                // waiting if necessary for space to become available.
                // Blocking.

                // TODO: look into "offer" method..
				// Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions,
                // returning true upon success and false if no space is currently available.
                //
                // When using a capacity-restricted queue, this method is generally preferable to add(E),
                // which can fail to insert an element only by throwing an exception.
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void consumer()
    {
        Random random = new Random();

        while(true)
        {
            try
            {
                Thread.sleep(100);
                // Simulate processing by the consumer

                if(random.nextInt(10) == 0)
                {
                    // "take", Retrieves and removes the head of this queue,
                    // waiting if necessary until an element becomes available.
                    // Blocking.
                    Integer value = queue.take();

                    Log.d(TAG, "Taken value: " + value + ". Queue size: " + queue.size());
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

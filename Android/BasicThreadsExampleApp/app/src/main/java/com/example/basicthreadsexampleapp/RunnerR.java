package com.example.basicthreadsexampleapp;

import android.util.Log;

public class RunnerR implements Runnable
{
    private static final String TAG = "RunnerR";

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
        for(int index = 0; index < 10; index++)
        {
            Log.d(TAG, "Hello " + index);

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }
}

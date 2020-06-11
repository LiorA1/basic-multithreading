package com.example.basicthreadsexampleapp;

import android.util.Log;

/**
 * This Class Using a Runner that EXTENDS Thread.
 */
public class RunnerT extends Thread
{
    private static final String TAG = "Runner";

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     * @see (ThreadGroup, Runnable, String)
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

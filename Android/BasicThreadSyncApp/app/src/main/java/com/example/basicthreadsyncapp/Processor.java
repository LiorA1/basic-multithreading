package com.example.basicthreadsyncapp;

public class Processor extends Thread
{
    //private boolean running = true;
    private volatile boolean running = true;
    // volatile - prevent threads caching variables,
    // when these are not changed from within that tread.

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
        while (running)
        {
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

    public void shutDown()
    {
        running = false;
    }
}

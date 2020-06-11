package com.example.basicthreadsexampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart()
    {
        super.onStart();

        RunnerT runner1 = new RunnerT();
        //runner1.start();

        // you can call run method, like:
        //runner1.run();
        // but it will run in the main thread.
        // If one called 'start' it runs in its own special thread.

        RunnerT runner2 = new RunnerT();
        //runner2.start();
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        Thread t1 = new Thread(new RunnerR());
        Thread t2 = new Thread(new RunnerR());

        t1.start();
        t2.start();

        // Anon Class -
        // A Theanic Without define a class.
        Thread t3 = new Thread(new Runnable()
        {
            private static final String TAG = "Anon_Class";

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
        });

        t3.start();

    }



}



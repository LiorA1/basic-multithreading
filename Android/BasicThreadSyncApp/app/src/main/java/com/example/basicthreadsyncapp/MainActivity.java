package com.example.basicthreadsyncapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        final Processor processor1 = new Processor();

        processor1.start();

        // How you could terminate the processor gracefully ?

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                processor1.shutDown();
                // This is not always works, because optimizations / cache issues.
                // So you need to use "volatile"
            }
        });

    }

    @Override
    protected void onResume()
    {
        super.onResume();

    }
}

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main
{
    private final static int NUM_OF_ITER = 2000;
    private final static int SLEEP_TIME = 10;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args)
    {
        MyObject MyObj = new MyObject();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        //ThreadLocalRandom.current().nextInt(MIN_SLEEP_TIME, MAX_SLEEP_TIME + 1);

        // first thread
        Thread first = new Thread(new Runnable() {
            @Override
            public void run() {
                try
                {
                    for(int numOfIter = NUM_OF_ITER ; numOfIter > 0 ; --numOfIter)
                    {
                        //System.out.println(ANSI_RED + "Thread " + Thread.currentThread().getName() + " is incrementing. Current value: " + MyObj.getValue());
                        //Thread.yield();

                        MyObj.increment();
                        Thread.sleep(SLEEP_TIME);
                    }

                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });



        // second thread.
        Thread second = new Thread(() -> {
            try
            {
                for(int numOfIter = NUM_OF_ITER ; numOfIter > 0 ; --numOfIter)
                {
                    //System.out.println(ANSI_YELLOW + "Thread " + Thread.currentThread().getName() + " is decrementing. Current value: " + MyObj.getValue());
                    //Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
                    //Thread.yield();

                    MyObj.decrement();
                    Thread.sleep(SLEEP_TIME);
                }

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });

        // third thread
        Thread three = new Thread(() -> {
            try
            {
                for(int numOfIter = NUM_OF_ITER ; numOfIter > 0 ; --numOfIter)
                {
                    //System.out.println(ANSI_YELLOW + "Thread " + Thread.currentThread().getName() + " is decrementing. Current value: " + MyObj.getValue());
                    //Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
                    //Thread.yield();

                    MyObj.decrement();
                    Thread.sleep(SLEEP_TIME);
                }

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });


        first.start();
        second.start();
        three.start();


        try
        {
            first.join();
            second.join();
            three.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }


        System.out.println("The final value is : " + MyObj.getValue());
        System.out.println("The current Therad Name is : " + Thread.currentThread().getName());


    }
}

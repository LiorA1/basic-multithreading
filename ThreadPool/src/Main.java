import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main
{

    public static void main(String[] args)
    {
        System.out.println("Hello World!");

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for(int i = 0; i < 5; i++)
        {
            executor.submit(new Processor(i));// Send a new Runnable to the pool.
        }

        executor.shutdown(); // Wait for all submit to be received.  

        System.out.println("All tasks submiteed");

        try
        {
			// Wait for all the 'Tasks' assigned to the pool to been over.
            executor.awaitTermination(1, TimeUnit.HOURS); 
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("All tasks completed.");


    }
}

// 
class Processor implements Runnable
{
    private int _id;

    public Processor(int i_Id)
    {
        this._id = i_Id;
    }

    public void run()
    {
        System.out.println("Starting: " + _id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed: " + _id);

    }
}

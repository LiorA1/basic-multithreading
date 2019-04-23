import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello World!");

        Runner runner1 = new Runner();
        runner1.start();

        Runner runner2 = new Runner();
        runner2.start();
    }
}

class Runner extends Thread
{
    private volatile boolean running = true;
    public void run()
    {
        while(running)
        {
            System.out.println("Hello ");
        }

        try
        {
            Thread.sleep(100);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void shutDown()
    {
        this.running = false;
    }
}

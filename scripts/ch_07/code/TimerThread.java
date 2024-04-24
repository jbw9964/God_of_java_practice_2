package scripts.ch_07.code;

import java.util.Date;

interface RequiredMethods   {
    public void printCurrentTime();
}

public class TimerThread extends Thread implements RequiredMethods {
    @Override
    public void printCurrentTime() {
        while (!currentThread().isInterrupted())    {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= 1_000);

            System.out.print(String.format(
                "%s\t[%,4d] ms\n",
                new Date(), (System.currentTimeMillis() - start)
            ));
        }
    }

    @Override
    public void run() {
        printCurrentTime();
    }

    public static void main(String[] args) {
        TimerThread test = new TimerThread();
        int sec = 3;

        System.out.println(String.format("Testing for %d sec", sec));
        long start = System.currentTimeMillis();

        test.start();
        while (System.currentTimeMillis() - start <= sec * 1_000);

        System.out.println("Interrupting thread...");

        test.interrupt();
        try                             {test.join();}
        catch (InterruptedException e)  {e.printStackTrace();}

        System.out.println("End of main");
    }
}

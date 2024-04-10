package scripts.ch_06.code;

import java.util.Hashtable;
import java.util.Random;
import java.util.TreeSet;

interface RequiredMethods {
    public void getRandomNumberStatistics();
    public void putCurrentNumber(int tempNumber);
    public void printStatistics();
}

abstract class Requirement implements RequiredMethods {
    protected static final int DATA_BOUNDARY = 50;
    protected Hashtable<Integer, Integer> hashtable = new Hashtable<>();
    protected static final Random Rand = new Random();

    protected void getRandomNumberStatistics(int iter) {
        iter = iter < 0 ? -iter : iter;
        
        for (int count = 0; count < iter; count++)
        putCurrentNumber(Rand.nextInt(1, DATA_BOUNDARY + 1));
    }

    @Override
    public void putCurrentNumber(int tempNumber) {
        hashtable.put(
            tempNumber, 
            hashtable.getOrDefault(tempNumber, 0) + 1
        );
    }

    @Override
    public void printStatistics() {
        TreeSet<Integer> keySet = new TreeSet<>(hashtable.keySet());

        int count = 0;
        while (!keySet.isEmpty())   {
            int key = keySet.pollLast();

            System.out.printf(
                "%2d:%3d\t\t", key, hashtable.get(key)
            );
            count++;

            if (count % 10 == 0)    System.out.println();
        }
    }
}

public class RandomNumberStatistics extends Requirement {
    public static void main(String[] args) {
        RandomNumberStatistics test = new RandomNumberStatistics();

        test.getRandomNumberStatistics();
    }

    @Override
    public void getRandomNumberStatistics() {
        getRandomNumberStatistics(5_000);
        printStatistics();
        System.out.println();
    }
}

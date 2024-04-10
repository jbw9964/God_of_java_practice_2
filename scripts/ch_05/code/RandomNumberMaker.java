package scripts.ch_05.code;

import java.util.HashSet;
import java.util.Random;

interface RequiredMethods {
    public HashSet<Integer> getSizeNumber(int num);
}

public class RandomNumberMaker implements RequiredMethods {
    
    public static final int RAN_NUMS = 6;
    public static final int THRESHOLD = 45;


    public static void main(String[] args) {
        RandomNumberMaker test = new RandomNumberMaker();

        for (int i = 0; i < 10; i++)
        System.out.println(test.getSizeNumber());
    }

    public HashSet<Integer> getSizeNumber() {return getSizeNumber(RAN_NUMS);}

    @Override
    public HashSet<Integer> getSizeNumber(int num) {
        Random rand = new Random();
        HashSet<Integer> result = new HashSet<>();

        while (result.size() < num) {
            int randNum = rand.nextInt(THRESHOLD);
            result.add(randNum);
        }

        return result;
    }
}

package scripts.ch_02.code;

public class Solution {
    public static void main(String[] args) {
        String testString = "r1024";
        long testValue = 1024;

        System.out.println("Result : " + SomeClass.parseLong(testString) + "\n");
        SomeClass.printOtherBase(testValue);
    }
}


class SomeClass {
    public static long parseLong(String data) {
        long result;

        try                             {result = Long.parseLong(data);}
        catch (NumberFormatException e) {
            System.out.println(data + " is not a number.\n");
            result = -1;
        }
        
        return result;
    }

    public static void printOtherBase(long value) {
        String[][] array2D = {
            {"Original",    Long.toString(value)},
            {"Binary",      Long.toBinaryString(value)},
            {"Hex",         Long.toHexString(value)},
            {"Octal",       Long.toOctalString(value)}
        };

        for (String[] array : array2D) {
            System.out.printf(
                "%-10s\t: %s\n",
                array[0], array[1]
            );
        }
    }
}

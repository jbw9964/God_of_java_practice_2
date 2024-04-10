package scripts.ch_03.code;

public class Solution {
    private static Integer[][] testArrayInt = {
        {1, 2, 3},
        {3, 1, 1},
        {2, 3, 1}
    };
    private static String[][] testArrayString = {
        {"a", "b", "c"},
        {"b", "c", "a"},
        {"a", "b", "c"}
    };

    public static void main(String[] args) {
        Solution test = new Solution();
        
        System.out.println("Maxima : ");
        test.testGetMax();

        System.out.println("\nMinima : ");
        test.testGetMin();
    }
    
    public void testGetMax() throws NullPointerException {
        for (Integer[] array : testArrayInt) {
            System.out.print(getMax(array) + "\t");
        };  System.out.println();
        
        for (String[] array : testArrayString) {
            System.out.print(getMax(array) + "\t");
        };  System.out.println();
    }
    public void testGetMin() throws NullPointerException {
        for (Integer[] array : testArrayInt) {
            System.out.print(getMin(array) + "\t");
        };  System.out.println();
        
        for (String[] array : testArrayString) {
            System.out.print(getMin(array) + "\t");
        };  System.out.println();
    }

    public <T extends Comparable<T>> T getMax(T[] array) throws NullPointerException {
        T maxVar = array[0];
        for (T var : array) {
            if (var.compareTo(maxVar) > 0)  maxVar = var;
        }
        return maxVar;
    }

    public <T extends Comparable<T>> T getMin(T[] array) throws NullPointerException {
        T minVar = array[0];
        for (T var : array) {
            if (var.compareTo(minVar) < 0)  minVar = var;
        }
        return minVar;
    }
}

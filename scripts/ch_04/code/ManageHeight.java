package scripts.ch_04.code;

import java.util.ArrayList;

interface RequiredMethods {
    public void setData();
    public void printHeight(int classNo);
    public void printAverage(int classNo);
}

public class ManageHeight implements RequiredMethods {
    private static int[][] DefaultData = {
        {170, 180, 173, 175, 177},
        {160, 165, 167, 186},
        {158, 177, 187, 176},
        {173, 182, 181},
        {170, 180, 165, 177, 172}
    };

    private ArrayList<ArrayList<Integer>> classLists;

    @Override
    public void setData() {
        classLists = new ArrayList<>(DefaultData.length);
        
        for (int i = 0; i < DefaultData.length; i++) {
            ArrayList<Integer> listForClass = new ArrayList<>(DefaultData[i].length);
            for (int j = 0; j < DefaultData[i].length; j++)
            listForClass.add(DefaultData[i][j]);

            classLists.add(listForClass);
        }
    }

    @Override
    public void printHeight(int classNo) {
        StringBuilder sb = new StringBuilder();
        sb.append("Class NO.\t: " + classNo + "\n");

        ArrayList<Integer> classList = classLists.get(classNo - 1);

        for (int j = 0; j < classList.size(); j++)
        sb.append(classList.get(j) + " ");
        sb.append("\n\n");

        System.out.println(sb.toString());
    }

    @Override
    public void printAverage(int classNo) {
        StringBuilder sb = new StringBuilder();
        sb.append("Class NO.\t: " + classNo + "\n");

        ArrayList<Integer> classList = classLists.get(classNo - 1);

        double sum = 0;
        for (int j = 0; j < classList.size(); j++)
        sum += classList.get(j);
        
        sb.append(
            "Height average : " 
            + String.format("%.2f", sum / classList.size()) + "\n\n"
        );

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        ManageHeight test = new ManageHeight();
        test.setData();
        for (int i = 0; i < 5; i++) test.printHeight(i + 1);
        for (int i = 0; i < 5; i++) test.printAverage(i + 1);
    }
}

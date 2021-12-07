package phonebook;

import java.util.List;

public class Sorter {


    //bubble sort with time limit.  If limit - then the sorting process stops. limit = linearSearchTime * 10
    public static boolean bubbleSort(List<String> allNamesList, long linearSearchTime, long startTime) {

        for (int i = 0; i < allNamesList.size() - 1; i++) {
            for (int j = 0; j < allNamesList.size() - i - 1; j++) {
                if (allNamesList.get(j).compareTo(allNamesList.get(j+1)) > 0){
                    String temp = allNamesList.get(j);
                    allNamesList.set(j, allNamesList.get(j + 1));
                    allNamesList.set(j + 1, temp);
                }
            }
            if (System.currentTimeMillis() - startTime > linearSearchTime * 10) {
                return false;
            }
        }
        return true;
    }

    public static void quickSort(List<String> list,  int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(list, begin, end);

            quickSort(list, begin, partitionIndex-1);
            quickSort(list, partitionIndex+1, end);
        }


    }

    private static int partition(List<String> list, int begin, int end) {
        String pivot = list.get(end);
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (list.get(j).compareTo(pivot) < 0) {
                i++;

                String swapTemp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, swapTemp);
            }
        }

        String swapTemp = list.get(i + 1);
        list.set(i + 1, list.get(end));
        list.set(end, swapTemp);

        return i+1;
    }
}

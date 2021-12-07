package phonebook;

import java.time.LocalTime;
import java.util.*;

public class Main {
    private static Repo repo;
    public static void main(String[] args) {
        //Creating and initialising repo
        repo = new Repo();
        repo.initAllNamesList();
        repo.initSearchingNamesList();

        //-----------------------------------------------------------------
        //linear search
        long start = System.currentTimeMillis();
        System.out.println("Start searching (linear search)...");
        long entries = Searcher.linearSearch(repo.namesList, repo.allNamesList);
        long end = System.currentTimeMillis();
        long linearSearchDuration = end - start;
        System.out.println("Found " + entries + " / " + repo.namesList.size() +
                        " entries. Time taken: ");
        printFormattedTime(linearSearchDuration);

        //-----------------------------------------------------------------
        //bubble sort + jump search
        System.out.print("\n\n\nStart searching (bubble sort + jump search)...");
        start = System.currentTimeMillis();
        boolean sortedInTime = Sorter.bubbleSort(repo.allNamesList, linearSearchDuration, start);//true if sortingTime <= linearSearchTime * 10
        end = System.currentTimeMillis();
        long sortingTime = end - start;
        start = System.currentTimeMillis();
       if (sortedInTime) {
            entries = Searcher.jumpSearch(repo.namesList, repo.allNamesList);
       } else {
            entries = Searcher.linearSearch(repo.namesList, repo.allNamesList);
       }
        end = System.currentTimeMillis();
        long jumpSearchDuration = end - start;
        long sortAndSearchTime = sortingTime + jumpSearchDuration;
        System.out.println("Found " + entries + " / " + repo.namesList.size() +
                " entries. Time taken: ");
        printFormattedTime(sortAndSearchTime);

        System.out.print("Sorting time: ");
        printFormattedTime(sortingTime);
        if (!sortedInTime) {
            System.out.print(" - STOPPED, moved to linear search");
        }
        System.out.print("\nSearching time: ");
        printFormattedTime(jumpSearchDuration);

        //-----------------------------------------------------------------
        //quick sort + binary search
        repo.initAllNamesList();
        System.out.print("\n\n\nStart searching (quick sort + binary search)...");
        start = System.currentTimeMillis();
        Sorter.quickSort(repo.allNamesList, 0, repo.allNamesList.size() - 1);
        end = System.currentTimeMillis();
        sortingTime = end - start;

        start = System.currentTimeMillis();
        entries = Searcher.jumpSearch(repo.namesList, repo.allNamesList);
        end = System.currentTimeMillis();

        long binarySearchDuration = end - start;
        sortAndSearchTime = sortingTime + binarySearchDuration;
        System.out.print("\nFound " + entries + " / " + repo.namesList.size() +
                " entries. Time taken: ");
        printFormattedTime(sortAndSearchTime);

        System.out.print("\nSorting time: ");
        printFormattedTime(sortingTime);
         System.out.print("\nSearching time: ");
        printFormattedTime(binarySearchDuration);

        //-----------------------------------------------------------------
        //Searching with HashMap implementation
        repo.initPhoneBookMap();
        System.out.print("\n\n\nStart searching (hash table)...");
        start = System.currentTimeMillis();
        Set<String> set = new HashSet<>(repo.allNamesList);
        end = System.currentTimeMillis();
        sortingTime = end - start;

        start = System.currentTimeMillis();
        entries = Searcher.findNamesInNamePhoneMap(repo.namesList, repo.namePhoneMap);
        end = System.currentTimeMillis();

        long hashSearchDuration = end - start;
        sortAndSearchTime = sortingTime + binarySearchDuration;
        System.out.print("\nFound " + entries + " / " + repo.namesList.size() +
                " entries. Time taken: ");
        printFormattedTime(sortAndSearchTime);

        System.out.print("\nCreating time: ");
        printFormattedTime(sortingTime);


        System.out.print("\nSearching time: ");
        printFormattedTime(hashSearchDuration);

    }

    private static void printFormattedTime(long millis) {
        System.out.print(millis /60000 + " min. " +
                (millis/1000) % 60 + " sec. " +
                millis % 1000 + " ms.");
    }








}

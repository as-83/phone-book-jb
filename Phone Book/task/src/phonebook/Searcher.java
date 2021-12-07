package phonebook;

import java.util.List;
import java.util.Map;

public class Searcher {
    public static long findNamesInNamePhoneMap(List<String> namesList, Map<String, String> phoneBook) {
        long entries = 0;
        for (String name : namesList ) {
            if (phoneBook.containsKey(name)) {
                entries++;
            }
        }
        return entries;
    }

    public static long linearSearch(List<String> namesList, List<String> allNamesList) {
        long entries = 0;
        for (String name : namesList ) {
            for (String nameInMap : allNamesList) {
                if (name.equals(nameInMap) ) {
                    entries++;
                }
            }
        }
        return entries;
    }

    public static long jumpSearch(List<String> namesList, List<String> allNamesList) {
        long count = 0;

        for (String name: namesList) {
            if(jumpSearch(name, allNamesList)) {
                count++;
            }
        }

        return count;
    }

    private static boolean jumpSearch(String name, List<String> allNamesList) {
        boolean found = false;
        int step = (int)Math.sqrt(allNamesList.size());
        for (int i = 0; i < allNamesList.size(); ) {
            if(allNamesList.get(i).equals(name)) {
                found = true;
                break;
            } else if(allNamesList.get(i).compareTo(name) < 0) {
                if (i > allNamesList.size() - 1 - step && i != allNamesList.size() - 1) {
                    i = allNamesList.size() - 1;
                } else {
                    i += step;
                }
            } else {
                if (i == 0) {
                    break;
                }
                if (step > 24 ) {
                    if(jumpSearch(name, allNamesList.subList(i - step, i))) {
                        found = true;
                        break;
                    }
                } else {
                    i--;
                }
            }
        }

        return found;
    }

    private static long findAllWithBinarySearch(List<String> namesList, List<String> allNamesList) {
        long count = 0;

        for (String name: namesList) {
            if(binarySearch(name, allNamesList)) {
                count++;
            }
        }

        return count;
    }

    private static boolean binarySearch(String item, List<String> list) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low  + ((high - low) / 2);
            if (list.get(mid).compareTo(item) < 0) {
                low = mid + 1;
            } else if (list.get(mid).compareTo(item) > 0) {
                high = mid - 1;
            } else if (list.get(mid).compareTo(item) == 0) {
                return true;
            }
        }
        return false;
    }
}

package phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileUtils {


    public FileUtils() {
    }

    //Loading data from file with phones and names to HashMap
    public static Map<String, String> getAllPhoneBook(String fullFileName){
        Map<String, String> map = new HashMap<>();
        try(Scanner scanner = new Scanner(new File(fullFileName));) {
            while (scanner.hasNext()) {
                String row = scanner.nextLine();
                String phone = row.substring(0, row.indexOf(" "));
                String name = row.substring(row.indexOf(" ") + 1);
                map.put(name, phone);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }

    //Loading data from file with names to ArrayList
    public static List<String> getAllNamesToSearch(String fullFileName){
        List<String> namesList = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(fullFileName));) {
            while (scanner.hasNext()) {
                namesList.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return namesList;
    }

    //Loading data from file with phones and names to HashMap
    public static List<String> getAllNamesList(String fullFileName){
        List<String> allNamesList = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(fullFileName));) {

            while (scanner.hasNext()) {
                String row = scanner.nextLine();
                String name = row.substring(row.indexOf(" ") + 1);//subtracting name
                allNamesList.add(name);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return allNamesList;
    }
}

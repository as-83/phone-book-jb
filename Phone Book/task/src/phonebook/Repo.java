package phonebook;

import java.util.*;

public class Repo {
    //Unsorted files
    private static final String NAME_PHONES_FILE = "D:/sul/data/phone_book/directory.txt";
    private static final String NAMES_FILE = "D:/sul/data/phone_book/find.txt";
    private static final String NAME_PHONES_FILE_SM = "D:/sul/data/phone_book/small_directory.txt";
    private static final String NAMES_FILE_SM = "D:/sul/data/phone_book/small_find.txt";

    //Collections to save data from files
    Map<String, String> namePhoneMap;
    List<String> namesList;
    List<String> allNamesList;

    public Repo() {
    }

    //Loading data from file with phones and names to HashMap
    public void initPhoneBookMap(){
        namePhoneMap = FileUtils.getAllPhoneBook(NAME_PHONES_FILE_SM);
    }

    //Loading data from file with names to ArrayList
    public void initSearchingNamesList(){
        namesList = FileUtils.getAllNamesToSearch(NAMES_FILE_SM);
    }

    //Loading data from file with phones and names to HashMap
    public void initAllNamesList(){
        allNamesList = FileUtils.getAllNamesList(NAME_PHONES_FILE_SM);
    }
}

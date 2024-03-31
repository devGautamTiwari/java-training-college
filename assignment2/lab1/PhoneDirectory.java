package assignment2.lab1;

import java.util.HashMap;

public class PhoneDirectory {
    private HashMap<String, String> phoneDirectory = new HashMap<>();
        
    public String getPhoneByName(String name) {
        return phoneDirectory.get(name);
    }

    public void addEntry(String name, String phoneNumber) {
        phoneDirectory.put(name, phoneNumber);
    }

    @Override
    public String toString() {
        String output = "";
        for (String name : phoneDirectory.keySet()) {
            output += name + " : " + phoneDirectory.get(name) + ", \n";
        }
        return output;

    }
}

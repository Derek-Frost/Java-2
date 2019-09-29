package HomeWork;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    private static void FindPhone(String S, HashMap hashMap){
        if(hashMap.containsKey(S)) System.out.println(hashMap.get(S));
    }

    private static void FindEmail(String S, HashMap hashMap){
        if(hashMap.containsKey(S)) System.out.println(hashMap.get(S));
    }
    private static void AddValuesPhone(Person person, HashMap<String, ArrayList<String>> hashMap){
        ArrayList<String> tempList;
        if (hashMap.containsKey(person.getFirst_name())) {
            tempList = hashMap.get(person.getFirst_name());
            if(tempList == null)
                tempList = new ArrayList<>();
                tempList.add(person.getPhone());
        } else {
            tempList = new ArrayList<>();
            tempList.add(person.getPhone());
        }
        hashMap.put(person.getFirst_name(),tempList);
    }

    private static void AddValuesEmail(Person person, HashMap<String, ArrayList<String>> hashMap){
        ArrayList<String> tempList;
        if (hashMap.containsKey(person.getFirst_name())) {
            tempList = hashMap.get(person.getFirst_name());
            if(tempList == null)
                tempList = new ArrayList<>();
                tempList.add(person.getEmail());
        } else {
            tempList = new ArrayList<>();
            tempList.add(person.getEmail());
        }
        hashMap.put(person.getFirst_name(),tempList);
    }
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> name_phone = new HashMap<>();
        HashMap<String, ArrayList<String>> name_email = new HashMap<>();
        Person person1 = new Person("Artyom", "+79234567", "Artyom@mail.ru");
        Person person2 = new Person("Alex", "+79234568", "Leha@mail.ru");
        Person person3 = new Person("Afanasiy", "+79234569", "Afan@mail.ru");
        Person person4 = new Person("Lebovski", "+79234570", "Leb@mail.ru");
        Person person5 = new Person("Afanasiy", "+79234581", "Afan1@mail.ru");
        Person person6 = new Person("Georgy", "+79234582", "Gogo@mail.ru");
        AddValuesPhone(person1, name_phone);
        AddValuesPhone(person2, name_phone);
        AddValuesPhone(person3, name_phone);
        AddValuesPhone(person4, name_phone);
        AddValuesPhone(person5, name_phone);
        AddValuesPhone(person6, name_phone);

        AddValuesEmail(person1, name_email);
        AddValuesEmail(person2, name_email);
        AddValuesEmail(person3, name_email);
        AddValuesEmail(person4, name_email);
        AddValuesEmail(person5, name_email);
        AddValuesEmail(person6, name_email);

        FindPhone("Afanasiy", name_phone);
        FindEmail("Afanasiy", name_email);
        System.out.println(name_phone);
        System.out.println(name_email);


    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Task1 {
    /*
    Реализуйте структуру телефонной книги с помощью HashMap,
    учитывая, что 1 человек может иметь несколько телефонов.
     */
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> contact = new HashMap<>();
        boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите 1 чтобы добавить контакт");
            System.out.println("Введите 2 чтобы посмотреть контакты и выйти");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Введите фамилию ");
                String name = scanner.next();
                System.out.println("Введите номер телефона ");
                String number = scanner.next();
                phoneBook(name, number,contact);
            }
            if (choice == 2) {
                System.out.println(contact);
                flag = false;
            }
        }
    }
    static void phoneBook(String name, String number, HashMap<String,ArrayList<String>> contact){
        ArrayList<String> arrayList = new ArrayList<>();
        if (contact.containsKey(name)) {
            arrayList = contact.get(name);
            arrayList.add(number);
            contact.put(name,arrayList);
        } else {
            arrayList.add(number);
            contact.put(name,arrayList);
        }
    }
}

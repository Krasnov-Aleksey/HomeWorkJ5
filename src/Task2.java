import java.util.*;

public class Task2 {
    /*
    Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова,
    Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова,
    Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова,
    Иван Мечников, Петр Петин, Иван Ежов.
    Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
    1 = Павел, Светлана
    2 = Марина,
    3 = Анна, Мария, Петр

     */
    public static void main(String[] args) {
        String text = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, " +
                "Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, " +
                "Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, " +
                "Иван Мечников, Петр Петин, Иван Ежов";

        text = text.replace(",",""); // убираем запятую
        String[] arrEmployees = text.split(" "); // массив по пробелу
        Map <String, Integer> name = new HashMap<>();
        // Ищем количество одинаковых имен
        for (int i = 0; i < arrEmployees.length; i+=2) {
            if (name.containsKey(arrEmployees[i])) {
                int count = name.get(arrEmployees[i]);
                count++;
                name.put(arrEmployees[i],count);
            }
            else {
                name.put(arrEmployees[i],1);
            }
        }
        Map<Integer,List<String>> sortTree = new TreeMap<>(Comparator.reverseOrder());// обратный порядок
        for (Map.Entry<String,Integer> entry : name.entrySet()) {

            if (sortTree.containsKey(entry.getValue())){
                List<String> list = sortTree.get(entry.getValue());// Значение по ключу
                list.add(entry.getKey());
            } else {
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                sortTree.put(entry.getValue(), list);
            }
        }
        System.out.println(sortTree);
    }
}


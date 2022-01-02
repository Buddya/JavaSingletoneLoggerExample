import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");

        logger.log("Просим пользователя ввести входные данные для списка\n" +
                "Введите размер списка:");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        logger.log("Введите верхнюю границу для значений:");
        int threshold = scanner.nextInt();

        logger.log("Создаём и наполняем список");
        ArrayList<Integer> sourceList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            sourceList.add(random.nextInt(threshold));
        }

        logger.log("Вот случайный список: " + getListValues(sourceList));

        logger.log("Просим пользователя ввести входные данные для фильтрации\n" +
                "Введите порог для фильтра:");
        int maxValue = scanner.nextInt();

        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(maxValue);
        List<Integer> filteredList = filter.filterOut(sourceList);


        logger.log("Выводим результат на экран\n" +
                "Отфильтрованный список: " + getListValues(filteredList));


        logger.log("Завершаем программу");
    }


    private static String getListValues(List<Integer> list) {
        return list.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}

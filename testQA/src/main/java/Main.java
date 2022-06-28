import java.util.*;

public class Main {

    private static final int[][] array = {
            {1, 2, 3, 4, 0},
            {5, 7, 9, 9, 1},
            {0, 9, 1, 8, 7},
            {6, 1, 6, 6, 6},
            {9, 100, -2, 3, 1}
    };
    private static final List<Map<String, String>> table = new ArrayList<>();

    public static void findMinElementToSecondDiagonal(int[][] array){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i + j == array[i].length - 1 && i != j) {
                    min = min > array[i][j] ? array[i][j] : min;
                }
            }
        }
        System.out.println(min);
    }

    public static void fun3() {
    }

    public static void main(String[] args) {
        table.add(Map.of("Имя", "Кирилл", "Возраст", "26", "Должность", "Middle java dev", "Зарплата", "150000 руб"));
        table.add(Map.of("Имя", "Виталий", "Возраст", "28", "Должность", "Senior java automation QA", "Зарплата", "2000$"));
        table.add(Map.of("Имя", "Александр", "Возраст", "31", "Должность", "junior functional tester", "Зарплата", "50000 руб"));
        table.add(Map.of("Имя", "Дементий", "Возраст", "35", "Должность", "jdev-ops", "Зарплата", "1500$"));

        System.out.println("Сотрудники младше 30-ти:");
        getEmployeeWithThirtyAgeJunior(table);
        System.out.println("Сотрудники, получающие ЗП в рублях");
        getEmployeeWithSalaryRUB(table);
        System.out.print("Средний возраст: ");
        getAverageEmployeesAge(table);
        System.out.println("Минимальный элемент матрицы: ");
        findMinElementToSecondDiagonal(array);


    }

    private static void getAverageEmployeesAge(List<Map<String, String>> table) {
        List<Integer> ages = new ArrayList<>();
        for (Map<String, String> row : table) {
            for (String key : row.keySet()) {
                if (key.equals("Возраст")) {
                    int age = Integer.parseInt(row.get(key));
                    ages.add(age);
                }
            }
        }
        System.out.println(ages.stream().mapToDouble(d -> d).average().getAsDouble());
    }

    public static void getEmployeeWithSalaryRUB(List<Map<String, String>> table) {
        for (Map<String, String> row : table) {
            for (String key : row.keySet()) {
                if (key.equals("Зарплата")) {
                    String salary = row.get(key);
                    if (salary.contains("руб")) {
                        System.out.println(row.get("Имя"));
                    }
                }
            }
        }
    }

    public static void getEmployeeWithThirtyAgeJunior(List<Map<String, String>> mapList) {
        for (Map<String, String> row : mapList) {
            for (String key : row.keySet()) {
                if (key.equals("Возраст")) {
                    int age = Integer.parseInt(row.get(key));
                    if (age < 30) {
                        System.out.println(row.get("Имя"));
                    }
                }
            }
        }
    }
}

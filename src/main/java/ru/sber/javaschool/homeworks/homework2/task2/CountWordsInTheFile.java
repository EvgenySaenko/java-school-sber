package ru.sber.javaschool.homeworks.homework2.task2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

//Исходные данные: текстовый файл со средней длиной строки равной 10 символам (файл или прошить текст в коде).
//    В реализациях используйте наиболее подходящие имплементации коллекций!
//    Задание 1: Подсчитайте количество различных слов в файле.
public class CountWordsInTheFile {
    public static final String PATH = "F:\\JavaSchoolSber\\java-school-sber\\src\\main\\java\\ru\\sber\\javaschool\\homeworks\\homework2\\task2\\text.txt";

    public static String readFile(Path path) {
        if (path == null) {
            throw new RuntimeException("Неправильно задан путь к файлу");
        } else if (Files.notExists((path))) {
            throw new RuntimeException("Файл не существует");
        } else {
            String text;
            try {
                text = new String(Files.readAllBytes(path));
                //System.out.println(text);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return text;
        }
    }

    //Задание 1: Подсчитайте количество различных слов в файле.
    public static void countDifferentWords(String text) {
        Set<String> set = new HashSet<String>();

        String[] textSplit = text.toLowerCase().split("\\s*(\\s|,|!|-|–|_|\\.)\\s*");
        set.addAll(Arrays.asList(textSplit));

        int countDifferent = set.size();
        for (String word : set) {
            System.out.println(word);
        }
        System.out.println("В тексте " + countDifferent + " уникальных слов");
    }

    //Задание 2: Выведите на экран список различных слов файла,
    // отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).
    // TODO немного не понял, что значит по тексту? сделал только по длине слова(
    public static void uniqueWordsAscending(String text) {
        String[] words = text.toLowerCase().replaceAll("[^А-я]", " ").trim().split("(?U)\\s*(\\s|,|!|-|–|_|—|\\.)\\s*");

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("Список уникальных слов в колличестве : " + uniqueWords.size());
        System.out.println(uniqueWords);

        SortedSet<String> uniqueWordsAscending = new TreeSet<>((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return 1;
            }
            return o1.length() - o2.length();
        });
        uniqueWordsAscending.addAll(uniqueWords);
        System.out.println("Отсортированный список уникальных слов: " + uniqueWords.size());
        System.out.println(uniqueWordsAscending);
    }

    //Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
    public static void listOfWordsAndDuplicates(String text) {
        String[] words = text.toLowerCase().replaceAll("[^А-я]", " ").trim().split("(?U)\\s*(\\s|,|!|-|–|_|—|\\.)\\s*");
        System.out.println(Arrays.asList(words));
        Map<String, Integer> mapWords = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (!mapWords.containsKey(words[i])) {
                mapWords.put(words[i], 1);
            } else if (mapWords.containsKey(words[i])) {
                int count = mapWords.getOrDefault(words[i], 0);
                mapWords.put(words[i], count + 1);
            }
        }

        Set<Map.Entry<String, Integer>> set = mapWords.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    //Задание 4:
    // Выведите на экран все строки файла в обратном порядке.
    public static void reverseLineInText(String incomingPath) {
        if (incomingPath == null) {
            throw new RuntimeException("Неправильно задан путь к файлу");
        } else if (Files.notExists(Paths.get(incomingPath))) {
            throw new RuntimeException("Файл не существует");
        } else {
            Path path = Paths.get(incomingPath);
            List<String> allLines = new ArrayList<>();
            try {
                allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < allLines.size(); i++) {
                String reverse = new StringBuilder(allLines.get(i)).reverse().toString();
                System.out.println(reverse);
            }
        }
    }

    //Задание 5:
    // Реализуйте свой Iterator для обхода списка в обратном порядке.
    public static void reverseListMyIterator(List<String> list) {
        System.out.println("Исходный список: " + list);
        Iterator<String> myIter = new MyReverseIterator<>(list).iterator();
        System.out.println("Итерируем с конца списка: " + myIter);
        System.out.print("[");
        while (myIter.hasNext()) {
            System.out.print(myIter.next() + ",");
        }
        System.out.print("]");
    }

    //Задание 6:
    // Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
    public static void randomNumberLinesInMap(String incomingPath) {
        if (incomingPath == null) {
            throw new RuntimeException("Неправильно задан путь к файлу");
        } else if (Files.notExists(Paths.get(incomingPath))) {
            throw new RuntimeException("Файл не существует");
        } else {
            Path path = Paths.get(incomingPath);
            List<String> allLines = new ArrayList<>();
            try {
                allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Map<String, Integer> mapLines = new HashMap<>();
            for (int i = 0; i < allLines.size(); i++) {
                mapLines.put(allLines.get(i), i);
            }

            Set<Map.Entry<String, Integer>> set = mapLines.entrySet();
            for (Map.Entry<String, Integer> entry : set) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
            //map.forEach((k,v) -> System.out.println(k + " " + v + " "));
        }
    }


    public static void main(String[] args) {
        //Исходные данные
        String text = readFile(Paths.get(PATH));//вычитали в строку текст

        //Задание 1
        //countDifferentWords(text);

        //Задание 2
        //uniqueWordsAscending(text);

        //Задание 3
        //listOfWordsAndDuplicates(text);

        //Задание 4:
        //reverseLineInText(PATH);

        //Задание 5:
        // Реализуйте свой Iterator для обхода списка в обратном порядке.
//        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
//        reverseListMyIterator(list);

        //Задание 6:
        // Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
        //randomNumberLinesInMap(PATH);
    }
}

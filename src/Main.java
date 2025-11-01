import hashset.MyHashSet;
import linkedlist.MyLinkedList;
import studandbook.Book;
import studandbook.Student;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        MyHashSet<String> myHashSet = new MyHashSet<String>(4);
//        System.out.println(myHashSet.add("1"));
//        System.out.println(myHashSet.add("d"));
//        System.out.println(myHashSet.add("ded"));
//        System.out.println(myHashSet.add(new String("ded")));
//        System.out.println(myHashSet.remove("ded"));
//        System.out.println(myHashSet.add("ded"));
//        System.out.println(myHashSet.toString());

//        MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
//        myLinkedList.add("1");
//        myLinkedList.add("2");
//        myLinkedList.add("3");
//        myLinkedList.add("4");
//        myLinkedList.add("5");
//        myLinkedList.add("6");
//        myLinkedList.add("7");
//        myLinkedList.add("8");
//        System.out.println(myLinkedList.toString());
//        System.out.println(myLinkedList.remove("1"));
//        System.out.println(myLinkedList.toString());
//        System.out.println(myLinkedList.remove("2"));
//        System.out.println(myLinkedList.toString());
//        System.out.println(myLinkedList.remove("3"));
//        System.out.println(myLinkedList.toString());
//        System.out.println(myLinkedList.remove("4"));
//        System.out.println(myLinkedList.toString());
//        List<String> test = List.of("str","str2");
//        myLinkedList.addAll(List.of("e","e","d"));
//        System.out.println(myLinkedList.toString());
//        String[] arr = {"ded","dee","rere"};
//        myLinkedList.addAll(arr);
//        System.out.println(myLinkedList.toString());



        LinkedList<Student> students = new LinkedList<>();
        students.add(new Student("Андрей", new ArrayList<Book>(List.of(
                new Book("Искусство любить", 224, 1956),
                new Book("Понедельник начинается в субботу", 320, 1965),
                new Book("Пикник на обочине", 256, 1972),
                new Book("Ночь в Лиссабоне", 320, 1962),
                new Book("Анна Каренина", 111, 1878)
        ))));
        students.add(new Student("Раиль", new ArrayList<Book>(List.of(
                new Book("Трудно быть богом", 256, 2001),
                new Book("Мастер и Маргарита", 480, 1966),
                new Book("Белые ночи", 320, 1848),
                new Book("Преступление и наказание", 672, 1866),
                new Book("Дубровский", 288, 1841)
        ))));
        students.add(new Student("Дмитрий", new ArrayList<Book>(List.of(
                new Book("Бесконечная шутка", 1280, 2000),
                new Book("Унесенные ветром",  736, 2025),
                new Book("Искусство любить", 224, 1956),
                new Book("Дубровский", 288, 1841),
                new Book("Зелёная Миля", 431, 2005)
        ))));
        students.add(new Student("Саша", new ArrayList<Book>(List.of(
                new Book("Мастер и Маргарита", 480, 1966),
                new Book("Трудно быть богом", 256, 2001),
                new Book("Мастер и Маргарита", 480, 1966),
                new Book("Прислуга", 562, 2005),
                new Book("В списках не значился", 439, 2024)
        ))));

        Optional<Book> books  = students.stream()
                .peek(s -> System.out.print(s.toString() + " ")) //вывод в консоль каждого студента
                .flatMap(s -> s.getBooks().stream())
                .sorted(Comparator.comparing(Book::getPages))
                .distinct()
                .filter(y -> y.getYearRelease() > 2000)
                .limit(3)
                .peek(y -> System.out.println("\n"+y.getYearRelease()))
                .findFirst();

        System.out.println(books.map(b -> "Год найденной книги: " + b.getYearRelease())
                .orElse("\nКниги не найдено"));


    }
}
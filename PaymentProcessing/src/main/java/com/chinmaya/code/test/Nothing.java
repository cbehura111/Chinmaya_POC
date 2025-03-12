package com.chinmaya.code.test;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class Nothing {
    public static void main(String[] args) {
        var salaries = Arrays.asList(710005, 500090, 130600, 95000, 87000, 81001, 19800);
        var words = Arrays.asList("Hello","world", "rupesh","Ankush","Nikhil","Asha","Indu");
        int n=3;
        Employee jyothi = new Employee("Jyothi",47000.00,"Engineering",new Date(122, 8, 17));
        Employee rupesh = new Employee("Rupesh",17000.00,"Engineering",new Date(123, 10, 23));
        Employee ankush = new Employee("Ankush",51000.00,"R&D",new Date(121, 11, 10));
        Employee asha = new Employee("Asha",36000.00,"Marketing",new Date(124, 12, 25));
        Employee madan = new Employee("Madan",48000.00,"R&D",new Date(123, 12, 15));
        var empList = Arrays.asList(jyothi,rupesh,ankush,asha,madan);
        //String word ="rhohttoh";
        //
        //Find first repeated latter
        //
        String word ="rhohttoh";
//        findFirstRepeatedWord(word);
//
//        getEachStringCharCount(words);
//
//        getNthHighestSalary(salaries, n);
//
//        getDeptWiseHighestSalary(empList);
//
//        processEmployeeIncrements(empList);
//
//        groupStringsByFirstCharacter(words);
//
//        getLongestString(words);
//
//        flattenListOfList(salaries, words, empList);

        //A Stair Case takes n steps to reach to the top. Each time you can either climb 1 or 2 steps.
        // In how many distinct ways can you climb to the top?
        //System.out.println(recursiveStepCount(5));
        List<Integer> numList = null;
        //m1(numList);
    }

    private static void m1(List<Integer> numList) {
        m8(numList);
    }

    private static void m8(List<Integer> numList) {
        m9(numList);
    }

    private static void m9(List<Integer> numList) {
        m10(numList);
    }

    private static void m10(List<Integer> numList) {
        numList.forEach(s-> System.out.println(s));
    }

    private static int billaStepCount(int n) {
        if(n<3){
            return n;
        } else {
            int first=1,second=2;
            for (int i=2;i<n;i++){
                int count=first+second;
                first=second;
                second=count;
            }
            return second;
        }
    }

    private static int recursiveStepCount(int n) {
        if(n<2){
            return 1;
        }
        return recursiveStepCount(n-1)+recursiveStepCount(n-2);
    }

    private static void getLongestString(List<String> words) {
        var longestStrings = words.stream().collect(Collectors.groupingBy(String::length)).entrySet().stream().max(Comparator.comparingInt(Map.Entry::getKey)).map(Map.Entry::getValue).orElse(Collections.EMPTY_LIST);
        System.out.println("Longest string(s) in given list : "+longestStrings);
    }

    private static void getEachStringCharCount(List<String> arrayList) {
        arrayList.stream().collect(Collectors.groupingBy(String::length,Collectors.counting()))
                .forEach((i,count) -> System.out.println("count for string containing "+i+" character : "+count));
    }

    private static void getNthHighestSalary(List<Integer> salaries, int n) {
        int nthHighestSalary = salaries.stream().distinct().sorted(Comparator.reverseOrder()).skip(n -1).findFirst().orElseThrow(() -> new NoSuchElementException("Not enough elements in the list"));
        System.out.println(n +" Highest Salary: " + nthHighestSalary);
    }
    @Data
    @AllArgsConstructor
    public static class Employee {
        private String eName;
        private double salary;
        private String deptName;
        private Date joiningDate;
    }

    private static void getDeptWiseHighestSalary(List<Employee> empList) {
        empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                Optional::get)
        )).forEach((dept,emp) -> System.out.println(emp.getDeptName() + " Highest Salary employee : "+ emp));
    }

    private static void processEmployeeIncrements(List<Employee> empList) {
        HashMap<Employee,Integer> empIncreamentMap = new HashMap<>();
        LocalDate increamentConsideredDate = LocalDate.now();
        empList.forEach(e->empIncreamentMap.put(e,e.getJoiningDate().before(java.sql.Date.valueOf(increamentConsideredDate.minusYears(1)))?20:0));
        empIncreamentMap.forEach((emp,inc) -> System.out.println("Employee :"+emp+" got an increment of : "+inc));
    }

    private static void groupStringsByFirstCharacter(List<String> words) {
       words.stream().map(String::trim).collect(Collectors.groupingBy(word -> word.toUpperCase().charAt(0))).forEach((k,v)-> System.out.println("Starting with '" + k + "': " + v));
    }

    private static void flattenListOfList(List<Integer> salaries, List<String> words, List<Employee> empList) {
        var listOfList = Arrays.asList(salaries,words);
        var employeeList =Arrays.asList(empList,empList);
        var flattenedList = listOfList.stream().flatMap(List::stream).toList();
        System.out.println("Flattened list: " + flattenedList);
        System.out.println("Employee flattened list : "+employeeList.stream().flatMap(List::stream).map(Employee::getDeptName).toList());

    }
    private static void findFirstRepeatedWord(String word) {
        HashSet<Character> seen = new HashSet<>();
        Optional.ofNullable(word)
                .map(w -> w.chars()
                        .mapToObj(ch -> (char) ch)
                        .filter(ch -> !seen.add(ch))
                        .findFirst()
                        .map(String::valueOf)
                        .orElse("No repeated character"))
                .ifPresent(System.out::println);

    }

}


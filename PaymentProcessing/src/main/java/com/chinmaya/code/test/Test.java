package com.chinmaya.code.test;

import java.util.Arrays;
import java.util.HashSet;

public class Test {

    //Person class - id  and name. create objects and add to the list. convert list to hash map using java streams api.
    //
    //Key - id
    //
    //Value - name / Person object
    //
    //Map<Integer,String> or Map<Integer,Person>


    public static void main(String[] args) {
        Person p1 = new Person(1, "Name1");
        Person p2 = new Person(2, "Name1");
        Person person3 = new Person(3, "Name1");
        Person person4 = new Person(4, "Name1");
        var personList = Arrays.asList(p1, p2, person3, person4);
        HashSet<Person> set= new HashSet<>();
        set.add(p1);
        set.add(p2);


        //var personMap = convertIntohashMap(personList);
        //Find a pair with the given sum in an array
        //
        //Input:
        //
        //
        //
        //nums = [8, 7, 2, 5, 3, 1]
        //
        //target = 10
        //
        //
        //
        //Output:
        //
        //
        //
        //Pair found (8, 2)
        //
        //
        //
        //Pair found (7, 3)
        int[] numArray = new int[]{8, 7, 2, 5, 3, 1};
        int sumTarget = 10;
        sumfunction(numArray, sumTarget);
    }

    private static void sumfunction(int[] numArray, int sumTarget) {
        //int[] newArr = new int[numArray.length];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numArray.length; i++) {
            if(set.contains(numArray[i])){
                System.out.println("With HasSet :: Nums are "+numArray[i] + " & "+ (sumTarget-numArray[i]));
            }
            set.add(sumTarget-numArray[i]);
//            var num = numArray[i];
//            for (int k = 0; k < numArray.length; k++) {
//                int dValue = numArray[k];
//                if (i != k && num + dValue == sumTarget) {
//                    System.out.println("With double foreach ::nums are " + num + "& " + dValue);
//                }
//            }
        }
    }
    // k-heap problem
    // mobile no T9
    //TRIE


}


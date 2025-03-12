package com.chinmaya.code.test;

import io.swagger.v3.oas.models.security.SecurityScheme;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class TestCode {
    public static void main(String[] args) {
        //String word ="rhohttoh";
        //
        //Find first repeated latter
        //
        String word ="swiss";
        Optional<Character> c = nonRepeatedFirstChar(word);
        System.out.println("Billa ka Chuski : "+(c.isEmpty() ? "NONE" : c.get()));

    }
    public static Optional<Character> nonRepeatedFirstChar(String word) {
        //char c = 'a';
        HashSet<Character> seen = new HashSet<>();
        HashMap<Character, Integer> charCountMap = new HashMap<>();

//        Optional.ofNullable(word).stream().forEach(wrd -> {
//            wrd.chars().mapToObj(p -> (char) p).filter(c -> !seen.add(c)).findFirst().stream().forEach(System.out::println);
//        });
//        word.chars().mapToObj(p -> (char) p).forEach(c -> charCountMap.merge(c,1,Integer::sum));
//
//        charCountMap.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().ifPresent(entry -> System.out.println("First non-repeated character: " + entry.getKey()));

        return Optional.ofNullable(word).map(w -> {
        w.chars().forEach(c -> charCountMap.merge((char)c,1, Integer::sum));
        return charCountMap.entrySet().stream().filter(entry -> entry.getValue()==1)
                .map(Map.Entry::getKey).findFirst().orElse(null);
        });
    }

}

package com.chinmaya.code.test;

import java.awt.print.Pageable;
import java.util.HashSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class PS {

    public static void main(String[] args) {
        CompletableFuture<String> x = new CompletableFuture<>();
        synchronized (PS.class)
        {

            HashSet<Integer> set = new HashSet<>();
            Pageable pageable;
            //findByIdStudentId(Sort sort);
        }
    }
}

package com.chinmaya.code.test;

import lombok.Synchronized;

import java.util.HashMap;

public class TestXXX {
//    //1
//    //2 6
//    //3 7 10
//    //4 8 11 13
//    //5 9 12 14 15
//
//
//    // WAP to take a method param as int n, print a triangle having a row equal to n. The triangle pattern must follow a decreasing in line integer values with a gap of 4,3,2,1 and should stop when the pattern gap hits 0 and proceed same way for next row.
//
//    public static void main(String[] args) {
//        var n =5;
//        printTriangle(n);
//    }
//    public static void printTriangle(int n){
//        StringBuilder x = new StringBuilder();
////        int counter=4;
////        int y;
////
////        for(int i=1; i<=n; i++){
////            StringBuilder x = new StringBuilder();
////            int p=n-i;
////            for(int j=i;j<=p;j++)
////                while(counter!=0 ) {
////                    y = j + (counter -= 1);
////                    x.append(j).append(" " + y);
////                }
////
////            System.out.println(x);
//        HashMap<Integer, Object> map = new HashMap<>();
//        for(int i =1; i<=n;i++){
//            int j= i;
//            while(j>0){
//                x.append(j);
//                if(j!=1)
//                    j-=j;
//                x.append(" "+j+(j))
//            }
//        }
//    }

    private static volatile TestXXX INSTANCE;
    private TestXXX(){
        //
    }
    public static TestXXX getInstance() {
        if (INSTANCE == null) {
            synchronized (TestXXX.class) {
                if (INSTANCE == null) {
                    return new TestXXX();
                }
            }
        }
        return INSTANCE;
    }


}

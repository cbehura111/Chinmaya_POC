package com.chinmaya.code.test;

import java.util.*;
import java.util.stream.IntStream;

public class M2PR2 {
    public static void main(String[] args) {
        int[] x = new int[]{1,2};
        int[] y = new int[]{3,6};
        int [][] z= new int[][] {x,y};
        int [][] intervals =new int[][]{new int[] {1,3},new int[]{2,6},new int[]{8,10},new int[]{9,18}};

        //mergeIntervals(intervals);
        var list = Arrays.asList(-2,-4,-3,-2);
        var java8 = list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
        System.out.println("java8 ==== "+java8);
        Set<Integer> treeSet = new TreeSet<>(Comparator.reverseOrder());
        treeSet.addAll(list);
        var withoutJava8 = new ArrayList<>(treeSet);
        System.out.println("set : "+ withoutJava8.get(1));
        var max = list.get(0);
        Integer IIndMax =0 ;
        for(int t=0; t<list.size();t++) {
            var no = list.get(t);
            if (no != max && no > max) {
                IIndMax=max;
                max = no;
            }
        }
        System.out.println("For loop 2nd Max : "+IIndMax);
    }




//    private static void mergeIntervals(int[][] intervals) {
//        intervals = [[1,2],[3,5],[4,8], [6,7],[8,10],[12,16]], newInterval = [4,8]
//        //1,2 // 3,10//12,16
//
//        (n-1) (n-1) log n
//        for(int i =0; i<intervals.length-1 ; i++){
//            for ()
//            if(intervals[i][1] > intervals[i+1][0]){
//                intervals[i][1]=intervals[i+1][1];
//                System.out.println(intervals[i]);
//            }
//        }
//
//    }
}

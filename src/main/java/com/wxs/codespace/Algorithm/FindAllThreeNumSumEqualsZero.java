package com.wxs.codespace.Algorithm;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 第15题
 * 给你一个包含n个整数的数组nums，判断nums中是否存在三个元素a, b, c，是的a+b+c=0?请你找出所有满足条件且不重复的三元组
 */
public class FindAllThreeNumSumEqualsZero {
    private static List<List<Integer>> result = new ArrayList<>();

    private void findTwoNumThatSumEqualsIOfArr(int[] nums, int i){
        if (nums == null || i < 0){
            return;
        }

        int begin = i;
        int move = i+1;
        int end = nums.length-1;

        while (move < end){
            int sum = nums[begin] + nums[end] + nums[move];
            List<Integer> tmpList = Lists.newArrayList(nums[begin], nums[move], nums[end]);
            if (sum == 0 && !result.contains(tmpList)){
                result.add(tmpList);
                ++move;
            }
            else if (sum < 0){
                ++move;
            }
            else {
                --end;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);
        FindAllThreeNumSumEqualsZero f = new FindAllThreeNumSumEqualsZero();
        for (int i = 0;i < nums.length; ++i){
            f.findTwoNumThatSumEqualsIOfArr(nums, i);
        }

        for (List<Integer> list : result){
            System.out.println(list);
        }
    }
}

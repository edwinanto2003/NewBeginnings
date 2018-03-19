package com.edwin.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subset
{
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums)
    {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(new ArrayList<Integer>());
        if(nums.length == 0){
            return lists;
        }
        combine(nums, 0, list, lists);
        return lists;

    }

    private static void combine(int[] nums, int curr, List<Integer> list, List<List<Integer>> lists)
    {
        if(!list.isEmpty())
        {
            lists.add(new ArrayList<Integer>(list));
        }
        if(curr >= nums.length)
        {
            return;
        }
        while(curr < nums.length)
        {
            list.add(nums[curr]);
            combine(nums, curr + 1, list, lists);
            list.remove(list.size() - 1);
            curr++;
        }
    }
}
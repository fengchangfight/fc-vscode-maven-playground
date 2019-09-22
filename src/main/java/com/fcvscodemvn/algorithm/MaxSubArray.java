package com.fcvscodemvn.algorithm;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, -4, 1 };

        // getMaxSumSubArray(arr);

        System.out.println(maxSubArray(arr));

    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int global = nums[0];
        int local = nums[0];
        for (int i = 1; i < nums.length; i++) {
            local = Math.max(nums[i], local + nums[i]);
            global = Math.max(local, global);
        }
        return global;
    }

    public static void getMaxSumSubArray(int[] input) {
        int tempSum = 0;
        int saveTempSum = 0;
        int saveLeft = 0;
        int saveRight = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        boolean newStart = true;
        for (int i = 0; i < input.length; i++) {
            if (input[i] < 0) {
                saveLeft = leftIndex;
                if (newStart == true) {
                    newStart = false;
                    if (tempSum > saveTempSum) {
                        saveTempSum = tempSum;
                        tempSum = 0;
                        saveRight = rightIndex;
                    }
                }
                continue;
            }
            if (newStart == false) {
                newStart = true;
                leftIndex = i;
            }
            tempSum += input[i];

            rightIndex++;
        }

        System.out.println("Left index:" + saveLeft + ",Right index:" + saveRight + ",max sum:" + saveTempSum);
    }
}

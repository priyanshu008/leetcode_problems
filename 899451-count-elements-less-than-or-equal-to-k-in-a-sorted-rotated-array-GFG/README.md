# [Count elements less than or equal to k in a sorted rotated array](https://www.geeksforgeeks.org/problems/count-elements-less-than-or-equal-to-k-in-a-sorted-rotated-array/1)
## Medium
Given a sorted array arr[] containing distinct positive integers that has been rotated at some unknown pivot, and a value x. Your task is to count the number of elements in the array that are less than or equal to x.
Examples: 
Input: arr[] = [4, 5, 8, 1, 3], x = 6Output:&nbsp;4Explanation: 1, 3, 4 and 5 are less than 6, so the count of all elements less than 6 is 4.
Input:&nbsp;arr[] = [6, 10, 12, 15, 2, 4, 5], x = 14Output:&nbsp;6Explanation: All elements except 15 are less than 14, so the count of all elements less than 14 is 6.
Constraints:1 ≤ arr.size() ≤ 1050 ≤ arr[i], x ≤ 109
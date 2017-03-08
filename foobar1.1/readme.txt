I forgot to add the readme for this. But the problem was this. Given an array of integers and a threshold n, remove all instances of numbers in the array that occur more than n times.
Additionally, keep the array in the same order that it was originally.

Test Cases
========

Inputs:
    (int_list) data = [2, 1, 2, 3, 4, 5, 10, 3]
    (int) n = 1
    
Outputs:
    (int_list) [1, 4, 5, 10]
    
Inputs:
    (int_list) data = [10, 12, 10, 14, 9, 8, 7, 2, 13, 201]
    (int) n = 0
    
Outputs:
    (int_list) []

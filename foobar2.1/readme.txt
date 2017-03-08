I forgot to add the readme for this as well. The problem was this:

Given an array of integers, which represent a set of pegs (imagine pegs along a number line), find a configuration of sizes of gears that fit between those pegs such that the last spins twice as quickly as the first.
Return an array of two integers representing the size of the first gear. The first index in this array is the numerator of the size and the second is the denominator. It is possible that there is no possible configuration. In that case return [-1, -1]

Test Cases
==========

Inputs:
    (int_list) pegs = [4, 17, 50]
    
Outputs:
    (int_list) [-1, -1]
    
Inputs:
    (int_list) pegs = [4, 30, 50]
    
Outputs:
    (int_list) [12, 1]

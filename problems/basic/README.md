### <ins>Basic</ins>

- [Frog.hs](Frog.hs) `countJumps` - counts minimal number of jumps from position X to Y.
For example having x = 10, y = 85 and d = 30, the result must be (85 - 10) / 30 = 7.5
- [PythagoreanTriplet.hs](PythagoreanTriplet.hs)  
Euler Problem 9:   
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a^2 + b^2 = c^2   
For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.   
There exists exactly one Pythagorean triplet for which a + b + c = 1000.   
Find the product abc.   
- [Frog.hs](Frog.hs) `earliestTime`   
A small frog wants to get the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river. 
You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.   
The goal is to find earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.   
For example, you are given integer X = 5 and array A such that:   
    A[0] = 1   
    A[1] = 3    
    A[2] = 1     
    A[3] = 4   
    A[4] = 2   
    A[5] = 3   
    A[6] = 5   
    A[7] = 4   
In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.   
Write a function: that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.   
If the frog is never able to jump to the other side of the river, the function should return −1.   

#### Sources
https://www.xarg.org/puzzle/project-euler/problem-9/   
https://dong-xia.medium.com/solving-in-js-frogriverone-ae24684ec882 


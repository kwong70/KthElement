# KthElement
Using a max and min heap to keep track of the k/3 element in a list. (k/3 is arbitrary)

The input will start with n (n <= 1000),
which is the number of values being sent (not including the 0’s). So the input in the above example
will actually look like 
12 500 100 800 1000 1100 300 0 900 1200 600 200 0 700 400

(n = 12) and 0s representing the call to retrieve the kth/3 element, where k is the number of elements added at that time. 

Goal: process the data efficiently in real time. One way to do this is to have a
maxheap with maximum size about n/3 and a minheap with maximum size about 2n/3. After k
values have arrived, the maxheap will have about the k/3 smallest values and the minheap will
have about the 2k/3 largest values. 

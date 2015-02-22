package MinStack;

// my:刚看到题目时想到用一个“指针”指示栈中最小的元素的位置，这样就可以在O(1)的时间内查找栈中的最小值，
// 但仔细一想，若按以上方案做，push、min是没有问题的，但当pop时，若需要pop的正好是那个最小元素，那pop后就需要重新找这个最小点，这时时间复杂度就不会再是O(1)。
// http://blog.csdn.net/ljiabin/article/details/40982153


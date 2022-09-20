/*
 * Task 3: Add at most five JUnit 5 test cases to reveal four distinct program faults in Util.
 * Add comments in each failing test case the line in Util.java that is the root cause of the failure.
 * Make corresponding amendment to the Util_Fixed class.
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class UtilFailingTest {

	private Util_Fixed utilFixed = new Util_Fixed();
	private Util util = new Util();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

	/**
	 * Util.java line:106 num[middle] > num[left]错误
	 * 应改为 num[left] > num[middle] 或 num[middle] > num[right]
	 */
	@Test
	void test_Util_findMinViaRecursion() {
		// get the minimal value of an array through recursion way
		// 通过递归的方法求出数组的最小值
		int[] nums = {5,4,3,2,1};
		int utilMin = util.findMinViaRecursion(nums);
		assertEquals(1, utilMin);
	}

	@Test
	void test_UtilFixed_findMinViaRecursion() {
		// get the minimal value of an array through recursion way
		// 通过递归的方法求出数组的最小值
		int[] nums = {5,4,3,2,1};
		int utilFixedMin = utilFixed.findMinViaRecursion(nums);
		assertEquals(1, utilFixedMin);
	}


	@Test
	void test_Util_findMinViaIteration() {
		// find the minimal value of an array through iteration
		// 通过迭代求出数组的最小值
		int[] nums = {5,4,3,2,1};
		int utilMin = util.findMinViaIteration(nums);
		assertEquals(1, utilMin);
	}

	/**
	 * Util.java line:185 A.length - count + 1	错误
	 * 应改为 A.length - (count + 1) 或 A.length - count - 1
	 */
	@Test
	void test_Util_removeDuplicateElements() {
		// find the minimal value of an array through iteration
		// 通过迭代求出数组的最小值
		int[] nums = {1,1};
		int utilMin = util.removeDuplicateElements(nums);
		assertEquals(1, utilMin);
	}

	@Test
	void test_UtilFixed_removeDuplicateElements() {
		// find the minimal value of an array through iteration
		// 通过迭代求出数组的最小值
		int[] nums = {1,1,1,1,1,2};
		int utilMin = utilFixed.removeDuplicateElements(nums);
		assertEquals(2, utilMin);
	}

	/**
	 * Util.java line:202 nums.length == 1 || nums[0] < s	错误
	 * 应改为 nums.length == 1 || nums[0] > s
	 */
	@Test
	void test_Util_findMinSubArrayLen() {
		// Find the minimal length of a subarray of which the sum is NOT smaller than a given value
		// 求其和不小于给定值的子数组的最小长度
		int[] nums = {1,3,5,7,3};
		int utilMin = util.findMinSubArrayLen(10,nums);
		assertEquals(2, utilMin);
	}

	@Test
	void test_UtilFixed_findMinSubArrayLen() {
		// Find the minimal length of a subarray of which the sum is NOT smaller than a given value
		// 求其和不小于给定值的子数组的最小长度
		int[] nums = {1,3,5,7,3};
		int utilMin = utilFixed.findMinSubArrayLen(10,nums);
		assertEquals(2, utilMin);
	}

	/**
	 * Util.java line:286 if(p==0 || q==0)	错误
	 * 应改为 if((p==0 || q==0) && nums[p] >= nums[q])
	 */
	@Test
	void test_Util_getNextPermutationNumber() {
		// rearranges the integer array such that the new array is the lexicographically next greater permutation of numbers Example: the next permutation of arr = [1,2,3] is [1,3,2] All permutations of {1,2,3} are {{1,2,3} , {1,3,2}, {2,13} , {2,3,1} , {3,1,2} , {3,2,1}}. So, the next permutation just after {1,2,3} is {1,3,2}.
		// 例如:arr =[1,2,3]的下一个排列是[1,3,2]
		// {1,2,3}的所有排列都是{{1,2,3}，{1,3,2}，{2,1,3}，{2,3,1}，{3,1,2}，{3,2,1}。
		// 所以，在{1,2,3}之后的下一个排列是{1,3,2}。

/*
2,1,3	按照从后往前的顺序去找，找到 第一个 左边数字小于右边的数字的 数字 a[ i ]，并记录下来该位置为 i  i=1。
2,1,3	再次从后往前开始寻找(直至遍历到 位置 n 时为止)，找到第一个大于 a[ i ] 的数字 a[ j ] ，记录下来该位置 j=2
2,1,3	二者互换	2,3,1
j=2,没数字了	最后将 a[ j ] 位置之后的数字按照 升序 的顺序重新排列。就得到了我们想要得到的序列。

2,1,3	按照从后往前的顺序去找，找到 第一个 左边数字小于右边的数字的 数字 a[ p ]，并记录下来该位置为 p  p=1。
2,1,3	再次从后往前开始寻找(直至遍历到 位置 n 时为止)，找到第一个大于 a[ p ] 的数字 a[ q ] ，记录下来该位置 q=2
2,1,3	二者互换	2,3,1
j=2,没数字了	最后将 a[ q ] 位置之后的数字按照 升序 的顺序重新排列。就得到了我们想要得到的序列。

1,3,2	按照从后往前的顺序去找，找到 第一个 左边数字小于右边的数字的 数字 a[ p ]，并记录下来该位置为 p  p=0。
1,3,2	再次从后往前开始寻找(直至遍历到 位置 n 时为止)，找到第一个大于 a[ p ] 的数字 a[ q ] ，记录下来该位置 q=2
1,3,2	二者互换	2,3,1	->2,1,3
j=2,没数字了	最后将 a[ q ] 位置之后的数字按照 升序 的顺序重新排列。就得到了我们想要得到的序列。

2,3,1	按照从后往前的顺序去找，找到 第一个 左边数字小于右边的数字的 数字 a[ p ]，并记录下来该位置为 p  p=0。
2,3,1	再次从后往前开始寻找(直至遍历到 位置 n 时为止)，找到第一个大于 a[ p ] 的数字 a[ q ] ，记录下来该位置 q=1
2,3,1	二者互换	3,2,1	->3,1,2
j=2,没数字了	最后将 a[ q ] 位置之后的数字按照 升序 的顺序重新排列。就得到了我们想要得到的序列。
 */
		int[] nums = {1,2,3};
		util.getNextPermutationNumber(nums);
		assertArrayEquals(nums, new int[]{1,3,2});
		util.getNextPermutationNumber(nums);
		assertArrayEquals(nums, new int[]{2,1,3});
		util.getNextPermutationNumber(nums);
		assertArrayEquals(nums, new int[]{2,3,1});
		util.getNextPermutationNumber(nums);
		assertArrayEquals(nums, new int[]{3,1,2});
		util.getNextPermutationNumber(nums);
		assertArrayEquals(nums, new int[]{3,2,1});
		util.getNextPermutationNumber(nums);
		assertArrayEquals(nums, new int[]{1,2,3});
	}

	@Test
	void test_UtilFixed_getNextPermutationNumber() {
		int[] nums = {1,2,3};
		utilFixed.getNextPermutationNumber(nums);
		assertArrayEquals(nums, new int[]{1,3,2});
		utilFixed.getNextPermutationNumber(nums);
		assertArrayEquals(nums, new int[]{2,1,3});
		utilFixed.getNextPermutationNumber(nums);
		assertArrayEquals(nums, new int[]{2,3,1});
		utilFixed.getNextPermutationNumber(nums);
		assertArrayEquals(nums, new int[]{3,1,2});
		utilFixed.getNextPermutationNumber(nums);
		assertArrayEquals(nums, new int[]{3,2,1});
		utilFixed.getNextPermutationNumber(nums);
		assertArrayEquals(nums, new int[]{1,2,3});
	}

	/**
	 * Util.java line:323 int min = Integer.MAX_VALUE;	错误
	 * 应改为 int min = Integer.MIN_VALUE;
	 */
	@Test
	void test_Util_threeSumClosest() {
		// Select 3 numbers from an array such that their sum value is closest to the target value
		// 从数组中选择3个数字 它们的总和最接近目标值
		int[] nums = {3,2,1};
		int count = util.threeSumClosest(nums, 5);
		assertEquals(6, count);
	}

	@Test
	void test_UtilFixed_threeSumClosest() {
		// Select 3 numbers from an array such that their sum value is closest to the target value
		// 从数组中选择3个数字 它们的总和最接近目标值
		int[] nums = {3,2,1};
		int count = utilFixed.threeSumClosest(nums, 5);
		assertEquals(6, count);
	}
}

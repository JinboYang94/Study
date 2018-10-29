package test;

/*
 * 给定整数n，取若干个1到n的整数可求和等于整数m，
 * 编程求出所有组合的个数。比如当n=6，m=8时，
 * 有四种组合：[2,6], [3,5], [1,2,5], [1,3,4]。
 * 限定n和m小于120 
 */

import java.util.*;

public class sumOfInteger{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		if (n >= 120 || m >= 120)
			System.exit(1);      // 
		System.out.println(getSum(n,m));
		input.close();
	}
    // 01 knapsack problem
	public static int getSum(int n, int m){
		// transform m<=n to m>n
		if(m<1||n<1)
			return 0;
		if(m<n)
			n=m;
		int sum = 0;
		if(m==n)
			sum++;
		// compute for m>n
		sum+=getSum(n-1,m);
		sum+=getSum(n-1,m-n);
		return sum;
	}
}
/* 
 * 分析：dynamic programming
 * 把用1~n中的数（不重复）表示m，
 * 分解为3种情况
 * m<=n时，(a)n=[1,m-1],此时f=[m-1][m]
 *         (b)n=m,此时f=1
 *         (c)n=[m+1,n],此时f=0,因为不存在比m小的n,那就无法相加为m
 * 此时结果集为： f=[m-1][m]+1
 * m>n时，  (a)n不参加构成m,此时f=[n-1][m]
 *         (b)n参加构成m,此时f=[n-1][m-n]
 * 此时结果集为： f=[n-1][m]+[n-1][m-n]
 * 这种做法：把m<n的情况变成了m>n的计算方法
 *           m<n时,[m-1][m]，故把n=m，则[n-1][m],这与后面m>n时(a)相同
 *           m=n时,sum+1表示m>n中(b)情形           
 *           则无论输入多少,都有相同的计算方法                 
 */

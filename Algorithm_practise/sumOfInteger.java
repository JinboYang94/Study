package test;

/*
 * ��������n��ȡ���ɸ�1��n����������͵�������m��
 * ������������ϵĸ��������統n=6��m=8ʱ��
 * ��������ϣ�[2,6], [3,5], [1,2,5], [1,3,4]��
 * �޶�n��mС��120 
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
 * ������dynamic programming
 * ����1~n�е��������ظ�����ʾm��
 * �ֽ�Ϊ3�����
 * m<=nʱ��(a)n=[1,m-1],��ʱf=[m-1][m]
 *         (b)n=m,��ʱf=1
 *         (c)n=[m+1,n],��ʱf=0,��Ϊ�����ڱ�mС��n,�Ǿ��޷����Ϊm
 * ��ʱ�����Ϊ�� f=[m-1][m]+1
 * m>nʱ��  (a)n���μӹ���m,��ʱf=[n-1][m]
 *         (b)n�μӹ���m,��ʱf=[n-1][m-n]
 * ��ʱ�����Ϊ�� f=[n-1][m]+[n-1][m-n]
 * ������������m<n����������m>n�ļ��㷽��
 *           m<nʱ,[m-1][m]���ʰ�n=m����[n-1][m],�������m>nʱ(a)��ͬ
 *           m=nʱ,sum+1��ʾm>n��(b)����           
 *           �������������,������ͬ�ļ��㷽��                 
 */

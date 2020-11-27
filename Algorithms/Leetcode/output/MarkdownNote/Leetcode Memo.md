# Leetcode Memo

### 1 ~ 100

#### 1. Two Sum (Easy)

> 给定一个数组nums和一个目标和target，从数组中找出两个数字相加等于目标和，并返回它们的下标值

```java
class Solution {
    
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }
    }
    throws new IllegalArgumentException("Invalid Argument.")
  }
}
```

> 总结：brute force，最简单的思路就是brute force直接遍历完事
>

> Time complexity: O(n^2)
>
> Space complexity: O(1)

#### 2. Add Two Numbers (Medium)

>给定两个非空linked list代表两个非负integer，并且linked list中是以逆序存储integer的，每一个node包含一个digit，要求把两者相加并返回成上述linked list形式(即返回值也是逆序存储)

```java
class ListNode {
    
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode output = dummy;
    int carry = 0;
    
    while (l1 != null || l2 != null) {
      int a = (l1 == null) ? 0 : l1.val;
      int b = (l2 == null) ? 0 : l2.val;
      int sum = a + b + carry;
      
      carry = sum / 10;
      output.next = new ListNode(sum % 10);
      output = output.next;
      
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
      if (carry != 0) {
        output.next = new ListNode(1);
      }
    }
    return dummy.next;
  }
}
```

> 总结：设立一个dummy node，然后output作为输出数组，遍历整个l1和l2并把每一位取出，算出carry和mod，carry留给下一次循环，mod则加入output的下个node中储存
>

> Time complexity: O(max(m, n))，m和n分别代表l1和l2的length，循环体循环max(m, n)次
>
> Space complexity: O(max(m, n))，同上，new LinkedList的大小最多是max(m, n) + 1，有个dummy head

#### 3. Longest Substring Without Repeating Characters (Medium)

>给定一个字符串，找到没有重复字符的最长子字符串，返回其长度

```java
class Solution {
    
  public int lengthOfLongestSubstring(String s) {
    int ans = 0;
    for (int i = 0; i < s.length(); i++) {
      ArrayList<Character> temp = new ArrayList<>();
      int j = i;
      while (j < s.length() && !temp.contains(s.charAt(j))) {
        temp.add(s.charAt(j));
        j++;
      }
      ans = Math.max(ans, j - i); // 与上一次的ans比较，取较大值为新ans
    }
    return ans;
  }
}
```

>总结：two pointer，遍历整个String的每一个character，对每个character再开始往后遍历，用一个ArrayList来存每一个遇到的不重复的character，这样遇到重复时就会跳出，两个pointer相减即可
>

> Time complexity: O(n^2)，因为worst case下for遍历完所有字母while也要遍历完所有字母
>
> Space complexity: O(n^2)，因为每个字母都有新建的ArrayList，而ArrayList最多占用n大小的extra space

#### 4. Median of Two Sorted Arrays (Hard)

> 给定两个有序数组长度分别为m和n，找到这两个数组的中间数，时间复杂度限制为O(log(m + n))

````java
class Solution {
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        if (a > b) {	// 保证nums1.length < nums2.length
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int temp2 = a;
            a = b;
            b = temp2;
        }
        
        int min = 0;
        int max = a;
        int half = (a + b + 1) / 2;	// 总数组一半的长度
        while (min <= max) {
            int i = (min + max) / 2;	// i用来分割nums1数组成左右两部分
            int j = half - i;	// j用来分割nums2数组成左右两部分
            if (i < max && nums2[j - 1] > nums1[i]) {	// i too small(nums2的左边大于nums1的右边)
                min = i + 1;
            } else if (i > min && nums1[i - 1] > nums2[j]) {  //i too big(nums1的左边大于nums2的右边)
                max = i - 1;
            } else {	// perfect i
                int maxL;	// 总数组左边最大值
                if (i == 0) {	// case1: nums1没有在左边部分的
                    maxL = nums2[j - 1];
                } else if (j == 0) {	// case2: nums2没有在左边部分的
                    maxL = nums1[i - 1];
                } else {
                    maxL = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((a + b) % 2 == 1) {	// 如果总数组长度是奇数，则这就是median
                    return maxL;
                }
                
                int minR;	// 总数组右边最大值
                if (i == a) {
                    minR = nums2[j];
                } else if (j == b) {
                    minR = nums1[i];
                } else {
                    minR = Math.min(nums1[i], nums2[j]);
                }
                return (double) (maxL + minR) / 2;	// 总数组长度偶数，则median为两者平均数
            }
        }
        return 0.0;
    }
}
````

>总结：数学方法，要找median，则要把两个有序数组都分为两半，然后在中间处找median。此时关注nums1，把它分割成如下示意: nums1[0]...nums1[i - 1] | nums1[i]...nums[len - 1]和nums2[0]...nums2[j - 1] | nums2[j]...nums2[len - 1]，保证nums2[j] > nums1[i - 1] && nums1[i] > nums2[j - 1]即保证nums2的右边比1的左边大 && nums1的右边比2的左边大，这时i, j就是完美划分两个数组的index，求median就可以了

> Time complexity: O(log(min(m, n))，因为是binary search，所以是较小数组的log级别复杂度
>
> Space complexity: O(1)

#### 5. Longest Palindromic Substring (Medium)

> 给定一个String s，找到s的最长回文子串

````java
class Solution {
    
    public String longestPalindrome(String s) {
        String ans = "";
        if (s == null || s.length() == 0) {
            return ans;
        }
        
        String ans1 = "";
        String ans2 = "";
        for (int i = 0; i < s.length(); i++) {	// 对每一个s中的字母
            // 结果是奇数长度substring，则回文以一个字母为中心，如bab
            String oneCenter = checkPanlindrome(s, i, i);
            if (oneCenter.length() > ans1.length()) {
                ans1 = oneCenter;
            }
            // 结果是偶数长度substring，则回文以两个字母为中心，如abba
            String twoCenter = checkPanlindrome(s, i, i + 1);
            if (twoCenter.length() > ans2.length()) {
                ans2 = twoCenter;
            }
            // 谁更长是谁
            if (ans1.length() > ans2.length()) {
                ans = ans1;
            } else {
                ans = ans2;
            }
        }
        return ans;    
    }
    
    // 检查是否为回文并返回以此为中心的最长回文
    private String checkPanlindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right); // 因为substring()包含begin index, 不包含end index
    }
}
````

> 总结：中心扩展法，回文的特性就是以一个或两个字母为中心，左右对称。所以对这两种情况分别考虑，对s中的每个字母，分别判断以它和它的下一个字母为中心的最长回文是什么，取较长的一个更新为ans。一直loop到最后得到的ans就是最长的回文串

> Time complexity: O(n^2)，checkPanlindrome()最多用O(n)，所以for loop内的check最多O(n * n)
>
> Space complexity: O(1)

#### 6. ZigZag Conversation (Medium)

> 给定一个String s和int numRows，要求把s以zigzag(锯齿状)写出后再按行读取成一个新String，先下后上的锯齿，写成numRows行

````java
class Solution {
    
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // 对每一行new一个StringBuilder，并将它们存在List中
        List<StringBuilder> eachRow = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
           eachRow.add(new StringBuilder()); 
        }
        
        int currRow = 0;	// 现在是第几行
        boolean down = false;	// zigzag的方向
        // 把s中每个字母按行数currRow存到List中对应的位置
        for (char c : s.toCharArray()) {
            eachRow.get(currRow).append(c);
            // 当到底或到顶，则逆转方向
            if (currRow == numRows - 1 || currRow == 0) {
                down = !down;
            }
            // 更新行数
            currRow += down == true ? 1 : -1;
        }
        // 处理结果成String
        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : eachRow) {
            ans.append(sb);
        }
        return ans.toString();
    }
}
````

> 总结：按行排列，模拟ZigZag的过程，用List保存每一行结果，用currRow来track当前行数，用down来确认当前遍历方向以更新currRow

> Time complexity: O(n)，n是s的length
>
> Space complexity: O(n)，保存每个字符都需要空间

#### 7. Reverse Integer (Easy)

> 给一个32 bit有符号的integer，反转其数字部分，但是像120就反转成21

````java
class Solution {
    
    public int reverse(int x) {
        boolean sign;
        if (x == Math.abs(x)) {
            sign = true;
        } else {
            sign = false;
            x = Math.abs(x);
        }
        
        StringBuilder sb = new StringBuilder();
        char[] charArray = Integer.toString(x).toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            sb.append(charArray[i]);
        }
        // 判断溢出
        try {
            if (sign) {
                return Integer.valueOf(sb.toString());
            } else {
                return -1 * Integer.valueOf(sb.toString());
            }
        } catch (IllegalArgumentException e) {
            return 0;
        }
    }
}
````

> 总结：很简单的转换成char数组再逆序组成新String，主要是判断溢出时，用try-catch来返回正确值

> Time complexity: O(n)
>
> Space complexity: O(n)，char[]与int x的长度有关

````java
class Solution {
    
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int mod = x % 10;	// 取mod得当前x的个位数
            x = x / 10;	// 更新x，去除个位
            // 溢出判断
            if (ans > Integer.MAX_VALUE / 10 || ans < Integer.MIN_VALUE / 10) {
                return 0;
            }
            ans = 10 * ans + mod;
        }
        return ans;
    }
}
````

> 总结：同样很简单的数学操作，在溢出判断上，讨论如下: 1. 此时的ans > Integer.MAX_VALUE / 10了， 则下一步 * 10肯定溢出；2. 此时ans == Integer.MAX_VALUE / 10，则2147483647 / 10 = 214748364，* 10后要求mod不能大于7，但是如果mod大于7那原数字x就是8463847412已经溢出，则不可能；3. 此时ans < Integer.MAX_VALUE / 10，则下一步 * 10 + mod肯定不会溢出

> Time complexity: O(log(n))，while中循环次数为n * (1 / 10) ^ t != 0，10 ^ t = n，t = log10(n) = log(n)，n为x的值       大小
>
> Space complexity: O(1)

#### 8. String to Integer (Medium)

> 给一个String str，把它转成integer，要求从左遍历str，无视空格，直到遇到+/-/数字开始转换，然后再遇到任何非数字就结束转换，如果遇到转换开始条件前出现了其他字符如ba1234就return 0，要是转换结果溢出就返回max/min

````java
class Solution {
    
    public int myAtoi(String str) {
        int ans = 0;
        int sign = 1;
        boolean started = false;	// 表示是否开始转换
        for (int i = 0; i < str.length(); i++) {
            // 空格
            if (started == false && str.charAt(i) == ' ') {
                continue;
            }
            // +号
            if (started == false && str.charAt(i) == '+') {
                started = true;
                continue;
            }
            // -号
            if (started == false && str.charAt(i) == '-') {
                started = true;
                sign = -1;
                continue;
            }
            // 数字
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                started = true;
                int curr = str.charAt(i) - '0';
                if (sign * ans > Integer.MAX_VALUE / 10 
                    || (sign * ans == Integer.MAX_VALUE / 10 && sign * curr > 7)) {
                    return Integer.MAX_VALUE;
                }
                if (sign * ans < Integer.MIN_VALUE / 10 
                   || (sign * ans == Integer.MIN_VALUE / 10 && sign * curr < -8)) {
                    return Integer.MIN_VALUE;
                }
                ans = ans * 10 + curr;
            } else {	// 遇到非数字quit loop
                return sign * ans;
            }
        }
        return sign * ans;
    }
}
````

> 总结：没什么特别的，if-else练习

> Time complexity: O(n)
>
> Space complexity: O(1)

#### 9. Palindrome Number (Easy)

> 判断一个integer是不是回文，标准是左到右读与右到左读一样，所以负数都不是(有-号)

````java
class Solution {
    
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            char[] charArray = Integer.toString(x).toCharArray();
            for (int i = charArray.length - 1; i >= 0; i--) {
                sb.append(charArray[i]);
            }
            String str = Integer.toString(x);
            if (sb.toString().equals(str)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
````

> 总结：最简单的办法换成String比较

> Time complexity: O(n)
>
> Space complexity: O(n)，有new StringBuilder

````java
class Solution {
    
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            // 得到总位数，不能直接用x
            int digits = 0;
            int temp = x;
            while (temp > 0) {
                temp /= 10;
                digits++;
            }
            // 反转x右半边
            int right = 0;
            for (int i = 0; i < digits / 2; i++) {
                int mod = x % 10;
                x = x / 10;
                right = right * 10 + mod;
            }
            // x是奇数长度，则再把右边的 / 10来符合，如121，右边反转为1，则剩余x = 12除10去掉最后一位 = 1
            if (digits % 2 == 1 && x / 10 == right) {
                return true;
            }
            // x是偶数长度，直接比较，如1221，右边反转为12，剩余x = 12
            if (digits % 2 == 0 && x == right) {
                return true;
            }
        }
        return false;
    }
}
````

> 总结：follow up要求不转成String做，这里可以用之前的reverse方法，也可以这样只反转x的右半边，跟剩余的x(此时也就是原x的左半边)比较

> Time complexity: O(log(n))，因为while中n * (1 / 10) ^ t > 0，t = log10(n) = log(n)，这就是最高复杂度了，for中是log(n / 2) = log(n)一样
>
> Space complexity: O(1)

#### 10. Regular Express Matching (Hard)

> 给定两个String s和p，按规则判断这两个String是否匹配。s为正常全小写字符串，p中则有" . "和" * "，" . "可以代替任何一个字符，" * " 只能代替空格或前一个字符

````java
class Solution {
    
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        boolean[0][0] = true;
        
        for ()
    }
}
````


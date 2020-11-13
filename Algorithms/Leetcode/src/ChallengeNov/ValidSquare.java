package ChallengeNov;

import java.util.HashSet;
import java.util.Set;

class ValidSquare {

  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    int[][] p = {p1, p2, p3, p4};
    return checkAll(p, 0);
  }

  private int dist(int[] a, int[] b) {
    return (int) Math.sqrt((b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]));
  }

  private boolean validate(int[] p1, int[] p2, int[] p3, int[] p4) {
    return dist(p1, p2) > 0 && dist(p1, p2) == dist(p2, p3) && dist(p2, p3) == dist(p3, p4) 
    && dist(p3, p4) == dist(p4, p1) && dist(p1, p3) == dist(p2, p4);
  }

  private boolean checkAll(int[][] p, int start) {
    // heap algorithm for permutation: A = [1, 2] 
    // 调用了swap(array, 0,0)然后调用perm(array, 1)
    //    调用swap(array, 1, 1)然后调用perm(array, 2)，然后在if里面2 == 2成立，打印[1, 2]
    // 　 调用swap(array, 1,1)把之前交换的swap(array,1,1)复原，虽然看起来没有变化
    // 回到上一层
    // 调用swap(array, 0, 1) 然后调用perm(array, 1)
    //    调用swap(array, 1, 1)然后调用perm(array, 2)，然后在if里面2 == 2成立，打印[2, 1]
    //    调用swap(array, 1,1)把之前交换的swap(array,1,1)复原，虽然看起来没有变化
    // 回到上一层
    // 跳出循环，程序结束。
    // [1, 2, 3]同理：
    // 调用了swap(array, 0,0)然后调用perm(array, 1)
    // 　　然后对[2, 3]进行全排列，其中输出[1,2,3]， [1, 3, 2]
    // 再次调用swap(array,0,0)复原
    // 调用了swap(array, 0,1)然后调用perm(array, 1)
    // 　　然后对[1,3]进行全排列，输出[2,1,3], [2,3,1]
    // 再次调用swap(array,0,1)复原
    // 调用了swap(array, 0,2)然后调用perm(array, 1)
    // 　　然后对[2,1]进行全排列，输出[3,2,1], [3,1,2]
    // 再次调用swap(array,0,2)复原

    if (start == 4) {
      return validate(p[0], p[1], p[2], p[3]);
    } else {
      boolean ret = false;
      for (int i = start; i < 4; i++) {
        swap(p, i, start);
        ret |= checkAll(p, start + 1);
        swap(p, i, start);
      }
      return ret;
    }
  }

  private void swap(int[][] p, int a, int b) {
    int[] temp = p[a];
    p[a] = p[b];
    p[b] = temp;
  }
}

class ValidSquare2 {

  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    // avoid same points
    if (p1[0] == p2[0] && p1[1] == p2[1] || p1[0] == p3[0] && p1[1] == p3[1] || p1[0] == p4[0] && p1[1] == p4[1]
    || p2[0] == p3[0] && p2[1] == p3[1] || p2[0] == p4[0] && p2[1] == p4[1] || p3[0] == p4[0] && p3[1] == p4[1]) {
      return false;
    }
    Set<Integer> set = new HashSet<>();
    int dist12 = dist(p1, p2);
    int dist13 = dist(p1, p3);
    int dist14 = dist(p1, p4);
    int dist23 = dist(p2, p3);
    int dist24 = dist(p2, p4);
    int dist34 = dist(p3, p4);
    set.add(dist12);
    set.add(dist13);
    set.add(dist14);
    set.add(dist23);
    set.add(dist24);
    set.add(dist34);
    if (set.size() == 2) {
      return true;
    } else {
      return false;
    }
  }

  private int dist(int[] a, int[] b) {
    return (b[1] - a[1]) * (b[1] - a[1]) + (b[0] - a[0]) * (b[0] - a[0]);
  }
}
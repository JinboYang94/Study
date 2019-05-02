import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import java.util.Iterator;

/**
 * Requirements:
 * The running time of Permutation must be linear in the size of the input.
 * You may use only a constant amount of memory plus either one Deque or
 * RandomizedQueue object of maximum size at most n. (For an extra challenge,
 * use only one Deque or RandomizedQueue object of maximum size at most k.)
 */

public class Permutation {

  public static void main(String[] args) {
    int k = Integer.parseInt(args[0]);
    RandomizedQueue<String> rand = new RandomizedQueue<>();
    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();
      rand.enqueue(s);
    }
    for (int i = 0; i < k; i++) {
      System.out.println(rand.dequeue());
    }
    // for independent iterator testing.
//    RandomizedQueue<Integer> rand = new RandomizedQueue<>();
//    rand.enqueue(2);
//    rand.enqueue(3);
//    rand.enqueue(4);
//    rand.enqueue(1);
//    rand.enqueue(8);
//    Iterator<Integer> it = rand.iterator();
//    Iterator<Integer> it2 = rand.iterator();
//    while (it.hasNext()) {
//      System.out.println("it" + it.next());
//    }
//
//    while (it2.hasNext()) {
//      System.out.println("it2" + it2.next());
//    }
    // for Deque testing
//    int k = Integer.parseInt(args[0]);
//    Deque<Integer> dq = new Deque<>();
//    while (!StdIn.isEmpty()) {
//      String s = StdIn.readString();
//      dq.addFirst(s);
//    }
//    for (int i = 0; i < k; i++) {
//      System.out.println(dq.removeLast());
//    }
//    System.out.println(dq.size());
//    dq.addFirst(1);
//    dq.addFirst(2);
//    System.out.println(dq.removeFirst());
//    System.out.println(dq.isEmpty());
//    System.out.println(dq.removeLast());
//    dq.addFirst(6);
//    System.out.println(dq.isEmpty());
//    System.out.println(dq.removeLast());
//    System.out.println(dq.iterator().next());
  }
}

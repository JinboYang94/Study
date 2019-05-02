import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Requirements:
 *  Your deque implementation must support each deque operation (including construction)
 *  in constant worst-case time.
 *  A deque containing n items must use at most 48n + 192 bytes of memory
 *  and use space proportional to the number of items currently in the deque.
 *  Additionally, your iterator implementation must support each operation (including construction)
 *  in constant worst-case time.
 *  Tag: Because need constant worst-case time, choose LinkedList implementation.
 *       Also because it requires add and delete from both sides, use doubly LinkedList.
 * @param <Item> a generic data type.
 */
public class Deque<Item> implements Iterable<Item> {

  // global variables, head here means front, tail here means back.
  private int size;
  private final Node head;
  private final Node tail;

  /**
   * Definition of Node which has value and two pointers to previous and next Node.
   */
  private class Node {
    Item item;
    Node prev;
    Node next;

    public Node(Item item, Node prevN, Node nextN) {
      this.item = item;
      this.prev = prevN;
      this.next = nextN;
    }
  }

  /**
   * The constructor of the {@link Deque} data structure, which has two {@link Node}s head and
   * tail, representing two virtual pointers in the Deque(actually a doubly LinkedList).
   */
  public Deque() {
    head = new Node(null, null, null);
    tail = new Node(null, null, null);
    head.prev = null;
    head.next = tail;
    tail.prev = head;
    tail.next = null;
    size = 0;
  }

  /**
   * Is the {@link Deque} empty or not.
   * @return true if the {@link Deque} is empty.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * The size of the {@link Deque}(how many items it contains).
   * @return the size of the {@link Deque}.
   */
  public int size() {
    return size;
  }

  /**
   * Add the item to the front of a {@link Deque} data structure.
   * @param item a generic data type.
   */
  public void addFirst(Item item) {
    validate(item);
    add(item, head, head.next);
    size++;
  }

  /**
   * Add the item to the last of a {@link Deque} data structure.
   * @param item a generic data type.
   */
  public void addLast(Item item) {
    validate(item);
    add(item, tail.prev, tail);
    size++;
  }

  /**
   * Remove and return the first item which should be at the front of a {@link Deque}.
   * @return a generic data type {@link Item}.
   */
  public Item removeFirst() {
    validate();
    Item item = head.next.item;
    head.next.next.prev = head;
    head.next = head.next.next;
    size--;
    return item;
  }

  /**
   * Remove and return the last item which should be at the tail of a {@link Deque}.
   * @return a generic data type {@link Item}.
   */
  public Item removeLast() {
    validate();
    Item item = tail.prev.item;
    tail.prev.prev.next = tail;
    tail.prev = tail.prev.prev;
    size--;
    return item;
  }

  /**
   * A new {@link Iterator} for {@link Deque} data structure.
   * @return the actual {@link Iterator}.
   */
  public Iterator<Item> iterator() {
    return new myIterator();
  }

  /**
   * The customized {@link Iterator} for {@link Deque} data structure.
   */
  private class myIterator implements Iterator<Item> {

    Node temp = head.next;

    @Override
    public boolean hasNext() {
      return temp != tail;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException("No next node available!");
      }
      temp = temp.next;
      return temp.prev.item;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("remove");
    }
  }

  /**
   * Add item between two {@link Node}s.
   * @param item a generic data type.
   * @param prev the previous {@link Node}.
   * @param next the next {@link Node}.
   */
  private void add(Item item, Node prev, Node next) {
    Node temp = new Node(item, prev, next);
    prev.next = temp;
    next.prev = temp;
  }

  /**
   * Check the argument is valid or not. According to requirements, it cannot be null.
   * @param item a generic data type.
   * @throws java.lang.IllegalArgumentException if the {@link Item} is null.
   */
  private void validate(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Argument cannot be null!");
    }
  }

  /**
   * Check the {@link Deque} is empty or not. Cannot call remove method when isEmpty().
   * @throws java.util.NoSuchElementException if the {@link Deque} is empty.
   */
  private void validate() {
    if (isEmpty()) {
      throw new NoSuchElementException("The deque is empty!");
    }
  }
}

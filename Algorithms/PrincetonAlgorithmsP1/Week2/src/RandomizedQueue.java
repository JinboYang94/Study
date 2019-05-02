import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Requirements:
 * Your randomized queue implementation must support each randomized queue operation
 * (besides creating an iterator) in constant amortized time.
 * That is, any sequence of m randomized queue operations (starting from an empty queue)
 * must take at most cm steps in the worst case, for some constant c.
 * A randomized queue containing n items must use at most 48n + 192 bytes of memory.
 * Additionally, your iterator implementation must support operations next() and hasNext()
 * in constant worst-case time; and construction in linear time;
 * you may (and will need to) use a linear amount of extra memory per iterator.
 * Tag: Because need constant amortized time complexity, choose resizing array implementation.
 * @param <Item> a generic data type.
 */

public class RandomizedQueue<Item> implements Iterable<Item> {

  // global variables, array.length means the size of queue, size means the num of items.
  private int size;
  private Item[] array;

  /**
   * The constructor of {@link RandomizedQueue} data structure, which uses an array to store
   * the {@link Item}s.
   */
  public RandomizedQueue() {
    this.array = (Item[]) new Object[1];
    this.size = 0;
  }

  /**
   * Is the {@link RandomizedQueue} empty or not.
   * @return true if the {@link RandomizedQueue} is empty.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * The size of the {@link RandomizedQueue}(how many items in it).
   * @return the size of the {@link RandomizedQueue}.
   */
  public int size() {
    return size;
  }

  /**
   * Add the item.
   * @param item a generic data type.
   */
  public void enqueue(Item item) {
    validate(item);
    if (size == array.length) {
      resize(array.length * 2);
    }
    array[size++] = item;
  }

  /**
   * Remove and return a random item.
   * @return a generic data type value.
   */
  public Item dequeue() {
    validate();
    int random = StdRandom.uniform(size);
    Item ans = array[random];
    array[random] = array[size - 1];
    array[size - 1] = null;
    size--;
    if (size > 0 && size ==  array.length / 4) {
      resize(array.length / 2);
    }
    return ans;
  }

  /**
   * Return but not remove a random item.
   * @return
   */
  public Item sample() {
    validate();
    int random = StdRandom.uniform(size);
    Item ans = array[random];
    return ans;
  }

  /**
   * A new {@link Iterator} for {@link RandomizedQueue} data structure.
   * @return the actual {@link Iterator}.
   */
  public Iterator<Item> iterator() {
    return new myRandomIterator();
  }

  /**
   * The customized {@link Iterator} for {@link RandomizedQueue} data structure.
   */
  private class myRandomIterator implements Iterator<Item> {
//    here we can use this method(permutation), same logic inside:
//    but one thing should notice, in next() we should use array[randomArray[index]] instead of
//    array[index] to make sure two iterator independent, because index are fixed. Absolutely
//    StdRandom.shuffle() is the key reason the two iterator independent.

//    private int[] randomArray = StdRandom.permutation(size);
//    private int index = 0;
    private int[] randomArray;
    private int index;

    public myRandomIterator() {
      this.randomArray = new int[size];
      for (int i = 0; i < size; i++) {
        randomArray[i] = i;
      }
      StdRandom.shuffle(randomArray);
      this.index = 0;
    }

    @Override
    public boolean hasNext() {
      return index != randomArray.length;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException("No next item available!");
      }
      Item curr = array[randomArray[index]];
      index++;
      return curr;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("remove");
    }
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
   * Check the {@link RandomizedQueue} is valid or not.
   * @throws java.util.NoSuchElementException if the {@link RandomizedQueue} is empty.
   */
  private void validate() {
    if (isEmpty()) {
      throw new NoSuchElementException("Randomized queue is empty!");
    }
  }

  /**
   * Resize the array if the the {@link RandomizedQueue} is full.
   * @param capacity the target capacity of array.
   */
  private void resize(int capacity) {
    // Item[] temp = (Item[]) new Objects[capacity];
    Item[] temp = Arrays.copyOf(array, capacity);
    array = temp;
  }
}

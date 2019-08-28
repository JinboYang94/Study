import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 * otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * The cache is initialized with a positive capacity.
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * <p>
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 /* capacity * / );  // no space between  * and /
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * </p>
 */

class Leetcode146 {

  private Map<Integer, DoublyLinkedList> cache = new HashMap<>();
  private DoublyLinkedList head;
  private DoublyLinkedList tail;
  private int cachedNode;
  private int maxCap;

  /**
   * Define a Doubly-LinkedList.
   */
  private class DoublyLinkedList {
    int key;
    int value;
    DoublyLinkedList pre;
    DoublyLinkedList next;
  }

  /**
   * Constructor.
   * @param capacity  max capacity of this cache data structure.
   */
  public Leetcode146(int capacity) {
    this.cachedNode = 0;
    this.maxCap = capacity;

    head = new DoublyLinkedList();
    head.pre = null;
    tail = new DoublyLinkedList();
    tail.next = null;
    head.next = tail;
    tail.pre = head;
  }

  /**
   * Retrieve from cache.
   * @param key an int value regarded as index.
   *
   * @return  the value correspond to the key, -1 if no such key in cache.
   */
  public int get(int key) {
    DoublyLinkedList node = cache.get(key);
    if (node == null) {
      return -1;
    }
    moveToHead(node);
    return node.value;
  }

  /**
   * Insert to cache.
   * @param key an int value regarded as index.
   * @param value the value of this node.
   */
  public void put(int key, int value) {
    DoublyLinkedList node = cache.get(key);
    if (node == null) {
      if (cachedNode == maxCap) {
        removeCache();
      }
      DoublyLinkedList toBeAdded = new DoublyLinkedList();
      toBeAdded.key = key;
      toBeAdded.value = value;
      cache.put(key, toBeAdded);
      addNode(toBeAdded);
      cachedNode++;
    } else {
      node.value = value;
      moveToHead(node);
    }
  }

  /**
   * Move node to the front of cache.
   * @param node  a node in LinkedList.
   */
  private void moveToHead(DoublyLinkedList node) {
    removeNode(node);
    addNode(node);
  }

  /**
   * Remove node from Doubly-LinkedList.
   * @param node  a node in LinkedList.
   */
  private void removeNode(DoublyLinkedList node) {
    DoublyLinkedList pre = node.pre;
    DoublyLinkedList next = node.next;

    pre.next = next;
    next.pre = pre;
  }

  /**
   * Add node into cache in the front, if exists, replace the original value.
   * @param node  a node in LinkedList.
   */
  private void addNode(DoublyLinkedList node) {
    DoublyLinkedList temp = head.next;
    head.next = node;
    node.pre = head;
    node.next = temp;
    temp.pre = node;
  }

  /**
   * Remove least recently used node from both HashMap and LinkedList.
   */
  private void removeCache() {
    DoublyLinkedList last = tail.pre;
    removeNode(last);
    cache.remove(last.key);
    cachedNode--;
  }
}

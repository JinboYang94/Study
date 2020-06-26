package LeetcodeProblems;

/**
 * Merge sort algorithm. Top-down approach(recursive) and bottom-up approach(iterative).
 * recursive will use O(N + log(N)) space complexity, ? iterative will use O(1).
 */

class MergeSort {

  // recursive
  public void mergeSort(int[] array, int low, int high) {
    int mid = low + (high - low) / 2;
    if (low < high) {
      mergeSort(array, low, mid);
      mergeSort(array, mid + 1, high);
      merge(array, low, mid, high);
    }
  }

  // iterative
  public void mergeSort2(int[] array) {
    int len = array.length;
    int k = 1;

    while (k < len) {
      mergePass(array, k ,len);
      k *= 2;
    }
  }

  // merge two adjacent subarray
  private void mergePass(int[] array, int k, int len) {
    int i = 0;
    // from start, merge two subarray(length == k) into one array
    while (i < len - 2 * k + 1) {
      merge(array, i, i + k - 1, i + 2 * k - 1);
      i += 2 * k;
    }
    // this guarantee the lonely part(length not enough k) be merged to previous array
    if (i < len - k) {
      merge(array, i, i + k - 1, len - 1);
    }
  }

  private void merge(int[] array, int low, int mid, int high) {
    int[] temp = new int[high - low + 1];
    int i = low;  // left part pointer
    int j = mid + 1;  // right part pointer
    int k = 0;  // new array after merged index

    while (i <= mid && j <= high) {
      if (array[i] < array[j]) {
        temp[k++] = array[i++];
      } else {
        temp[k++] = array[j++];
      }
    }
    // handle odd number of elements, add the redundant one into array
    while (i <= mid) {
      temp[k++] = array[i++];
    }
    while (j <= high) {
      temp[k++] = array[j++];
    }
    // update to original array
    for (int l = 0; l < temp.length; l++) {
      array[low + l] = temp[l];
    }
  }
}

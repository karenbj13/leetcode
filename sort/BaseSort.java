package sort;

/**
 * @Description
 * @Author qiujiaojiao
 * @Create 2019-03-31 上午11:57
 **/
public class BaseSort {

  public void sort(int[] num) {

    quickSort(num, 0, num.length - 1);
  }


  private void quickSort(int[] num, int s, int e) {
    if (s < e) {
      int index = partition(num, s, e);
      quickSort(num, s, index - 1);
      quickSort(num, index + 1, e);
    }
  }

  private int partition(int[] num, int low, int high) {
    int temp = num[low];
    while (low < high) {
      while (high > low && num[high] > temp) {
        high--;
      }
      num[low] = num[high];
      while (low < high && num[low] <= temp) {
        low++;
      }
      num[high] = num[low];
    }
    num[low] = temp;
    return low;
  }


  public static void main(String[] args) {
    BaseSort baseSort = new BaseSort();
    int[] num = {49, 38, 65, 97, 76, 13, 27, 49};
    baseSort.sort(num);
    for (int i = 0; i < num.length; i++) {
      System.out.print(num[i] + " ");
    }

    /*List<String> list = new ArrayList<>();
    list.add("aa");
    list.add("bb");
    list.add("cc");
    for (int i = list.size() - 1; i >= 0; i--) {
      String str = list.get(i);
      if ("aa".equals(str)) {
        list.remove(str);
      }
    }
    System.out.println(list.size());*/
  }

  public void quickSort(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }
    cal(nums, 0, nums.length - 1);
  }

  public void cal(int[] nums, int low, int high) {
    int l = low, h = high, temp = nums[low];
    while (l < h) {
      while (l < h && nums[h] > temp) {
        h--;
      }
      if (l < h) {
        nums[l] = nums[h];
        l++;
      }
      while (l < h && nums[l] >= temp) {
        l++;
      }
      if (l < h) {
        nums[h] = nums[l];
        h--;
      }
    }
    nums[l] = temp;
    cal(nums, low, l - 1);
    cal(nums, l + 1, high);
  }

  public void sort_2(int a[]) {
    if (a == null || a.length == 0) {
      return;
    }
    quickSort_2(a, 0, a.length);
  }

  private void quickSort_2(int a[], int l, int h) {
    int i = l, j = h, flag = a[i];
    while (i < j) {
      while (i < j && a[j] > flag) {
        j--;
      }
      if (i < j) {
        a[i++] = a[j];
      }
      while (i < j && a[i] <= flag) {
        i++;
      }
      if (i < j) {
        a[j--] = a[i];
      }
    }
    a[i] = flag;
    quickSort_2(a, l, i );
    quickSort(a, i, h);
  }

}

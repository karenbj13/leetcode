package a_huawei;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author qiujiaojiao
 * @Create 2019-12-24 下午5:21
 **/

public class Solution {

  public static void main(String[] args) {
    int data[] = new int[10];
    for (int i = 0; i < 10; i++) {
      data[i] = i;
    }
    List<Integer> res = cal(data, 3);
    System.out.println(res);
  }

  public static List<Integer> cal(int[] data, int m) {
    List<Integer> res = new ArrayList<>();
    if (null == data) {
      return res;
    }
    int n = data.length, i = 0, j = 1;
    while (n >= m) {
      if (data[i] != -1) {
        if (j != m) {
          j++;
        } else {
          data[i] = -1;
          n--;
          j = 1;
        }
      }
      i = (i + 1) % data.length;
    }

    for (i = 0; i < data.length; i++) {
      if (data[i] != -1) {
        res.add(data[i]);
      }
    }
    return res;
  }


}

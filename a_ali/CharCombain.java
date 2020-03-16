package a_ali;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Author qiujiaojiao
 * @Create 2019-12-17 下午8:43
 **/
public class CharCombain {

  public Set<String> getCombine(String str) {
    Set<String> res = new HashSet<>();
    if (null == str || str.length() == 0) {
      return res;
    }
    cal(str, res, 0);
    return res;
  }

  private void cal(String str, Set<String> res, int s) {
    for (int i = s; i < str.length(); i++) {
      String temp = str.substring(s, i + 1);
      res.add(temp);
      cal(str, res, s + 1);
    }
  }

  public List<String> getCombine2(String str) {
    List<String> res = new ArrayList<>();
    if (null == str || 0 == str.length()) {
      return res;
    }
    for (int i = 0; i < str.length(); i++) {
      cal(str, i, res);
    }
    Collections.sort(res, (a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());
    return res;
  }

  public void cal(String str, int s, List<String> res) {
    for (int i = s; i < str.length(); i++) {
      res.add(str.substring(s, i + 1));
    }
  }

  //利用leetcode回溯
  public List<String> getCombine3(String str) {
    List<String> res = new ArrayList<>();
    cal(str, res, "", 0);
  //  Collections.sort(res, (a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());
    return res;
  }

  public void cal(String str, List<String> res, String cur, int s) {
    if (cur != null && cur.length() > 0) {
      res.add(cur);
    }
    for (int i = s; i < str.length(); i++) {
      if (i > s && str.charAt(i) == str.charAt(s)) {
        continue;
      }
      cal(str, res, cur + str.charAt(i), i + 1);
    }
  }

  public static void main(String[] args) {
    CharCombain charCombain = new CharCombain();
    List<String> res = charCombain.getCombine3("abc");
    System.out.println(res);

  }
}

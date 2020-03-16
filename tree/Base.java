package three.tree;

/**
 * @Description
 * @Author qiujiaojiao
 * @Create 2019-12-24 下午4:21
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Base {

  public List<Integer> preOrder(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (null == root) {
      return res;
    }
    Stack<TreeNode> s = new Stack<>();
    TreeNode cur = root;
    while (!s.isEmpty() || null != cur) {
      while (null != cur) {
        res.add(cur.val);
        s.push(cur);
        cur = cur.left;
      }
      cur = s.pop();
      cur = cur.right;
    }
    return res;
  }

  public List<Integer> inOrder(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (null == root) {
      return res;
    }
    Stack<TreeNode> s = new Stack<>();
    TreeNode cur = root;
    while (!s.isEmpty() || null != cur) {
      while (null != cur) {
        s.push(cur);
        cur = cur.left;
      }
      cur = s.pop();
      res.add(cur.val);
      cur = cur.right;
    }
    return res;
  }

  public List<Integer> postOrder(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> s = new Stack<>();
    TreeNode cur = root, last = null;
    while (!s.isEmpty() || null != cur) {
      while (null != cur) {
        s.push(cur);
        cur = cur.left;
      }
      cur = s.peek();
      if (null == cur.right || last == cur.right) {
        res.add(cur.val);
        s.pop();
        last = cur;
        cur = null;
      } else {
        cur = cur.right;
      }

    }
    return res;
  }
}

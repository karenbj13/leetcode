package a_ali;

import java.util.Stack;

/**
 * @Description
 * @Author qiujiaojiao
 * @Create 2019-12-17 下午8:39
 **/
public class MyQueue {

  private Stack<Integer> stack1 = new Stack<>();
  private Stack<Integer> stack2 = new Stack<>();

  public void push(Integer value) {
    stack1.push(value);
  }

  public Integer pop() throws Exception {
    if (stack1.isEmpty() && stack2.isEmpty()) {
      throw new NullPointerException();
    }
    if (!stack2.isEmpty()) {
      return stack2.pop();
    }
    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }
    return stack2.pop();
  }
}

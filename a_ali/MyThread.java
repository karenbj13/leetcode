package a_ali;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @Description
 * @Author qiujiaojiao
 * @Create 2019-12-17 下午9:04
 **/
public class MyThread {

  public static void main(String[] args) throws Exception {
     run();
  //  run2();
    //run3();
  }

  public static void run() throws Exception {
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(1000);
          System.out.println("t1");
        } catch (Exception e) {

        }
      }
    });
    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          t1.join();
          Thread.sleep(1000);
          System.out.println("t2");
        } catch (Exception e) {

        }

      }
    });

    Thread t3 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          t2.join();
          Thread.sleep(1000);
          System.out.println("t3");
        } catch (Exception e) {

        }

      }
    });
    t1.start();
    t2.start();
    t3.start();
  }

  public static void run2() throws Exception {
    CountDownLatch c1 = new CountDownLatch(1);
    CountDownLatch c2 = new CountDownLatch(1);
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(1000);
          System.out.println("t1");
          c1.countDown();
        } catch (Exception e) {

        }

      }
    });
    t1.start();
    c1.await();
    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(1000);
          System.out.println("t2");
          c2.countDown();
        } catch (Exception e) {

        }
      }
    });
    t2.start();
    c2.await();

    Thread t3 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(1000);
          System.out.println("t3");
        } catch (Exception e) {

        }

      }
    });
    t3.start();
  }

  public static void run3() throws Exception {
    Semaphore s1 = new Semaphore(1);
    Semaphore s2 = new Semaphore(1);
    Semaphore s3 = new Semaphore(1);
    s2.acquire(1);
    s3.acquire(1);
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          s1.acquire();
          Thread.sleep(1000);
          System.out.println("t1");
          s2.release();
        } catch (Exception e) {

        }

      }
    });
    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          s2.acquire(1);
          Thread.sleep(1000);
          System.out.println("t2");
          s3.release();
        } catch (Exception e) {

        }
      }
    });

    Thread t3 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          s3.acquire(1);
          Thread.sleep(1000);
          System.out.println("t3");

        } catch (Exception e) {

        }
      }
    });
    t1.start();
    t2.start();
    t3.start();
  }
}

# 单例模式
[git单例模式学习代码](https://github.com/number-47/leetCodeTrain/tree/master/src/com/number47/train/design/singleton)
**单例模式**：该模式的类一个类只有一个实例。即一个类只有一个对象实例。
私有的构造函数，提供返回实现的静态方法
**懒汉**：当程序需要这个实例的时候才去创建对象，就如同一个人懒的饿到不行了才去吃东西
**饿汉**：不管程序是否需要这个对象的实例，总是在类加载的时候就先创建好实例
**线程安全判断**：在instance实例化之前调用getInstance()，存在线程安全问题，如果已经把实例创建好了，后面再去并发调用getInstance()就是线程安全的了，而此时也就变成了饿汉模式。
## 1.懒汉，线程不安全

```
public class Singleton{
  private static Singleton instance;     
  private Singleton(){}
  public static Singleton getInstance(){ //1
    if (instance == null) {          //2
        instance = new Singleton();  //3
    }                                //4
    return instance;                 //5
  }
}
```
### 线程不安全产生原因
线程A和线程B同时执行getInstance(),A和B执行是随机的，因为CPU的切换，不知道哪个线程先执行。

当A线程执行到2语句的时候（2语句执行完了），停止，切换B线程执行，B线程执行到3语句后将资源释放，给A继续执行，但是A已经判断过了啊，已经执行完第2句话了，于是A继续执行第3句话，于是再次new了一个Singleton对象，所有就产生了实例多次的现象。（可以在构造函数打印语句，看实例了多少次）

## 2.懒汉，线程安全

```
public class Singleton{
      private static Singleton instance;
      private Singleton(){}
      public static synchronized Singleton getInstance(){
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
      }
}
```
优化

```
public class Singleton{
      private static Singleton instance;
      private Singleton(){}
      public static Singleton getInstance(){
        if (singleton == null) {
           synchronized (Singleton.class) {
              if (singleton == null) {
                  singleton = new Singleton();
              }
           }
        }
      }
}
```

## 3. 饿汉，线程安全

```
public class Singleton{
   private static Singleton instance = new Singleton();
   private Singleton () { }
   public static Singleton getInstance() {
       return instance;
   }
}
```
## 4.饿汉，变种，线程安全

```
pubic class Singleton {
   private Singleton instance = null;
   static {
      instance = new Singleton;
   }
   private Singleton () {};
   public static Singleton getInstance() {
      return this.instance;
   }
}
```
## 5.静态内部类（线程安全）

```
public class Singleton {
    private static class SingletonHolder{
       private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton () {}
    public static final Singleton getInstance () {
        return SingletonHolder.INSTANCE;
    }
 }
```

## 6.枚举

```
public class Singleton {
    INSTANCE;
    public void whateverMethod() {

    }
 }
 
 //调用方式
 public class Main {

    public static void main(String[] args) {
        Singleton.INSTANCE.doSomething();
    }

}

```
## 7.双重校验锁

```
public class Singleton {
    private volatile static Singleton singleton;
    private Singleton () {}
    public static Singleton getSingleton() {
       if (singleton == null) {
           synchronized (Singleton.class) {
              if (singleton == null) {
                  singleton = new Singleton();
              }
           }
       }
       return singleton;
    }
 }
```
volatile功能
### **原子操作**：
#### 不可分割的操作，在计算机中，就是指不会因为线程调度被打断的操作。
比如：
简单的赋值就是一个原子操作
m=10;
例如m原先的值为10，那么对于这个操作，要么执行成功变成了10，要么执行失败变成了0，而不会出现诸如m=3这种中间状态，即使是在并发的线程中。
**但是**声明赋值则不是原子操作，，例如：
int m =10;
对于这个语句，至少有两个操作：
1、声明一个变量m
2、给m赋值为10
这样就会有一个中间状态：变量m已经被申明了但是还没有赋值
所以，这种状况在多线程中，由于线程执行的不确定性，如果两个线程都使用m，就可能倒是不稳定的结果出现。
### **指令重排**：
简单的来说：就是计算机为了提高执行效率，会做一些优化，在不影响最终结果的情况下，可能会对一些语句的执行顺序进行调整。例如;
int a;//语句1
a=8;//语句2
int b =9; //语句3
int c =a+b;//语句4
正常来说，对于顺序结构，执行的顺序是自上到下
但是，由于指令重排，因为不影响最终结果，所以执行的顺序很可能编程3124，或者1234
由于3，4没有原子性问题，语句3，4可能会被拆分成原子操作，再重排。
也就是说，对于非原子性操作，在不影响结果的情况下，其拆分成的原子操作可能会重排执行顺序
所以在上面的懒汉式代码中 singleton = new Singleton()这句，这并非是一个原子操作，事实上在JVM中这句话大概做了下面3件事情
1.给singleton分配内存
2.调用Singleton的构造函数来初始化成员变量
3.将singleton对象指向分配的内存空间（执行到这一步，singleton才是非null的了）
但是在JVM的及时编译器中，存在指令重拍的优化，也就是说，第二步和第三步的顺序是无法保证的



### Chapter 07 : 쓰레드는 개발자라면 알아두는 것이 좋아요

- [`6. 쓰레드와 관련이 많은 synchronized`](#6-쓰레드와-관련이-많은-synchronized)


---

### `6. 쓰레드와 관련이 많은 synchronized`

이전 [`[VOL 1 - Java 의 예약어 / 키워드 정리]`](https://github.com/jbw9964/God_of_java_practice/blob/post/scripts/ch_03/extra/reserved_words_in_java.md) 에서 잠깐 `synchronized` 키워드를 알아보았다.

`synchronized` 키워드를 이해하기 위해, `Oracle` 문서의 `동기화` 를 인용하겠다. [`[1]`](#synchronization---the-java™-tutorials), [`[3]`](#synchronized-methods---the-java™-tutorials)

- 스레드는 주로 어느 객체의 참조 또는 필드의 값에 접근하며 통신을 이어갑니다. 이러한 통신 형태는 매우 효율적이지만, 다음 두 가지 오류가 발생할 수 있습니다.
- `스레드 간섭` `(Thread interference)` 과 `메모리 일관성 오류` `(Memory consistency error)` 입니다. 이러한 오류를 막기위한 도구가 바로 `동기화` `(synchronization)` 입니다.
- `Java` 언어는 기본적으로 2 가지 `동기화 방법` 을 제공합니다. `동기화 메서드` `(Synchronized methods)` 와 `동기화 구문` `(Synchronized statements)` 입니다.
- `동기화 메서드` 는 간단히 메서드 헤더에 `synchronized` 키워드를 붙여 사용할 수 있습니다.

많은 스레드를 사용할 수록 스레드간 간섭, 심각한 병목이 일어나지 않도록 유의해야 한다. `synchronized` 는 스레드 간섭을 방지해주기 위한 키워드인 것이다.

```java
static int Value = 10;

Runnable calc = new Runnable() {
    @Override
    public void run() {
        System.out.println("Current Value is : " + Value);
        try                 {Thread.sleep(1_000);}
        catch (Exception e) {e.printStackTrace();}
        System.out.println("Value * 10 is : " + Value * 10);
}};

Runnable setZero = new Runnable() {
    @Override
    public void run() {Value = 0;}
};

Thread calcThread = new Thread(calc);
Thread setZeroThread = new Thread(setZero);

System.out.println("Value before start : " + Value + "\n");

calcThread.start();
setZeroThread.start();

try                 {calcThread.join(); setZeroThread.join();}
catch (Exception e) {e.printStackTrace();}

System.out.println("\nValue after start : " + Value);
```
```
Value before start : 10

Current Value is : 10
Value * 10 is : 0

Value after start : 0
```

위 예시에서는 2 개의 스레드가 실행된다. 하나는 `Value * 10` 을 계산하는 스레드이고, 하나는 `Value` 를 `0` 으로 변경하는 스레드이다.

위 출력을 보면 `Current Value is : 10` 이라 나와있지만, 정작 `Value * 10 is : 0` 로, `calcThread` 가 실행중 `setZeroThread` 에 의해 이상한 행동을 한 것을 볼 수 있다.

---

### Reference

- ##### [`Synchronization - The Java™ Tutorials`](https://docs.oracle.com/javase/tutorial/essential/concurrency/sync.html)
    - `[1]` : Threads communicate primarily by sharing access to fields and the objects reference fields refer to. This form of communication is extremely efficient, but makes two kinds of errors possible: thread interference and memory consistency errors. The tool needed to prevent these errors is synchronization.

    - `[2]` : However, synchronization can introduce thread contention, which occurs when two or more threads try to access the same resource simultaneously and cause the Java runtime to execute one or more threads more slowly, or even suspend their execution. Starvation and livelock are forms of thread contention. See the section Liveness for more information.

- ##### [`Synchronized Methods - The Java™ Tutorials`](https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html)
    - `[3]` : The `Java` programming language provides two basic synchronization idioms: `synchronized methods` and `synchronized statements`. 
        ... 
        To make a method synchronized, simply add the `synchronized` keyword to its declaration: ...


---

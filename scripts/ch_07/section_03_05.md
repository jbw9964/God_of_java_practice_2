
### Chapter 07 : 쓰레드는 개발자라면 알아두는 것이 좋아요

- [`3. Thread 클래스의 생성자를 살펴보자`](#3-thread-클래스의-생성자를-살펴보자)

- [`5. Thread 클래스의 주요 메서드를 살펴보자`](#5-thread-클래스의-주요-메서드를-살펴보자)


---

### `3. Thread 클래스의 생성자를 살펴보자`

`Thread` 클래스를 자세히 알아보자. `Thread` 클래스는 총 9 개의 생성자가 존재하고, 교재에서는 이 중 8 개를 설명한다.

|`Constructor`|`Description`|
|---|---|
|`Thread()`|새로운 스레드를 생성한다.|
|`Thread(Runnable task)`|주어진 `task` 의 `run()` 메서드를 수행하는 스레드를 생성한다.|
|`Thread(Runnable task, String name)`|주어진 `task` 의 `run()` 메서드를 수행하는 `name` 이름의 스레드를 생성한다.|
|`Thread(String name)`|`name` 이름의 스레드를 생성한다.|
|`Thread(ThreadGroup group, Runnable task)`|`task` 를 수행하는 스레드를 생성한다. 이 때 생성된 스레드는 `group` 에 속한다.|
|`Thread(ThreadGroup group, Runnable task, String name)`|`task` 를 수행하며 이름이 `name` 인 스레드를 생성한다. 이 때 생성된 스레드는 `group` 에 속한다. |
|`Thread(ThreadGroup group, Runnable task, String name, long stackSize)`|`task` 를 수행하며 이름이 `name` 인 스레드를 생성한다. 이 때 생성된 스레드는 `group` 에 속하며, `stackSize` 만큼의 메모리를 자원을 할당받는다.|
|`Thread(ThreadGroup group, String name)`|`name` 이름의 스레드를 생성한다. 이 때 생성된 스레드는 `group` 에 속한다.|

생성자 중 `java.lang.ThreadGroup` 을 사용하는 생성자들이 많다. `ThreadGroup` 과 관련해서는 추후에 설명하도록 하겠다.

모든 스레드는 이름이 있다. 만약 이름을 지정하지 않으면 `"Thread-n"` 과 같이 이름이 자동으로 부여된다. `(n : 스레드 생성 순서)`

또한 `JVM` 이 실행되는 `OS` 에 따라 스레드에서 얼마나 많은 메서드를 호출하는지, 동시 처리될 수 있는 스레드 수 등이 다르다고 한다.

`(OS 별로 Thread 의 내부 작동이 다르다는 것 같다)`

`Thread` 는 위 처럼 많은 생성자가 존재하기에, 이를 상속받으면 만들어야 할 생성자가 많을 수 있다. 또한 각 스레드마다 `"무언가 다른 값을 기준"` 으로 실행해야 할 수 있다. 이는 다음 예시처럼 구현할 수 있다.

```java
class ThreadExtends extends Thread  {
    private int initValue = 0;

    private void init(int initValue)    {
        this.initValue = initValue;
    }

    public ThreadExtends(int initValue) {
        super();
        init(initValue);
    }
    public ThreadExtends(int initValue, String name)   {
        super(name);
        init(initValue);
    }
    public ThreadExtends(int initValue, ThreadGroup group, Runnable task)   {
        super(group, task);
        init(initValue);
    }
    
    @Override
    public void run() {
        /*
         *  do something with this.initValue
         */
    }
}
```

---

### `5. Thread 클래스의 주요 메서드를 살펴보자`

`Thread` 클래스에는 상당히 많은 메서드가 존재하지만, 대부분 스레드의 속성 확인, 지정, 통제하는 메서드들이다.

이번 `section` 에서는 스레드의 속성을 확인하고 지정하는 메서드를 알아보겠다.

|`Modifier and Type`|`Method`|`Description`|
|---|---|---|
|`void`|`run()`|스레드가 수행할 작업 `(Runnable)` 이 명시된 메서드. 만약 지정된 작업이 없으면 아무것도 수행하지 않는다.|
|`long`|`getId()`|스레드의 고유 `ID` 를 반환한다. `Java 19` 부터 `Deprececated` 되었다.|
|`String`|`getName()`|스레드의 이름을 반환한다.|
|`void`|`setName(String name)`|스레드의 이름을 변경한다.|
|`int`|`getPriority()`|현 스레드의 우선순위를 반환한다.|
|`void`|`setPriority(int newPriority)`|현 스레드의 우선순위를 변경한다. |
|`boolean`|`isDaemon()`|현 스레드가 `데몬 스레드` `(Daemon Thread)` 인지 확인한다.|
|`void`|`setDaemon(boolean on)`|현 스레드를 `데몬 스레드` 로 지정 또는 해제한다. 해당 메서드는 스레드가 시작되기 전에 호출되어야 한다. 스레드가 종료된 후 해당 메서드의 동작은 명시되지 않았다.|
|`StackTraceElement[]`|`getStackTrace()`|현 스레드의 `StackTrace` 배열을 반환한다. 만약 스레드가 시작되지 않았거나 종료되었을 때, 시작하였지만 아직 시스템에 의해 `스케쥴` 되지 않았을 때, 길이 `0` 의 배열을 반환한다.|
|`Thread.State`|`getState()`|현 스레드의 상태를 반환한다.|
|`ThreadGroup`|`getThreadGroup()`|현 스레드가 속한 `ThreadGroup` 을 반환한다. 만약 스레드가 종료되었으면 `null` 을 반환한다.|

메서드 중 스레드의 `우선 순위` 가 언급되었다. 스레드의 우선순위를 직접 설정하는 것은 권장하지 않지만 설정하지 못하는 것은 아니다.

스레드의 우선순위를 그냥 값을 넣어 지정할 수 있지만, `Thread` 클래스에 정의된 필드 상수를 이용하는 것이 바람직하다.

|`Field`|`Description`|
|---|---|
|`MAX_PRIORITY`|스레드가 가질 수 있는 최고 우선순위 값 : `10`|
|`MIN_PRIORITY`|스레드가 가질 수 있는 최소 우선순위 값 : `1`|
|`NORM_PRIORITY`|스레드에 할당되는 기본 우선순위 값 : `5`|

각 필드 상수의 값은 [`[1]`](#1--constant-field-values--javalangthread---oracle-docs) 에 명시되어 있다.

이에 더불어 `데몬 스레드` `(Daemon Thread)` 라는 것이 언급되었다. `데몬 스레드` 란 `"main 프로그램이 완전히 종료되는 것을 막지 않는 스레드"` [`[2]`](#what-is-a-daemon-thread-in-java---stackoverflow) 이다. 

아래 예시를 보자.

```java
Runnable eternal = new Runnable() {
    @Override
    public void run()   {
        for (;true;)    {
            System.out.println("Running Thread list : ");
            for (Thread thread : Thread.getAllStackTraces().keySet())
            System.out.print(Thread.State.RUNNABLE == thread.getState() ? "- " + thread.getName() + "\n" : "");
            System.out.println();

            try                 {Thread.sleep(1_000);}
            catch (Exception e) {e.printStackTrace();}
        }
    }
};

Thread.currentThread().setName("Main thread");

Thread test = new Thread(eternal);
test.setName("Eternal thread");
test.start();

try                 {Thread.sleep(2_000);}
catch (Exception e) {e.printStackTrace();}

System.out.println("--------------[End of main]--------------");
```
```
Running Thread list : 
- Notification Thread
- Signal Dispatcher
- Eternal thread
- Reference Handler

Running Thread list : 
- Notification Thread
- Signal Dispatcher
- Eternal thread
- Reference Handler

--------------[End of main]--------------
Running Thread list : 
- Notification Thread
- Signal Dispatcher
- Eternal thread
- Reference Handler
- DestroyJavaVM

...
```

위 예시는 `main` 메서드는 중단되었으나 실행한 스레드가 종료되지 않는 예시이다. 스레드 `Eternal thread` 는 일정 주기마다 `RUNNABLE` 한 스레드를 출력하는데, `main` 메서드가 중단된 후, `DestroyJavaVM` 라는 스레드가 추가된 것을 볼 수 있다.

`Oracle` 의 설명 [`[3]`](#chapter-5-the-invocation-api--destroyjavavm---oracle-technotes) 에 따르면 `DestroyJavaVM` 의 정의는 다음과 같다.

- JVM 을 언로드하고 자원 회수를 요청합니다.
- 어떠한 스레드든 `(연결되었든 아니든)` 이 함수를 호출할 수 있습니다.
- 만약 스레드가 `"데몬 스레드가 아니고 user-level 의 Java 스레드이며 연결된 스레드"` 라면, `VM` 은 스레드가 떨어지길 기다립니다.

`(정확히 이해한 건지는 모르겠지만)` 결국 `DestroyJavaVM` 는 `VM` 을 종료시키게 하는 무언가이고, `non-daemon` 스레드가 실행중이면 스레드가 끝날 때 까지 기다린 다는 것이다.

때문에 실행 중인 스레드가 오직 `데몬 스레드` 뿐 만이라면 아래 예시처럼 곧바로 프로그램이 종료되게 된다.

```java
Thread test = new Thread(eternal);
test.setName("Eternal thread");
test.setDaemon(true);
test.start();

try                 {Thread.sleep(2_000);}
catch (Exception e) {e.printStackTrace();}

System.out.println("--------------[End of main]--------------");
```
```
Running Thread list : 
- Reference Handler
- Signal Dispatcher
- Eternal thread
- Notification Thread

Running Thread list : 
- Reference Handler
- Signal Dispatcher
- Eternal thread
- Notification Thread

--------------[End of main]--------------
```

덧붙여 교재는 `데몬 스레드` 를 이용해 `"부가적인 작업을 수행하는 스레드"` 를 만들 수 있다고 언급한다.

---

### Reference

- ##### [`[1] : Constant Field Values : java.lang.Thread - Oracle Docs`](https://docs.oracle.com/en/java/javase/21/docs/api/constant-values.html#java.lang.Thread.MAX_PRIORITY)

- ##### [`What is a daemon thread in Java? - StackOverflow`](https://stackoverflow.com/questions/2213340/what-is-a-daemon-thread-in-java)
    - `[2]` : A daemon thread is a thread that does not prevent the `JVM` from exiting when the program finishes but the thread is still running. An example for a daemon thread is the garbage collection.


- ##### [`Chapter 5: The Invocation API : DestroyJavaVM - Oracle technotes`](https://docs.oracle.com/javase/8/docs/technotes/guides/jni/spec/invocation.html#DestroyJavaVM)

    - `[3]` : Unloads a Java VM and reclaims its resources.

        Any thread, whether attached or not, can invoke this function. If the current thread is attached, the VM waits until the current thread is the only non-daemon user-level Java thread. 

---

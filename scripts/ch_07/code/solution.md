
### Chapter 07 : 쓰레드는 개발자라면 알아두는 것이 좋아요 - 직접해 봅시다

- [`문제 설명`](./README.md)

---

문제 자체는 어렵지 않았으나, 한가지 새롭게 안 사실을 적고자 한다.

문제를 처음 구현하였을 때, 시험삼아 아래처럼 `3 초` 만 작동하고 종료되도록 하였다.

```java
TimerThread test = new TimerThread();
int sec = 3;

System.out.println(String.format("Testing for %d sec", sec));
long start = System.currentTimeMillis();

test.start();
while (System.currentTimeMillis() - start <= sec * 1_000);

System.out.println("Interrupting thread...");

test.interrupt();
try                             {test.join();}
catch (InterruptedException e)  {e.printStackTrace();}

System.out.println("End of main");
```

하지만 `interrupt()` 메서드를 사용했음에도 스레드가 멈추지 않는 것을 확인하였다.

이를 검색해 알아보니 스레드 내 다음처럼 조건을 만들어야 함을 알게되었다.

```java
@Override
public void printCurrentTime() {
    while (!currentThread().isInterrupted())    {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= 1_000);

        System.out.print(String.format(
            "%s\t[%,4d] ms\n",
            new Date(), (System.currentTimeMillis() - start)
        ));
    }
}
```

이전에는 `while` 반복 조건에 그저 `true` 를 사용하였다. 나는 스레드가 `interrupted` 되면 무조건 멈춘다고 생각했는데 그건 아니었나 보다.

---

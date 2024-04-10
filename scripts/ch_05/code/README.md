
### Chapter 05 : 자바랭 다음으로 많이 쓰는 애들은 컬렉션 - Part2(Set 과 Queue) - 직접해 봅시다

`Set` 은 중복되는 데이터가 저장되지 않도록 할 때 주로 사용된다. 이러한 `Set` 의 특징을 확인하기 위한 예제를 살펴보자. 이 예제에서는 임의로 중복되지 않는 6 개의 수를 생성하여 출력하는 메서드를 만드는 것이 목표다. 임의의 수는 다음과 같이 `java.util.Random` 클래스를 사용하면 된다. `(이 클래스에 대한 자세한 설명은 다음 다음 장에서 살펴보니, 어떻게 사용하는지만 간단히 보자)`

```java
Random random = new Random();
int tempNumber = random.nextInt(45);
```

이렇게 `random` 객체의 `nextInt()` 메서드를 사용하면, `0` 부터 `45` 까지 임의의 숫자를 리턴하고 `tempNumber` 에 값을 지정할 수 있다.

- `[1]` : 먼저 `d.collection.practice` 패키지에 `RandomNumberMaker` 라는 클래스를 만들고, `main()` 메서드를 만들자.
- `[2]` : `Random` 클래스를 사용하기 위해서 `java.util.Random` 클래스를 `import` 하자.
- `[3]` : `public HashSet<Integer> getSizeNumber()` 라는 메서드를 만들자. 이 메서드에서는 앞서 설명한 `Random` 클래스를 사용하여 임의의 숫자 `6` 개를 생성하여 리턴한다.

    `Hint` : `HashSet<Integer>` 사용, `while (true)` 를 사용하여 `HashSet` 객체에 더하고, 그 크기가 `6` 이 될 때까지 반복

- `[4]` : `getSixNumber()` 메서드를 `main()` 메서드에서 반복하여 10 번 호출하고, 리턴된 `hashSet<Integer>` 객체를 출력한다.

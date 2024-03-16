
### Chapter 03 : 실수를 방지하기 위한 제너릭이라는 것도 있어요 - 직접해 봅시다

- `[1]` : `testGetMax()` 라는 메서드를 다음과 같이 만들자.

```java
public void testGetMax() {
    System.out.println(getMax(1, 2, 3));
    System.out.println(getMax(3, 1, 1));
    System.out.println(getMax(2, 3, 1));
    System.out.println(getMax("a", "b", "c"));
    System.out.println(getMax("b", "c", "a"));
    System.out.println(getMax("a", "b", "c"));
}
```

- `[2]` : `API` 문서를 통해 `java.lang` 패키지에 있는 `Comparable` 인터페이스를 열어 어떤 역할을 수행하는지 확인해보자. 숫자 관련 `Long`, `Integer` 등의 클래스와 `String` 클래스가 이 인터페이스를 구현했는지 확인해보자.

- `[3]` : 다음과 같이 `getMax()` 메서드를 만들자.

```java
public <T extends Comparable<T>> T getMax(T ... a) {
    T maxT = a[0];
    for (T tempT : a) {
        if (tempT.compareTo(maxT) > 0)  maxT = tempT;
    }

    return maxT;
}
```

- `[4]` : `main()` 메서드에서 `testGetMax()` 메서드를 호출하여 결과를 확인해보자.

- `[5]` : `getMax()` 메서드를 참고하여 최소값을 리턴하는 `getMin()` 메서드를 만들자.

- `[6]` : `testGetMax()` 메서드를 복사하여 `testGetMin()` 메서드를 만들고, 이 메서드 내에서 `getMax()` 대신 `getMin()` 메서드를 호출하도록 변경하자.

- `[7]` : `main()` 메서드에서 `testGetMin()` 메서드만을 호출하도록 변경한 후 결과를 확인해보자. 결과는 다음과 같이 출력되어야 한다.

```
1
1
1
a
a
a
```

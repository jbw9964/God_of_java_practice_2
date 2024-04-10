
### Chapter 03 : 실수를 방지하기 위한 제너릭이라는 것도 있어요 - 직접해 봅시다

- [`문제 설명`](./README.md)

---

먼저 `Oracle` 의 `Interface Comparable<T>` 을 알아보자. [`[1], [2]`](#interface-comparablet---oracle-docs)

- `Comparable` 인터페이스는 이를 `implements` 한 클래스 타입의 객체에 `"전체적인 순서"` `(total ordering)` 를 부여합니다.
- 이러한 순서를 클래스의 `"자연적인 순서"` `(natural ordering)` 라 부르며, `compareTo` 메서드를 이용해 이 `자연적인 순서` 를 확인할 수 있습니다.
- 어느 클래스 `C` 타입 객체 `e1`, `e2` 가 있다 생각해 봅시다. `e1`, `e2` 객체간 `자연 순서` 는, `e1.compareTo(e2) == 0` 의 값이 `e1.equals(e2)` 와 동일해야만 `일관적이다` 라 말할 수 있습니다.
- 이처럼 `equals` 메서드와 `compareTo` 의 관계를 통해 `일관적인 순서를 정의` 하는 이유는 `Java` 의 `sorted set` 등이 이 전제를 기반으로 만들어졌기 때문입니다. 따라서 이 `정의` 를 강제하는 것은 아니지만 이를 따르는 것을 강력히 권장합니다.

위 설명을 정리하자면 `Comparable<T>` `interface` 는 객체간 순서를 따지기 위한 `interface` 이며, `compareTo(T o)` 메서드를 이용한다는 것이다.

그리고 설명에서 언급된 `자연 순서` 는 다음 글을 참조하는 것이 좋을 듯 하다. [`[4], [5]`](#natural-order)

별 건 아니고 정말 말 그대로 `"우리가 생각하는 순서 방식"` 이다. 도서관에서 책 번호 매기는 거와 동일하다 생각하면 될 듯 하다.

이제 `Comparable<T>` 의 `int compareTo(T o)` 메서드 설명을 보면,

- 주어진 객체와 현재 객체의 순서를 비교합니다. 만약 메서드를 호출한 객체가, 매개변수로 주어진 객체보다 더 빠르면 `음수`, 동일하면 `0`, 더 느리면 `양수` 를 반환합니다.

라고 되어있다.

---

정리하자면 결국 `Comparable<T>` 가 구현된 클래스는 `순서를 비교하는데` 사용될 수 있고, 이는 `compareTo` 메서드를 이용한다는 것이다.

이를 토대로 문제에서 제공한 `getMax` 메서드를 확인해 보자.

```java
public <T extends Comparable<T>> T getMax(T ... a) {
    T maxT = a[0];
    for (T tempT : a) {
        if (tempT.compareTo(maxT) > 0)  maxT = tempT;
    }

    return maxT;
}
```

`type parameter` `T` 는 `Comparable<T>` 에 의해 `bounded` 되었으므로, `T` 는 무조건 `Comparable<T>` 가 구현된 타입이다.

`Comparable` `interface` 가 구현되었으므로, `compareTo` 메서드가 `Override` 되었을 것이므로 이를 이용해 순서를 비교한다.

`compareTo` 메서드는 현재 객체보다 매개변수로 주어진 객체가 더 `느릴때` 양수를 반환하므로, `tempT.compareTo(maxT) > 0` 은 `"tempT 가 maxT 보다 큰가?"` 를 확인하는 것이다.

---

여기까지 이해했다면 이제 어려울 것이 없다. 문제에서 요구한 `getMin` 메서드는 이를 그냥 뒤집으면 되기 때문이다.

거기다 애초에 `getMax` 메서드를 보여줬으니 어려운 점이 없을 것이다.

---

### Reference

- ##### [`Interface Comparable<T> - Oracle Docs`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Comparable.html)
    - `[1]` : This interface imposes a `total ordering` on the objects of each class that implements it. This ordering is referred to as the class's `natural ordering`, and the class's `compareTo` method is referred to as its natural comparison method.

    - `[2]` : The `natural ordering` for a class `C` is said to be `consistent` with equals if and only if `e1.compareTo(e2) == 0` has the same boolean value as `e1.equals(e2)` for every `e1` and `e2` of class `C`.  
        ...
        It is strongly recommended `(though not required)` that `natural orderings` be `consistent` with `equals`. This is so because sorted sets `(and sorted maps)` without explicit comparators behave `"strangely"` when they are used with elements `(or keys)` whose `natural ordering` is `inconsistent` with `equals`. In particular, such a sorted set `(or sorted map)` violates the general contract for set `(or map)`, which is defined in terms of the `equals` method.

    - ##### `int compareTo(T o)`

        - `[3]` : Compares this object with the specified object for order. Returns a `negative integer`, `zero`, or a `positive integer` as this object is `less than`, `equal to`, or `greater than` the specified object.

- ##### `Natural order`

    - ##### [`[4] : Natural sort order - Wikepedia`](https://en.wikipedia.org/wiki/Natural_sort_order)

    - ##### [`[5] : What is the true meaning of "natural ordering"? - StackExchange`](https://softwareengineering.stackexchange.com/questions/411527/what-is-the-true-meaning-of-natural-ordering)

---

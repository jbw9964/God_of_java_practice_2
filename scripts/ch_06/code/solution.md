
### Chapter 06 : 자바랭 다음으로 많이 쓰는 애들은 컬렉션 - Part3(Map) - 직접해 봅시다

- [`문제 설명`](./README.md)

---

그리 어렵지 않은 문제이다.

좀 더 구분해 구현하기 위해 `Requirement` 추상 클래스를 만들고, 해당 클래스에서 `void putCurrentNumber(int tempNumber)`, `void printStatistics()` 추상 메서드를 구현하였다. 또한 `void getRandomNumberStatistics(int iter)` 메서드를 만들어 원하는 반복만큼 수를 뽑을 수 있도록 하였다.

---

### [`문제의 답`](https://github.com/godofjava/GodOfJava3rd/blob/main/Volume2/Chapter24/src/d/collection/practice/RandomNumberStatistics.java) 에서 잘못된 점

문제를 풀며 한가지 의아한 점이 있었다. 교재 문제 `[9]` 를 보면 `key` 값들이 순서대로 정렬되어 있는 것을 볼 수 있다.
하지만 문제의 이전 설명에 따르면 `Hashtable` 의 `keySet()` 메서드를 이용해 `key` 를 얻으라 하였지, 정렬하라는 명확한 언급이 없었다.

때문에 문제의 의도는 `"정렬하는 건 알아서 해봐"` 인 것 같은데, 정작 이전에 정렬하는 건 `TreeMap` 을 사용하는 방법만 알려줬어서 `"Collections.sort, Arrays.sort 메서드는 알아서 찾으라는 건가?"` 라는 생각이 들었다.

그래서 정답은 어떻게 될까 궁금하여 [`정답`](https://github.com/godofjava/GodOfJava3rd/blob/main/Volume2/Chapter24/src/d/collection/practice/RandomNumberStatistics.java) 을 확인해 봤는데, 너무나도 충격적인 사실을 발견하였다.


```java
public void printStatistics() {
    Set<Integer> keySet = hashtable.keySet();
    for (int key : keySet) {
        int count = hashtable.get(key);
        System.out.print(key + "=" + count + "\t");
        if (key % 10 - 1 == 0)
            System.out.println();
    }
}
```

**아무런 정렬 없이** `keySet()` 메서드로 반환받은 `keySet` 을 그대로 사용하고 있다.

이게 문제가 되는 이유는, `Set` 과 `Hashtable` 은 기본적으로 정렬이 **`보장`** 되지 않는다고 **이전 교재 설명에서 스스로 설명했기 때문** 이다. `(SequencedSet 과 같은 것은 예외)`

**`"그럼 왜 저렇게 만들어도 정렬되서 나와?"`** 라고 되물을 수 있다. 나도 그 점이 너무 의아해 많은 내용을 검색하였고, 잘 풀리지 않아 `StackOverflow` 에 질문 [`[1]`](#1--the-order-of-hashtablekeyset-duplicate---stackoverflow) 해 [`[2]`](#1--the-order-of-hashtablekeyset-duplicate---stackoverflow) 와 같은 답변을 얻을 수 있었다.

- `keySet()` 메서드로 반환된 객체의 순서는 `"보장"` 받을 수 없습니다. 분명히 객체의 순서가 `"완전히 무작위"` 인 것은 아니지만 이는 우연의 일치로 보입니다.
- 이처럼 순서가 보장되는 것 처럼 보이는 이유는 `hash` 자료구조가 작동하는 원리와 관계되어 있습니다. `Java` 에서 `hash` 자료구조는 `Object.hashCode` 메서드를 이용해 `hash 값` 을 생성하는데, `Integer` 클래스의 `hashCode` 메서드는 [`"아주 단순하게"`](https://github.com/openjdk/jdk/blob/a48289ac30a6a9ddc9941676726d105b11689ab3/src/java.base/share/classes/java/lang/Integer.java#L1144-L1160) `(Integer 클래스에 지정된 int 값을 그대로 hash 로 이용)` `hash 값` 을 생성합니다.
- 또한 `hash` 자료구조는 `(hash 값) % (bucket 의 크기)` 로 데이터가 저장될 `bucket 의 index` 를 결정합니다.
- 따라서 숫자 `1`, `2`, `3`, ... 이 `key` 로 삽입될 시, `1` 은 `bucket index 1` 으로, `2` 는 `bucket index 2` 로 지정되 순서가 지켜지는 것 처럼 보이는 것입니다.
- 하지만 이는 이전 삽입된 수들과 동 떨어진 수 `(예를 들어 100)` 을 삽입해 확인하면, 순서가 지켜지지 않는 것을 손쉽게 확인할 수 있습니다.
- 마지막으로 `HashMap` 과 `Hashtable` 내 원소의 순서는 API 에 명시되지 않았으며 `JVM` 에 따라 다를 수 있습니다.

정리하자면 정렬되서 나오는 것은 `"Hashtable 내부 동작으로 인한 우연의 일치"` 일 뿐, 정말로 정렬된 것이 아니라는 것이다.

이를 분명히 이전에 알려줬으면서 답을 저렇게 제시하다니... 충격이다.

---

### Reference

- ##### [`[1] : The order of Hashtable.keySet()? [duplicate] - StackOverflow`](https://stackoverflow.com/questions/78298208/the-order-of-hashtable-keyset)
    - `[2]` : You cannot rely on the order. While it isn't really `"random"` that this happens, one could definitely consider this accidental. ... The order of elements in a `HashMap` or `Hashtable` is not specified and could even vary across different JVMs.

- ##### [`[3] : Java HashMap<Integer, ...> keyset() iterating in sorted order [duplicate]`](https://stackoverflow.com/questions/49038495/java-hashmapinteger-keyset-iterating-in-sorted-order)
    - No particular order is guaranteed for the `HashMaps` and `HashSets`, period. You may derange your order by removing and adding some elements.

---

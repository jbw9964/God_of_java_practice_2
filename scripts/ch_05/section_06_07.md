
### Chapter 05 : 자바랭 다음으로 많이 쓰는 애들은 컬렉션 - Part2(Set 과 Queue)

- [`6. LinkedList 를 파헤쳐보자`](#6-linkedlist-를-파헤쳐보자)

- [`7. LinkeList 의 생성자와 주요 메서드를 살펴보자`](#7-linkelist-의-생성자와-주요-메서드를-살펴보자)

---

### `6. LinkedList 를 파헤쳐보자`

이전 [`CH 4`](../ch_04/README.md) 에서 `LinkedList` 가 잠시 언급되었었다.

`LinkedList` 의 상속, 구현 관계를 나타내면 다음과 같다.

```
java.lang.Object
    ㄴ java.util.AbstractCollection<E>
        ㄴ java.util.AbstractList<E>
            ㄴ java.util.AbstractSequentialList<E>
                ㄴ java.util.LinkedList<E>
```

<!-- Java_LinkedList_Diagram.png -->

<p align="center">
    <img src="../../images/ch_05/Java_LinkedList_Diagram.png", width=70%, height=70%>
</p>

이를 보면 `LinkedList` 는 `List<E>` 와 `Deque<E>` 를 구현한 것을 볼 수 있다. 때문에 `LinkedList` 는 `List` 처럼 사용할 수도 있고 `Deque` 또는 `Queue` 처럼 사용할 수 있다.

또한 이전 `ArrayList`, `Vector` 와 달리 `AbstractSequntialList` 클래스를 상속하는 것을 볼 수 있다. `AbstractList` 와 `AbstractSequentialList` 의 차이점은 `add`, `set`, `remove` 등 메서드의 세부 구현이 다르다는 정도라고 한다.

---

### `7. LinkeList 의 생성자와 주요 메서드를 살펴보자`

`LinkedList` 클래스의 생성자는 2 가지만 존재한다.

|`Constructor`|`Description`|
|---|---|
|`LinkedList()`|빈 `list` 를 생성한다.|
|`LinkedList(Collection<? extends E> c)`|주어진 컬렉션의 원소를 모두 포함하는 `list` 를 생성한다.|

하지만 앞서 말했듯이 `LinkedList` 는 `List<E>`, `Deque<E>` `interface` 를 구현하기 때문에 꽤 많은 메서드가 존재하지만 중복된 기능을 제공하는 경우가 많다.

<details><summary> 원소를 추가하는 메서드</summary>

---

아래의 표는 존재하는 메서드 중 원소를 추가하는 기능을 포함한 메서드이다.

|`Method`|`Description`|
|---|---|
|`void addFirst(E e)`|`LinkedList` 의 `head` 에 원소를 저장한다.|
|`boolean offerFirst(E e)`|    내부적으로 `addFirst(E e) 호출` 을 호출한다. `(중복)`|
|`void push(E e)`|    내부적으로 `addFirst(E e)` 을 호출한다. `(중복)`|
|`boolean add(E e)`|`LinkedList` 의 `tail` 에 원소를 저장한다.|
|`void addLast(E e)`|   내부적으로 `add(E e)` 을 호출한다. `(중복)`|
|`boolean offer(E e)`|   `(중복)`|
|`boolean offerLast(E e)`|   내부적으로 `offer(E e)` 을 호출한다. `(중복)`|
|`void add(int index, E element)`|지정된 `index` 에 원소를 저장한다. `(index < 0 \|\| index > size)` 면 `java.lang.IndexOutOfBoundsException` 예외를 발생시킨다. |
|`E set(int index, E element)`|특정 `index` 의 원소를 `element` 로 바꾸고, 기존 원소를 반환한다. `(index < 0 \|\| index > size)` 면 `java.lang.IndexOutOfBoundsException` 예외를 발생시킨다. |
|`boolean addAll(Collection<? extends E> c)`|`LinkedList` 의 `tail` 에 주어진 컬렉션 원소들을 추가한다. 현 메서드의 호출로 `LinkedList` 가 변화했으면 `true`, 그렇지 않다면 `false` 를 반환한다.|
|`boolean addAll(int index, Collection<? extends E> c)`|지정된 `index` 에 컬렉션에 주어진 원소들을 추가한다. 현 메서드의 호출로 `LinkedList` 가 변화했으면 `true`, 그렇지 않다면 `false` 를 반환한다. 또한 `(index < 0 \|\| index > size)` 면 `java.lang.IndexOutOfBoundsException` 예외를 발생시킨다.|

`LinkedList` 의 메서드는 중복되는 기능이 많다. 그래서 `offerFirst`, `push` 등의 메서드는 내부적으로 `addFirst` 을 호출한다. 

---

</details>

<details><summary> 원소를 꺼내는 메서드</summary>

---

아래의 표는 메서드 중 어느 위치의 원소를 꺼내는 메서드이다.

|`Method`|`Description`|
|---|---|
|`E getFirst()`|`LinkedList` 의 `head` 에 위치한 원소를 `pop`, `peek` 한다.|
|`E peekFirst()`|`(중복)`|
|`E peek()`|`(중복)`|
|`E element()`|`(중복)`|
|`E getLast()`|`LinkedList` 의 `tail` 에 위치한 원소를 `pop`, `peek` 한다.|
|`E peekLast()`|`(중복)`|
|`E get(int index)`|`LinkedList` 의 특정 `index` 에 위치한 원소를 `pop` 한다.|

---

</details>

<details><summary> 특정 원소가 존재하는지 확인하는 메서드</summary>

---

아래 표는 메서드 중 `LinkedList` 에서 특정 원소가 포함되었는지 화인하는 메서드이다.

|`Method`|`Description`|
|---|---|
|`boolean contains(Object o)`|주어진 객체와 `동등한` 원소가 있을 시 `ture` 를 반환한다.|
|`int indexOf(Object o)`|주어진 객체와 `동등한` 원소가 있을 시, 그러한 원소 중 가장 `head` 에 가까운 원소의 `index` 를 반환한다. 만약 존재하지 않을 시, `-1` 을 반환한다.|
|`int lastIndexOf(Object o)`|주어진 객체와 `동등한` 원소가 있을 시, 그러한 원소 중 가장 `tail` 에 까가운 원소의 `index` 를 반환한다. 만약 존재하지 않을 시, `-1` 을 반환한다.|

---

</details>

<details><summary> 원소를 삭제하는 메서드</summary>

---

아래 표는 원소를 삭제하는 데 사용될 수 있는 메서드들이다.

|`Method`|`Description`|
|---|---|
|`E remove()`|`LinkedList` 의 `head` 을 삭제하고 반환한다.|
|`E removeFirst()`|    `(중복)`|
|`E poll()`|    `(중복)`|
|`E pollFirst()`|    `(중복)`|
|`E pop()`|    `(중복)`|
|`E pollLast()`|`LinkedList` 의 `tail` 을 삭제하고 반환한다.|
|`E removeLast()`|    `(중복)`|
|`E remove(int index)`|`LinkedList` 의 특정 `index` 에 위치한 원소를 `pop` 한다.|
|`boolean remove(Object o)`|`LinkedList` 의 원소 중 주어진 객체와 `동등한` 원소를 삭제한다. 이 때 주어진 객체가 원소로 존재했었으면 `true`, 그렇지 않다면 `false` 를 반환한다.|
|`boolean removeFirstOccurrence(Object o)`|`LinkedList` 의 원소 중 주어진 객체와 `동등한` 원소 중 `head` 에 가장 가까운 원소를 삭제한다. 이 때 주어진 객체가 존재했었으면 `true`, 그렇지 않다면 `false` 를 반환한다.|
|`boolean removeLastOccurrence(Object o)`|`LinkedList` 의 원소 중 주어진 객체와 `동등한` 원소 중 `tail` 에 가장 가까운 원소를 삭제한다. 이 때 주어진 객체가 존재했었으면 `true`, 그렇지 않다면 `false` 를 반환한다.|

---

</details>

아래 표는 메서드 중 `java.util.Iterator` 와 관련된 메서드이다.

|`Method`|`Description`|
|---|---|
|`ListIterator<E> listIterator(int index)`|주어진 `index` 부터 시작하는 `ListIterator` `interface` 를 반환한다.|
|`Iterator<E> descendingIterator()`|`LinkedList` 의 `tail` 에서 시작하는 `Iterator` `interface` 를 반환한다.|

`ListIterator` 는 `java.util` 패키지에 존재하는 `interface` 로, 쉽게 말해 `Iterator` 의 단점을 보완할 수 있는 `interface` 이다.

`Iterator` 는 한 방향으로만 `이동` 할 수 있다. `(head --> tail)` 하지만 `ListIterator` 는 양 방향으로 `이동` 할 수 있고 `(head <--> tail)`, `cursor` 를 이용하여 자료구조의 중간(?) 에도 원소를 삽입할 수 있다.

<!-- Iterator_and_ListIterator.png -->

<p align="center">
    <img src="../../images/ch_05/Iterator_and_ListIterator.png", width=55%, height=55%>
</p>


더 자세한 설명은 공식 API 를 참조하면 좋을 듯 하다. [`[1]`]()

---

### Reference

- ##### `[1] : Iterator<E> & ListIterator<E> - Oracle Docs`
    - [`java.util : Interface Iterator<E>`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Iterator.html)
    - [`java.util : Interface ListIterator<E>`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ListIterator.html)

---

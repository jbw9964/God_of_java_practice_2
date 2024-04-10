
### Chapter 05 : 자바랭 다음으로 많이 쓰는 애들은 컬렉션 - Part2(Set 과 Queue)

- [`1. Set 이 왜 필요하지?`](./section_01_04.md#1-set-이-왜-필요하지)
- [`2. HashSet 에 대해서 파헤쳐 보자`](./section_01_04.md#2-hashset-에-대해서-파헤쳐-보자)
- [`3. HashSet 생성자들도 여러 종류가 있다`](./section_01_04.md#3-hashset-생성자들도-여러-종류가-있다)
- [`4. HashSet 의 주요 메서드를 살펴보자`](./section_01_04.md#4-hashset-의-주요-메서드를-살펴보자)

- [`6. LinkedList 를 파헤쳐보자`](./section_06_07.md#6-linkedlist-를-파헤쳐보자)
- [`7. LinkeList 의 생성자와 주요 메서드를 살펴보자`](./section_06_07.md#7-linkelist-의-생성자와-주요-메서드를-살펴보자)

---

### What I learned from this chapter

이번 챕터에서는 `HashSet` 과 `LinkedList` 클래스에 대해 알아보았지만 교재의 내용이 너무나 아쉬웠다.

맨 처음 교재에서 `Set<E>` 는 `HashSet`, `TreeSet`, `LinkedHashSet` 클래스에서 구현된다 하였다.
하지만 이 중 `HashSet` 만 설명하고, 그것도 그냥 메서드 사용법만 설명하였다.

더욱 충격적인 것은 `Queue` 를 알아본다 하면서 `LinkedList` 만 언급하고 `PriorityQueue` 같은 자료구조를 일절 언급하지 않은 점이다.

나는 적어도 이러한 자료구조 클래스가 정확히 어떠한 자료구조를 이용하고, 내부적으로 간략하게 어떻게 동작하는지 정도는 말해줄 것이라 생각했다. 그런데 메서드 사용법만 적어놓다니. 참 실망이 크다.

가볍게 알아보니 `java` 의 `TreeSet` 은 `Red Black Tree` 자료구조를 이용한다 하고, `LinkedHashSet` 은 `(확실하지 않지만)` `Doubly Linked List` 와 `Hash Table` 을 이용해 구현하는 것 같다. `(Doubly Linked List 의 Node 를 Hash Table 에 저장하는 방식)` 해쉬 충돌에 대한 전략은 어떤 것을 이용하는지 잘 모르겠다.

`RB Tree` 는 나중에 반드시 공부해야겠다.

---

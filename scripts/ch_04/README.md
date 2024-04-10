
### Chapter 04 : 자바랭 다음으로 많이 쓰는 애들은 컬렉션 - Part1(List)

- [`1. 자바 컬렉션`](./section_01_03.md#1-자바-컬렉션)
- [`2. List 인터페이스와 그 동생들`](./section_01_03.md#2-list-인터페이스와-그-동생들)
- [`3. ArrayList 에 대해서 파해쳐보자`](./section_01_03.md#3-arraylist-에-대해서-파해쳐보자)

- [`4. ArrayList 의 생성자는 3 개다`](./section_04_08.md#4-arraylist-의-생성자는-3-개다)
- [`5. ArrayList 의 데이터를 담아보자`](./section_04_08.md#5-arraylist-의-데이터를-담아보자)
- [`6. ArrayList 에서 데이터를 꺼내자`](./section_04_08.md#6-arraylist-에서-데이터를-꺼내자)
- [`7. ArrayList 에 있는 데이터를 삭제하자`](./section_04_08.md#7-arraylist-에-있는-데이터를-삭제하자)
- [`8. Stack 클래스는 뭐가 다른데?`](./section_04_08.md#8-stack-클래스는-뭐가-다른데)

---

### What I learned from this chapter

이번 챕터에서는 `Java` 의 자료구조에 대한 큰 틀을 볼 수 있었다.

`Java` 의 자료구조는 `Collection` `interface` 를 `implements` 하여 만들어 진 것이 많다. `Set`, `List`, `Queue` 형 자료구조가 그러하다.

또한 책에서는 별로 언급하지 않았지만 `Java` 의 자료구조는 `단계적인 추상화` 가 아주 잘 이루어 진 것으로 보인다. `Collection` 을 `implements` 한 `AbstractCollection` 클래스가 존재하고, 이를 상속하며 `List` `interface` 를 `implements` 한 `AbstractList` 클래스가 존재하기 때문이다.

다만 한가지 아쉬운 점이 있는데, 교재에서 자료구조를 직접 구현하거나 하지 않고 그냥 사용하는 방법만 알려준 점이다. 직접 `AbstractList` 클래스를 상속해 자료구조를 만들었다면 훨씬 유익할텐데 좀 아쉬웠다.

---

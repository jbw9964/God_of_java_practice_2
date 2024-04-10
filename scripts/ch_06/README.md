
### Chapter 06 : 자바랭 다음으로 많이 쓰는 애들은 컬렉션 - Part3(Map)

- [`1. Map 이란?`](./section_01_02.md#1-map-이란)
- [`2. Map 을 구현한 주요 클래스들을 살펴보자`](./section_01_02.md#2-map-을-구현한-주요-클래스들을-살펴보자)

- [`3. HashMap 클래스에 대해서 자세히 알아보자`](./section_03_06.md#3-hashmap-클래스에-대해서-자세히-알아보자)
- [`5. HashMap 객체의 값을 확인하는 다른 방법들을 알아보자`](./section_03_06.md#5-hashmap-객체의-값을-확인하는-다른-방법들을-알아보자)
- [`6. 정렬된 키의 목록을 원한다면 TreeMap 을 사용하자`](./section_03_06.md#6-정렬된-키의-목록을-원한다면-treemap-을-사용하자)

- [`7. Map 을 구현한 Properties 클래스는 알아두면 편리하다`](./section_07.md#7-map-을-구현한-properties-클래스는-알아두면-편리하다)

---

### What I learned from this chapter

이번 챕터에는 `Map<K,V>` `interface` 와 이를 구현한 클래스를 알아보았다.

애초에 `Map` `interface` 가 `key-value` 를 쌍으로 저장하려는 목적이 있다보니, `Set` 과 겹치는 부분이 존재했다. `(HashSet <--> HashMap || TreeSet <--> TreeMap 등)`

또한 [`(CH 6.6)`](./section_03_06.md#6-정렬된-키의-목록을-원한다면-treemap-을-사용하자) 에서 `TreeMap(Comparator<? super K> comparator)` 와 같은 생성자를 알아보았는데, `Comparator` 를 이용해 순서를 지정시키는 방법은 좀 더 연습이 필요할 것 같다.

더불어 이번 챕터의 [`직접해봅시다`](./code/README.md) 를 풀며 문제가 참 아쉬운 부분이 있어 유감스러웠다.

---


### Chapter 03 : 실수를 방지하기 위한 제너릭이라는 것도 있어요

- [`1. 실수를 방지할 수 있도록 도와주는 제너릭`](./section_01_06.md#1-실수를-방지할-수-있도록-도와주는-제너릭)

- [`2. 제너릭이 뭐지?`](./section_01_06.md#2-제너릭이-뭐지)

- [`3. 제너릭 타입의 이름 정하기`](./section_01_06.md#3-제너릭-타입의-이름-정하기)

- [`4. 제너릭에 ? 가 있는 것은 뭐야?`](./section_01_06.md#4-제너릭에--가-있는-것은-뭐야)

- [`6. 메서드를 제너릭하게 선언하기`](./section_01_06.md#6-메서드를-제너릭하게-선언하기)

---

### What I learned from this chapter

~~드디어~~ 이번 챕터에서 `generic` 을 배웠다. 처음에 `generic` 을 `C++` 의 탬플릿과 동일한 것이라 생각했었는데, 알고보니 조금 달랐다.

탬플릿은 ~~원래 `C++` 이 그렇지만~~ `compiler` 의 보조(?) 로 인한 특별한 특징들이 있지만, `generic` 은 그보다 덜 하였다.

크게 놀란 점은 `generic` 에서 `primitive type` 은 사용하지 못한다는 것이었고, ~~또 그놈의 객체지향이라~~ 탬플릿 보다 아주 유연하게 사용할 수 있다는 점이었다.

`Wildcard`, `Bounded Type Parameter` 등이 그러했다.

더불어 교재와 `Oracle` 문서의 [`Generics`](https://docs.oracle.com/javase/tutorial/java/generics/index.html) 를 비교해 보니, 꽤 큼직한 내용들이 생략되 있었고 뭔가 소개하는 순서가 잘 맞지 않았다.

아마 교재는 일단 `generic` 을 사용하기 위한 정보들만 소개한 듯 하다.

그래서 교재에서 언급한 내용들 위주로만 공부 내용을 기록하였고, `Raw Generic Types`, `Type Erasure` 같은 내용은 적지 않았다.

`Oracle` 문서를 참고하면 훨씬 좋은 내용의 글이 될 것 같지만 그 내용이 방대해 나중에 진행하도록 하겠다.

---
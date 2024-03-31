
### Chapter 04 : 자바랭 다음으로 많이 쓰는 애들은 컬렉션 - Part1(List) - 직접해 봅시다

- `[1]` : 키를 관리하는 `ManageHeight` 라는 클래스를 `d.collection.practice` 패키지에 만들고, 클래스를 실행할 수 있는 `main()` 메서드도 만들자.
- `[2]` : 각 반별로 학생의 수는 다음과 같다. 이 데이터를 저장하는 클래스의 인스턴스 변수로 `gradeHeights` 라는 `ArrayList<ArrayList<Integer>>` 타입으로 선언하자. 이 데이터는 `public void setData()` 메서드에서 지정하자.

|`반`|`학생수`|`1 번부터의 키`|
|:---:|:---:|---|
| `1` | `5` |`170`, `180`, `173`, `175`, `177`|
| `2` | `4` |`160`, `165`, `167`, `186`|
| `3` | `4` |`158`, `177`, `187`, `176`|
| `4` | `3` |`173`, `182`, `181`|
| `5` | `5` |`170`, `180`, `165`, `177`, `172`|

- `[3]` : 반 번호를 매개 변수로 넘겨주면 해당 반 학생들의 키를 번호 순대로 출력하는 `public void printHeight(int classNo)` 라는 메서드를 만들자.
- `[4]` : `mina()` 메서드에서 `setData()` 메서드를 호출하여 데이터를 지정하고, `printHeight()` 메서드를 `for` 루프를 사용해 1 ~ 5 반 까지 호출하자.

```
Class NO.   : 1
170 180 173 175 177

Class NO.   : 2
160 165 167 186 

Class NO.   : 3
158 177 187 176

Class NO.   : 4
173 182 181

Class NO.   : 5
170 180 165 177 172
```

- `[5]` : 각 반별 키의 평균을 계산하여 출력하는 `public void printAverage(int classNo)` 라는 메서드를 만들자. 단 여기서 평균을 구하기 위한 합을 저장하는 변수는 `double` 로 지정한다.

- `[6]` : `main()` 메서드에서 `printHeight()` 를 호출하는 부분만 주석 처리하고, `printAverage()` 메서드를 `while` 루프를 사용하여 1 ~ 5 반 까지 호출하자.

```
Class NO.   : 1
Height average : 175.0

Class NO.   : 2
Height average : 169.5

Class NO.   : 3
Height average : 174.5

Class NO.   : 4
Height average : 178.7

Class NO.   : 5
Height average : 172.8
```

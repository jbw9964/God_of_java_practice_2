
### Chapter 06 : 자바랭 다음으로 많이 쓰는 애들은 컬렉션 - Part3(Map) - 직접해 봅시다

- `[1]` : `d.collection.practice` 패키지에 `RandomNumberStatistics` 클래스를 만들고, `main()` 메서드를 만들자.
- `[2]` : 정상적인 컴파일이 되도록 다음의 `import` 구문을 클래스 선언문 위에 추가하자.

    ```java
    import java.util.Hashtable;
    import java.util.Random;
    import java.util.Set;
    ```

- `[3]` : 클래스에 `DATA_BOUNDARY` 라는 정수로 된 변수를 `private final` 로 선언하고 `50` 을 할당하자.
- `[4]` : 클래스에 `hashtable` 이라는 이름의 `Hashtable` 을 선언하고 생성자를 호출하여 초기화해 놓자. 단 여기서 `hashtable` 의 제너릭 타입은 `<Integer, Integer>` 이다.
- `[5]` : `public void getRandomNumberStatistics()` 이라는 메서드를 만들자. 이 메서드에서는 `1` 부터 `50` 까지의 임의의 수를 `5000` 번 생성하고, 생성한 임의의 수를 잠시 후에 만드는 `putCurrentNumber()` 라는 메서드로 전달한다.

    `Hint` : `for` 루프와 `Random` 클래스의 `nextInt(int)` 메서드 사용

- `[6]` : `public void putCurrentNumber(int tempNumber)` 라는 메서드를 만들자. 이 메서드에서는 `hashtable` 에 `tempNumber` 의 통계 정보를 저장한다. 만약 `hashtable` 의 키에 `tempNumber` 로 넘어온 값이 존재하지 않으면,

    ```java
    hashtable.put(tempNumber, 1);
    ```

    로 해당 키에 대한 처음 값을 저장한다. 그렇지 않고 `hashtable` 에 `tempNumber` 로 넘어온 값이 있으면,

    ```java
    hashtable.put(tempNumber, hashtable.get(tempNumber) + 1);
    ```

    로 해당 키의 수행 횟수에 `1` 을 더한다.

    `Hint` : `Hashtable` 의 `contains()` 메서드 사용

- `[7]` : `public void printStatistics()` 라는 메서드를 만들자. 이 메서드에서는 `hashtable` 에 있는 데이터를 출력한다. 먼저 키의 목록을 `Hashtable` 에 선언된 `keySet()` 메서드를 사용하여 `Set<Integer>` 로 추출한다. 그 다음에는 `for` 루프를 사용하여 키 목록에 있는 값을 꺼내어 `System.out.print()` 메서드를 사용하여 출력한다. 만약 키가 `11`, `21`, `31`, `41` 일 경우에는 줄바꿈을 한다. 다음과 같이 처리하면 된다.

    ```java
    if (key % 10 - 1 == 0)  System.out.println();
    ```

- `[8]` : `getRandomNumberStatistics()` 메서드의 가장 마지막 줄에서 `printStatistics()` 메서드를 호출하는 코드를 추가하자.

- `[9]` : `main()` 메서드에서 `getRandomNumberStatistics()` 메서드를 호출하도록 한 후 클래스를 컴파일 하고 실행하자.

```
50: 95          49: 85          48:115          47:103          46:101          45:105          44: 96          43: 98          42: 82          41: 96
40: 92          39:103          38:104          37: 82          36:111          35:104          34: 98          33:120          32: 89          31:105
30:113          29: 98          28:112          27: 88          26: 86          25:102          24: 84          23:107          22: 90          21: 92
20:102          19:103          18: 81          17:102          16: 94          15:118          14:108          13: 99          12: 90          11:105
10:123           9:101           8: 85           7:110           6:105           5:114           4: 98           3: 94           2:122           1: 90
```
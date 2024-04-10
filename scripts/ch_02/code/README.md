
### Chapter 02 : 가장 많이 쓰는 패키지는 자바랭 - 직접해 봅시다

- `[1]` : `public long parseLong(String data)` 메서드를 만들자. 이 메서드는 `data` 라는 문자열을 받아 `long` 타입으로 변환하여 리턴한다. 여기서 `data` 값은 숫자나 문자열이 올 수 있다.

    `Hint` : `Long` 클래스의 `parseLong()` 메서드를 사용. `NumberFormatException` 을 처리할 수 있도록 `try-catch` 로 묶어 줌

    만약 숫자일 경우에는 숫자를 출력하고, 그 값을 리턴한다. `"r1024"` 와 같이 숫자가 아닌 문자열 값으로 매개 변수가 넘어오면 다음과 같이 출력하고 결과는 `-1` 을 리턴한다.

    ```
    r1024 is not a number.
    ```

- `[2]` : `public void printOtherBase(long value)` 메서드를 만들자. 이 메서드는 `value` 로 받은 값을 2진수, 8진수, 16진수로 변환하여 출력한다.

    `Hint` : `Long` 클래스의 `toBinaryString()`, `toHexString()`, `toOctalString()` 메서드를 사용


    `1024` 를 매개 변수로 받았을 때의 결과는 다음과 같다.

    ```
    Original    : 1024
    Binary      : 10000000000
    Hex         : 400
    Octal       : 2000
    ```

---


### Chapter 02 : 가장 많이 쓰는 패키지는 자바랭

- [`1. java.lang 패키지는 특별하죠`](#1-javalang-패키지는-특별하죠)

- [`2. 숫자를 처리하는 클래스들`](#2-숫자를-처리하는-클래스들)

- [``]()

- [``]()

- [``]()

---

### `1. java.lang 패키지는 특별하죠`

`java.lang` 패키지가 특별한 이유는 `import` 하지 않아도 사용할 수 있기 때문이다. 그만큼 `java.lang` 은 `Java` 에 꼭 필요한 여러 기능들을 제공한다.

`java.lang` 에서 제공하는 `interface`, 클래스, 예외 클래스 등은 다음처럼 분류할 수 있다.


<details><summary> 언어 관련 기본</summary>

|`Type`|`Subjects`|
|---|---|
|`interface`|`Cloneable`, `Comparable`, `Iterable`, `Readable`|
|`class`|`Class`, `ClassLoader`, `Compiler`, `Enum`, `Object`, `pacakge`, `SecurityManager`, `StackTraceElement`, `System`, `Void`|
|`Exception` or `Error`|`ArrayIndexOutOfBoundsException`, `ArrayStoreException`, `ClassCastException`, `ClassNotFoundException`, `CloneNotSupportedException`, `EnumConstantNotPresentException`, `IllegalAccessException`, `IllegalArgumentException`, `IndexOutOfBoundsException`, `InstantiationException`, `NegativeArraySizeException`, `NoSuchFieldException`, `NoSuchMethodException`, `NullPointerException`, `RuntimeException`, `SecurityException`, `TypeNotPresentException`, `UnsupportedOperationException`|

</details>


<details><summary> 문자열 관련</summary>

|`Type`|`Subjects`|
|---|---|
|`interface`|`Appendable`, **<ins>`CharSequence`</ins>** |
|`class`|**<ins>`String`</ins>**, **<ins>`StringBuffer`</ins>**, **<ins>`StringBuilder`</ins>**|
|`Exception` or `Error`|`StringIndexOutOfBoundsException`|

</details>


<details><summary> 기본 자료형 및 숫자 관련</summary>

|`Type`|`Subjects`|
|---|---|
|`class`|**<ins>`Boolean`</ins>**, **<ins>`Byte`</ins>**, **<ins>`Character`</ins>**, `Character.Subset`, `Character.UnicodeBlock`, **<ins>`Double`</ins>**, **<ins>`Float`</ins>**, **<ins>`Integer`</ins>**, **<ins>`Long`</ins>**, **<ins>`Math`</ins>**, **<ins>`Bynber`</ins>**, **<ins>`Short`</ins>**, `StrictMath`|
|`Exception` or `Error`|`ArithmeticException`, `NumberFormatException`|

</details>


<details><summary> 스레드 관련</summary>

|`Type`|`Subjects`|
|---|---|
|`interface`|**<ins>`Runnable`</ins>**, `Thread.UncaughtExceptionHandler`|
|`class`|`InheritableThreadLocal`, **<ins>`Thread`</ins>**, **<ins>`ThreadGroup`</ins>**, **<ins>`ThreadLocal`</ins>**, `Thread.Sate` `(Enum 타입임)`|
|`Exception` or `Error`|`illegalMonitorStateException`, `IllegalThreadStateException`, `InterruptedException`|

</details>


<details><summary> 예외 관련</summary>

|`Type`|`Subjects`|
|---|---|
|`class`|`Throwable`|
|`Exception` or `Error`|`Exception`|

</details>


<details><summary> 런타임 관련</summary>

|`Type`|`Subjects`|
|---|---|
|`class`|`Process`, `ProcessBuilder`, `Runtime`, `RuntimePermission`|
|`Exception` or `Error`|`IllegalStateException`|

</details>

위 분류는 교재에서 이렇게 분류하였다. `Oracle` 이나 다른 문서에서 이렇게 구분한 것은 아니다.

<details><summary> 추가로 java.lang 패키지에 정의된 Error 는 다음과 같다</summary>

- `AbstractMethodError`, `AssertionError`, `ClassCircularityError`, `ClassFormatError`, `Error`, `ExceptionInInitializerError`, `IllegalAccessError`, `IncompatibleClassChangeError`, `InstantiationError`, `InternalError`, `LinkageError`, `NoClassDeffoundError`, `NoSuchFieldError`, `NoSuchMethodError`, `OutOfMemoryError`, `StackOverflowError`, `ThreadDeath`, `UnknownError`, `UnsatisfiedLinkError`, `UnsupportedClassVersionError`, `VerifyError`, `VirtualMachineError`

위 에러는 그렇게 접할 일은 없지만 `OutOfMemoryError` `(OOME)` 와 `StackOverflowError` 정도는 알고 있어야 한다.

`Java` 는 가상 머신에서 메모리를 관리하지만, 프로그램을 잘못 작성하거나 설정이 제대로 되어 있지 않은 경우에는 이러한 에러가 발생할 수 있다.

`StackOverflowError` 는 호출된 메서드의 깊이가 너무 깊을 때 발생한다. `Java` 는 `Stack` 영역에 어떤 메서드가 어느 메서드를 호출했는지에 대한 정보를 관리하기 때문이다.

대표적인 재귀 메서드를 잘못 작성하였을 때 `StackOverflowError` 가 발생한다.

</details>


<details><summary> 마지막으로 다음 annotation 이 선언되어 있다</summary>

- `Deprecated`, `FunctionalInterface`, `Override`, `SafeVarargs`, `SuppressWarnings`

</details>

---

### `2. 숫자를 처리하는 클래스들`



---

### Reference

- ##### [``]()

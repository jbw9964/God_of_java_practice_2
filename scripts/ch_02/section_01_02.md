
### Chapter 02 : 가장 많이 쓰는 패키지는 자바랭

- [`1. java.lang 패키지는 특별하죠`](#1-javalang-패키지는-특별하죠)

- [`2. 숫자를 처리하는 클래스들`](#2-숫자를-처리하는-클래스들)

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

`Java` 의 메모리 영역은 크게 `Stack` 과 `Heap` 으로 나뉜다고 할 수 있다. `(그렇다고 그 둘만 있다는 것은 절대 아니다)`

<details><summary> Stack 과 Heap</summary>

`JLS` 에 따르면 `Stack` 에는 `C` 처럼 지역 변수와 부분 변수를 저장하고, 메서드 호출 및 반환에 관련된 역할을 한다. `Stack` 은 스레드가 생성될 때마다 생성되어 각 스레드마다 독립적인 `Stack` 을 갖는다. [`[1]`](#252-java-virtual-machine-stacks)


반면 `Heap` 은 스레드 간 공유될 수 있으며 클래스 인스턴스와 배열 같은 것들이 저장된다. `Heap` 은 가상 머신이 시작될 때 생성되며, 그 크기는 고정되거나 `(필요에 의해)` 확장 또는 축소될 수 있다. [`[2]`](#253-heap)

</details>

그런데 종종 기본 자료형의 숫자를 객체로 처리해야 할 때가 존재한다. 그래서 `Java` 에는 각각의 기본 자료형에 따른 `Wrapper Class` 가 존재한다.

- `Byte`, `Character`, `Short`, `Integer`, `Long`, `Float`, `Double`, `Boolean`

이 중 `Character` 와 `Boolean` 을 제외하고 모두 `Number` 라는 `추상 클래스` 의 자식들이다.

이들은 모두 참조 자료형이지만 기본 자료형처럼 사용할 수 있다. `Java Compiler` 가 자동으로 형 변환을 해주기 때문이다. `(compile-time 에 변환되지 않고 runtime 에 변환된다)` [`[3]`](#autoboxing-and-unboxing---the-java™-tutorials)

또한 `Character` 클래스를 제외하고 모두 `parse{Type}`, `valueOf` 메서드가 존재한다.

`parse` 는 국문으로 `"구문을 분석하다"` 로 주어진 문자열을 해당하는 기본 자료형으로 바꿔 반환한다.

|`Declaration`|`Description`|
|---|---|
|`static {type} parse{Type}(String s)`|주어진 문자열을 일치하는 `기본 자료형` 으로 바꿔 반환한다.|
|`static {type} parse{Type}(String s, int radix)`|주어진 문자열이 `radix` 진법 이라 생각해 해당하는 값을 `기본 자료형` 으로 바꿔 반환한다.|

반면 `valueOf` 는 주어진 매개변수를 해당하는 `Wrapper Class` 로 변환해 반환한다.

|`Declaration`|`Description`|
|---|---|
|`public static {Type} valueOf({type}} s)`|매개변수로 주어진 기본 자료형의 값을 갖는 `Wrapper Class` 를 반환한다.|
|`public static {Type} valueOf(String s)`|문자열로 주어진 값을 갖는 `Wrapper Class` 를 반환한다.|
|`public static {Type} valueOf(String s, int radix)`|문자열을 `radix` 진법이라 생각해 해당하는 값을 갖는 `Wrapper Class` 를 반환한다.|

<details><summary> radix 이용 예시</summary>

```java
String testString = "00010";

System.out.println("Decimal scale\tBinary scale\tHexadecimal scale");
System.out.printf(
    "%s\t\t%s\t\t%s\n",
    Integer.parseInt(testString),
    Integer.parseInt(testString, 2),
    Integer.parseInt(testString, 16)
);
```
```
Decimal scale   Binary scale    Hexadecimal scale
10              2               16
```

</details>

위 두 메서드 모두 `static` 함에 유의하자.

마지막으로 `Integer` 클래스와 `Long` 클래스에는 `toBinaryString` 이라는 메서드가 있는데, 이는 해당하는 기본 자료형 값을 `이진법` 으로 나타낸 `String` 을 반환하는 메서드이다.

나중에 유용하게 쓰일 듯 싶어 언급하였다.

---

### Reference

- ##### [`Chapter 2. The Structure of the Java Virtual Machine- Java Language Specification, SE 21`](https://docs.oracle.com/javase/specs/jvms/se21/html/jvms-2.html)

    - ##### [`2.5.2. Java Virtual Machine Stacks`](https://docs.oracle.com/javase/specs/jvms/se21/html/jvms-2.html#jvms-2.5.2)
        - `[1]` : Each Java Virtual Machine thread has a private Java Virtual Machine stack, created at the same time as the thread. A Java Virtual Machine stack stores `frames` [`(JLS §2.6)`](https://docs.oracle.com/javase/specs/jvms/se21/html/jvms-2.html#jvms-2.6). A Java Virtual Machine stack is analogous to the stack of a conventional language such as C: it holds local variables and partial results, and plays a part in method invocation and return. 

    - ##### [`2.5.3. Heap`](https://docs.oracle.com/javase/specs/jvms/se21/html/jvms-2.html#jvms-2.5.3)
        - `[2]` : The Java Virtual Machine has a heap that is shared among all Java Virtual Machine threads. The heap is the run-time data area from which memory for all class instances and arrays is allocated.
        
            The heap is created on virtual machine start-up. ... The heap may be of a fixed size or may be expanded as required by the computation and may be contracted if a larger heap becomes unnecessary.

- ##### [`Autoboxing and Unboxing - The Java™ Tutorials`](https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html)
    - `[3]` : `Autoboxing` is the automatic conversion that the `Java compiler` makes between the primitive types and their corresponding object wrapper classes. ... the compiler converts the previous code to the following at runtime ...

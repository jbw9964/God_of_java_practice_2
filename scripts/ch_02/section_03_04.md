
### Chapter 02 : 가장 많이 쓰는 패키지는 자바랭

- [`3. 각종 정보를 확인하기 위한 System 클래스`](#3-각종-정보를-확인하기-위한-system-클래스)

- [`4. System.out 을 살펴보자`](#4-systemout-을-살펴보자)

---

### `3. 각종 정보를 확인하기 위한 System 클래스`

`System` 클래스의 `API` 를 보면 다음 3 개의 클래스 변수가 선언되어 있다.

|`Fields`|`Description`|
|---|---|
|`static final PrintStream err`|표준 에러 출력 스트림|
|`static final InputStream in`|표준 입력 스트림|
|`static final PrintStream out`|표준 출력 스트림|

조금 더 신기한 사실은 직접 코드를 까보면 위 세 필드가 모두 `null` 로 초기화 되어있다는 점이다. 이는 사실 `Java` 의 보안을 위해 이렇게 되있는 것이며, 다른 `native method` 를 이용해 잘 초기화 된다. [`[1]`](#1--systemout-is-declared-as-static-final-and-initialized-with-null-duplicate---stackoverflow)

아무튼 위 세 필드들은 `PrintStream` 또는 `InputStream` 이어서 각 스트림의 메서드를 보려면 이들을 찾아가야 한다. 이들은 모두 `java.io` 패키지에 선언되어 있다.

`IO` 는 이후 챕터에서 다룰 것이므로 일단은 `System` 클래스에 대해서만 알아보자.

---

`System` 클래스는 시스템에 대한 정보를 확인하는 클래스이며, 클래스에서 제공하는 메서드를 분류하면 다음과 같다.

- [`a. 시스템 속성 (Property) 값 관리`](#a-시스템-속성-property-값-관리)

- [`b. 시스템 환경 (Environment) 값 조회`](#b-시스템-환경-environment-값-조회)

- [`c. GC 수행`](#c-d--gc-수행-jvm-종료)

- [`d. JVM 종료`](#c-d--gc-수행-jvm-종료)

- [`e. 현재 시간 조회`](#e-현재-시간-조회)

- 기타 등등

---

#### `a. 시스템 속성 (Property) 값 관리`

|`Method`|`Description`|
|---|---|
|`static String clearProperty(String key)`|`Key` 에 지정된 시스템 속성을 제거한다.|
|`static Properties getProperties()`|현재 시스템 속성을 `java.util.Properties` 클래스 형태로 반환한다.|
|`static String getProperty(String key)`|`Key` 에 지정된 시스템 속성의 값 `(value)` 를 반환한다.|
|`static String getProperty(String key, String def)`|`Key` 에 지정된 값 `(value)` 를 얻고, 만약 존재하지 않으면 `def` 를 반환한다.|
|`static void setProperties(Properties props)`|매개변수로 주어진 `Properties` 들을 시스템 속성에 넣는다.|
|`static String setProperty(String key, String value)`|`Key` 에 지정된 시스템 속성 값을 매개변수 `value` 로 대체한다.|

`Properties` 클래스는 `java.util` 패키지에 속하며, `java.util.Hashtable<K,V>` 클래스를 상속받은 클래스이다. 때문에 `Properties` 는 `KEY` 값과 `VALUE` 값이 존재하며, `getProperties` 메서드로 조회할 수 있는 `KEY` 는 [`[2]`](#2--javalangsystem-getproperties---oracle-docs) 에 적혀있다.


---

#### `b. 시스템 환경 (Environment) 값 조회`

|`Method`|`Description`|
|---|---|
|`static Map<String,String> getenv()`|현재 시스템 환경을 `Map` 형태로 반환한다.|
|`static String getenv(String name)`|주어진 `name` 에 대한 시스템 환경값을 반환한다.|

시스템 속성은 `Java` 에서도 변경 가능했다. 하지만 시스템 환경은 오직 조회만 가능하다.

만약 입력한 환경 `KEY` 가 존재하지 않는다면 `null` 을 반환한다.


---

#### `c, d : GC 수행, JVM 종료`

|`Method`|`Description`|
|---|---|
|`static void gc()`|`GC` 를 실행한다.|
|`static void runFinalization()`|`GC` 처리를 기다리는 모든 객체에 대하여 `finalize` 메서드를 실행한다. `Java 18` 부터 `Deprecated` 되었다.|
|`static void exit(int status)`|현재 수행중인 `JVM` 을 멈춘다.|

사실 위 메서드는 사용하면 ~~정말로~~ 이단취급 받는다. 이전 [`(Ch 1.9)`](../ch_01/section_05_09.md#9-자바의-gc-는-어떻게-진행되나요) 에서 언급했듯, `GC` 는 `Stop the World Event` 이므로 의도치 않은 성능 저하를 야기할 수 있을 뿐더러, 어차피 `JVM` 이 알아서 진행하기 때문이다.

또한 `exit` 메서드는 호출된 메서드가 존재하는 스레드만이 아니라 `JVM` 이 통채로 끝나버리기 때문에 아주 위험하다.

특히 서버와 같은 `multi-thread` 어플리케이션에서 `exit` 을 사용한다면 멀쩡한 서버가 갑자기 중단되는 일이 일어날 것이다.

덧붙여 `exit` 의 `status` 매개변수는 `0` 이면 정상 종료, 그 외는 비정상 종료를 뜻한다. 


---

#### `e. 현재 시간 조회`

|`Method`|`Description`|
|---|---|
|`static long currentTimeMillis()`|현재 시간을 `ms` 단위로 반환한다.|
|`static long nanoTime()`|현재 시간을 `ns` 단위로 반환한다.|

두 메서드는 현재 시간을 반환한다. 두 시간은 `UTC` `(Coordinated Universal Time)` 을 기준으로 하며, 이는 `1970 년 1 월 1 일 00:00` 을 기준 삼아 계산된다.

---

### `4. System.out 을 살펴보자`

이전에 보았듯이 `System.out` 과 `System.err` 는 모두 `PrintStream` 의 자식들이다. `out` 과 `err` 모두 `static` 하게 선언되었으므로 `PrintStream` 의 생성자는 나중에 알아볼 것이다.

`PrintStream` 의 메서드 중 출력을 위한 주요 메서드는 다음과 같다.

- `print(...)`
- `println(...)`
- `format(String format, Object ... args)`, `format(Locale l, String format, Object ... args)`
- `printf(String format, Object ... args)`, `printf(Locale l, String format, Object ... args)`
- `write(byte[] buf)`, `write(byte[] buf, int off, int len)`, `write(int b)`

`print` 와 `println` 의 경우, `Overload` 된 메서드가 너무 많아 생략하였다. `(기본 자료형과 java.lang.Object, char[], String 으로 Overload 되어있다)`

추가로 이전 `VOL.1` 에서 `print`, `println` 에 `Object` 가 주어졌을 때 어떻게 동작하는 지를 알아보았었다. [`(VOL.1 - Ch 7.3)`](https://github.com/jbw9964/God_of_java_practice/blob/post/scripts/ch_07/section_01_03.md#3-%EB%B0%B0%EC%97%B4%EC%9D%84-%EA%B7%B8%EB%83%A5-%EC%B6%9C%EB%A0%A5%ED%95%B4%EB%B3%B4%EB%A9%B4-%EC%96%B4%EB%96%BB%EA%B2%8C-%EB%82%98%EC%98%AC%EA%B9%8C)

이를 상기시키자면 `PrintStream` 의 `print` 에 `Object` 가 주어지면, `String.valueOf(obj)` 를 실행시킨다 하였다.

`String.valueOf(Object obj)` 메서드는 `obj` 가 `null` 일 시, `"null"` 문자열을 반환하고 그렇지 않으면 `obj.toString()` 메서드를 반환한다 하였다.

이 때문에 다음과 같은 상황에서 에러가 발생하지 않는다.

```java
Object obj = null;

System.out.println(obj);    // no Exception occurs
```

한마디로 `(null 을 포함한)` 객체가 `print` 될 때, 그냥 무조건 `toString()` 메서드를 호출하는 게 아니란 말이다.

만약 무조건 `toString()` 을 호출한다면 `NullPointerException` 예외가 발생했을 것이다.


---

### Reference

- ##### [`[1] : System.out is declared as static final and initialized with null? [duplicate] - StackOverflow`](https://stackoverflow.com/questions/31743760/system-out-is-declared-as-static-final-and-initialized-with-null)

- ##### [`[2] : java.lang.System, getProperties - Oracle Docs`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#getProperties())

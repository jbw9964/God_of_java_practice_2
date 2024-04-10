
### Chapter 03 : 실수를 방지하기 위한 제너릭이라는 것도 있어요

- [`1. 실수를 방지할 수 있도록 도와주는 제너릭`](#1-실수를-방지할-수-있도록-도와주는-제너릭)

- [`2. 제너릭이 뭐지?`](#2-제너릭이-뭐지)

- [`3. 제너릭 타입의 이름 정하기`](#3-제너릭-타입의-이름-정하기)

- [`4. 제너릭에 ? 가 있는 것은 뭐야?`](#4-제너릭에--가-있는-것은-뭐야)

- [`6. 메서드를 제너릭하게 선언하기`](#6-메서드를-제너릭하게-선언하기)

---

### `1. 실수를 방지할 수 있도록 도와주는 제너릭`

`제너릭` 은 `Java 5` 부터 추가된 기능으로, 데이터 타입을 일반화화여 매개변수화 할 수 있는 기능을 말한다.

`C++` 의 템플릿과 유사하지만 `generic` 은 `runtime` 에서 바뀐다는 특징이 있고, 템플릿은 `compile-time` 이라는 차이점이 존재한다.

또한 `generic` 은 `primitive type` 을 제외한 타입만 가능하다는 점, 템플릿은 각 타입마다 `(compiler 에 의해)` 서로 다른 소스가 생성된다는 점, 이 때문에 `parameter type` 이 어떠하든 `generic` 은 모두 같은 타입이지만 템플릿은 각기 다른 타입이라는 점 등이 있다.

`(Java 의 generic 과 C++ 템플릿의 차이를 정확히 적고 싶었으나 내용이 방대하고 모르는 점이 많아 간략하게만 적었다...)`

[`(Java 의 generic 에 관한 자세한 내용은 The Java™ Tutorials 을 읽어보는 게 좋을 듯 하다 : [1])`](#1--generics---the-java™-tutorials)

---

### `2. 제너릭이 뭐지?`

`generic` 은 다음처럼 사용 가능하다.

```java
class SomeClass <T1, T2, ... Tn>    {/* ... */}

SomeClass test = new SomeClass<type1, type2, ... typen>();
```

이 때 `SomeClass` 의 선언부에 적혀진 `<T1, T2, ... Tn>` 을 `type parameter`, `test` 객체를 생성할 때 사용된 `<type1, type2, ... typen>` 을 `type argument` 라 칭한다. [`[2]`](#invoking-and-instantiating-a-generic-type---type-parameter-and-type-argument-terminology)


`generic` 은 굳이 클래스에서만 사용할 수 있는 것이 아니다. `interface`, 메서드에도 사용 가능하다.


`Oracle` 문서에 따르면 `generic` 을 사용함으로서 얻는 이득은 다음과 같다 한다.

- `compile-time` 에서의 `강력한 type check`
- 불필요한 `type cast` 삭제
- 더욱 일반화 된 소스를 제공 가능

이에 대한 예시를 한번 생각해보자.

<details><summary> DTO 와 관련된 예시</summary>

---

```java
import java.io.Serializable;

public class DTO implements Serializable {
    private Object data = null;

    public void setData(Object obj) {this.data = obj;}
    public Object getData()         {return this.data;}
}

DTO dto1 = new DTO();
DTO dto2 = new DTO();
DTO dto3 = new DTO();

dto1.setData(new String());
dto2.setData(new StringBuffer());
dto3.setData(new StringBuilder());
```

`DTO` `(Data Transfer Object)` 를 통해 어느 정보를 직렬화 한다 하자. `dto1` 은 그냥 `String` 을, `dto2` 와 `dto3` 는 각각 `StringBuffer`, `StringBuilder` 객체를 데이터로 입력하였다.

위 코드에서는 아무 문제가 없지만 이후 데이터를 꺼내고자 할 때 문제가 발생한다. 

`DTO` 에 저장된 데이터가 어떤 타입인지 기억하기 어렵고, 잘 안다 하더라도 사용하려면 `type casting` 을 해줘야하기 때문이다.


```java
String data1 = (String) dto1.getData();
String data2 = (StringBuffer) dto2.getData();
String data3 = (StringBuilder) dto3.getData();

Object data_raw = dto2.getData();
Class<?> datClass = data_raw.getClass();

if (datClass.equals(String.class))              {/* ... */}
else if (datClass.equals(StringBuffer.class))   {/* ... */}
else if (datClass.equals(StringBuilder.class))  {/* ... */}
else                                            {/* ... */}
```

이는 아주 귀찮고 코드를 필요없이 길게 만들 수 있다.

하지만 `generic` 을 이용하면 간편히 작성할 수 있다.

```java
import java.io.Serializable;

public class DTO<RandomName> 
        implements Serializable {
    
    private RandomName data = null;

    public void setData(RandomName obj) {this.data = obj;}
    public RandomName getData()         {return this.data;}
}

DTO<String>         dto1 = new DTO<String>();
DTO<StringBuffer>   dto2 = new DTO<StringBuffer>();
DTO<StringBuilder>  dto3 = new DTO<StringBuilder>();

dto1.setData(new String());
dto2.setData(new StringBuffer());
dto3.setData(new StringBuilder());

String          data1 = dto1.getData();
StringBuffer    data2 = dto2.getData();
StringBuilder   data3 = dto3.getData();
```

이전과 달리 형변환을 할 필요가 없어졌고, `type parameter` 와 `type argument` 가 맞지 않으면 애초에 `compile` 이 되지 않으므로 `type-safety` 가 보장된다.

</details>

---

### `3. 제너릭 타입의 이름 정하기`

`Oracle` 문서 [`[3]`](#type-parameter-naming-conventions) 에 따르면 `generic` 은 다음처럼 이름을 짓는 관용이 있다.

- 대문자이면서 오직 한 글자로만 표기한다.
- 다음 관용을 따른다.
    - `E` - 원소로 사용되는 객체의 타입
    - `K` - `hash table` 과 같은 자료구조의 `KEY` 데이터의 타입
    - `V` - `hash table` 과 같은 자료구조의 `VALUE` 데이터의 타입
    - `N` - 그냥 숫자
    - `T` - 그냥 타입
    - `S`, `U`, `V` 등등 - 2 번째, 3 번째, 4 번째 ... 등

당연히 관용이므로 이를 언어적으로 강제하진 않는다.

---

### `4. 제너릭에 ? 가 있는 것은 뭐야?`

`generic` 의 `type parameter` 는 기본 자료형을 제외하고 어떠한 타입이여도 상관 없다. `(annotation 도 가능하고, 심지어 generic 도 가능하다)`

그런데 종종 `"알려지지 않은 generic"(??)` 을 사용하고 싶을 때가 있다.

```java
class Generic<T, S> {
    private T dataT = null;
    private S dataS = null;

    /* ... */
    
    public void showData()  {
        System.out.println(
            String.valueOf(dataT) + "\t" + String.valueOf(dataS)
        );
    }
}

class SomeClass {
    public static void someMethod(Generic<?, ?> obj) {
        obj.showData();
    }
}
```

위 처럼 `generic` 을 사용한 클래스가 있고, 그냥 데이터를 출력하기만 하는 `showData()` 메서드가 있다 하자.

그런데 종종 `SomeClass` 의 `someMethod` 처럼 `generic` 의 `type parameter` 와 관계 없는 행위를 하거나, 굳이 `type parameter` 를 생각하지 않아도 될 때가 있다.

이 때 사용되는 것이 `와일드 카드` `(Wildcard)` `?` 이다.

`?` 는 `알려지지 않은 타입` 을 뜻하며 `generic` 의 타입을 명시하지 않고 사용할 수 있게 해준다.

`Wildcard` 는 크게 `Unbounded`, `Upper Bounded`, `Lower Bounded` 로 나눌 수 있다.

---

#### `Unbounded Wildcard`

`Unbounded Wildcard` 는 그냥 `<?>` 와 같은 형태인 `Wildcard` 이다. 가장 일반적인 형태라고 볼 수 있다.

`Wildcard` 는 `type parameter` 로 사용 불가능하며 오직 `type argument` 로만 사용 가능하다.

또한 `Wildcard` 는 매개변수, 필드, 지역변수, 심지어 ~~그리 좋은 예시는 아니지만~~ 반환 **<ins>타입</ins>** 으로도 사용될 수 있다. `(Wildcard 를 이용해 무언가를 생성(?) 하는 건 불가능하지만 참조(?) 를 위한 것은 된다는 뜻이다)`

```java
class Generic<T, S> {}

class SomeClass {
    public Generic<?, ?> WildcardData;

    public Generic<?, ?> someGenericMethod(Generic<?, ?> arg) {
        Generic<?, ?> localGenericVariable = arg;
        return null;
    }
}
```

위 예시를 보면 `Generic<T, S>` 클래스를 선언하였고, `Wildcard` 를 이용해 `SomeClass` 의 필드 타입, 메서드 매개변수의 타입, 반환 타입으로 사용되는 것을 볼 수 있다.

---

#### `Upper Bounded Wildcard`

`Upper Bounded Wildcard` 는 `extends` 키워드를 이용해, 어느 것을 상속 또는 구현한 타입의 `Wildcard` 만 사용하게 하는 방법이다. 이 때 `interface` 를 사용한다 해도 `extends` 키워들 이용한다.

`Upper Bounded Wildcard` 는 `<? extends class or interface>` 와 같은 형식으로 사용할 수 있다.

```java
class SupClass {}
interface SupInterface {}

class GenericClass<T> {}
interface GenericInterface<T> {}

class SomeClass {
    public GenericClass<? extends SupClass> dataClass;
    public GenericInterface<? extends SupInterface> dataInterface;

    public GenericClass<? extends Object> 
        someMethod1(GenericClass<? extends Object> obj) {

            GenericClass<? extends Object> localVariable = obj;
            return null;
    }

    public GenericInterface<? extends SupInterface> 
        someMethod2(GenericInterface<? extends SupInterface> obj) {
            GenericInterface<? extends SupInterface> localVariable = obj;
            return null;
    }
}
```

`Upper Bounded Wildcard` 를 사용하면 오직 뒤에 딸려온 `class` 또는 `interface` 의 <ins>**자식**</ins>인 `generic` 만 사용할 수 있다.

---

#### `Lower Bounded Wildcard`

반면 `Lower Bounded Wildcard` 는 뒤따라온 `class` 또는 `interface` 의 <ins>**부모**</ins>인 `generic` 만 사용할 수 있다.

`Lower Bounded Wildcard` 는 `super` 키워드를 사용하는데, 이는 `Upper Bounded Wildcard` 에서 `extends` 만 바꾼 형태와 동일하다.

`<? super class or interface>`

```java
class SomeClass {
    public GenericClass<? super SupClass> dataClass;
    public GenericInterface<? super SupInterface> dataInterface;

    public GenericClass<? super Object> 
        someMethod1(GenericClass<? super Object> obj) {

            GenericClass<? super Object> localVariable = obj;
            GenericClass<Number> temp = null;

            GenericClass temp2 = new GenericClass();
            return null;
    }

    public GenericInterface<? super SupInterface> 
        someMethod2(GenericInterface<? super SupInterface> obj) {
            GenericInterface<? super SupInterface> localVariable = obj;
            return null;
    }
}
```

---

### `6. 메서드를 제너릭하게 선언하기`

해당 절에서는 메서드 헤더에서도 사용하려는 `generic` 을 명시할 수 있음을 보여준다.

```java
<T> String someMethod(T data) {
    System.out.println(data.getClass());
    return data.toString();
}

System.out.println(
    someMethod(new Object()) + "\t" 
    + someMethod(Integer.valueOf(0))
);
```
```
class java.lang.Object
class java.lang.Integer
java.lang.Object@279f2327       0
```

위 예시를 보면 메서드 선언 앞에 `<T>` 를 사용하는 것을 볼 수 있다. 굳이 클래스 헤더에서 선언하지 않을 수 있다는 것이다.

---

### Reference

- ##### [`[1] : Generics - The Java™ Tutorials`](https://docs.oracle.com/javase/tutorial/java/generics/index.html)

    - [`Generic Types`](https://docs.oracle.com/javase/tutorial/java/generics/types.html)

        - ##### `Invoking and Instantiating a Generic Type - Type Parameter and Type Argument Terminology`
            - `[2]` : Many developers use the terms `"type parameter"` and `"type argument"` interchangeably, but these terms are not the same. When coding, one provides type arguments in order to create a parameterized type. Therefore, the `T in Foo<T>` is a `type parameter` and the `String` in `Foo<String> f` is a `type argument`.

        - ##### `Type Parameter Naming Conventions`
            - `[3]` : By convention, `type parameter` names are single, uppercase letters. ... The most commonly used `type parameter` names are:

                - `E` - Element `(used extensively by the Java Collections Framework)`
                - `K` - Key
                - `N` - Number
                - `T` - Type
                - `V` - Value
                - `S`, `U`, `V` etc. - 2nd, 3rd, 4th types

---

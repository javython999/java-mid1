# 실전 자바 - 중급1편
***
## java.lang 패키지
자바가 기본으로 제공하는 라이브러리중에 가장 기본이 되는 것이 바로 `java.lang` 패키지이다.
여기서 `lang`은 `Language`의 줄임말이다. 자바 언어를 이루는 가장 기본이 되는 클래스들을 보관하는 패키지를 뜻한다.

java.lang 패키지의 대표적인 클래스
* Object: 모든 자바 객체의 부모 클래스
* String: 문자열
* Integer, Long, Double: 래퍼 타입, 기본형 데이터 타입을 객체로 만든 것
* Class: 클래스 메타 정보
* System: 시스템과 관련된 기본 기능들을 제공

### import 생략가능
`java.lang` 패키지는 모든 자바 애플리케이션에 자동으로 import 된다. 따라서 임포트 구문을 사용하지 않아도 된다.
***
## Object 클래스
자바에서 모든 클래스의 최상위 부모 클래스는 항상 `Object` 클래스이다.
* 클래스에 상속 받을 부모 클래스를 명시적으로 지정하면 `Object`를 상속 받지 않는다.

#### 자바에서 Object 클래스가 최상위 부모 클래스인 이유
* 공통 기능 제공
> 객체의 정보를 제공하고, 이 객체가 다른 객체와 같은지 비교하고, 객체가 어떤 클래스로 만들어졌는지 확인하는 기능은 모든 객체에게 필요한 기본기능이다.
> 이런 기능을 객체를 만들 때마다 항상 새로운 메서드를 정의해서 만들어야 한다면 상당히 번거로울 것이다. Object는 모든 객체에 필요한 공통 기능을 제공한다.
> 모든 객체는 공통 기능을 편리하게 제공(상속)받을 수 있다.
* 다형성의 기본 구현
> 부모는 자식을 담을 수 있다. Object는 모든 클래스의 부모 클래스이다. 따라서 모든 객체를 참조할 수 있다.
> Object 클래스는 다형성을 지원하는 기본적인 메커니즘을 제공한다. 모든 자바 객체는 Object 타입으로 처리될 수 있으며,
> 이는 다양한 타입의 객체를 통합적으로 처리할 수 있게 해준다.

### Object 다형성
```java
private static void action(Object object) {}
```
`Object`는 모든 객체의 부모다. 따라서 어떤 객체든지 인자로 전달할 수 있다.
#### Object 다형성의 한계
자식 클래스에 있는 메서드를 호출 하려면 `다운캐스팅을 해야 한다.`

### Object 배열
`Object`는 모든 타입의 객체를 담을 수 있다. 따라서 `Object[]`을 만들면 모든 객체를 담을 수 있는 배열을 만들 수 있다.

#### Object가 없다면?
* `void action(Object object)`와 같이 모든 객체를 받을 수 있는 메서드를 만들 수 없다.
* `Object[] objects`처럼 모든 객체를 저장할 수 있는 배열을 만들 수 없다.

### toString()
`Object.toString()` 메서드는 객체의 정보를 문자열 형태로 제공한다. 그래서 디버깅과 로깅에 유용하게 사용된다.
이 메서드는 `Object` 클래스에 정의되므로 모든 클래스에서 상속받아 사용할 수 있다.

### toString() 오버라이딩
`Object.toString()` 메서드가 클래스 정보와 참조값을 제공하지만 이 정보만으로는 객체의 상태를 적절히 나타내지 못한다.
그래서 보통 `toString()`을 재정의(오버라이딩)해서 보다 유용한 정보를 제공하는 것이 일반적이다.

> 참고 - 객체의 참조값 직접 출력
* `toString()`은 기본으로 객체의 참조값을 출력한다. 그런데 `toString()`이나 `hashCode()`를 재정의하면 객체의 참조값을 출력할 수 없다.
이때는 다음 코드를 사용하면 객체의 참조값을 출력할 수 있다.
```java
String refValue = Integer.toHexString(System.identityHashCode(object));
System.out.println(refValue);
```

### Object와 OCP
만약 `Object`가 없고, 또 `Object`가 제공하는 `toString()`이 없다면
서로 아무런 관계가 없는 객체의 정보를 출력하기 어려울 것이다. 여기서 아무 관계가 없다는 것은 공통의 부모가 없다는 뜻이다.
아마도 다음의 `BadObjectPrinter`클래스와 같이 각각의 클래스마다 별도의 메서드를 작성해야할 것이다.

#### BadObjectPrinter
```java
public class BadObjectPrinter {
    
    public static void print(Car car) {
        System.out.println("객체 정보 출력: " + car.carInfo());
    }
    
    public static void print(Dog dog) {
        System.out.println("객체 정보 출력: " + dog.carInfo());
    }
    
}
```
#### 구체적인 것에 의존
`BadObjectPrinter`는 구체적인 타입인 `Car`, `Dog`를 사용한다. 
따라서 이후에 출력해야 할 구체적인 클래스가 늘어나면 구체적인 클래스에 맞추어 메서드도 늘어나게 된다. 
이렇게 `BadObjectPrinter`클래스가 구체적인 특정 클래스인 `Car`, `Dog`를 사용하는 것을 `의존한다`고 표현한다.

#### 추상적인 것에 의존
```java
public class ObjectPrinter {
    
    public static void print(Object object) {
        System.out.println("객체 정보 출력: " + object.toString());
    }
    
}
```
`ObjectPrinter`는 구체적인 것에 의존하는 것이 아니라 추상적인 것에 의존한다.
`ObjectPrinter`와 `Object`를 사용하는 구조는 다형성을 매우 잘 활용하고 있다.
다형성을 잘 활용한다는 것은 다형적 참조와 메서드 오버라이딩을 적절하게 사용한다는 뜻이다.

#### OCP 원칙
* Open: 새로운 클래스를 추가하고, `toString()`을 오버라이딩해서 기능을 확장할 수 있다.
* Closed: 새로운 클래스를 추가해도 `Object`와 `toString()`을 사용하는 클라이언트 코드인 `ObjectPrinter`는 변경하지 않아도 된다.

> 참고 - 정적 의존관계 VS 동적 의존관계
* 정적 의존관계는 컴파일 시간에 결정되며, 주로 클래스 간의 관계를 의미한다.
* 동적 의존관계는 프로그램을 실행하는 런타임에 확인할 수 있는 의존관계이다. 
`ObjectPrinter.print(Object object)`에 어떤 객체가 전달 될 지는 프로그램을 실행해봐야 알 수 있다.
이렇게 런타임에 어떤 인스턴스를 사용하는지를 나타내는 것이 동적 의존관계이다.

### eqauls() - 1. 동일성과 동등성
`Object`는 동등성 비교를 위한 `eqauls()` 메서드를 제공한다.

자바는 두 객체가 같다라는 표현을 2가지로 분리해서 제공한다.
* 동일성(Identity): `==` 연산자를 사용해서 두 객체의 참조가 동일한 객체를 가리키고 있는지 확인
* 동등성(Eqaulity): `equals()` 메서드를 사용하여 두객체가 논리적으로 동등한지 확인

`동일`은 완전히 같음을 의미한다. 반면 `동등`은 같은 가치나 수준을 의미하지만 그 형태나 외관 등이 완전히  같지는 않을 수 있다.
동일성은 자바 머신 기준이고 메모리의 참조가 기준이므로 물리적이다. 반면 동등성은 보통 사람이 생각하는 논리적인 기준에 맞추어 비교한다.

#### Object.equals() 메서드
```java
public boolean equals(Object object) {
    return (this == object);
}
```
`Object`가 기본으로 제공하는 `equals()`는 `==`으로 동일성 비교를 제공한다.

동등성이라는 개념은 각각의 클래스 마다 다르다. 어떤 클래스는 주민등록번호를 기반으로 동등성을 처리할 수 있고,
어떤 클래스는 고객의 연락처를 기반으로 동등성을 처리할 수 있다. 어떤 클래스는 회원번호를 기반으로 동등성을 처리할 수 있다.
따라서 동등성 비교를 사용하고 싶으면 `equals()` 메서드를 재정의해야 한다. 그렇지 않으면 `Object`는 동일성 비교를 기본으로 제공한다.

#### 정확한 equals() 구현
equals() 메서드를 구현할 때 지켜야 하는 규칙
* 반사성(Reflexivity): 객체는 자기 자신과 동등해야 한다.(x.equals(x)는 항상 true)
* 대칭성(Symmetry): 두 객체가 서로에 대해 동일하다고 판단하면, 이는 양방향으로 동일 해야 한다. (x.equals(y)가 true이면 y.equals(x)도 true)
* 추이성(Transitivity): 만약 한 객체가 두 번째 객체와 동일하고, 두번째 객체가 세 번째 객체와 동일하면, 첫번째 객체는 세 번째 객체와 동일해야 한다.
* 일관성(Consistency): 두 객체의 상태가 변경되지 않는 한, `equals()` 메서드는 항상 동일한 값을 반환해야 한다.
* null에 대한 비교: 모든 객체는 `null`과 비교 했을 때 `false`를 반환해야 한다.
***
## 불변객체
### 기본형과 참조형의 공유
자바의 데이터 타입은 크게 기본형(Primitive Type)과 참조형(Reference Type)으로 나눌 수 있다.
* 기본형: 하나의 값을 여러 변수에서 절대 공유하지 않는다.
* 참조형: 하나의 객체를 참조값을 통해 여러 변수에서 공유할 수 있다.

### 공유 참조와 사이드 이펙트
사이드 이펙트는 프로그래밍에서 어떤 계산이 주된 작업 외에 추가적인 부수 효과를 일으키는 것을 말한다.
프로그래밍에서 사이드 이펙트는 보통 부정적인 의미로 사용되는데, 프로그램의 특정 부분에서 발생한 변경이 의도치 않게
다른 부분에 영향을 미치는 경우에 발생한다. 이로 인해 디버깅이 어려워지고 코드의 안정성이 저하될 수 있다.
```java
Address a = new Addres("서울");
Address b = a;
b.setValue("부산");
System.out.println("a = " + a.getValue()); // "부산"
System.out.println("b = " + b.getValue()); // "부산"
```

### 사이드 이펙트 해결 방안
`a`와 `b`가 처음부터 다른 인스턴스를 참조하면 된다.
```java
import lang.immutable.address.Address;

Address a = new Address("서울");
Address b = new Address("서울");
b.setValue("부산");
System.out.println("a = " + a.getValue()); // "서울"
System.out.println("b = " + b.getValue()); // "부산"
```
> 하지만 여러 변수가 하나의 객체를 공유하는 것을 막을 방법은 없다.
```java
import lang.immutable.address.Address;

Address a = new Address("서울");
Address b = a; // 참조값 대입을 막을 수 있는 방법은 없다.
```

### 불변 객체 - 도입
공유하면 안되는 객체를 여러 변수에서 공유 했기 때문에 문제가 발생 했다.
하지만 객체의 공유를 막을 방법은 없다. 그런데 사이드 이펙트의 더 근본적인 원인을 고려해보면,
객체를 공유하는 것 자체가 문제가 아니다. 문제는 공유된 객체의 값을 변경한 것에 있다.

객체의 상태(객체 내부의 값, 필드, 멤버 변수)가 변하지 않는 객체를 불변 객체(Immuatable Object)라 한다.
불변 클래스를 만드는 방법은 아주 단순하다. 어떻게든 필드 값을 변경할 수 없게 클래스를 설계하면 된다.

### 불변 객체 - 값 변경
불변 객체를 사용하지만 그래도 값을 변경해야 하는 메서드가 필요하면 어떻게 해야 될까?
불변 객체는 값을 변경하는 것이 아니라 새로운 값으로 새로운 객체를 만들어서 반환한다.
***
## String 클래스
### String 클래스 구조
`String` 클래스는 대략 다음과 같이 생겼다.
```java
public final class String {
    private final char[] value; // 자바 9 이전
    private final byte[] value; // 자바 9 이후
    
    // 여러 메서드
    public String concat(String str) {}
    public int length() {}
}
```

> 참고: 자바 9 이후 String 클래스 변경 사항  
> 자바 9부터 `String` 클래스에서 `char[]` 대신에 `byte[]`을 사용한다.  
> 자바에서 문자 하나를 표현하는 `char`는 `2byte`를 차지한다.  
> 그런데 영어, 슷자는 보통 `1byte`로 표현이 가능하다.  
> 그래서 단순 영어, 숫자로만 표현된 경우 `1byte`를 사용하고 (정확히는 Latin-1 인코딩의 경우),   
> 그렇지 않은 나머지의 경우 `2byte`인 UTF-16인코딩을 사용한다.  
> 따라서 메모리를 더 효율적으로 사용할 수 있게 변경되었다.

### String 클래스와 참조형
`String`은 클래스이다. 따라서 기본형이 아니라 참조형이다.
참조형은 변수에 계산할 수 있는 값들이 들어있는 것이 아니라, `x001`과 같이 계산할 수 없는 참조값이 들어있다.
따라서 원칙적으로 `+` 같은 연산을 사용할 수 없다.

* 자바에서 문자열을 더할 때는 `String`이 제공하는 `concat()`과 같은 메서드를 사용해야 한다.
* 하지만 문자열은 너무 자주 다루어지기 때문에 자바 언어에서 편의상 특별히 `+`연산을 제공한다.

### String 클래스 비교
`String`클래스를 비교할 때는 `==` 비교가 아니라 항상 `equals()` 비교를 해야 한다.
* 동일성(Identity): `==` 연산자를 사용해서 두 객체의 참조가 동일한 객체를 가리키고 있는지 확인
* 동등성(Eqaulity): `equals()`메서드를 사용하여 두 객체가 논리적으로 같은지 확인

#### 문자열 리터럴, 문자열 풀
```java
String str3 = "hello";
String str4 = "hello";

System.out.println("리터럴 == 비교 : " + (str3 == str4)); // true
System.out.println("리터럴 equals() 비교 : " + (str3.equals(str4))); // true
```
* `String str3 = "hello"`와 같이 문자열 리터럴을 사용하는 경우 자바는 메모리 효율성과 성능 최적화를 위해 문자열 풀을 사용한다.
* 자바가 실행되는 시점에 클래스에 문자열 리터럴이 있으면 문자열 풀에 `String`인스턴스를 미리 만들어 둔다. 이 때 같은 문자열이 있으면 만들지 않는다.
* `String str3 = "hello"`와 같이 문자열 리터럴을 사용하면 문자열 풀에서 `"hello"`라는 문자를 가진 `String` 인스턴스를 찾는다. 그리고 찾은 인스턴스의 참조를 반환한다.
* `String str4 = "hello"`의 경우 `"hello"` 문자열 리터럴을 사용하므로 문자열 풀에서 `str3`과 같은 참조를 사용한다.
* 문자열 풀 덕분에 같은 문자를 사용하는 경우 메모리 사용을 줄이고 문자를 만드는 시간도 줄어들기 때문에 성능도 최적화 할 수 있다.

> 참고: 프로그래밍에서 풀은 공용 자원을 모아둔 곳을 뜻한다. 여러 곳에서 함께 사용할 수 있는 객체를 필요할 때마다 생성하고, 제거하는 것은 비효율 적이다.   
> 대신에 이렇게 문자열 풀에 필요한 String 인스턴스를 미리 만들어두고 여러곳에서 재사용할 수있다면 성능과 메모리를 더 최적화 할 수 있다.   
> 참고로 문자열 풀은 힙 영역을 사용한다. 그리고 문자열 풀에서 문자를 찾을 때는 해시 알고리즘을 사용하기 때문에 매우 빠른 속도로 원하는 String 인스턴스를 찾을 수 있다.

문자열 비교는 항상 `equals()`를 사용해서 동등성 비교를 해야 한다.

### String 불변 객체
`String`은 불변 객체이다. 따라서 생성 이후에는 절대로 내부의 문자열 값을 변경할 수 없다.

#### String이 불변 객체로 설계된 이유
`String`이 불변 객체로 설계된 이유는 앞서 불변 객체에서 배운 내용에 추가로 다음과 같은 이유도 있다.
`문자열 풀`에 있는 `String` 인스턴스의 값이 중간에 변경되면 같은 문자열을 참고하는 다른 변수의 값도 함께 변경된다.
* `String`은 자바 내부에서 문자열 풀을 통해 최적화를 한다.
* 만약 `String` 내부의 값을 변경할 수 있다면, 기존에 문자열 풀에서 같은 문자를 참조하는 변수의 모든 문자가 함께 변경되어 버리는 문제가 발생한다.
`String` 클래스는 불변으로 설계되어 이런 사이드 이펙트 문제가 발생하지 않는다.

### String 클래스 주요 메서드
#### 문자열 정보 조회
* `length()`: 문자열의 길이를 반환한다.
* `isEmpty()`: 문자열이 비어있는지 확인한다.(길이가 0)
* `isBlank()`: 문장려이 비어있는지 확인한ㄷ.(길이가 0이거나 공백(Whitespace)만 있는 경우), 자바11
* `charAt(int index)`: 지정된 인덱스에 있는 문자를 반환한다.

#### 문자열 비교
* `equals(Object anObject)`: 두 문자열이 동일한지 비교한다.
* `eqaulsIgnoreCase(String anotherString)`: 두 문자열을 대소문자 구분 없이 비교한다.
* `compateTo(String anotherString)`: 두 문자열을 사전 순으로 비교한다.
* `compateToIgnoreCase(String str)`: 두 문자열을 대소문자 구분 없이 사전적으로 비교한다.
* `startsWith(String prefix)`: 문자열이 특정 접두사로 시작하는지 확인한다.
* `endWith(String suffix)`: 문자열이 특정 접미사로 끝나는지 확인한다.

#### 문자열 검색
* `contains(CharSequence s)`: 문자열이 특정 문자열을 포함하고 있는지 확인한다.
* `indexOf(String ch)` / `indexOf(String ch, int fromIndx)`: 문자열이 처음 등장하는 위치를 반환한다.
* `lastIndexOf(String ch)`: 문자열이 마지막 등장하는 위치를 반환한다.

#### 문자열 조작 및 변환
* `subString(int beginIndex)` / `substring(int beginIndex, int endIndex)`: 문자열의 부분 문자열을 반환한다.
* `concat(String str)`: 문자열의 끝에 다른 문자열을 붙인다.
* `replace(CharSequence target, CharSequence replacement`): 특정 문자열을 새 문자열로 대체한다.
* `replaceAll(String regex, String replacement)`: 문자열에서 정규 표현식과 일치하는 첫 번째 부분을 새문자열로 대체한다.
* `replaceFirst(String regex,String replacement)`: 문자열에 정규 표현식과 일치하는 첫 번째 부분을 새문자열로 대체한다.
* `toLowerCase()` / `toUpperCase()`: 문자열을 소문자나 대문자로 변환한다.
* `trim()`: 문자열 양쪽 끝의 공백을 제거한다. 단순 `Whitespace`만 제거할 수 있다.
* `strip()`: `Whitespace`와 유니코드 공백을 포함해서 제거한다. 자바11

#### 문자열 분할 및 조합
* `split(String regex)`: 문자열을 정규 표현식을 기준으로 분할 한다.
* `join(Charsequence delimiter, Charsequence ... elements)`: 주어진 구분자로 여러 문자열을 결합한다.

#### 기타 유틸리티
* `valueOf(Object obj)`: 다양한 타입을 문자열로 변환한다.
* `toCharArray()`: 문자열을 문자 배열로 변환한다.
* `format(String format, Object... args)`: 형식 문자열과 인자를 사용하여 새로운 문자열을 생성한다.
* `matches(String regex)`: 문자열이 주어진 정규 표현식과 일치하는지 확인한다.

### StringBuilder - 가변 String
불변인 String 클래스의 단점은 문자를 더하거나 변경할 때마다 계속 새로운 객체를 생성해야 한다는 점이다.  
문자를 자주 더하거나 변경해야 하는 상황이라면 `String` 객체를 만들고, `GC`해야 한다.   
결과적으로 컴퓨터의 CPU, 메모리를 많이 사용하게 된다.

#### 가변(Mutable) VS 불가변(Immutable)
* `String`은 불편하다. 즉, 한 번 생성되면 그 내용을 변경할 수 없다. 따라서 문자열에 변화를 주려고 할 때마다 새로운 `String` 객체가 생성되고,
기존 객체는 버려진다. 이 과정에서 메모리와 처리 시간을 더 많이 소모한다.
* 반면에, `StringBuilder`는 가변적이다. 하나의 `StringBuilder` 객체 안에서 문자열을 추가, 삭제, 수정할 수 있으며, 이 때마다 새로운 객체를 생성하지 않는다.
* 이로 인해 메모리 사용을 줄이고 성능을 향상시킬 수 있다. 단 사이드 이펙트를 주의해야한다.

`StringBuilder`는 보통 문자열을 변경하는 동안만 사용하다가 문자열 변경이 끝나면 안전한(불변) `String`으로 변환하는 것이 좋다.

### String 최적화
#### 문자열 리터럴 최적화
자바의 컴파일러는 다음과 같이 문자열 리터럴을 더 하는 부분을 자동으로 합쳐준다.
```java
// 컴파일 전
String helloWorld = "Hello, " + "World";

// 컴파일 후
String helloWorld = "Hello, World";
```
따라서 런타임에 별도의 문자열 결합 연사을 수행하지 않기 때문에 성능이 향상된다.

#### String 변수 최적화
문자열 번수의 경우 그 안에 어떤 값이 들어있는지 컴파일 시점에는 알 수 없기 떄문에 단순하게 합칠 수 없다.
```java
String result = str1 + str2;
```
이런 경우 예를 들면 다음과 같이 최적화를 수행한다.(최적화 방식은 자바 버전에 따라 달라진다.)
```java
String result = new StringBuilder().append(str1).append(str2).toString();
```

> 참고: 자바 9부터는 `StringConcatFactory`를 사용해서 최적화를 수행한다.

이렇듯 자바가 최적화를 처리해주기 때문에 지금처럼 간단한 경우에는 `StringBuilder`를 사용하지 않아도 된다. 대신 문자열 더하기 연산을 사용하면 충분하다.

#### String 최적화가 어려운 경우
다음과 같이 문자열을 루프안에서 문자열 더하기를 하는 경우에는 최적화가 이루어지지 않는다.
```java
String result = "";
for(int i = 0; i<100000; i++){
    result += "Hello, Java";
}
```
반복문의 루프 내부에서는 최적화가 되는 것 처럼 보이지만, 반복 횟수만큼 객체를 생성해야 한다.
반복문 내에서의 문자열 연결은, 런타임때 연결할 문자열과 개수가 결정된다. 이런 경우, 컴파일러는 얼마나 많은 반복이 일어날지, 각 빈복문에서 문자열이 어떻게 변할지 예측할 수 없다.
따라서 이런 상황에서는 최적화가 어렵다.
`StringBuilder`는 물론이고, 아마도 대략 반복 횟수인 100,000번의 `String`객체를 생성했을 것이다.

#### 정리
문자열을 합칠 때 대부분의 경우 최적화가 되므로 `+`연산을 사용하면 된다.
`StringBuilder`를 직접 사용하는 것이 더 좋은 경우
* 반복문에서 반복해서 문자열을 연결 할 때
* 조건문을 통해 동적으로 문자열을 조합할 때
* 복잡한 문자열의 특정 부분을 변경해야 할 때
* 매우 긴 대용량 문자열을 다룰 때

> 참고 : StringBuilder VS StringBuffer    
`StringBuilder`와 똑같은 기능을 수행하는 `StringBuffer` 클래스도 있다.   
`StringBuffer`는 내부에 동기화가 되어 있어서, 멀티 스레드 상황에 안전하지만 동기화 오버헤드로 인해 성능이 느리다.   
`StringBuilder`는 멀티 스레드 상황에 안전하지 않지만 동기화 오버헤드가 없으므로 속도가 빠르다.
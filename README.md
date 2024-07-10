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
이런 기능을 객체를 만들 때마다 항상 새로운 메서드를 정의해서 만들어야 한다면 상당히 번거로울 것이다. Object는 모든 객체에 필요한 공통 기능을 제공한다.
모든 객체는 공통 기능을 편리하게 제공(상속)받을 수 있다.
* 다형성의 기본 구현
> 부모는 자식을 담을 수 있다. Object는 모든 클래스의 부모 클래스이다. 따라서 모든 객체를 참조할 수 있다. 
Object 클래스는 다형성을 지원하는 기본적인 메커니즘을 제공한다. 모든 자바 객체는 Object 타입으로 처리될 수 있으며,
이는 다양한 타입의 객체를 통합적으로 처리할 수 있게 해준다.

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

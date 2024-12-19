# 디자인 패턴 학습

## 학습 속도
- 최대 하루 2개의 패턴을 공부한다.

## 일자별 학습 목록
1. day01 (2024.12.16)
    - Adapter pattern
    - Template method pattern


### Adapter Pattern
- 기존 클래스를 전혀 수정하지 않고. 인터페이스에 맞출 때 유용함.
- 기존에 테스트가 끝난 코드를 수정하지 않고 그대로 사용할 수 있음.

### Template method pattern
- 로직을 공통화 할때 사용한다.
- 상위 클래스에서는 ( interface or abstract class) 전반적인 로직을 결정한다.
- 하위 클래스에서는 ( implements or extends ) 구체적인 로직을 결정한다.
  - 이때 상위 클래스가 Interface 인 경우 java8이상이라면 default method를 이용하여 전반적인 로직을 결정할 수 있다.
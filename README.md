# 어플리케이션 기본 프로젝트
처음 시작할 때 기본적으로 세팅되어있는 프로젝트로 사용할 수 있습니다.

## 1. Getting started
### 1-1. Setting arguments
Arguments.java 의 Enum Class 에서 사용할 옵션을 추가/제거등 변경을 통해 프로젝트에서 사용할 인자 값을 조정할 수 있습니다.

```java
public static void generate();
public static void commandParse(String[] args);
```

### 2. Multi language
다국어를 사용하기 위한 사용법입니다.  
LocaleType 클래스의 getLocale 함수 인자에 따라 원하는 언어를 볼 수 있는 방법을 소개합니다.  
`2. Multi language에서는 콘솔에 출력하는 로그를 기준으로만 설명합니다. 다른 다국어는 아래 다른 목차를 통해 확인하도록 합니다.

#### 2-1. Supported language
```text
한국어: ko_kr
영어: en_us
일본어: ja_jp
중국어: zh_cn
```

#### 2-2. using yaml example
> application.yaml
```yaml
locale:
  language: ko_kr
  messages:
    encoding: UTF-8
```

#### 2-3. using java example
```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageSource messageSource;
    
    public void test() {
        log.info(CodeFormatter.create(LogCode.L000001));
        log.debug(CodeFormatter.create(LogCode.L000002));
    }
}
```

### 3. RestAPI Responser
RestAPI 요청시 응답 결과를 반환할 때, 사용해야하는 공통 클래스를 사용합니다.  
응답 결과 반환을 사용하는 사용법에 대해 소개합니다.

Responser 라는 static 클래스를 사용해서 RestAPI의 반환을 어떤 코드로 할 것인지 정하고, 반환할 데이터를 인자로 넣습니다.
```java
// example 1.
Responser.SUCCESS_200({코드번호},{반환할 데이터},{응답 설명}, {언어});

// example 2.
Responser.SUCCESS_200({코드번호},{반환할 데이터})
```

코드 번호는 ResponseCode.R000000 을 통해 사용할 수 있으며, kr.co.wisenut.sampleproject.common.api.code 패키지의 ResponseCode 클래스에서 미리 정의하도록 합니다.  
코드를 정의할 때, 코드 번호와 해당 코드에 적합한 메세지를 명시해야합니다.  
여기에 명시된 메세지는 응답할 때 아래 포맷과 동일하게 자동으로 메세지에 저장되어 반환됩니다.

마찬가지로 DescriptionCode.D000000 을 통해 응답 설명에 대한 메세지를 kr.co.wisenut.sampleproject.common.api.code 패키지의 DescriptionCode 클래스에서 미리 정의하도록 합니다.
코드를 정의할 때, 코드 번호와 해당 코드에 적합한 메세지를 명시해야합니다.  
다국어 적용을 위해 적극 사용하는 것을 권장하며, RestAPI Responser는 사용자가 어떤 언어를 사용하는지 PathVariable 인자 값을 통해 클라이언트에게 적합한 언어로 제공하는 것을 권장합니다.

- **데이터가 Map(JSON)으로 된 객체인 경우**
```json
{
  "code": "000001",
  "message": "스크립트 조작이 의심됩니다. 정상적인 경로로 접속해주세요.",
  "result": {
    "address": "경기도 성남시 분당구 대왕판교로",
    "name": "Wisenut, Kang",
    "company": "wisenut",
    "age": 22
  },
  "description": ""
}
```

#### 3-1. using java example
```java
@RestController
@RequestMapping(value = "{lang}/sample")
public class SampleController {

    @GetMapping(value = "data")
    public ResponseEntity get(@PathVariable String lang) {
        Data data = new Data();
        data.setName("Wisenut, Kang");
        data.setAge(22);
        data.setCompany("wisenut");
        data.setAddress("경기도 성남시 분당구 대왕판교로");

        return Responser.SUCCESS_200(lang, ResponseCode.R000001, data, DescriptionCode.D000001);
    }
}
```

#### 3-2. Get response data
- ResponseDto.toMap(entity);
  - api 응답 결과 전체를 Map으로 변환합니다.

- ResponseDto.toJson(entity);
  - api 응답 결과 전체를 Json으로 변환합니다.

- ResponseDto.getResult(entity);
  - api 응답 결과 중 실제 데이터를 추출합니다.

- ResponseDto.getResultMap(entity);
  - api 응답 결과 중 실제 데이터를 Map 형태로 추출합니다.

- ResponseDto.getResultList(entity);
  - api 응답 결과 중 실제 데이터를 List 형태로 추출합니다. 

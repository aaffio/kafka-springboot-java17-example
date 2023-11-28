## kafka with java 17 example


### prerequisite
- java 17
- mvn
- kafka

### compile

```shell
mvn clean install -DskipTests
```

### run

```shell
mvn spring-boot:run
```

### test
```shell
curl --request POST 'localhost:5001/send/foo/test1'
```

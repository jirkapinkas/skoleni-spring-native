V projektu je rozchozeny priklad na pouziti reflexe + proxy se Spring Native

Test:

    mvn clean spring-boot:build-image
    docker run --rm -it -p 8080:8080 demo-native:0.0.1-SNAPSHOT
    ZAVOLAT: http://localhost:8080

Co se deje uvnitr:

- RootController vola GET na http://localhost:8080/stuff, cimz ziska objekt pres reflexi
- MessageService pouziva @Cacheable => cili Spring generuje proxy


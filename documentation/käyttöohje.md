## Komentorivitoiminnot
Komennot tehdään sovelluksen juurikansiossa, eli siinä missä on tiedosto pom.xml.

### Testaus

Testit suoritetaan kirjoittamalla komento

```
mvn test
```

Testikattavuusraportti tehdään komennolla

```
mvn jacoco:report
```

Raporttia voi tarkastella internetselaimella avaamalla tiedoston _target/site/jacoco/index.html_.   

### Suoritettavan jarin generointi

Komento

```
mvn package
```

luo kansioon _target_ suoritettavan jar-tiedoston _ristinolla-1.0-SNAPSHOT.jar_. Jarin voi sitten ajaa komennolla

```
java -jar target/ristinolla-1.0-SNAPSHOT.jar
```

### Checkstyle

Checkstylen määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Raporttia voi tarkastella internetselaimella avaamalla tiedoston _target/site/checkstyle.html_.

### JavaDoc

JavaDoc luodaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella internetselaimella avaamalla tiedoston _target/site/apidocs/index.html_

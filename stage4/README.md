# Agenda
* Review Time
  * https://github.com/b2etw/Spring-Boot-Kotlin-Dojo/tree/master/stage3/README.md
* take a little break
* Actuator
* ControllerAdvice
* Deployment
  * docker run --name mysql -d -p 3306:3306 -e “TZ=Asia/Taipei” -e MYSQL_ROOT_PASSWORD=rootroot mysql:8
    * Jar
      * ./gradlew clean build
      * java -jar build/libs/demo-deploy-0.0.1-SNAPSHOT.jar
    * Docker
      * ./gradlew clean jibDockerBuild
      * docker-compose up -d

---

# References
* https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html
* https://github.com/GoogleContainerTools/jib/tree/master/jib-gradle-plugin

# Agenda
* Review Time
  * https://github.com/b2etw/Spring-Boot-Kotlin-Dojo/tree/master/stage3/README.md
* take a little break
* Actuator
* ControllerAdvice
* Swagger
* Deployment
  * docker run --name mysql -d -p 3306:3306 -e “TZ=Asia/Taipei” -e MYSQL_ROOT_PASSWORD=rootroot mysql:8
    * Jar
      * ./gradlew clean build
      * java -jar build/libs/demo-deploy-0.0.1-SNAPSHOT.jar
    * Docker
      * ./gradlew clean jibDockerBuild
      * docker-compose up -d
 * summary
   * create the project
   * a brief introduction of Spring
   * 3-tier architecture
   * basic CRUD
   * unit test
   * deployment
   * api document
 * homework
   * crud for Item
   * crud for Order

---

# References
* https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html
* https://github.com/GoogleContainerTools/jib/tree/master/jib-gradle-plugin
* https://springfox.github.io/springfox/

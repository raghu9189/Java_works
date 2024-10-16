Sure! Here's a comprehensive **Spring Boot Cheat Sheet** to help you quickly reference key concepts, annotations, commands, and configurations.

---

## **1. Project Setup**

### **Using Spring Initializr**
- **URL:** [start.spring.io](https://start.spring.io/)
- **Steps:**
  1. Choose Project (Maven/Gradle)
  2. Select Language (Java, Kotlin, Groovy)
  3. Set Spring Boot version
  4. Add Dependencies (e.g., Spring Web, Spring Data JPA)
  5. Generate and download the project

### **Maven Dependencies Example**
```xml
<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Starter Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- MySQL Driver -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Spring Boot Starter Test -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

---

## **2. Application Entry Point**

### **Main Application Class**
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```

---

## **3. Common Annotations**

- **@SpringBootApplication:** Combines @Configuration, @EnableAutoConfiguration, and @ComponentScan.
- **@RestController:** Combines @Controller and @ResponseBody for REST APIs.
- **@RequestMapping:** Maps HTTP requests to handler methods.
- **@GetMapping, @PostMapping, @PutMapping, @DeleteMapping:** Specialized @RequestMapping for HTTP methods.
- **@Autowired:** Injects dependencies.
- **@Service:** Marks a service layer component.
- **@Repository:** Marks a repository (DAO) component.
- **@Entity:** Marks a JPA entity.
- **@Value:** Injects property values.
- **@Configuration:** Indicates a configuration class.
- **@Bean:** Defines a Spring bean.
- **@Component:** Generic stereotype for any Spring-managed component.

---

## **4. Configuration Files**

### **application.properties**
```properties
# Server Configuration
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=secret
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Logging
logging.level.org.springframework=INFO
```

### **application.yml**
```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
    username: root
    password: secret
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

logging:
  level:
    org.springframework: INFO
```

---

## **5. Building REST APIs**

### **Controller Example**
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // GET all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    // GET user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    // POST create new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    // PUT update user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    // DELETE user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
```

### **Service Example**
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() { return userRepository.findAll(); }

    public User findById(Long id) { return userRepository.findById(id).orElse(null); }

    public User save(User user) { return userRepository.save(user); }

    public User update(Long id, User userDetails) {
        User user = findById(id);
        if(user != null){
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            // Update other fields
            return userRepository.save(user);
        }
        return null;
    }

    public void delete(Long id) { userRepository.deleteById(id); }
}
```

### **Repository Example**
```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods if needed
}
```

### **Entity Example**
```java
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    
    // Constructors, Getters, Setters
}
```

---

## **6. Data Access with Spring Data JPA**

- **CRUD Operations:** Provided by `JpaRepository`.
- **Custom Queries:**
  ```java
  List<User> findByName(String name);
  User findByEmail(String email);
  
  // Using @Query
  @Query("SELECT u FROM User u WHERE u.status = ?1")
  List<User> findByStatus(String status);
  ```

---

## **7. Configuration Management**

### **Externalizing Configuration**
- Use `application.properties` or `application.yml`.
- Profiles: `application-dev.properties`, `application-prod.properties`.
- Activate profiles:
  ```properties
  spring.profiles.active=dev
  ```

### **@ConfigurationProperties**
```java
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String name;
    private String description;
    // Getters and Setters
}
```

### **Example application.yml**
```yaml
app:
  name: MyApp
  description: This is my Spring Boot application.
```

---

## **8. Security with Spring Security**

### **Basic Setup**
- **Dependency:**
  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-security</artifactId>
  </dependency>
  ```

### **Security Configuration**
```java
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
            .and()
            .httpBasic();
        return http.build();
    }
}
```

---

## **9. Exception Handling**

### **Global Exception Handler**
```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```

---

## **10. Testing**

### **Unit Testing with JUnit and Mockito**
```java
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testFindById() {
        User user = new User(1L, "John", "john@example.com");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User found = userService.findById(1L);
        assertEquals("John", found.getName());
    }
}
```

### **Integration Testing with Spring Boot Test**
```java
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class UserControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetUsers() {
        ResponseEntity<User[]> response = restTemplate.getForEntity("/api/users", User[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().length > 0);
    }
}
```

---

## **11. Common Commands**

### **Maven**
- **Run Application:** `mvn spring-boot:run`
- **Package:** `mvn clean package`
- **Test:** `mvn test`

### **Gradle**
- **Run Application:** `./gradlew bootRun`
- **Build:** `./gradlew build`
- **Test:** `./gradlew test`

---

## **12. Useful Tips**

- **Hot Reload:** Use Spring Boot DevTools for automatic restarts.
  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-devtools</artifactId>
      <scope>runtime</scope>
  </dependency>
  ```
  
- **Actuator:** Monitor and manage your application.
  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-actuator</artifactId>
  </dependency>
  ```
  - **Endpoints:** `/actuator/health`, `/actuator/info`, etc.
  
- **Lombok:** Reduce boilerplate code.
  ```xml
  <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <scope>provided</scope>
  </dependency>
  ```
  - **Annotations:** `@Data`, `@Getter`, `@Setter`, `@NoArgsConstructor`, etc.

- **Profile-specific Beans:**
  ```java
  @Service
  @Profile("dev")
  public class DevService implements MyService { ... }

  @Service
  @Profile("prod")
  public class ProdService implements MyService { ... }
  ```

---

## **13. Reference Links**

- **Spring Boot Documentation:** [https://docs.spring.io/spring-boot/docs/current/reference/html/](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- **Spring Initializr:** [https://start.spring.io/](https://start.spring.io/)
- **Spring Guides:** [https://spring.io/guides](https://spring.io/guides)

---

This cheat sheet covers fundamental aspects of Spring Boot to accelerate your development process. For more detailed information, refer to the official [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/).
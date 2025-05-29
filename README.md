# Courses Backend Service

Сервис для управления курсами и пользователями, разработанный на Spring Boot.

## Требования

- Java 17 или выше
- Maven 3.6 или выше
- PostgreSQL 12 или выше

3. Настройте подключение к базе данных в файле `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/courses_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## Сборка проекта

1. Клонируйте репозиторий:
```bash
git clone <repository-url>
cd courses_backend_spring
```

2. Соберите проект с помощью Maven:
```bash
./mvnw clean install
```

## Запуск сервера

### Вариант 1: Запуск через Maven
```bash
./mvnw spring-boot:run
```

### Вариант 2: Запуск через JAR файл
```bash
java -jar target/courses-0.0.1-SNAPSHOT.jar
```

Сервер будет запущен на порту 8080 (http://localhost:8080)

## API Endpoints

### Курсы (`/api/courses`)

- `GET /api/courses` - получить список всех курсов
- `GET /api/courses/{id}` - получить курс по ID
- `POST /api/courses` - создать новый курс
- `PUT /api/courses/{id}` - обновить существующий курс
- `DELETE /api/courses/{id}` - удалить курс

### Пользователи (`/api/users`)

- `GET /api/users` - получить список всех пользователей
- `GET /api/users/{id}` - получить пользователя по ID
- `POST /api/users` - создать нового пользователя
- `PUT /api/users/{id}` - обновить существующего пользователя
- `DELETE /api/users/{id}` - удалить пользователя
- `POST /api/users/login` - аутентификация пользователя

## Примеры запросов

### Создание курса
```bash
curl -X POST http://localhost:8080/api/courses \
-H "Content-Type: application/json" \
-d '{
    "title": "Java Programming",
    "description": "Learn Java programming language",
    "instructor": "John Doe",
    "durationHours": 40,
    "price": 99.99
}'
```

### Создание пользователя
```bash
curl -X POST http://localhost:8080/api/users \
-H "Content-Type: application/json" \
-d '{
    "email": "user@example.com",
    "password": "password123"
}'
```

### Аутентификация
```bash
curl -X POST http://localhost:8080/api/users/login \
-H "Content-Type: application/json" \
-d '{
    "email": "user@example.com",
    "password": "password123"
}'
```

## Структура проекта

```
src/main/java/com/example/courses/
├── controller/     # REST контроллеры
├── service/        # Бизнес-логика
├── repository/     # Репозитории для работы с БД
├── model/         # Сущности
└── dto/           # Data Transfer Objects
```

## Технологии

- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok 
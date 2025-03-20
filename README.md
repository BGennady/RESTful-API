# RESTful API - BFF (Backend For Frontend)

Этот проект представляет собой API, которое собирает данные о пользователях и их заказах, обрабатывая запросы через BFF (Backend For Frontend) сервис.
Используется Spring Boot для создания микросервисов, которые взаимодействуют с двумя другими сервисами: пользователями и заказами.

## Структура проекта

### Основные компоненты

- **BffController**: Основной контроллер, который обрабатывает запросы от клиента, собирает данные о пользователе и его заказах с двух различных сервисов и отправляет комбинированный ответ.
- **UserController**: Контроллер для работы с данными пользователей.
- **OrderController**: Контроллер для работы с данными заказов.
- **Сервис UserService** и **OrderService**: Логика для работы с данными пользователей и заказов соответственно.
- **Модели**: `Users`, `Order` — используются для представления данных пользователя и заказа.
- **Репозитории**: Для работы с базой данных через JPA.
- **Настройки**: Конфигурации для подключения к базе данных и настройка зависимостей.

## Технологии

- **Spring Boot**: Фреймворк для разработки микросервисов.
- **Spring Data JPA**: Для работы с базой данных.
- **PostgreSQL**: База данных для хранения информации о пользователях и заказах.
- **RestTemplate**: Для взаимодействия с внешними микросервисами.
- **Lombok**: Для упрощения создания классов моделей.

## Запуск проекта

### Настройка базы данных

1. Создайте базу данных в PostgreSQL, если она еще не существует.
2. Импортируйте следующие таблицы и данные:

```sql
CREATE TABLE microservices.USERS (
    id BIGSERIAL PRIMARY KEY,
    firstName VARCHAR(25) NOT NULL,
    lastName VARCHAR(25) NOT NULL,
    middleName VARCHAR(25) NOT NULL,
    deliveryAddress VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(20) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE microservices.ORDERS (
    id BIGSERIAL PRIMARY KEY,
    userId BIGINT NOT NULL,
    totalAmount DOUBLE PRECISION NOT NULL,
    currency VARCHAR(10) NOT NULL,
    quantity BIGINT NOT NULL
);

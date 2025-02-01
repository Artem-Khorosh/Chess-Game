# Chess

## Описание
Это проект шахматной игры, реализованный на Java с использованием JavaFX для графического интерфейса и Maven для управления зависимостями.

## Требования
- JDK 17 или выше
- Maven 3.6.0 или выше

## Установка
1. Клонируйте репозиторий:
    ```sh
    git clone https://github.com/Artem-Khorosh/Chess.git
    cd Chess
    ```

2. Убедитесь, что у вас установлена правильная версия JDK и Maven.

3. Соберите проект с помощью Maven:
    ```sh
    mvn clean install
    ```

## Запуск
Для запуска приложения используйте следующую команду Maven:
```sh
mvn clean javafx:run

##Структура проекта
src/main/java/com/chess/game - Основные классы игры
src/main/java/com/chess/board - Классы, связанные с доской и клетками
src/main/java/com/chess/pieces - Классы шахматных фигур
src/test/java/com/chess/test - Тесты для различных компонентов игры

Тестирование
Для запуска тестов используйте следующую команду Maven:
mvn test
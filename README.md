# Discord Bot на Java

Этот проект представляет собой бота для Discord, написанного на Java, который обрабатывает команды с использованием аннотаций. 

## Оглавление

- [Начало работы](#начало-работы)
- [Требования](#требования)
- [Установка](#установка)
- [Использование](#использование)
- [Создание команд](#создание-команд)
- [Примеры команд](#примеры-команд)
- [Лицензия](#лицензия)

## Начало работы

Эти инструкции помогут вам скопировать проект и запустить его на локальной машине для разработки и тестирования.

### Требования

Для запуска этого проекта вам потребуется:

- Java 8 или выше
- Maven
- Токен бота для Discord (можно получить на [Discord Developer Portal](https://discord.com/developers/applications))

### Установка

1. Клонируйте репозиторий:

    ```bash
    git clone https://github.com/username/discord-bot-java.git
    cd discord-bot-java
    ```

2. Установите зависимости с помощью Maven:

    ```bash
    mvn install
    ```

3. Создайте файл `config.properties` в корневом каталоге проекта и добавьте ваш токен бота:

    ```
    token=ВАШ_ТОКЕН
    ```

### Использование

Запустите основное приложение:

```bash
mvn exec:java -Dexec.mainClass="com.mycompany.app.Bot"
```

Бот запустится и будет готов к обработке команд в вашем Discord сервере.

## Создание команд

Для создания новой команды выполните следующие шаги:

1. Создайте новый класс и аннотируйте его `@Command`.
2. Реализуйте интерфейс `ICommand`.

### Пример

```java
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

@Command("example")
public class ExampleCommand implements ICommand {
    @Override
    public void execute(MessageReceivedEvent event) {
        event.getChannel().sendMessage("This is an example command!").queue();
    }
}
```

Поместите класс в пакет, указанный в `CommandHandler` для автоматической регистрации.

## Примеры команд

В проекте уже включены несколько команд для примера:

- **PingCommand**: отвечает "Pong!" на команду `!ping`.
- **HelloCommand**: отвечает приветственным сообщением на команду `!hello`.

### PingCommand

```java
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

@Command("ping")
public class PingCommand implements ICommand {
    @Override
    public void execute(MessageReceivedEvent event) {
        event.getChannel().sendMessage("Pong!").queue();
    }
}
```

### HelloCommand

```java
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

@Command("hello")
public class HelloCommand implements ICommand {
    @Override
    public void execute(MessageReceivedEvent event) {
        event.getChannel().sendMessage("Hello, " + event.getAuthor().getName() + "!").queue();
    }
}
```

## Лицензия

Этот проект лицензирован под лицензией MIT. Подробности смотрите в файле [LICENSE](LICENSE).

---

Этот README должен дать четкое представление о проекте, его установке и использовании, а также о том, как создавать и добавлять новые команды. Не забудьте заменить ссылки и информацию на те, которые соответствуют вашему проекту и репозиторию.

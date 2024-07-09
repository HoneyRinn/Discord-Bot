package org.example;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommandHandler {
    private final Map<String, DisCommand> commandMap = new HashMap<>();

    public CommandHandler(String basePackage) {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .forPackages(basePackage)
                .addScanners(Scanners.TypesAnnotated)); //Используется библиотека Reflections для сканирования аннотации команд

        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(Command.class);
        for (Class<?> clazz : annotatedClasses) {
            try {
                Command commandAnnotation = clazz.getAnnotation(Command.class);
                DisCommand commandInstance = (DisCommand) clazz.getDeclaredConstructor().newInstance();
                commandMap.put(commandAnnotation.value(), commandInstance);
                System.out.println("Registered command: " + commandAnnotation.value()); // Debug output
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public void handleCommand(String command, MessageReceivedEvent event) {
        DisCommand commandInstance = commandMap.get(command);
        if (commandInstance != null) {
            commandInstance.execute(event);
        } else {
            System.out.println("Command not found: " + command); // Debug output
        }
    }
}

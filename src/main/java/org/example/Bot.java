package org.example;
import net.dv8tion.jda.annotations.Incubating;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;


public class Bot extends ListenerAdapter {
    private final CommandHandler commandHandler;

    public Bot() {
        this.commandHandler = new CommandHandler("org.example.commands");
    }

    public static void main(String[] args) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault("MTI2MDI5MTYyNjM2MjczMjYyNQ.G9NjUW.knjW_DHgfhsnn8pihUm5K4I6KqovlGTNc7VYiU");
        builder.setActivity(Activity.playing("Ебу и ем одновременно"));
        builder.enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT);
        builder.addEventListeners(new Bot());
        builder.build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        String message = event.getMessage().getContentRaw();
        if (message.startsWith("!")) {
            String command = message.substring(1); // Убираем префикс "!"
            System.out.println("Received command: " + command);
            commandHandler.handleCommand(command, event);
        }
    }
}
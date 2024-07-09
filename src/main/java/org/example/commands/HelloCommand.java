package org.example.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.example.Command;
import org.example.DisCommand;

@Command("hello")
public class HelloCommand implements DisCommand {
    @Override
    public void execute(MessageReceivedEvent event) {
        event.getChannel().sendMessage("Hello, " + event.getAuthor().getName() + "!").queue();
    }
}

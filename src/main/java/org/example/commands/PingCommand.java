package org.example.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.example.Command;
import org.example.DisCommand;

@Command("ping")
public class PingCommand implements DisCommand {
    @Override
    public void execute(MessageReceivedEvent event) {
        event.getChannel().sendMessage("Pong!").queue();
    }
}


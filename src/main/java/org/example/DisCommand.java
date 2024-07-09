package org.example;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface DisCommand {
    void execute(MessageReceivedEvent event);
}

package org.example.commands;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import net.dv8tion.jda.api.audio.AudioSendHandler;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.managers.AudioManager;
import org.example.Command;
import org.example.DisCommand;
import org.example.handlers.AudioPlayerHandler;

@Command("play")
public class MusicCommand implements DisCommand {
    @Override
    public void execute(MessageReceivedEvent event) {
        Member member = event.getMember();
        Guild guild = event.getGuild();
        VoiceChannel voiceChannel = member.getVoiceState().getChannel().asVoiceChannel();

        AudioManager audioManager = guild.getAudioManager();
        audioManager.openAudioConnection(voiceChannel);
        AudioPlayerManager apm = new DefaultAudioPlayerManager();
        AudioSourceManagers.registerLocalSource(apm);
        AudioPlayer player = apm.createPlayer();

        AudioPlayerHandler aphandler = new AudioPlayerHandler(player);
        audioManager.setSendingHandler(aphandler);
    }
}

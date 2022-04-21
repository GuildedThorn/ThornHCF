package com.guildedthorn.thornhcf.bot;

import com.guildedthorn.thornhcf.ThornHCF;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import tech.xigam.cch.ComplexCommandHandler;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;

public class HCFBot {

    public static JDA jda;
    public static ComplexCommandHandler commandHandler;

    public void Initialize(String token) throws LoginException {
        commandHandler = new ComplexCommandHandler(true)
                .setPrefix(ThornHCF.getInstance().getConfig().getString("Bot.prefix"));
        jda = JDABuilder.create(token, EnumSet.allOf(GatewayIntent.class))
                .setAutoReconnect(true)
                .setActivity(getActivityByNumber(ThornHCF.getInstance().getConfig().getString("Bot.activity_type")))
                .build();
        commandHandler.setJda(jda);
    }

    private Activity getActivityByNumber(String activity_type) {
        return switch (activity_type) {
            case "1" -> Activity.watching(ThornHCF.getInstance().getConfig().getString("Bot.activity_message"));
            case "2" -> Activity.listening(ThornHCF.getInstance().getConfig().getString("Bot.activity_message"));
            case "3" -> Activity.competing(ThornHCF.getInstance().getConfig().getString("Bot.activity_message"));
            case "4" -> Activity.playing(ThornHCF.getInstance().getConfig().getString("Bot.activity_message"));
            case "5" -> Activity.streaming(ThornHCF.getInstance().getConfig().getString("Bot.activity_message"), ThornHCF.getInstance().getConfig().getString("Bot.activity_url"));
            default -> Activity.watching(" the idot who configured this");
        };
    }

    public static JDA getJDA() {
        return jda;
    }
}

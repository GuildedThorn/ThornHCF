package com.guildedthorn.thornhcf.managers;

import com.guildedthorn.thornhcf.ThornHCF;
import com.guildedthorn.thornhcf.bot.HCFBot;

import javax.security.auth.login.LoginException;

public class BotManager {

    public static HCFBot bot;

    public BotManager() {
        Initialize();
    }
    
    private void Initialize() {
        try {
            bot = new HCFBot();
            bot.Initialize(ThornHCF.getInstance().getConfig().getString("Bot.token"));   
        } catch (LoginException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static HCFBot getBot() {
        return bot;
    }
}
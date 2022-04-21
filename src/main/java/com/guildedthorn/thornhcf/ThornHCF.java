package com.guildedthorn.thornhcf;

import cn.nukkit.plugin.PluginBase;
import com.guildedthorn.thornhcf.managers.BotManager;

public class ThornHCF extends PluginBase {

    protected static ThornHCF instance;
    protected static BotManager botManager;
    
    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        //TODO Make Autoloader that automatically initializes each manager
        //TODO Make this 100% WebAPI Based to save resources
        new BotManager();
    }

    public static ThornHCF getInstance() {
        return instance;
    }
}

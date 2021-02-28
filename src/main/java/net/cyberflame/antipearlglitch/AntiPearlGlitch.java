package net.cyberflame.antipearlglitch;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiPearlGlitch
  extends JavaPlugin
  implements Listener {
  public void onEnable() {
    getServer().getPluginManager().registerEvents(this, (Plugin)this);
  }
  
  @EventHandler
  public void onPlayerTeleport(PlayerTeleportEvent event) {
    if (event.getCause().equals(PlayerTeleportEvent.TeleportCause.ENDER_PEARL)) {
      Location location = event.getTo();
      
      location.setX(location.getBlockX() + 0.5D);
      location.setY(location.getBlockY());
      location.setZ(location.getBlockZ() + 0.5D);
      
      event.setTo(location);
    } 
  }
}

package retsrif.NoteBlockGUI;

import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.keyboard.Keyboard;


public class NoteBlockGUI extends JavaPlugin {
	
	public void onDisable() {
		System.out.println("[NoteBlockGUI] disabled.");
	}

	public void onEnable() {
		SpoutManager.getKeyBindingManager().registerBinding("Open NoteBlockGUI", Keyboard.KEY_N, "Opens the NoteBlockGUI", new NBGKeyListener(this), this);
		System.out.println("[NoteBlockGUI] enabled.");
	}
	
	
}

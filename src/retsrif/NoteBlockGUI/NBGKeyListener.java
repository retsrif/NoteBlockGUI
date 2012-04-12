package retsrif.NoteBlockGUI;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.NoteBlock;
import org.getspout.spoutapi.event.input.KeyBindingEvent;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.keyboard.BindingExecutionDelegate;
import org.getspout.spoutapi.player.SpoutPlayer;

public class NBGKeyListener implements BindingExecutionDelegate {
	NoteBlockGUI plugin;
	
	public NBGKeyListener(NoteBlockGUI instance) {
		plugin = instance;
	}

	public void keyPressed(KeyBindingEvent arg0) {
		if(arg0.getScreenType() == ScreenType.GAME_SCREEN) {
			SpoutPlayer sp = arg0.getPlayer();
			Block b = sp.getTargetBlock(null, 100);
			if(b.getType() == Material.NOTE_BLOCK) {
				//pitch and octave
				NoteBlock nb = (NoteBlock)b.getState();
				String str = nb.getNote().getTone().name();
				if(nb.getNote().isSharped())
					str = str.concat("#");
				int octa = nb.getNote().getOctave();
				String oct = String.valueOf(octa);
				
				//instrument
				String instr;
				Block ub = b.getRelative(BlockFace.DOWN);
				if(ub.getType() == Material.GLASS) {
					instr = "Clicks";
				}
				else if(ub.getType() == Material.SAND || ub.getType() == Material.GRAVEL || ub.getType() == Material.SOUL_SAND) {
					instr = "Snare Drum";
				}
				else if(ub.getType() == Material.OBSIDIAN || ub.getType() == Material.BRICK || ub.getType() == Material.NETHERRACK || ub.getType() == Material.NETHER_BRICK 
						|| ub.getType() == Material.STONE || ub.getType() == Material.COBBLESTONE || ub.getType() == Material.COAL_ORE || ub.getType() == Material.GOLD_ORE
						|| ub.getType() == Material.DIAMOND_ORE || ub.getType() == Material.REDSTONE_ORE || ub.getType() == Material.IRON_ORE || ub.getType() == Material.LAPIS_ORE) {
					instr = "Bass Drum";
				}
				else if(ub.getType() == Material.LOG || ub.getType() == Material.WOOD || ub.getType() == Material.BOOKSHELF || ub.getType() == Material.CHEST || ub.getType() == Material.WORKBENCH
						|| ub.getType() == Material.FENCE || ub.getType() == Material.FENCE_GATE || ub.getType() == Material.JUKEBOX || ub.getType() == Material.NOTE_BLOCK) {
					instr = "Bass Guitar";
				}
				else {
					instr = "Piano";
				}
				
				//gui
				GUI gui = new GUI();
				gui.openGUI(plugin, sp, instr, str, oct, ub, nb);
			}
		}
	}

	public void keyReleased(KeyBindingEvent arg0) { }
}

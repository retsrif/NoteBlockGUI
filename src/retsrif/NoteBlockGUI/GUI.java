package retsrif.NoteBlockGUI;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Note.Tone;
import org.bukkit.block.Block;
import org.bukkit.block.NoteBlock;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericItemWidget;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class GUI {
	public static Block b;
	public static SpoutPlayer p;
	public static UUID inid;
	public static UUID pid;
	public static UUID octid;
	public static int octave;
	public static NoteBlock note;
	
	public static void openGUI(Plugin plugin, SpoutPlayer player, String instr, String pit, String oct, Block ub, NoteBlock nb) {
		int line = 20;
		octave = Integer.parseInt(oct);
		b = ub;
		p = player;
		note = nb;
		
		Color white = new Color(255, 255, 255);
		Color green = new Color(0, 255, 0);
		Color yellow = new Color(255, 255, 0);
		
		//TITLE
		GenericLabel title = new GenericLabel();
		title.setAlign(WidgetAnchor.TOP_CENTER);
		title.setAnchor(WidgetAnchor.TOP_CENTER);
		title.setHeight(line);
		title.setText("Note Block GUI").setTextColor(green);	
		
		//INSTRUMENT
		//label
		GenericLabel instrumentTitle = new GenericLabel();
		instrumentTitle.setHeight(line);
		instrumentTitle.setX(0).setY(title.getY()+line);
		instrumentTitle.setText("Instrument: ").setTextColor(white);
		//type
		GenericLabel instrument = new GenericLabel();
		instrument.setHeight(line);
		inid = instrument.getId();
		int instrx = (int)(instrumentTitle.getWidth()*1.2);
		instrument.setX(instrx).setY(instrumentTitle.getY());
		instrument.setText(instr).setTextColor(yellow);
		
		int iny = instrument.getY()-instrument.getY()/4;
		
		//piano
		GenericButton piano = new GenericButton("Piano") {
			public void onButtonClick(ButtonClickEvent event) {
					setType(Material.GRASS);
			}
		};
		piano.setHeight(line).setWidth(62);
		piano.setX(117).setY(iny);
		//bass guitar
		GenericButton bassGuitar = new GenericButton("Bass Guitar") {
			public void onButtonClick(ButtonClickEvent event) {
					setType(Material.WOOD);
			}
		};
		bassGuitar.setHeight(line).setWidth(62);
		bassGuitar.setX(piano.getX()+62).setY(iny);
		//snare drum
		GenericButton snareDrum = new GenericButton("Snare Drum") {
			public void onButtonClick(ButtonClickEvent event) {
					setType(Material.SAND);
			}
		};
		snareDrum.setHeight(line).setWidth(62);
		snareDrum.setX(bassGuitar.getX()+62).setY(iny);
		//clicks
		GenericButton clicks = new GenericButton("Clicks") {
			public void onButtonClick(ButtonClickEvent event) {
					setType(Material.GLASS);
			}
		};
		clicks.setHeight(line).setWidth(62);
		clicks.setX(snareDrum.getX()+62).setY(iny);
		//bass drum
		GenericButton bassDrum = new GenericButton("Bass Drum") {
			public void onButtonClick(ButtonClickEvent event) {
					setType(Material.STONE);
			}
		};
		bassDrum.setHeight(line).setWidth(62);
		bassDrum.setX(clicks.getX()+62).setY(iny);
		
		
		//PITCH
		//label
		GenericLabel pitchTitle = new GenericLabel();
		pitchTitle.setText("Pitch: ").setTextColor(white);
		pitchTitle.setHeight(line);
		pitchTitle.setX(0).setY(instrumentTitle.getY()+2*line);
		//pitch
		GenericLabel pitch = new GenericLabel();
		pitch.setText(pit).setTextColor(yellow);
		pitch.setHeight(line);
		pitch.setX(pitchTitle.getWidth()).setY(pitchTitle.getY());
		pid = pitch.getId();
		
		//row 1
		//F#
		GenericButton fs = new GenericButton("F#") {
			public void onButtonClick(ButtonClickEvent event) {
				setPitch("F#");
			}
		};
		fs.setHeight(line).setWidth(line);
		fs.setX(170).setY(pitch.getY()+10);
		//G
		GenericButton g = new GenericButton("G") {
			public void onButtonClick(ButtonClickEvent event) {
				setPitch("G");
			}
		};
		g.setHeight(line).setWidth(line);
		g.setX(193).setY(pitch.getY()+10);
		//G#
		GenericButton gs = new GenericButton("G#") {
			public void onButtonClick(ButtonClickEvent event) {
				setPitch("G#");
			}
		};
		gs.setHeight(line).setWidth(line);
		gs.setX(215).setY(pitch.getY()+10);
		//A
		GenericButton a = new GenericButton("A") {
			public void onButtonClick(ButtonClickEvent event) {
				setPitch("A");
			}
		};
		a.setHeight(line).setWidth(line);
		a.setX(238).setY(pitch.getY()+10);
		
		//row 2
		//A#
		GenericButton as = new GenericButton("A#") {
			public void onButtonClick(ButtonClickEvent event) {
				setPitch("A#");
			}
		};
		as.setHeight(line).setWidth(line);
		as.setX(170).setY(pitch.getY()+31);
		//B
		GenericButton b = new GenericButton("B") {
			public void onButtonClick(ButtonClickEvent event) {
				setPitch("B");
			}
		};
		b.setHeight(line).setWidth(line);
		b.setX(193).setY(pitch.getY()+31);
		//C
		GenericButton c = new GenericButton("C") {
			public void onButtonClick(ButtonClickEvent event) {
				setPitch("C");
			}
		};
		c.setHeight(line).setWidth(line);
		c.setX(215).setY(pitch.getY()+31);
		//C#
		GenericButton cs = new GenericButton("C#") {
			public void onButtonClick(ButtonClickEvent event) {
				setPitch("C#");
			}
		};
		cs.setHeight(line).setWidth(line);
		cs.setX(238).setY(pitch.getY()+31);
		
		//row 3
		//D
		GenericButton d = new GenericButton("D") {
			public void onButtonClick(ButtonClickEvent event) {
				setPitch("D");
			}
		};
		d.setHeight(line).setWidth(line);
		d.setX(170).setY(pitch.getY()+53);
		//D#
		GenericButton ds = new GenericButton("D#") {
			public void onButtonClick(ButtonClickEvent event) {
				setPitch("D#");
			}
		};
		ds.setHeight(line).setWidth(line);
		ds.setX(193).setY(pitch.getY()+53);
		//E
		GenericButton e = new GenericButton("E") {
			public void onButtonClick(ButtonClickEvent event) {
				setPitch("E");
			}
		};
		e.setHeight(line).setWidth(line);
		e.setX(215).setY(pitch.getY()+53);
		//F
		GenericButton f = new GenericButton("F") {
			public void onButtonClick(ButtonClickEvent event) {
				setPitch("F");
			}
		};
		f.setHeight(line).setWidth(line);
		f.setX(238).setY(pitch.getY()+53);
		
		//OCTAVE
		//label
		GenericLabel octaveTitle = new GenericLabel();
		octaveTitle.setText("Octave: ").setTextColor(white);
		octaveTitle.setHeight(line);
		octaveTitle.setX(0).setY(f.getY()+2*line);
		//octave
		GenericLabel octave = new GenericLabel();
		octave.setText(oct).setTextColor(yellow);
		octave.setHeight(line);
		octave.setX(octaveTitle.getWidth()).setY(octaveTitle.getY());
		octid = octave.getId();
		//1
		GenericButton one = new GenericButton("1") {
			public void onButtonClick(ButtonClickEvent event) {
				setOctave(0);
			}
		};
		one.setHeight(line).setWidth(105);
		one.setX(95).setY(octave.getY()-5);
		//2
		GenericButton two = new GenericButton("2") {
			public void onButtonClick(ButtonClickEvent event) {
				setOctave(1);
			}
		};
		two.setHeight(line).setWidth(105);
		two.setX(205).setY(octave.getY()-5);
		//3
		GenericButton three= new GenericButton("3") {
			public void onButtonClick(ButtonClickEvent event) {
				setOctave(2);
			}
		};
		three.setHeight(line).setWidth(105);
		three.setX(315).setY(octave.getY()-5);
		
		//PLAY
		GenericButton play = new GenericButton("PLAY") {
			public void onButtonClick(ButtonClickEvent event) {
				playNote();
			}
		};
		play.setX(107).setY(200);
		play.setWidth(214).setHeight(line);
		
		//popup
		GenericPopup popup = new GenericPopup();
		popup.attachWidget(plugin, title);
		popup.attachWidget(plugin, instrumentTitle);
		popup.attachWidget(plugin, instrument);
		popup.attachWidget(plugin, piano);
		popup.attachWidget(plugin, bassGuitar);
		popup.attachWidget(plugin, snareDrum);
		popup.attachWidget(plugin, clicks);
		popup.attachWidget(plugin, bassDrum);
		popup.attachWidget(plugin, pitchTitle);
		popup.attachWidget(plugin, pitch);
		popup.attachWidget(plugin, fs);
		popup.attachWidget(plugin, g);
		popup.attachWidget(plugin, gs);
		popup.attachWidget(plugin, a);
		popup.attachWidget(plugin, as);
		popup.attachWidget(plugin, b);
		popup.attachWidget(plugin, c);
		popup.attachWidget(plugin, cs);
		popup.attachWidget(plugin, d);
		popup.attachWidget(plugin, ds);
		popup.attachWidget(plugin, e);
		popup.attachWidget(plugin, f);
		popup.attachWidget(plugin, octaveTitle);
		popup.attachWidget(plugin, octave);
		popup.attachWidget(plugin, one);
		popup.attachWidget(plugin, two);
		popup.attachWidget(plugin, three);
		popup.attachWidget(plugin, play);
		
		player.getMainScreen().attachPopupScreen(popup);
	}
	
	public static void setType(Material mat) {
		b.setType(mat);
		switch(mat) {
		case GRASS:
			getLabel(inid).setText("Piano");
			break;
		case STONE:
			getLabel(inid).setText("Bass Drum");
			break;
		case GLASS:
			getLabel(inid).setText("Clicks");
			break;
		case SAND:
			getLabel(inid).setText("Snare Drum");
			break;
		case WOOD:
			getLabel(inid).setText("Bass Guitar");
			break;
		default:
			break;
		}
		
		note.play();
	}
	
	public static void playNote() {
		note.play();
	}
	
	public static GenericLabel getLabel(UUID id) {
		return (GenericLabel)p.getMainScreen().getActivePopup().getWidget(id);
	}
	
	public static void setPitch(String pitch) {
		boolean sharped = false;
		Tone tone = Tone.F;
		if(pitch.length() > 1) {
			sharped = true;
		}
		if(pitch.startsWith("F")) {
			tone = Tone.F;
		}
		if(pitch.startsWith("G")) {
			tone = Tone.G;
		}
		if(pitch.startsWith("A")) {
			tone = Tone.A;
		}
		if(pitch.startsWith("B")) {
			tone = Tone.B;
		}
		if(pitch.startsWith("C")) {
			tone = Tone.C;
		}
		if(pitch.startsWith("D")) {
			tone = Tone.D;
		}
		if(pitch.startsWith("E")) {
			tone = Tone.E;
		}
		
		if(octave == 2 && !(pitch.equals("F#"))) {
			sharped = true;
			tone = Tone.F;
		}
		
		note.setNote(new Note(octave, tone, sharped));
		
		String s = tone.name();
		if(sharped)
			s = s.concat("#");
		
		getLabel(pid).setText(s);
		
		note.play();
	}
	
	public static void setOctave(int oct) {
		octave = oct;
		getLabel(octid).setText(String.valueOf(oct+1));
		
		if(oct == 2 && !(getLabel(pid).getText().equals("F#"))) {
			setPitch("F#");
		}
		
		note.play();
	}
 }

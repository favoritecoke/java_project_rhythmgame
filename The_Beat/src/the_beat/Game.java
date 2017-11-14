package the_beat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class Game extends Thread {
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image judgeImage;
	
	static int notesize = 0;
	static Note a ;
	private String titleName;
	private String musicTitle;
	private static Music gameMusic;
	private NoteBeat[] beats = null;
	static String result;

	private static Judge judge;

	ArrayList<Note> noteList = new ArrayList<Note>();

	public Game(String titleName, String musicTitle) {
		this.titleName = titleName;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}

	public void screenDraw(Graphics2D g) {

		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteJImage, 540, 30, null);
		g.drawImage(noteRouteKImage, 644, 30, null);
		g.drawImage(noteRouteLImage, 748, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 640, 30, null);
		g.drawImage(noteRouteLineImage, 744, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		g.drawImage(judgeImage, 360, 420, null);

		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			a=note;
			if (note.getY() > 620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/miss.png")).getImage();
				judge.plusScore("miss");
			}
			if (!note.isProceeded()) {
				noteList.remove(i);
				i--;
			} else {
				note.screenDraw(g);
			}
		}

		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 615);
		g.drawString("D", 374, 615);
		g.drawString("F", 478, 615);
		g.drawString("J", 572, 615);
		g.drawString("K", 676, 615);
		g.drawString("L", 780, 615);

	}

	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}

	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}

	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}

	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}

	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}

	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	@Override
	public void run() {
		dropNotes();
		
	}

	public static void gameEnd() {
		Timer tm = new Timer();
		TimerTask tt = new TimerTask() {
			@Override
			public void run() {
				close();
			}
		};
		tm.schedule(tt, 3000);
	}

	public static  void close() {
		result = judge.calculateGrade();
		
		System.out.println("³¡" + result);
		gameMusic.close();
		//this.interrupt();
		Beat.resultMain();
	}

	public void dropNotes() {
		NoteBeat[] beats = null;
		if (titleName.equals("elise")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new NoteBeat[] { 
					new NoteBeat(startTime + gap * 2, "K"), new NoteBeat(startTime + gap * 4, "S"),
					new NoteBeat(startTime + gap * 6, "J"), new NoteBeat(startTime + gap * 8, "S"),
					new NoteBeat(startTime + gap * 10, "F"), new NoteBeat(startTime + gap * 12, "J"),
					new NoteBeat(startTime + gap * 14, "S"), new NoteBeat(startTime + gap * 16, "K"),
					new NoteBeat(startTime + gap * 18, "F"), new NoteBeat(startTime + gap * 20, "L"),
					new NoteBeat(startTime + gap * 22, "F"), new NoteBeat(startTime + gap * 24, "S"),
					new NoteBeat(startTime + gap * 26, "L"), new NoteBeat(startTime + gap * 28, "D"),
					new NoteBeat(startTime + gap * 30, "F"),
	

			};
			notesize=beats.length;
			System.out.println(notesize);

		} else if (titleName.equals("summer")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new NoteBeat[] { new NoteBeat(startTime + gap * 4, "S"), new NoteBeat(startTime + gap * 8, "K"),
					new NoteBeat(startTime + gap * 13, "D"), new NoteBeat(startTime + gap * 16, "K"),
					new NoteBeat(startTime + gap * 19, "D"), new NoteBeat(startTime + gap * 22, "L"),
					new NoteBeat(startTime + gap * 24, "D"), new NoteBeat(startTime + gap * 26, "L"),
					new NoteBeat(startTime + gap * 28, "D"), new NoteBeat(startTime + gap * 30, "L"),


			};
			notesize=beats.length;
			System.out.println(notesize);

		} else if (titleName.equals("canon")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new NoteBeat[] { new NoteBeat(startTime + gap * 10, "K"), new NoteBeat(startTime + gap * 22, "F"),
					new NoteBeat(startTime + gap * 33, "J"), new NoteBeat(startTime + gap * 45, "D"),
					new NoteBeat(startTime + gap * 54, "J"), new NoteBeat(startTime + gap * 66, "K"),
					

			};
			notesize=beats.length;
			System.out.println(notesize);

		}
		int i = 0;
		judge = new Judge(beats.length);
		gameMusic.start();
		while (i < beats.length && !isInterrupted()) {
			boolean dropped = false;

			if (beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if (!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}

	public void judge(String input) {

		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (input.equals(note.getNoteType())) {
				String s = "";
				judgeEvent(s = note.judge());
				judge.plusScore(s);
			
				break;
			}
		}
	}

	public void judgeEvent(String judge) {
		if (judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/miss.png")).getImage();
		} else if (judge.equals("Bad")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/bad.png")).getImage();
		} else if (judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/good.png")).getImage();
		} else if (judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/perfect.png")).getImage();
		}

	}
}

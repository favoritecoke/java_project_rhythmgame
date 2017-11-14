package the_beat;

public class NoteBeat {
	private int time;
	private String noteName;
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getNoteName() {
		return noteName;
	}
	
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	public NoteBeat(int time, String noteName) {
		super();
		this.time = time;
		this.noteName = noteName;
	}
	
}

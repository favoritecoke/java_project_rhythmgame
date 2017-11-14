package the_beat;

public class Judge {

	static int perfect;
	static int good;
	static int miss;
	static int bad;
	static int noteCnt;


	final String[] grade = new String[] { "S", "A", "B", "C", "F" };

	public Judge(int noteCnt) {
		bad = 0;
		good = 0;
		perfect = 0;
		miss = 0;
		this.noteCnt = noteCnt;
	}

	public String[] getGrade() {
		return grade;
	}

	public void plusScore(String score){
		String s = score.toLowerCase();

		if(s.equals("perfect")){
			++perfect;
		}
		else if(s.equals("good")){
			++good;
		}
		else if(s.equals("miss")){
			miss++;
		}
		else if(s.equals("bad")){
			bad++;
		}


	}


	public String calculateGrade(){
		int max = (int)((perfect*1 + good*0.7 + bad*0.3 + miss*0)/noteCnt*100);

		System.out.println("³ëÆ®°³¼ö:"+noteCnt+" ,ÆÛÆåÆ®:"+perfect+", ±»: "+ good+" ,º£µå: "+bad+" ,¹Ì½º: "+miss);

		if(max == 100) {
			return grade[0];
		} else if(max >=70) {
			return grade[1];
		} else if(max >=50) {
			return grade[2];
		} else if(max>=30) {
			return grade[3];
		} else {
			return grade[4];
		}
	}



}
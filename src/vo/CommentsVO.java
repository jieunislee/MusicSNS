package vo;

public class CommentsVO {
	private int idx;
	private String c_name;
	private String c_content;
	private String c_date;
	private int c_goodpoint;
	private int musicidx;
	private int memberidx;

	public CommentsVO() {}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}

	public String getC_date() {
		return c_date;
	}

	public void setC_date(String c_date) {
		this.c_date = c_date;
	}

	public int getC_goodpoint() {
		return c_goodpoint;
	}

	public void setC_goodpoint(int c_goodpoint) {
		this.c_goodpoint = c_goodpoint;
	}

	public int getMusicidx() {
		return musicidx;
	}

	public void setMusicidx(int musicidx) {
		this.musicidx = musicidx;
	}
	public int getMemberidx() {
		return memberidx;
	}
	public void setMemberidx(int memberidx) {
		this.memberidx = memberidx;
	}
}

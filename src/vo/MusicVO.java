package vo;

public class MusicVO {
	private int idx; 
	private String m_title;
	private String m_content; 
	private String m_musicfile;
	private String m_image; 
	private String m_date;
	private String name;
	private int m_goodpoint;
	private int memberidx;
	public MusicVO() {}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getMemberidx() {
		return memberidx;
	}
	public void setMemberidx(int memberidx) {
		this.memberidx = memberidx;
	}
	
	public int getM_goodpoint() {
		return m_goodpoint;
	}
	public void setM_goodpoint(int m_goodpoint) {
		this.m_goodpoint = m_goodpoint;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getM_title() {
		return m_title;
	}
	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
	public String getM_content() {
		return m_content;
	}
	public void setM_content(String m_content) {
		this.m_content = m_content;
	}
	public String getM_musicfile() {
		return m_musicfile;
	}
	public void setM_musicfile(String m_musicfile) {
		this.m_musicfile = m_musicfile;
	}
	public String getM_image() {
		return m_image;
	}
	public void setM_image(String m_image) {
		this.m_image = m_image;
	}
	public String getM_date() {
		return m_date;
	}
	public void setM_date(String m_date) {
		this.m_date = m_date;
	}
}

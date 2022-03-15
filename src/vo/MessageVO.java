package vo;

public class MessageVO {
	private int idx;
	private int sendIdx;
	private String sendId;
	private String receivedId;
	private String msg;
	
	public MessageVO() {
		// TODO Auto-generated constructor stub
	}

	public MessageVO(int idx, int sendIdx, String sendId, String receivedId, String msg) {
		this.idx = idx;
		this.sendIdx = sendIdx;
		this.sendId = sendId;
		this.receivedId = receivedId;
		this.msg = msg;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getSendIdx() {
		return sendIdx;
	}

	public void setSendIdx(int sendIdx) {
		this.sendIdx = sendIdx;
	}

	public String getSendId() {
		return sendId;
	}
	
	public void setSendId(String sendId) {
		this.sendId = sendId;
	}
	public String getReceivedId() {
		return receivedId;
	}

	public void setReceivedId(String receivedId) {
		this.receivedId = receivedId;
	}

	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}

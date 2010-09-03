package model;

public class Description {
	private int pno;
	private String text;
	private String langCode;
	
	public Description(int pno, String text, String langCode) {
		this.pno = pno;
		this.text = text;
		this.langCode = langCode;
	}
	
	public Description() {
		
	}
	

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
	
	
}

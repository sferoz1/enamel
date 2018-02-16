package enamel;

public class ScenarioEvent {
	private String title;
	private String question;
	private String responseRight;
	private String responseWrong;
	private int correctAns;
	public int index;
	
	public ScenarioEvent(int index, String title, String question, String responseRight, String responseWrong, int correctAns) {
		this.index = index;
		this.title = title;
		this.question = question;
		this.responseRight = responseRight;
		this.responseWrong = responseWrong;
		this.correctAns = correctAns;
		
	}

	public void overwrite(String title, String question, String responseRight, String responseWrong, int correctAns) {
		this.title = title;
		this.question = question;
		this.responseRight = responseRight;
		this.responseWrong = responseWrong;
		this.correctAns = correctAns;
		
	}
	public String getTitle(){
		return this.title;
	}
	
	public String getQuestion(){
		return this.question;
		
	}
	
	public String getResponseRight(){
		return this.responseWrong;
		
	}
	
	public String getResponseWrong(){
		return this.responseRight;
		
	}
	
	public int getCorrectAns(){
		return this.correctAns;
	}

	public void setIndex(int i) {
		this.index = i;
		
	}
	
	public String toString(){
		return this.title;
	}
	
	
	
	
}

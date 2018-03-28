package enamel;

public class ScenarioEvent implements Comparable<ScenarioEvent>{
	private String title;
	private String question;
	private String responseRight;
	private String responseWrong;
	private String questionAudio, responseRightAudio, responseWrongAudio;
	public String[] cellArray;
	private int correctAns;
	public int index;
	
	public ScenarioEvent(int index, String title, String question, String questionAudio, String responseRight, String responseRightAudio, String responseWrong, String responseWrongAudio, String[] cellArray, int correctAns) {
		this.cellArray = cellArray;
		this.index = index;
		this.title = title;
		this.question = question;
		this.questionAudio = questionAudio;
		this.responseRight = responseRight;
		this.responseRightAudio = responseRightAudio;
		this.responseWrong = responseWrong;
		this.responseWrongAudio = responseWrongAudio;
		this.correctAns = correctAns;
		
	}

	public void overwrite(int index, String title, String question, String questionAudio, String responseRight, String responseRightAudio, String responseWrong, String responseWrongAudio, String[] cellArray, int correctAns) {
		this.index = index;
		this.cellArray = cellArray.clone();
		this.title = title;
		this.question = question;
		this.questionAudio = questionAudio;
		this.responseRight = responseRight;
		this.responseRightAudio = responseRightAudio;
		this.responseWrong = responseWrong;
		this.responseWrongAudio = responseWrongAudio;
		this.correctAns = correctAns;
		
	}
	public String getTitle(){
		return this.title;
	}
	
	public String getQuestion(){
		return this.question;
		
	}
	public void setQuestionAudio(String s) {
		this.questionAudio = s;
	}
	
	public String getQuestionAudio(){
		return this.questionAudio;
	}
	
	public void setResponseRight(String s) {
		this.responseRight = s;
	}
	
	public String getResponseRight(){
		return this.responseRight;
		
	}
	
	public void setResponseRightAudio(String s) {
		this.responseRightAudio = s;
	}
	
	public String getResponseRightAudio(){
		return this.responseRightAudio;
	}
	
	
	
	
	
	
	
	public String getResponseWrong(){
		return this.responseWrong;
	}
	
	public String getResponseWrongAudio(){
		return this.responseWrongAudio;
	}
	
	public void setResponseWrongAudio(String s) {
		this.responseWrongAudio = s;
	}
	
	public int getCorrectAns(){
		return this.correctAns;
	}

	public void setIndex(int i) {
		this.index = i;
		
	}
	
	public int getIndex() {
		int i = this.index;
		return i;
	}
	
	public String[] getCellArray() {
		return this.cellArray;
	}
	
	
	public String toString(){
		return this.title;
	}	
	
	public int compareTo(ScenarioEvent e) {
		int otherIndex = e.getIndex();
		int thisIndex = this.getIndex();
		if(thisIndex > otherIndex) {
			return 1;
		} else if (thisIndex < otherIndex) {
			return -1;
		} else {
			return -1;
		}
	}
	
}

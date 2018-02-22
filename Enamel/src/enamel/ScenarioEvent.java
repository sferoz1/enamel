package enamel;

public class ScenarioEvent implements Comparable<ScenarioEvent>{
	private String title;
	private String question;
	private String responseRight;
	private String responseWrong;
	public String[] cellArray;
	private int correctAns;
	public int index;
	
	public ScenarioEvent(int index, String title, String question, String responseRight, String responseWrong, String[] cellArray, int correctAns) {
		this.cellArray = cellArray;
		this.index = index;
		this.title = title;
		this.question = question;
		this.responseRight = responseRight;
		this.responseWrong = responseWrong;
		this.correctAns = correctAns;
		
	}

	public void overwrite(String title, String question, String responseRight, String responseWrong, String[] cellArray, int correctAns) {
		this.cellArray = cellArray.clone();
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

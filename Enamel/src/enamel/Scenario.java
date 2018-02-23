package enamel;

public class Scenario {
	protected int cellNumber =0;
	protected int buttonNumber=0;
	public String title = "";
	public EventList scenarioEventList;
	public String Title = "";
	
	public Scenario(int cells, int buttons,String Title, EventList events) {
		this.cellNumber = cells;
		this.buttonNumber = buttons;
		this.scenarioEventList = events;
		this.Title = Title;
	}
	public Scenario() {
		this.cellNumber = -5;
		this.buttonNumber = -5;
		this.scenarioEventList = new EventList();
		this.Title = null;
	}
	
	public int getCellNumber() {
		return this.cellNumber;
	}
	public void setCellNumber(int cellNumber){
		this.cellNumber = cellNumber;
	}
	public int getButtonNumber() {
		return this.buttonNumber;
	}
	public void setButtonNumber(int buttonNumber) {
		this.buttonNumber  = buttonNumber;
	}
	public EventList getScenarioEventList() {
		return this.scenarioEventList;
	}
	public void setScenarioEventList(EventList eventList) {
		this.scenarioEventList = eventList;
	}
	public void setTitle (String title) {
		this.Title = title;
	}
	public String getTitle () {
		return this.Title;
	}
	
}

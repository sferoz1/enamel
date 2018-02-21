package enamel;

public class Scenario {
	protected int cellNumber =0;
	protected int buttonNumber=0;
	public String title = "";
	public EventList scenarioEventList = new EventList();
	public String Title = "";
	
	public Scenario(int cells, int buttons,String Title, EventList events) {
		this.cellNumber = cells;
		this.buttonNumber = buttons;
		this.scenarioEventList = events;
		this.Title = Title;
	}
	
	
	
}

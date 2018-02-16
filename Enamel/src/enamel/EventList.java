package enamel;

import java.util.LinkedList;

public class EventList {
	private LinkedList<ScenarioEvent> timeline;
	
	public EventList(){
		this.timeline = new LinkedList<ScenarioEvent>();
	}
	
	public void add(int index, ScenarioEvent e){
		timeline.add(index, e);
		updateIndexes();
	}
	
	public void remove(ScenarioEvent e){
		timeline.remove(e);
		updateIndexes();
		}
	
	private void updateIndexes(){
		for(int i = 0; i < timeline.size(); i++){
			timeline.get(i).setIndex(i);
		}
	}
}

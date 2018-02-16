package enamel;

import java.util.LinkedList;

public class EventList {
	private LinkedList<ScenarioEvent> timeline;
	
	public EventList(){
		this.timeline = new LinkedList<ScenarioEvent>();
	}
	
	public void add(int index, ScenarioEvent e){
		timeline.add(e);
		updateIndexes();
	}
	
	public void remove(ScenarioEvent e){
		timeline.remove(e);
		updateIndexes();
	}
	
	public int size(){
		return timeline.size();
	}
	
	private void updateIndexes(){
		for(int i = 0; i < timeline.size(); i++){
			timeline.get(i).setIndex(i);
		}
	}
}

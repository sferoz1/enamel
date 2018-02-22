package enamel;

import java.util.Collections;


import java.util.LinkedList;

public class EventList extends LinkedList<ScenarioEvent>{
	private int size;
	
	protected LinkedList<ScenarioEvent> timeline;	
	
	public EventList(){
		this.timeline = new LinkedList<ScenarioEvent>();
		size = 0;
	}
	
	public void add(int index, ScenarioEvent e){
		timeline.add(e);
		size++;
		updateIndexes();
	}
	
	public void remove(int index, ScenarioEvent e){
		timeline.remove(e);
		size--;
		updateIndexes();
	}
	
	public int getSize(){
		return this.size();
	}
	
	private void updateIndexes(){
		for(int i = 0; i < this.size(); i++){
			timeline.get(i).setIndex(i);
		}
	}
}

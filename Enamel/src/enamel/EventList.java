package enamel;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class EventList extends LinkedList<ScenarioEvent>{
	private int size;
	public static int buttons;
	private LinkedList<ScenarioEvent> timeline;	
	
	public EventList(){
		this.timeline = new LinkedList<ScenarioEvent>();
		setSize(0);
	}
	
	public void add(int indexi, ScenarioEvent e){
		int index = indexi;
		if (index > this.timeline.size()) {
			timeline.addLast(e);
			setSize(getSize() + 1);
			updateIndexes();
			
			}
		if (index == 0) {
			timeline.addFirst(e);
			setSize(getSize() + 1);
			updateIndexes();
		}
		
		
		/*if (index< this.size() && index >0){
				
			for (int i =index; i <timeline.size()+1; i++) {
				ScenarioEvent shift = this.timeline.get(index);
				this.timeline.add(index, e);
				this.timeline.set(i, shiftRight);
				shiftRight = timeline.get(index +1);
			}
		}*/
		else {
		timeline.add(index, e);
		setSize(getSize() + 1);
		updateIndexes();
		}

		
	}
	
	public void remove(int index, ScenarioEvent e){
		timeline.remove(e);
		setSize(getSize() - 1);
		updateIndexes();
	}
	
	public int getSize(){
		return this.size;
	}
	
	public LinkedList<ScenarioEvent> getTimeline() {
		return this.timeline;
	}
	
	public void updateIndexes(){
		for(int i = 0; i < this.size(); i++){
			timeline.get(i).setIndex(i);
		}
	}

	public void setSize(int size) {
		this.size = size;
	}
}

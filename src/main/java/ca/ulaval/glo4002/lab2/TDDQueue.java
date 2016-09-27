package ca.ulaval.glo4002.lab2;

import java.util.ArrayList;

public class TDDQueue {
	
	private ArrayList<Integer> list;

	public TDDQueue() {
		list = new ArrayList<Integer>();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void queue(int element) {
		list.add(element);
	}
	
	public int dequeue() {
		int value = list.get(0);
		list.remove(0);
		return value;
	}
	
	public int peek() {
		return list.get(0);
	}
}

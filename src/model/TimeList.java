package model;

import java.time.LocalTime;
import java.time.ZoneId;

public class TimeList{

	int size;
	Node first, last;
	
	public TimeList() {
		size = 0;
		first = null;
		last = null;
	}

	public void add(ZoneId zoneId) {
		if(size == 0) {
			first = new Node(zoneId);
			last = first;
		}
		else {
			last.addNext(zoneId);
			last = last.getNext();
		}
		size++;
	}

	public void remove(int position) {
		if(size>0 && 0<=position && position<=size) {
			Node container = first;
			for(int i=0;i<position-1;i++) {
				container = container.getNext();
			}
			container.setNext(container.getNext().getNext());
			size--;
		}
	}

	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}

	public int size() {
		return size;
	}

	public String getTimes() {
		String message = "";
		if(isEmpty()) {
			return message;
		}
		
		Node container = first;
		for(int i=0;i<size;i++) {
			message += LocalTime.now(container.getZoneId())+"\n";
			container.getNext();
		}
		return message;
	}
	
}

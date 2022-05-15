package model;

import java.time.ZoneId;

public class Node {

	private ZoneId zoneId;
	private Node next;
	
	public Node(ZoneId zoneId) {
		this.zoneId = zoneId;
		next = null;
	}

	public Node getNext() {
		return next;
	}

	public void addNext(ZoneId zoneId) {
		this.next = new Node(zoneId);
	}
	
	public void setNext(Node node) {
		this.next = node;
	}
	
	public ZoneId getZoneId() {
		return zoneId;
	}
	
	public boolean hasNext() {
		if(next != null) {
			return true;
		}
		return false;
	}
	
}

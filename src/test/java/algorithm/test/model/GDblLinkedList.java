package algorithm.test.model;

import java.util.Comparator;

public class GDblLinkedList<T> {
	class Node<T> {
		private T data;
		private Node<T> prev;
		private Node<T> next;
		
		Node() {
			this.data = null;
			this.prev = this.next = this;
		}
		
		Node(T obj, Node<T> prev, Node<T> next){
			this.data = obj;
			this.prev = prev;
			this.next = next;
		}
	}
	
	private Node<T> head;
	private Node<T> crnt;
	private Node<T> tail;
	
	
	public GDblLinkedList() {
		this.head = this.crnt = this.tail = new Node<T>();
	}
	
	public boolean isEmpty() {
		return this.head.next == this.head;
	}
	
	public T search(T obj, Comparator<? super T> c) {
		Node<T> ptr = this.head.next;
		
		while(ptr != this.head) {
			if(c.compare(obj, ptr.data) == 0) {
				this.crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		
		return null;
	}
	
	public void printCurrentNode() {
		if(isEmpty()) {
			System.out.println("선택 노드가 없습니다.");
		}else {			
			System.out.println(this.crnt.data);
		}
	}
	
	public void dump() {
		Node<T> ptr = this.head.next;
		
		while(ptr != this.head) {
			System.out.printf("%2d,", ptr.data);
			ptr = ptr.next;
		}
	}
	
	public void dumpReverse() {
		Node<T> ptr = this.head.prev;
		
		while(ptr != this.head) {
			System.out.printf("%2d,", ptr.data);
			ptr = ptr.prev;
		}
	}
	
	public boolean next() {
		if(isEmpty() || this.crnt.next == this.head) {
			return false;
		}else {
			this.crnt = this.crnt.next;
			return true;
		}
	}
	
	public boolean prev() {
		if(isEmpty() || this.crnt.prev == this.head) {
			return false;
		}else {
			this.crnt = this.crnt.prev;
			return true;
		}
	}
	
	public void add(T obj, boolean type) {
		Node<T> node = new Node<T>(obj, this.crnt, this.crnt.next);
		
		this.crnt.next = this.crnt.next.prev = node;
		this.crnt = node;
		if(this.crnt.prev == node) this.tail = node;
	}
	
	public void addFirst(T obj) {
		this.crnt = this.head;
		add(obj, true);
	}
	
	public void addLast(T obj) {
		this.crnt = this.head.prev;
		add(obj, false);
	}
	
	public void removeCurrentNode() {
		if(!isEmpty()) {
			this.crnt.prev.next = this.crnt.next;
			this.crnt.next.prev = this.crnt.prev;
			this.crnt = this.crnt.prev;
			
			if(this.crnt == this.head) {
				this.crnt = this.head.next;
			}
		}
	}
	
	public void remove(Node<T> obj) {
		Node<T> ptr = this.head.next;
		
		while(ptr != this.head) {
			if(ptr == obj) {
				this.crnt = obj;
				removeCurrentNode();
				break;
			}else {
				ptr = ptr.next;
			}
		}
	}
	
	public void removeFirst() {
		this.crnt = this.head.next;
		removeCurrentNode();
	}
	
	public void removeLast() {
		this.crnt = this.head.prev;
		this.tail = this.crnt.prev;
		removeCurrentNode();
	}
	
	public void clear() {
		while(!isEmpty())
			removeFirst();
	}
	
	public T getHead() {
		return this.head.next.data;
	}
	
	public T getCrnt() {
		return this.crnt.data;
	}
	
	public T getTail() {
		return this.tail.data;
	}
}

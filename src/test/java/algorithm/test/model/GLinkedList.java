package algorithm.test.model;

import java.util.Comparator;

public class GLinkedList<T> {
	class Node<T> {
		private T data;
		private Node<T> next;
		
		Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<T> head;
	private Node<T> crnt;
	
	public GLinkedList() {
		this.head = this.crnt = null;
	}
	
	public T search(T data, Comparator<? super T> c) {
		Node<T> ptr = this.head;
		
		while(ptr != null) {
			if(c.compare(data, ptr.data) == 0) {
				this.crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		
		return null;
	}
	
	/**
	 * 가장 앞쪽에 Node 추가
	 * @param data
	 */
	public void addFirst(T data) {
		Node<T> ptr = this.head;
		head = crnt = new Node<T>(data, ptr);
	}
	
	/**
	 * 가장 뒷쪽에 Node 추가
	 * @param data
	 */
	public void addLast(T data) {
		if(this.head == null) addFirst(data);
		else {
			Node<T> ptr = this.head;
			while(ptr.next != null)
				ptr = ptr.next;
			ptr.next = crnt = new Node<T>(data, null);
		}
	}
	
	public void remove(Node<T> data) {
		if(this.head != null) {
			if(data == this.head) {
				removeFirst();
			}else {
				Node<T> ptr = this.head;
				
				while(ptr.next != data) {
					ptr = ptr.next;
					if(ptr == null) return;
				}
				ptr.next = data.next;
				this.crnt = ptr;
			}
		}
	}
	
	public void removeFirst() {
		if(this.head != null) 
			this.head = this.crnt = this.head.next;
	}
	
	public void removeLast() {
		if(this.head != null) {
			if(this.head.next == null) {
				removeFirst();
			}else {
				Node<T> ptr = this.head;
				Node<T> pre = this.head;
				
				while(ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null;
				this.crnt = pre;
			}
		}
	}
	public void removeCurrentNode() {
		remove(this.crnt);
	}
	
	public void clear() {
		while(this.head != null) {
			removeFirst();
		}
		this.crnt = null;
	}
	
	public boolean next() {
		if(this.crnt == null || this.crnt.next == null) {
			return false;
		}
		this.crnt = this.crnt.next;
		return true;
	}
	
	public void printCurrentNode() {
		if(this.crnt == null) {
			System.out.println("선택한 노드가 없습니다.");
		}else {
			System.out.println(crnt.data);
		}
	}
	
	public void dump() {
		Node<T> ptr = this.head;
		
		while(ptr != null) {
			System.out.printf(ptr.data + ", ");
			ptr = ptr.next;
		}
	}
	
	public void purge(Comparator <? super T> c) {
		Node<T> ptr = this.head;
		
		while(ptr != null) {
			int count = 0;
			Node<T> ptr2 = ptr;
			Node<T> pre = ptr;
			
			while(pre.next != null) {
				ptr2 = pre.next;
				if(c.compare(ptr.data, ptr2.data) == 0) {
					pre.next = ptr2.next;
					count++;
				}else {
					pre = ptr2;
				}
			}
			if(count == 0) {
				ptr = ptr.next;
			}else {
				Node<T> temp = ptr;
				remove(ptr);
				ptr = temp.next;
			}
		}
		this.crnt = this.head;
	}
	
	public T retrieve(int n) {
		Node<T> ptr = this.head;
		
		if(n == 0) return ptr.data;
		for(int i = 0; i < n; i++) {
			ptr = ptr.next;
		}
		
		return ptr.data;
	}
}

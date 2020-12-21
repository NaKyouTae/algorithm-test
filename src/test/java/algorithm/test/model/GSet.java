package algorithm.test.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GSet<T> {
	private int max;
	private int num;
	private T[] set;
	
	@SuppressWarnings("unchecked")
	public GSet(int capacity) {
		this.num = 0;
		this.max = capacity;
		try {
			this.set = (T[]) new Object[max]; 
		} catch (Exception e) {
			max = 0;
		}
	}
	
	public int capacity() {
		return this.max;
	}
	public int size() {
		return this.num;
	}
	
	public int indexOf(T data) {
		for(int i = 0; i < num; i++) {
			if(this.set[i] == data) return i; 
		}
		return -1;
	}
	
	public boolean contains(T data) {
		return (indexOf(data) == -1) ? false:true;
	}
	
	public boolean add(T data) {
		if(num >= max || contains(data)) {
			return false;
		}else {
			this.set[num++] = data;
			return true;
		}
	}
	
	public boolean remove(T data) {
		int idx;
		if(num <= 0 || (idx = indexOf(data)) == -1) {
			return false;
		}else {
			List<T> list = new ArrayList<>(Arrays.asList(this.set));
					
			list.remove(idx);
			
			for(int i = 1; i < num--; i++) {
				this.set[i] = list.get(i);
			}
			
			return true;
		}
	}
	
	public void copyTo(GSet<T> s) {
		int n = (s.max > this.num) ? num:s.max;
		
		for(int i = 0; i < n; i++) {
			s.set[i] = this.set[i];
		}
		s.num = n;
	}
	
	public void copyFrom(GSet<T> s) {
		int n = (s.num > max) ? max:s.num;
		
		for(int i = 0; i < n; i++) {
			this.set[i] = s.set[i];
		}
		
		this.num = n;
	}
	
	public boolean equalTo(GSet<T> s) {
		if(this.num != s.num) {
			return false;
		}
		
		for(int i = 0; i < this.num; i++) {
			int j = 0;
			for(; j < s.num; j++) {
				if(set[i] == s.set[j]) break;
			}
			if(j == s.num) {
				return false;
			}
		}
		return true;
	}
	
	public void unionOf(GSet<T> s, GSet<T> t) {
		copyFrom(s);
		for(int i = 0; i < t.num; i++)
			add(t.set[i]);
	}
	
	public String toString() {
		if(this.num == 0) return "집합이 비어 있습니다.";
		
		StringBuilder sb = new StringBuilder("{");
		for(int i = 0; i < num; i++) {
			sb.append(this.set[i] + ",");
		}
		sb.append("}");
		
		return sb.toString();
	}
	
	public boolean isEmpty() {
		return (this.num == 0) ? true:false;
	}
	
	public boolean isFull() {
		return (this.num == max) ? true:false;
	}
	
	@SuppressWarnings("unchecked")
	public void clear() {
		this.num = 0;
		this.set = (T[]) new Object[this.max];
	}
	
	
	public boolean union(GSet<T> data) {
		boolean flag = false;
		
		for(int i = 0; i < this.num; i++) {
			if(add(set[i]) == true) {
				flag = true;
			}
		}
		return flag;
	}
	
	public boolean retain(GSet<T> data) {
		boolean flag = false;
		
		for(int i = 0; i < num; i++) {
			if(data.contains(set[i]) == false) {
				remove(set[i]);
				flag = true;
			}
		}
		return flag;
	}
	
	public boolean remove(GSet<T> data) {
		boolean flag = false;
		
		for(int i = 0; i < num; i++) {
			if(data.contains(set[i]))
				remove(set[i]);
				flag = true;
		}
		
		return flag;
	}
}

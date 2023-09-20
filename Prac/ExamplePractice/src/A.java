import java.util.ArrayList;
import java.util.Collections;

public class A<K,V> {
	
	
	private static class LinkedListNode<K,V>{
		
		public LinkedListNode<K,V> next;
		public LinkedListNode<K,V> prev;
		
		
		public K key;
		public V val;
		
		LinkedListNode(K k,V v){
			key=k;
			val=v;
		}
	}
	
	private ArrayList<LinkedListNode<K,V>> arr;
	
	
	public A(int capacity) {
		arr=new ArrayList<LinkedListNode<K,V>>();
		arr.ensureCapacity(capacity);
		Collections.fill(arr, null);
	}
	
	
	public void put(K key, V val) {
		
		LinkedListNode<K,V> node=getNodeForKey(key);
		
		if(node != null) {
		   node.val=val;
		   return;
		}
		node =new LinkedListNode(key,val);
		
		int index=getIndex(key);
		
		LinkedListNode curr=arr.get(index);
		
		if(curr!= null) {
			node.next=curr;
			node.next.prev=node;
		}
		
		arr.set(index, node);
		
	}
	
	public V get(K key) {
		LinkedListNode<K,V> node=getNodeForKey(key);
		return node == null ? null:node.val;
	}
	
	
	public void remove(K key) {
		LinkedListNode node=getNodeForKey(key);
		
		if(node.prev != null) {
			
			node.prev.next=node.next;
			
		}else {
			int index=getIndex(key);
			arr.set(index, node.next);
		}
		
		if(node.next != null) {
			node.next.prev=node.prev;ṇ
		}
		
		
	}


	private LinkedListNode<K, V> getNodeForKey(K key) {
		
		int index=getIndex(key);
		
		LinkedListNode curr=arr.get(index);
		
		while(curr != null) {
			if(curr.key==key) {
				return curr;
			}
			curr=curr.next;
		}		
		return null;
	}


	private int getIndex(K key) {
		
		return Math.abs(key.hashCode()%arr.size());
	}

}

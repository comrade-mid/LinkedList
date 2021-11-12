public class List{
	private class Node {
		Node next;
		Node prev;
		int data;
		Node (int input) { // Creates a new empty list.
			data = input;
			next = null;
			prev = null;
		}
	}
	//fields
	private Node head;
	private Node tail;
	private int length;
	private int index;
	
	
	// Constructor
	public List (){
		head = null;
		tail = null;
		length = 0;
		index =  0;
	}
	// Access functions
	int length(){
		return length;
	}// Returns the number of elements in this List.
	int index(){
		if (index >= 0) {return index;}
		else {return -1;}
	}// If cursor is defined, returns the index of the cursor element,
 // otherwise returns -1.
	
	
	int front()
	{
		
		if(length < 0) {
			return -1;
		} else {return head.data;}
		
	} // Returns front element. Pre: length()>0
	
	
	int back()
	{
		if (length < 0) {
			return -1;
		} else { return tail.data; }
		
	} // Returns back element. Pre: length()>0
	
	int get(){
		if(length > 0 && index >= 0){
			Node M = head;
			int n = index;
			while(n > 0 && M.next != null){
				M = M.next;
				n--;
			}
			return M.data;
		} else {
			return -1;
		}
	}		// Returns cursor element. Pre: length()>0, index()>=0
	
	boolean equals(List L)
	{
		Node M = head;
		Node N = L.head;
		
		
			for(;M.next != null; M = M.next){
				if(M.data != N.data){return false;}
				else {N = N.next;}
			}
			return true;
	}
	 // Returns true if this List and L are the same integer
	// sequence. The cursor is ignored in both lists.
	
	
	// Manipulation procedures
	

	void prepend(int data)
	{
		if(length == 0){
			Node N = new Node(data);
			head = N;
			tail = head;
			N.next = null;
		} else {
			Node M = head;
			M.prev = new Node(data);
			head = M.prev;
			Node O = head;
			O.next = M;
		}
		
		++length;
	}// Insert new element into this List. If List is non-empty,
 // insertion takes place before front element.
	void append(int data)
	{
		Node N = new Node(data);
		if(length == 0){
			head = N;
			tail = head;
			N.next = null;
			N.prev = null;
		} else {
			Node M = head;
			while(M.next != null) {M = M.next;}
			M.next = N;
			N.prev = M;
			tail = N;
		}
		++length;
	}// Insert new element into this List. If List is non-empty,
 // insertion takes place after back element.
 
 
	void moveFront(){
		
		if(length > 0){ index = 0; }
		
	}; // If List is non-empty, places the cursor under the front element,
 // otherwise does nothing.
void moveBack(){
	if(length > 0){
		index = length - 1;
	}
}	// If List is non-empty, places the cursor under the back element,
 // otherwise does nothing.
void movePrev(){
	if(length > 0){
		if(index >= 0) --index;
		}
}	// If cursor is defined and not at front, moves cursor one step toward
 // front of this List, if cursor is defined and at front, cursor becomes
// undefined, if cursor is undefined does nothing.
void moveNext(){
	if(length > 0) {
		if(index >= 0 && index < length)++index;
		}
}	// If cursor is defined and not at back, moves cursor one step toward
 // back of this List, if cursor is defined and at back, cursor becomes
// undefined, if cursor is undefined does nothing.
 
 
void insertBefore(int data){

	if(length > 0 && index >= 0){
		Node H = head;
		Node T = tail;
		Node M = new Node(data);
		int L = index;
		if (index == 0){
			
			M.next = H;
			head = M;
		} else {
			while (L > 0 && H.next != null){
				H = H.next;
				--L;
			}
			M.next = H;
			M.prev = H.prev;
			H.prev.next = M;
			H.prev = M;
		}
		++length;
	}

}	// Insert new element before cursor.
 // Pre: length()>0, index()>=0
void insertAfter(int data){
	if(length > 0 && index >= 0){
		Node H = head;
		Node T = tail;
		Node M = new Node(data);
		int L = index;
		
		if(index == (length-1)){
			T.next = M;
			M.prev = T;
			tail = M;
		} else {
			while (L != 0 && H.next != null){
				H = H.next;
				--L;
			}
			M.next = H.next;
			M.prev = H;
			H.next.prev = M;
			H.next = M;
		}
		++length;
	}
}	
// Inserts new element after cursor.
 // Pre: length()>0, index()>=0
 
 
void deleteFront(){
	
	Node H = head;
	Node P = H;
	if (length > 0){
		P = H.next;
		head = P;
		H = null;
		--length;
	}
}	// Deletes the front element. Pre: length()>0
void deleteBack(){
	Node T = tail;
	Node P = T;
	if(length > 0){
		if(head != tail){
			P = T.prev;
			T.prev = null;
			P.next = null;
			tail = P;
			T = null;
		} else {
			head = null;
			tail = null;
		}
		--length;
	}
}	// Deletes the back element. Pre: length()>0
void delete(){
	Node H = head;
	Node P = H;
	Node T = tail;
	int L = index;
	if(length > 0 && index >= 0){
		if(index == (length-1)){
			P = T.prev;
			tail = P;
			T = null;
		} else if (index == 0){
			P = H.next;
			head = P;
			H = null;
		} else {
			for(; L > 0; L-- ) H = H.next;
			P = H.prev;
			P.next = H.next;
			H.next.prev = P;
			H.next = null;
			H.prev = null;
			H = null;
		}
		--length;
	}
}	// Deletes cursor element, making cursor undefined.
    // Pre: length()>0, index()>=0
	
	

void clear(){
	Node H = head;
	Node T = tail;
	Node P = head;
	P.next = null;
	P.prev = null;
	P.data = 0;
} // Resets this List to its original empty state.


// Other methods
	public String toString(){
    	StringBuffer sb = new StringBuffer();
    	Node N = head;
		int L = 0;
        for( ; N!=null; N=N.next){ 
			++L;
			sb.append(N.data+" ").append("\n");
		}
    	return new String(sb);
    }

	List copy(){
		Node H = head;
		List L = new List();
		for(; H != null; H = H.next){
			L.append(H.data);
		}
		
		return L;
	}		// Returns a new List representing the same integer sequence as this
 // List. The cursor in the new list is undefined, regardless of the
 // state of the cursor in this List. This List is unchanged.
/*
List concat(List L); // Returns a new List which is the concatenation of
 // this list followed by L. The cursor in the new List
 // is undefined, regardless of the states of the cursors
 // in this List and L. The states of this List and L are
 // unchanged.
 
 */
}	
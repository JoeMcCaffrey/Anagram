
/**
 * This class supports the Linked list for chaining
 * @author Lenny
 * Joseph McCaffrey
 */
public class hashmap {
  private Node head;
  private int listCount;
  
  
  public hashmap(){
    head = new Node(null);
    listCount = 0;
  }
  
  public void add(String data){
    Node temp = new Node(data);
    Node current = head;
    
    while(current.getNext() != null){
      current = current.getNext();
    }
    current.setNext(temp);
    listCount++;
  }
  // This is unused
    public void add(String data, int index)
    // inserts the specified element at the specified position in this list
    {
        Node temp = new Node(data);
        Node current = head;
        
        for (int i = 1; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        
        temp.setNext(current.getNext());
        current.setNext(temp);
        listCount++;
    }
  
  public String get(int index){
    if(index <=0){
      return null;
    }
    
    Node current = head.getNext();
    if(head.getNext() == null) return null;
    
   for(int i =1; i <index; i++){
      if(current.getNext() == null){
       return null; 
      }
      current = current.getNext();
    }
    return current.getData();
  }
  
  public int size(){
    return listCount;
  }
  
  
  
  
  }


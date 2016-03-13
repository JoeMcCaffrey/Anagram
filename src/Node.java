
/**
 * This class is the nodes for the Linked list
 * @author Lenny
 * Joseph McCaffrey
 */
public class Node {
  
     String data;
      public Node next;
 
    public  Node(String dataValue) {
            next = null;
            data= dataValue;
      }
 public Node(String dataValue, Node nextValue){
  next =  nextValue;
  data = dataValue;
  }
 
 
      public String getData() {
            return data;
      }
 
      public void setData(String dataValue) {
            data= dataValue;
      }
 
      
 
      public Node getNext() {
            return next;
      }
 
      public void setNext(Node nextValue) {
            next = nextValue;
      }
  
}

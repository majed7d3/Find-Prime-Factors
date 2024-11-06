public class DLL {
    private node head;
    private node tail;
    private node current;

    public DLL(){
        head = current = tail = null;
    }

    public void goFirst(){
        if(head != null){
            current = head;
        }
    }

    public void goLast(){
        if(tail != null){
            current = tail;
        }
    }

    public int getVal() {
        return current.getVal();
    }

    public void next(){
        current = current.getNext();
    }

    public void insert(int val){
        node newNode = new node(val);
        if(tail == null){
            head = current = tail = newNode;
            return;
        }
        newNode.setPrevious(tail);
        tail.setNext(newNode);
        tail = newNode;
    }

    public void delete(){
        current = tail.getPrevious();
        current.setNext(null);
        tail.setPrevious(null);
        tail = current;
        goFirst();
    }

    public boolean empty(){
        return head == null;
    }

    public boolean last(){
        return current == tail;
    }

}

public class node {
    private int val;
    private node next;
    private node previous;

    public node(int val){
        this.val = val;
        next = null;
        previous = null;
    }

    public node getPrevious() {
        return previous;
    }

    public node getNext() {
        return next;
    }

    public int getVal() {
        return val;
    }

    public void setPrevious(node previous) {
        this.previous = previous;
    }

    public void setNext(node next) {
        this.next = next;
    }

    public void setVal(int val) {
        this.val = val;
    }

}

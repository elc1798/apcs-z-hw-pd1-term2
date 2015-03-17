public class LList{
    private Node l = null;
    
    public void add(String s){
        Node tmp = new Node(s);
        tmp.setNext(l);
        l = tmp;
    }

    public String find(int n) {
        Node tmp;
        int i = 0;
        for (tmp = l; tmp != null && i <= n; tmp = tmp.getNext()) {
            i++;
        }
        if (tmp != null) {
            return tmp.getData();
        } else {
            return "NULL";
        }
    }

    public void insert(int index , String data) {
        Node tmp , appendee;
        int i = 0;
        appendee = new Node(data);
        for (tmp = l; tmp != null && i <= index - 1; tmp = tmp.getNext()) {
            appendee.setNext(tmp.getNext());
            i++;
        }
        // Store the one before in a temporary variable
        if (tmp != null) {
            appendee.setNext(tmp.getNext());
            tmp.setNext(appendee);
        } else {
            tmp.setNext(appendee);
        }
    }

    public String toString(){
        String s = "";
        Node tmp;
        for (tmp = l ; tmp != null ; tmp = tmp.getNext()){
            s = s + tmp + " --> ";
        }
        s = s + "null";
        return s;
    }
}

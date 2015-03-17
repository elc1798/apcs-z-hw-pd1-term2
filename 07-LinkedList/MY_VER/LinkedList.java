public class LinkedList {
    
    private Node[] list;
    
    public LinkedList() {
        list = new Node[0];
    }
    
    public LinkedList(Node n) {
        list = new Node[1];
        list[0] = n;
        n.setID(0);
    }
    
    public void addNode(Node n) {
        Node[] _list = new Node[list.length + 1];
        System.arraycopy(list , 0 , _list , 0 , list.length);
        if (_list.length >= 2) {
            _list[_list.length - 2].setDaughter(n);
        }
        _list[_list.length - 1] = n;
        n.setID(_list.length - 1);
        n.setDaughter(null);
        if (_list.length >= 2) {
            n.setParent(_list[_list.length - 2]);
        }
        list = _list;
    }
    
    public void rmNode(Node n) {
        n.getParent().setDaughter(n.getDaughter());
        n.getDaughter().setParent(n.getParent());
        n.setParent(null);
        n.setDaughter(null);
    }
    
}

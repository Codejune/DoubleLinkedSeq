package kr.ac.soongsil.assignment;

public class Node {
    private double data;        // 데이터를 저장하는 공간
    private Node prevNode;      // 이전 노드
    private Node nextNode;      // 다음 노드

    Node(double data) {
        this.data = data;       // 데이터 지정
        this.nextNode = null;   // 다음 노드는 지정하지 않음.
    }

    public void addNodeAfter(double data)
    {
        Node newNode = new Node(data);
        newNode.setPrevNode(this);
        this.setNextNode(newNode);
    }

    public static Node listCopy(Node list) {
        Node copyHead = null;
        Node copyTail = null;
        Node cursor = list;
        if(list == null) {    // 리스트가 비어있을 경우
            return null;
        }
        copyHead = new Node(list.getData());    // 첫 노드 생성
        copyTail = copyHead;                    // copyHead = copyTail = 첫 노드
        while(cursor.getNextNode() != null) {   // cursor가 마지막 노드까지 이동
            cursor = cursor.getNextNode();
            copyTail.addNodeAfter(cursor.getData());
            copyTail = copyTail.getNextNode();
        }
        return copyHead;
    }

    public static Node[] listCopyWithTail(Node list) {
        Node[] answer = new Node[2];
        Node cursor = list;

        // Handle the special case of the empty list.
        if (list != null) {
            // Make the first node for the newly created list.
            Node copyHead = new Node(list.getData());
            Node copyTail = copyHead;

            // Make the rest of the nodes for the newly created list.
            while (cursor.getNextNode() != null) {
                cursor = cursor.getNextNode();
                copyTail.addNodeAfter(cursor.getData());
                copyTail = copyTail.getNextNode();
            }
            // Return the head and tail references.
            answer[0] = copyHead;
            answer[1] = copyTail;
        }
        return answer;
    }

    public void setData(double newdata) {
        data = newdata;
    }

    public void setPrevNode(Node node) {
        prevNode = node;
    }

    public void setNextNode(Node node) {
        nextNode = node;
    }

    public double getData() {
        return data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public Node getPrevNode() {
        return prevNode;
    }

}

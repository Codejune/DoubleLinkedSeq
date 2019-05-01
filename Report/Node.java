package kr.ac.soongsil.assignment;

public class Node {
    private double data;        // �����͸� �����ϴ� ����
    private Node prevNode;      // ���� ���
    private Node nextNode;      // ���� ���

    Node(double data) {
        this.data = data;       // ������ ����
        this.nextNode = null;   // ���� ���� �������� ����.
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
        if(list == null) {    // ����Ʈ�� ������� ���
            return null;
        }
        copyHead = new Node(list.getData());    // ù ��� ����
        copyTail = copyHead;                    // copyHead = copyTail = ù ���
        while(cursor.getNextNode() != null) {   // cursor�� ������ ������ �̵�
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

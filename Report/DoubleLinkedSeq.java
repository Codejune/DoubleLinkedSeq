package kr.ac.soongsil.assignment;

/******************************************************************************
 * This class is a homework assignment;
 * A DoubleLinkedSeq is a collection of double numbers.
 * The sequence can have a special "current element," which is specified and
 * accessed through four methods that are not available in the sequence class
 * (start, getCurrent, advance and isCurrent).
 *
 * Limitations:
 *   Beyond Int.MAX_VALUE elements, the size method
 *   does not work.
 *
 * Note:
 *   This file contains only blank implementations ("stubs")
 *   because this is a Programming Project for my students.
 ******************************************************************************/
public class DoubleLinkedSeq implements Cloneable {
    private Node head;      // head : ����Ʈ�� ����
    private Node tail;      // tail : ����Ʈ�� ��
    private Node cursor;    // cursor : �׻� �������� �߰��� ��带 ����Ŵ
    private int size;       // ��� ����


    /**
     * Initialize an empty sequence.
     * ����Ʈ�� �ʱ�ȭ
     *
     * @param - none
     *
     * Postcondition:   This sequence is empty.
     *                  ������ ����Ʈ�� ����ֽ��ϴ�.
     **/
    public DoubleLinkedSeq() {
        head = null;
        tail = null;
        cursor = head;
        size = 0;
    }


    /**
     * Add a new element to this sequence, after the current element.
     * ���ο� ��带 ����Ʈ ���� ����
     *
     * @param data      the new element that is being added
     *                  ���ο� ��带 �����ϴµ�
     *                  A new copy of the element has been added to this sequence.
     *                  If there was no current element, then the new element is placed at the end of the sequence.
     *                  ����Ʈ�� ��尡 �������� ���� ��� ����Ʈ�� ���ο� ��尡 ����Ʈ�� ���� ��
     *                  If there was a current element, then the new element is placed after the current element.
     *                  ����Ʈ�� ��尡 ������ ��� ���ο� ��带 ����Ʈ�� ���� ����
     *                  In all cases, the new element becomes the new current element of this sequence.
     *                  ���� ��� ��찡 ����Ǹ� ���� ������ ���� ���ο� ��忩�� ��.
     *
     * @throws OutOfMemoryError Indicates insufficient memory for a new node.
     **/
    public void addAfter(double data) {
        Node newNode = new Node(data);          // ���ο� ��� ����
        if (size == 0) {                        // ����Ʈ�� ��尡 ���� ���
            head = newNode;          // head�� ���� ��� �ּҸ� ���ο� ���� ����
            tail = newNode;          // tail�� ���� ��� �ּҸ� ���ο� ���� ����
            cursor = newNode;
        } else if(cursor == tail) {
            newNode.setPrevNode(cursor);        // ���ο� ����� ���� ��� �ּҸ� Ŀ���� ��ġ�� ����
            cursor.setNextNode(newNode);        // cursor�� ����Ű�� ����� ���� ��� �ּҸ� ���ο� ���� ����
            tail = newNode;          // tail�� ���� ��� �ּҸ� ���ο� ���� ����
            cursor = newNode;
        } else {
            newNode.setPrevNode(cursor);
            newNode.setNextNode(cursor.getNextNode());
            cursor.getNextNode().setPrevNode(newNode);
            cursor.setNextNode(newNode);
            cursor = newNode;
        }
        size++;                                 // size + 1
    }



    /**
     * Add a new element to this sequence, before the current element.
     * ���ο� ��带 ����Ʈ�� ���ۿ� ����
     *
     * @param data      the new element that is being added
     *                  ���ο� ��带 �����ϴµ�
     *                  A new copy of the element has been added to this sequence.
     *                  If there was no current element, then the new element is placed at the start of the sequence.
     *                  ����Ʈ�� ��尡 �������� ���� ��� ���ο� ��尡 ����Ʈ�� ������ ��.
     *                  If there was a current element, then the new element is placed before the current element.
     *                  ����Ʈ�� ��尡 ������ ��� ���ο� ��带 ����Ʈ�� ���ۿ� ����.
     *                  In all cases, the new element becomes the new current element of this sequence.
     *                  ���� ��� ��찡 ����Ǹ� ���� ���� ���ο� ��忩�� ��.
     *
     * @throws OutOfMemoryError Indicates insufficient memory for a new node.
     **/
    public void addBefore(double data) {
        Node newNode = new Node(data);              // ���ο� ��� ����
        if (size == 0) {                            // ����Ʈ�� ��尡 ���� ���
            head = newNode;          // head�� ���� ��� �ּҸ� ���ο� ���� ����
            tail = newNode;          // tail�� ���� ��� �ּҸ� ���ο� ���� ����
            cursor = newNode;
        } else if(cursor == head){
            newNode.setNextNode(cursor);            // ���ο� ����� ���� ��� �ּҸ� cursor�� ����Ű�� ���� ����
            head.setPrevNode(newNode);            // cursor�� ����Ű�� ����� ���� ��� �ּҸ� ���ο� ���� ����
            head = newNode;              // head�� ���� ��� �ּҸ� ���ο� ���� ����
            cursor = newNode;
        } else {
            newNode.setNextNode(cursor);
            newNode.setPrevNode(cursor.getPrevNode());
            cursor.getPrevNode().setNextNode(newNode);
            cursor.setPrevNode(newNode);
            cursor = newNode;
        }
        size++;                                     // size + 1
    }


    /**
     * Place the contents of another sequence at the end of this sequence.
     * �Ķ���ͷ� ���޵� ����Ʈ�� ������ ȣ��� ����Ʈ�� ���� ��ġ���ִ� �Լ�
     *
     * @param list      a sequence whose contents will be placed at the end of this sequence
     *                  ȣ��� ����Ʈ�� ���� ��ġ �� ����Ʈ
     *
     *
     * Precondition:    The parameter, list, is not null.
     *                  �Ķ���ͷ� �޴� list�� null�� �ƴ� ��
     *
     * Postcondition:   The elements from list have been placed at the end of this sequence.
     *                  �Ķ���ͷ� ������ list�� ȣ��� ����Ʈ�� ���� ��ġ�ȴ�.
     *                  The current element of this sequence remains where it was, and the list is also unchanged.
     *                  ȣ��� ����Ʈ�� ������ ������ �Ǹ�, �Ķ���ͷ� ���޵� list�� ������ ���� �ʴ´�.
     *
     * @throws IllegalArgumentException Indicates that list is null.
     *                                  �߰��Ϸ��� ����Ʈ�� ������� ���
     *
     * @throws NullPointerException     Indicates that reference list is null.
     *                                  �߰��ϴ� �������� �Ǵ� ����Ʈ�� ������� ���
     *
     * @throws OutOfMemoryError          Indicates insufficient memory to increase the size of this sequence.
     *                                   ����Ʈ�� �߰��Ϸ��� �Ҷ� �޸𸮰� ������� ���� ���
     *
     **/
    public void addAll(DoubleLinkedSeq list) {
        if(list == null) {
            throw new IllegalArgumentException("addAll: list is null");
        }
        if(list.size() > 0) {
            if((head == null) || (tail == null)) {
                head = list.head;
                tail = list.tail;
            } else {
                DoubleLinkedSeq listclone = (DoubleLinkedSeq) list.clone();
                tail.setNextNode(listclone.head);
                listclone.head.setPrevNode(tail);
                tail = listclone.tail;
            }
            size += list.size();
        }
    }


    /**
     * Move forward, so that the current element is now the next element in this sequence.
     * cursor�� ����Ű�� ��带 ���� ���� ����
     *
     * @param - none
     *
     * Precondition:    isCurrent() returns true.
     *                  isCurrent()�� true�� ��ȯ�� �� (cursor�� ����Ű�� ��尡 ����)
     *
     * Postcondition:   If the current element was already the end element of this sequence
     *                  ���� cursor�� ����Ʈ�� ���� �����ϴ� ��带 ����Ű�� ���� ���
     *                  (with nothing after it), then there is no longer any current element.
     *                  (�ƹ��͵� ���� �ʰ�) cursor�� null�� ����Ű�� �ȴ�.
     *                  Otherwise, the new element is the element immediately after the
     *                  �׷��� ������ cursor�� ���� cursor�� ����Ű�� ����� ������带 ����Ű�� �ȴ�.
     *                  original current element.
     *
     * @throws IllegalStateException    Indicates that there is no current element, so advance may not be called.
     *                                  cursor�� �ƹ��͵� ����Ű�� �ʾƼ� advance() �޼ҵ尡 ȣ����� ���� ���
     **/
    public void advance() {
        if(isCurrent() != true) {
            throw new IllegalStateException("advance: cursor is null");
        }
        cursor = cursor.getNextNode();
    }

    public void retreat() {
        if(isCurrent() != true) {
            throw new IllegalStateException("advance: cursor is null");
        }
        cursor = cursor.getPrevNode();
    }

    /**
     * Generate a copy of this sequence.
     * ȣ��� ����Ʈ�� �����մϴ�.
     *
     * @param - none
     *
     * @return  The return value is a copy of this sequence. Subsequent changes to the
     *          ��ȯ�Ǵ� ���� ȣ��� ����Ʈ�� ���纻�̴�. ���纻�� �ļ� ���� ������ ������ ������ ���� ������
     *          copy will not affect the original, nor vice versa. Note that the return
     *          �ݴ��� ��쿡�� ���������Դϴ�. ���� ���� ����ϱ� ���� DoubleLinkedSeq �ڷ������� �̷����
     *          value must be type cast to a DoubleLinkedSeq before it can be used.
     *          ���ο� ������ �Ҵ�Ǿ�� ����� �����մϴ�.
     *
     * @throws OutOfMemoryError Indicates insufficient memory for creating the clone.
     *                          ���纻 ������ �ʿ��� �޸𸮰� ������ ���
     **/
    /*
    public Object clone() {
        DoubleLinkedSeq answer;
        try {
            answer = (DoubleLinkedSeq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("clone: This class does not implement Cloneable");
        }
        answer.head = Node.listCopy(head);
        answer.cursor = answer.head;
        return answer;
    }
    */
    public Object clone() {
        DoubleLinkedSeq answer;
        try {
            answer = (DoubleLinkedSeq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("clone: This class does not implement Cloneable");
        }
        //Sequence has no current element
        if (cursor == null) {
            Node[] newList = Node.listCopyWithTail(head);

            answer.head = newList[0];
            answer.tail = newList[1];
        }
        //Sequence with a current element equal to head
        else if (cursor == head) {
            Node[] newList = Node.listCopyWithTail(head);
            answer.head = newList[0];
            answer.tail = newList[1];

            answer.cursor = answer.head;
        }

        else if (cursor != null) {
            this.start();
            Node[] newList = Node.listCopyWithTail(head);
            answer.head = newList[0];
            answer.tail = newList[1];

            answer.cursor = answer.head;
        }

        return answer;
    }


    /**
     * Create a new sequence that contains all the elements from one sequence followed by another.
     * �ΰ��� ����Ʈ�� ���ļ� ���ο� �Ѱ��� ����Ʈ�� ��ȯ�ϴ� �޼ҵ�
     *
     * @param s1    the first of two sequences
     *              �ΰ��� ����Ʈ �� ù��° ����Ʈ
     * @param s2    the second of two sequences
     *              �ΰ��� ����Ʈ �� �ι�° ����Ʈ
     *
     * Precondition:    Neither s1 nor s2 is null.
     *                  �ΰ��� ����Ʈ s1�� s2 �Ѵ� null�� �ƴҶ�
     *
     * @return      a new sequence that has the elements of s1 followed by the elements of s2 (with no current element)
     *              answer�� s1�� ���̾� s2�� �������� ��ȯ�ȴ�. (cursor = null)
     *
     * @throws NullPointerException Indicates that one of the arguments is null.
     * @throws OutOfMemoryError     Indicates insufficient memory for the new sequence.
     **/
    public DoubleLinkedSeq catenation(DoubleLinkedSeq s1, DoubleLinkedSeq s2) {
        if((s1 == null) || (s2 == null)) {
            throw new IllegalArgumentException("catenation: argument is null");
        } else {
            DoubleLinkedSeq answer = new DoubleLinkedSeq();
            answer.addAll(s1);
            answer.addAll(s2);
            return answer;
        }
    }


    /**
     * Accessor method to get the current element of this sequence.
     * ����Ʈ�� �����ϴ� cursor�� data�� ��� ���� Accessor �޼ҵ���.
     *
     * @param - none
     *
     * Precondition:    isCurrent() returns true.
     *                  isCurrent()�� ���� ��ȯ�� ��
     *
     * @return  cursor�� ����Ű�� ����� data
     *
     * @throws IllegalStateException    Indicates that there is no current element, so getCurrent may not be called.
     *                                  cursor�� �ƹ��͵� ����Ű�� �������� ���� getCurrent()�� ȣ����� ���� �� ������ ó��
     **/
    public double getCurrent() {
        if (!isCurrent()) {
            throw new IllegalStateException("getCurrent: isCurrent() is null");
        } else {
            return cursor.getData();
        }
    }


    /**
     * Accessor method to determine whether this sequence has a specified
     * �� ����Ʈ�� getCurrent()�� cursor�� data�� ��� ����
     * current element that can be retrieved with the getCurrent method.
     * cursor�� ��� ���� ������ �Ǻ��ϴ� �޼ҵ�.
     *
     * @param - none
     *
     * @return true(cursor�� ����Ű�� ��尡 ����) or false(cursor�� ����Ű�� ��尡 ����)
     **/
    public boolean isCurrent() {
        return cursor != null;
    }

    /**
     * Remove the current element from this sequence.
     * ����Ʈ���� cursor�� ����Ű�� ��带 �����մϴ�.
     *
     * @param - none
     *
     * Precondition:    isCurrent() returns true.
     *                  isCurrent()�� true�� ��ȯ�� ��
     *
     * Postcondition:   The current element has been removed from this sequence, and the
     *                  cursor�� �����ϴ� ��尡 ����Ʈ���� ���ŵ˴ϴ�. �׸��� cursor�� ���ŵ� �����
     *                  following element (if there is one) is now the new current element.
     *                  ���� ����� ��ġ�� �̵��մϴ�. ���� ���ŵ� ����� ���� ��尡 ���� ��� cursor�� null�� �˴ϴ�.
     *                  If there was no following element, then there is now no current element.
     *
     * @throws IllegalStateException Indicates that there is no current element, so removeCurrent may not be called.
     **/
    public void removeCurrent() {
        if(!isCurrent()) {          // cursor�� ����Ű�� ��尡 ����
            throw new IllegalStateException("removeCurrent: isCurrent() is null");
        } else if(size() == 0) {    // ����Ʈ�� �������
            throw new IllegalStateException("removeCurrent: list is empty");
        } else if(size() == 1) {    // ����Ʈ�� ��尡 1���ۿ� ����
            head = null;
            tail = null;
            cursor = null;
        } else if(cursor == head) { // cursor�� ���� ��忡 ���� ���
            head = head.getNextNode();
            cursor = cursor.getNextNode();
            cursor.setPrevNode(null);
        } else if(cursor == tail) { // cursor�� �� ��忡 ���� ���
            tail = tail.getPrevNode();
            cursor = cursor.getPrevNode();
            cursor.setNextNode(null);
        } else {                    // cursor�� ����Ʈ �߰� ��忡 ���� ���
            Node temp = head;
            while(temp.getNextNode() != cursor) {
                temp = temp.getNextNode();
            }
            temp.setNextNode(cursor.getNextNode());
            temp = temp.getNextNode();
            temp.setPrevNode(cursor.getPrevNode());
            cursor = cursor.getNextNode();
        }
        size--;
    }


    /**
     * Determine the number of elements in this sequence.
     * ����Ʈ�� ����� ������ �����մϴ�.
     *
     * @param - none
     * @return  the number of elements in this sequence
     *          ����Ʈ�� �����ϴ� ����� ���� ��ȯ
     **/
    public int size() {
        return size;
    }


    /**
     * Set the current element at the front of this sequence.
     * �� ����Ʈ�� �� �� ��忡 cursor�� �����մϴ�.
     *
     * @param - none
     *
     * Postcondition:   The front element of this sequence is now the current element (but
     *                  cursor�� ����Ʈ�� �� �� ��带 ����ŵ�ϴ�. �׷��� ����Ʈ�� ��尡 ���� ���
     *                  if this sequence has no elements at all, then there is no current element).
     *                  cursor�� null�� ����ŵ�ϴ�.
     **/
    public void start() {
        if(head == null) {
            cursor = null;
        }
        cursor = head;
    }

    /**
     * Set the current element at the end of this sequence.
     * �� ����Ʈ�� �� �ڿ� cursor�� �����մϴ�.
     *
     * @param - none
     *
     * Postcondition:   The end element of this sequence is now the current element
     *                  cursor�� ����Ʈ�� �� �� ��带 ����ŵ�ϴ�. �׷��� ����Ʈ�� ��尡 ���� ���
     *                  (but if this sequence has no elements at all, then there is no current element).
     *                  cursor�� null�� ����ŵ�ϴ�.
     **/
    public void end() {
        if(tail == null) {
            cursor = null;
        }
        cursor = tail;
    }

    @Override
    public String toString() {
        String information = "Size: " + size() + "\n";
        information += "Current Node: " + (cursor != null ? cursor.getData() : "null") + "\n";
        information += "Nodes: [";
        Node cursor = head;
        while(cursor != null) {
            information += cursor.getData();
            if(cursor.getNextNode() != null) {
                information += ", ";
            }
            cursor = cursor.getNextNode();
        }
        information += "]";
        return information;
    }
}

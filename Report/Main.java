package kr.ac.soongsil.assignment;

public class Main {
    public static void main(String args[]) {
        DoubleLinkedSeq list[] = new DoubleLinkedSeq[3];
        DoubleLinkedSeq l1;

        for(int i = 0; i < 3; i++) {
            list[i] = new DoubleLinkedSeq();
        }

        //addBeforeµµ °¡´É
        list[0].addAfter(1);
        list[0].addAfter(2);
        list[0].addAfter(3);
        list[1].addAfter(4);
        list[1].addAfter(5);
        list[1].addAfter(6);

        list[2] = (DoubleLinkedSeq) list[1].clone();
        l1 = (DoubleLinkedSeq) list[2].clone();


        list[0].start();
        list[1].end();
        list[0].removeCurrent();
        list[1].removeCurrent();


        list[2].addAll(list[1]);
        l1.addAll(list[0]);

        System.out.println("=========List[0]=========");
        printList(list[0]);
        System.out.println("=========List[1]=========");
        printList(list[1]);
        System.out.println("=========List[2]=========");
        printList(list[2]);
        System.out.println("========== l1 ==========");
        printList(l1);

    }

    public static void printList(DoubleLinkedSeq list) {
        String information = list.toString();
        System.out.println(information);
    }
}


import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main1 {

    /*Linked List Intersection Question
    Programming challenge description:
    Please watch the video below before starting the test:

    https://youtu.be/zCezJ8QkUL4

    Linked List Intersection Question

    You are given a collection of singly-linked lists (SLLs). Return true of any if them share a common node (or “intersect”), or false otherwise.

            Additional notes

    Please don’t use recursion. Assume the SLLs might be very large in length (in the millions).
    Stop traversing and return immediately if you detect a common node.
    If a cycle is detected, please throw an error.
    Aim to be as efficient as possible from a time complexity perspective.
    Implement this function with this signature:

    DoLinkedListsIntersect(Collection<SinglyLinkedList>) returns bool

    Input:
    Your program should read lines of text from the standard input in Codevue. The first lines of the input will describe the singly-linked-lists in a directed acyclic graph (DAG) format. The graph description language is a similar idea to the GraphViz graph description language, see: https://en.wikipedia.org/wiki/DOT_(graph_description_language).

    Each node is described as a string token, which is a unique identifier for the node. So “a->b” means a DAG with node “a” directionally connected to node “b”. As we are describing singly-linked-lists, take it as a given that the out degree of every node is either zero or one.

    After each of the edges has been described, then each subsequent line will include set of SLL starting nodes to traverse from. We advise that you draw a diagram to help you understand the example more clearly.

            Note: we have added an attachment image to show this visually.

            Output:
    For each SLL print 'True' or 'False' based on the return value of your function

true prints True
false prints False
    On throwing an error print Error Thrown!
    Test 1
    Test Input
    Download Test 1 Input
    a->b
    r->s
    b->c
    x->c
    q->r
    y->x
    w->z
            a,q,w
    a,c,r
            y,z,a,r
    a,w
    Expected Output
    Download Test 1 Output
            False
    True
            True
    False
    Test 2
    Test Input
    Download Test 2 Input
    A->B
    G->B
    B->C
    C->D
    D->E
    H->J
    J->F
            A,G,E
    H,A
    Expected Output
    Download Test 2 Output
            True
    False
    Test 3
    Test Input
    Download Test 3 Input
    ABC->BCD
    BCD->CDE
    DEF->EFG
    EFG->BCD
123->456
    ABC,CDE
123,DEF
            ABC,DEF*/

    /**
     * The Main class implements an application that reads lines from the standard input
     * and prints them to the standard output.
     */

    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static boolean DoLinkedListsIntersect(Collection<SinglyLinkedList> singlyLinkedList) {

        return false;
    }



    class Node{
        String value;
        Node next;

        Node(String value){
            this.value = value;
            this.next = null;
        }
    }

    class SinglyLinkedList {
        public SinglyLinkedList() {
        }

        Node insertNode(Node head,String val) {
            Node newNode = new Node(val);

            if(head == null) {
                head = newNode;
                return head;
            }

            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
            return head;
        }

    }
}
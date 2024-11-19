import java.util.Scanner;

public class DoublyLinkedList {

    // Node class for the doubly linked list
    private static class Node {
        Node previous;
        int data;
        Node next;

        // Constructor for the Node class
        Node(int data) {
            this.previous = null;
            this.data = data;
            this.next = null;
        }
    }

    // Head node to access the list
    private Node head;

    // Add a node at the start of the list
    private void addStart(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    // Add a node at the end of the list
    private void addEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.previous = current;
        }
    }

    // Add a node at the middle of the list
    private void addMid(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            int mid = getSize() / 2;
            Node current = head;
            for (int count = 0; count < mid; count++) {
                current = current.next;
            }
            newNode.next = current;
            if (current.previous != null) {
                newNode.previous = current.previous;
                current.previous.next = newNode;
            } else {
                head = newNode; // If adding to the beginning
            }
            current.previous = newNode;
        }
    }

    // Add a node at a specific position
    private void addAnyPos(int data, int position) {
        if (position < 1 || position > getSize() + 1) {
            System.out.println("Invalid position!");
            return;
        }

        if (position == 1) {
            addStart(data);
        } else if (position == getSize() + 1) {
            addEnd(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for (int count = 1; count < position; count++) {
                current = current.next;
            }
            newNode.next = current;
            newNode.previous = current.previous;
            current.previous.next = newNode;
            current.previous = newNode;
        }
    }

    // Get the size of the list
    private int getSize() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Delete the node from the start of the list
    private void delStart() {
        if (head == null) {
            System.out.println("Nothing to delete, List is already empty!!");
        } else {
            Node current = head.next;
            if (current != null) {
                current.previous = null;
            }
            head.next = null;
            head = current;
        }
    }

    // Delete the node from the end of the list
    private void delEnd() {
        if (head == null) {
            System.out.println("Nothing to delete, List is empty already!!");
        } else if (head.next == null) {
            head = null;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.previous.next = null;
            current.previous = null;
        }
    }

    // Delete the node from the middle of the list
    private void delMid() {
        if (head == null) {
            System.out.println("Nothing to delete, List is already empty!!");
        } else {
            int mid = getSize() / 2;
            Node current = head;
            for (int count = 0; count < mid; count++) {
                current = current.next;
            }
            if (current.previous != null) {
                current.previous.next = current.next;
            } else {
                head = current.next; // If deleting the first node
            }
            if (current.next != null) {
                current.next.previous = current.previous;
            }
        }
    }

    // Delete a node at a specific position
    private void delAnyPos(int position) {
        if (position < 1 || position > getSize()) {
            System.out.println("Invalid position!");
            return;
        }

        if (position == 1) {
            delStart();
        } else if (position == getSize()) {
            delEnd();
        } else {
            Node current = head;
            for (int count = 1; count < position; count++) {
                current = current.next;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
            current.previous = null;
            current.next = null;
        }
    }

    // Display the list from the start to the end
    private void display() {
        if (head == null) {
            System.out.println("List is empty!!");
        } else {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("NULL");
        }
    }

    // Main function remains unchanged
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        DoublyLinkedList List = new DoublyLinkedList();

        boolean status = true;
        int size, data;

        System.out.println("CODE IS FOR DOUBLY LINKED LIST");
        while (status) {
            System.out.println("1: CREATE LIST FROM THE BEGINNING");
            System.out.println("2: CREATE LIST FROM THE END");
            System.out.println("3: ADD NODE TO THE MID");
            System.out.println("4: ADD NODE TO ANY POSITION");
            System.out.println("5: DISPLAY CURRENT LIST");
            System.out.println("6: DISPLAY CURRENT SIZE OF THE LIST");
            System.out.println("7: DELETE LIST FROM THE BEGINNING");
            System.out.println("8: DELETE LIST FROM THE END");
            System.out.println("9: REMOVE NODE TO THE MID");
            System.out.println("10: REMOVE NODE TO ANY POSITION");
            System.out.println("11: TO END THE PROCESS..");
            System.out.print("Enter here: ");

            int option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Insertion from begin");
                    System.out.print("Enter the size of the list: ");
                    size = input.nextInt();
                    for (int i = 1; i <= size; i++) {
                        System.out.print("Enter node " + i + " data: ");
                        data = input.nextInt();
                        List.addStart(data);
                    }
                    break;
                case 2:
                    System.out.println("Insertion from end");
                    System.out.print("Enter the size of the list: ");
                    size = input.nextInt();
                    for (int i = 1; i <= size; i++) {
                        System.out.print("Enter node " + i + " data: ");
                        data = input.nextInt();
                        List.addEnd(data);
                    }
                    break;
                case 3:
                    System.out.println("Insertion from the mid");
                    System.out.print("Enter the data you want to enter at the mid of the list: ");
                    data = input.nextInt();
                    List.addMid(data);
                    break;
                case 4:
                    System.out.println("Insertion from any location");
                    System.out.print("Enter the location to insert the node: ");
                    int position = input.nextInt();
                    System.out.print("Enter data for the node: ");
                    data = input.nextInt();
                    List.addAnyPos(data, position);
                    break;
                case 5:
                    System.out.println("Current List Nodes are !!");
                    List.display();
                    break;
                case 6:
                    System.out.println("Current size of the List is: " + List.getSize());
                    break;
                case 7:
                    System.out.println("Deletion from begin");
                    List.delStart();
                    break;
                case 8:
                    System.out.println("Deletion from end");
                    List.delEnd();
                    break;
                case 9:
                    System.out.println("Deletion from mid");
                    List.delMid();
                    break;
                case 10:
                    System.out.println("Deletion from any point");
                    System.out.print("Enter the location to delete the node: ");
                    int position1 = input.nextInt();
                    List.delAnyPos(position1);
                    break;
                case 11:
                    System.out.println("Exiting the process.....");
                    status = false;
                    break;
                default:
                    System.out.println("Please enter valid option...");
            }
        }
        input.close();
    }
}

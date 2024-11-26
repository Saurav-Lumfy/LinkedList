import java.util.InputMismatchException;
import java.util.Scanner;

public class SinglyCircularLinkedList {

    // Inner class representing a Node
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // Head pointer

    // Add node at the start
    private void addStart(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            newNode.next = head;
            head = newNode;
            current.next = head;
        }
    }

    // Add node at the end
    private void addEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
    }

    // Add node at the middle
    private void addMid(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            int mid = getSize() / 2;
            Node current = head;
            int count = 1;

            while (count < mid) {
                current = current.next;
                count++;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Add node at any position
    private void addAnyPos(int data, int pos) {
        if (pos < 1) {
            throw new IllegalArgumentException("Position cannot be less than 1.");
        }

        if (pos > getSize() + 1) {
            System.out.println("Position exceeds list size. Adding node at the end.");
            addEnd(data);
        } else if (pos == 1) {
            addStart(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            int count = 1;

            while (count < pos - 1) {
                current = current.next;
                count++;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Delete node at the start
    private void delStart() {
        if (head == null) {
            throw new IllegalStateException("Cannot delete from an empty list.");
        } else if (head.next == head) {
            head = null;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            head = head.next;
            current.next = head;
        }
    }

    // Delete node at the end
    private void delEnd() {
        if (head == null) {
            throw new IllegalStateException("Cannot delete from an empty list.");
        } else if (head.next == head) {
            head = null;
        } else {
            Node current = head;
            while (current.next.next != head) {
                current = current.next;
            }
            current.next = head;
        }
    }

    // Delete node at any position
    private void delAnyPos(int pos) {
        if (pos < 1 || pos > getSize()) {
            throw new IndexOutOfBoundsException("Invalid position. Please enter a valid position.");
        }

        if (pos == 1) {
            delStart();
        } else {
            Node current = head;
            Node previous = null;
            int count = 1;

            while (count < pos) {
                previous = current;
                current = current.next;
                count++;
            }
            previous.next = current.next;
        }
    }

    // Get size of the list
    private int getSize() {
        int count = 0;
        if (head == null) {
            return count;
        } else {
            Node current = head;
            do {
                count++;
                current = current.next;
            } while (current != head);
        }
        return count;
    }

    // Display list
    private void display() {
        if (head == null) {
            System.out.println("Empty!!");
        } else {
            Node current = head;
            do {
                System.out.print(current.data + " -> ");
                current = current.next;
            } while (current != head);
            System.out.println("End!!");
        }
    }

    // Main function
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SinglyCircularLinkedList list = new SinglyCircularLinkedList();
        boolean status = true;

        System.out.println("CODE IS FOR SINGLY CIRCULAR LINKED LIST");
        while (status) {
            try {
                System.out.println("1: CREATE LIST FROM THE BEGINNING");
                System.out.println("2: CREATE LIST FROM THE END");
                System.out.println("3: ADD NODE TO THE MID");
                System.out.println("4: ADD NODE TO ANY POSITION");
                System.out.println("5: DISPLAY CURRENT LIST");
                System.out.println("6: DISPLAY CURRENT SIZE OF THE LIST");
                System.out.println("7: DELETE LIST FROM THE BEGINNING");
                System.out.println("8: DELETE LIST FROM THE END");
                System.out.println("9: REMOVE NODE FROM THE MID");
                System.out.println("10: REMOVE NODE FROM ANY POSITION");
                System.out.println("11: EXIT");
                System.out.print("Enter here: ");

                int option = input.nextInt();

                switch (option) {
                    case 1 -> {
                        System.out.print("Enter size of list: ");
                        int size = input.nextInt();
                        for (int i = 1; i <= size; i++) {
                            System.out.print("Enter node " + i + " data: ");
                            int data = input.nextInt();
                            list.addStart(data);
                        }
                    }
                    case 2 -> {
                        System.out.print("Enter size of list: ");
                        int size = input.nextInt();
                        for (int i = 1; i <= size; i++) {
                            System.out.print("Enter node " + i + " data: ");
                            int data = input.nextInt();
                            list.addEnd(data);
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter data for mid: ");
                        int data = input.nextInt();
                        list.addMid(data);
                    }
                    case 4 -> {
                        System.out.print("Enter position: ");
                        int pos = input.nextInt();
                        System.out.print("Enter data: ");
                        int data = input.nextInt();
                        list.addAnyPos(data, pos);
                    }
                    case 5 -> list.display();
                    case 6 -> System.out.println("Current size: " + list.getSize());
                    case 7 -> list.delStart();
                    case 8 -> list.delEnd();
                    case 9 -> list.delAnyPos((list.getSize() + 1) / 2);
                    case 10 -> {
                        System.out.print("Enter position: ");
                        int pos = input.nextInt();
                        list.delAnyPos(pos);
                    }
                    case 11 -> {
                        System.out.println("Exiting...");
                        status = false;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                input.next(); // Clear invalid input
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        input.close();
    }
}


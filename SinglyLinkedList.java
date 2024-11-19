import java.util.Scanner;
public class SinglyLinkedList{

    private static class Node{
        int data;
        Node next;
    
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    //creating head
    private Node head;

    //insert the node at the end of the list
    public void addEnd(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
        }else{
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    //insert the node at the beginning
    public void addBegin(int data){
        Node newNode = new Node(data);

            newNode.next = head;
            head = newNode;
    }

    //add node from the mid
    public void addMid(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else {
            Node current = head;
            int mid = getSize()/2;
            int count = 1;
            while (count < mid){
                current = current.next;
                count++;
            }
            newNode.next = current.next;
            current.next = newNode;

        }
    }

    //insertion from any location
    public void addAny(int data, int location){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        if(location == 1){
            newNode = head;
            head = newNode.next;
        }
        else{
            Node current = head;
            Node previous = head;

            int count = 1;
            while (count != location){
                previous = current;
                current = current.next;
                count++;
            }

            newNode.next = current;
            previous.next = newNode;
        }
    }

    //delete from start
    public void delStart(){
        if(head == null){
            System.out.println("List is already empty");
        }else{
            head = head.next;
        }
    }
    //delete from end
    public void delEnd(){
        if(head == null){
            System.out.println("List is already empty");
        }
        if(head.next == null){
            head = null;
        }
        else {
            Node current = head;
            while (current.next != null && current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
    }

    //delete from mid
    public void delMid(){
        if(head == null){
            System.out.println("List is empty");
        }else if(head.next == null){
            head = null;
        }
        else {
            int mid = getSize()/2;

            Node current = head;
            Node previous = head;

            int count = 0;
            while(count < mid){
                previous = current;
                current = current.next;
                count++;
            }

            previous.next = current.next;
            current.next = null;
        }
    }

    //delete from any location
    public void delAny(int position){
        if(head == null){
            System.out.println("List is empty");
        }
        if(position == 1){
            head = head.next;
        }
        else{
        Node current = head;
        Node previous = head;

        int count = 1;
        while (count != position){
            previous = current;
            current = current.next;
            count++;
        }

        previous.next = current.next;
        current.next = null;
        }
    }

    //get size of the linked list
    public int getSize(){
        Node current = head;
        int count = 0;
        while(current != null){
            current = current.next;
            count++;
        }
        return count;
    }

    //display list
    public void display(){
        if(head == null){
            System.out.println("List is empty");
        }else{
            Node current = head;
            while (current != null){
                System.out.print(current.data+"->");
                current = current.next;
            }
        }

        System.out.println("null");
    }
    // main process
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("WELCOME TO PERFORM ALL THE OPERATION OF SINGLY LINKED LIST!!");

        SinglyLinkedList lst = new SinglyLinkedList();

        boolean status = true;

        while (status){
            System.out.println("CHOOSE OPTIONS TO PERFORM OPERATIONS!!");
            System.out.println("1: Insert from began");
            System.out.println("2: Insert from end");
            System.out.println("3: Insert from mid");
            System.out.println("4: Insert from any position");
            System.out.println("5: Delete from start");
            System.out.println("6: Delete from end");
            System.out.println("7: Delete from mid");
            System.out.println("8: Delete from any position");
            System.out.println("9: If wants to exit press");
            while(!input.hasNextInt()) {
                System.out.println("Please enter valid option it should be 1,2,3,4 or 5");
            }
            int option = input.nextInt();
            switch (option){
                case 1:
                    System.out.println("Insert from the start");
                    System.out.print("Enter the size of the list: ");
                    if(!input.hasNextInt()){
                        System.out.println("Please Enter valid input it should be integer");
                    }
                    int size = input.nextInt();
                    for(int i = 1; i<=size; i++){
                        System.out.print("Enter the data for the "+i+" node: ");
                        if(!input.hasNextInt()){
                            System.out.println("Please enter valid data. it should be positive integer");
                        }
                        int data = input.nextInt();
                        lst.addBegin(data);
                    }
                    lst.display();
                    break;
                case 2:
                    System.out.println("Insertion from the end");
                    System.out.print("Enter the size of the list: ");
                    if(!input.hasNextInt()){
                        System.out.println("Please Enter valid input it should be integer");
                    }
                    int size1 = input.nextInt();
                    for (int i = 1; i<=size1; i++){
                        System.out.print("Enter the data for the "+i+" node: ");
                        if(!input.hasNextInt()){
                            System.out.println("Please enter valid data. it should be positive integer");
                        }
                        int data = input.nextInt();
                        lst.addEnd(data);
                    }
                    lst.display();
                    break;
                case 3:
                    System.out.println("Insertion from the mid");
                    System.out.print("Enter the data: ");
                    if(!input.hasNextInt()){
                        System.out.println("Please enter the valid input. It should be positive integer");
                    }
                    int data = input.nextInt();
                    lst.addMid(data);
                    lst.display();
                    break;
                case 4:
                    System.out.println("Insertion at any location");
                    System.out.print("Where you want to store the data: ");
                        if(!input.hasNextInt()){
                            System.out.println("Please enter valid data. It should be positive integer");
                        }
                        int location = input.nextInt();
                        if(location <= 0){
                            System.out.print("Enter the data: ");
                            if(!input.hasNextInt()) {
                                System.out.println("Please enter valid data. It should be positive integer");
                            }
                            int data1 = input.nextInt();
                            lst.addBegin(data1);
                            System.out.println("location should be more than 0 or positive currently data is added to the starting of the list");
                        }else if(location > lst.getSize()) {
                            System.out.print("Enter the data: ");
                            if(!input.hasNextInt()) {
                                System.out.println("Please enter valid data. It should be positive integer");
                            }
                            int data1 = input.nextInt();
                            lst.addEnd(data1);
                            System.out.println("location should be less than size currently data is added to the end of the list");
                        }else{
                    System.out.print("Enter the data: ");
                    if(!input.hasNextInt()){
                        System.out.println("Please enter valid data. It should be positive integer");
                    }
                        int data1 = input.nextInt();

                        lst.addAny(data1, location);
                    }
                        lst.display();
                    break;
                case 5:
                    System.out.println("Delete from start");
                    lst.delStart();
                    System.out.println();
                    lst.display();
                    break;
                case 6:
                    System.out.println("Delete from end");
                    lst.delEnd();
                    System.out.println();
                    lst.display();
                    break;
                case 7:
                    System.out.println("Delete from mid");
                    lst.delMid();
                    System.out.println();
                    lst.display();
                    break;
                case 8:
                    System.out.print("Enter the position where you want to delete the node: ");
                    int position = input.nextInt();
                    while(position > lst.getSize() || position < 1){
                        System.out.println("Please enter the location less than sie or greater than 0");
                        position = input.nextInt();
                    }
                    lst.delAny(position);
                    System.out.println();
                    lst.display();
                    break;
                case 9:
                        status = false;
                    System.out.println("Exiting!!!");
                        break;
                default:
                    System.out.println("Please enter valid input");
            }
        }
    }
}
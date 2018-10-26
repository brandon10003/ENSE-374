import java.io.*;
import java.util.*;

public class UI {
   
	/**
	 * @param args
	 */
	public static void main(String[] args) {
            Scanner instream = new Scanner(System.in);
            char in;
            boolean run = true;
            int index;
            int indata;
            int outdata;
            int listsize = 0;
            ListElement head = new ListElement();
            ListElement pointer = new ListElement();
            pointer.next = head;
            
            
            do{
                System.out.println("Please enter a character to continue:");
                System.out.println("Enter 'a' to add a node");
                System.out.println("Enter 'g' to get a node");
                System.out.println("Enter 'd' to delete a node");
                System.out.println("Enter 'p' to print a list starting from the head");
                System.out.println("Enter 'r' to print a list starting from the tail");
                System.out.println("Enter 'q' to quit");
                
                in = instream.next().charAt(0);
                in = Character.toLowerCase(in);
                
                switch(in){
                    case 'a':
                        System.out.println("Please enter the value to be added to the list");
                        indata = instream.nextInt();
                        pointer.next.setData(indata);
                        pointer.next.next = new ListElement();
                        pointer.next.next.prev = pointer.next;
                        pointer.next = pointer.next.next;
                        listsize++;
                            
                        break;
                    case 'g':
                        System.out.println("Please enter the index of the link which you wish to retreive the value from");
                        index = instream.nextInt();
                        if (index > listsize){
                            System.out.println("That is not a valid index");
                            break;
                        }
                        pointer.next = head;
                        for (int i=0; i<index; i++){
                            pointer.next = pointer.next.next;
                        }
                        outdata = pointer.next.getData();
                        System.out.println("The value at link " + index + " is " + outdata);
                        break;
                    case 'd':
                        System.out.println("Please enter the index of the link which you wish to delete");
                        index = instream.nextInt();
                        if (index > listsize){
                            System.out.println("That is not a valid index");
                            break;
                        }
                        pointer.next = head;
                        for (int i=0; i<(index-1); i++){
                            pointer.next = pointer.next.next;
                        }
                        pointer.next.next = pointer.next.next.next;
                        pointer.next.next.prev = pointer.next;
                        listsize--;
                        System.out.println("The former link at index " + index + " has been deleted");
                        break;
                    case 'p':
                        System.out.println("The list printed from the head node as is follows");
                        System.out.println("->null");
                        pointer.next = head;
                        for (int i=0; i<listsize; i++){
                            outdata = pointer.next.getData();
                            System.out.println(outdata + "<->");
                            pointer.next = pointer.next.next;
                        }
                        System.out.println("null");
                        break;
                    case 'r':
                        System.out.println("The list printed from the tail node as is follows");
                        System.out.println("->null");
                        pointer.next = head;
                        for (int i=0; i<(listsize-1); i++){
                            pointer.next = pointer.next.next;
                        }
                        for (int i=0; i<listsize; i++){
                            outdata = pointer.next.getData();
                            System.out.println(outdata + "<->");
                            pointer.next = pointer.next.prev;
                        }
                        System.out.println("null");
                        break;
                    case 'q':
                        run = false;
                        break;
                    default:
                        System.out.println("That is not a valid input, please enter a valid input");
                        break;
                }
            }while(run);
	}
}

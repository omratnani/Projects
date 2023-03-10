package com.company;
import java.util.Scanner;
public class Student {
        String[][] array = new String[50][100];
        int record_count = 0;

        public void IsAuthentication() {  //method for password which compares the given username and password with the input
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter UserName :");
            String username = sc.nextLine();
            System.out.println("Enter Password :");
            String password = sc.nextLine();
            if (username.equals("Om") && password.equals("Kirshana")) {
                mainMenu();
            } else
                System.out.println("Invalid Credentials. Try Again!");
            IsAuthentication();
        }
        public void mainMenu()   // method for main menu which displays the menu
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("****************************************************************************");
            System.out.println("*                                                                          *");
            System.out.println("*                                                                          *");
            System.out.println("*                             **MAIN MENU*                                 *");
            System.out.println("*                                                                          *");
            System.out.println("*                                                                          *");
            System.out.println("****************************************************************************\n");
            System.out.println("       1.---------------------Add Student Data---------------------------");
            System.out.println("      2.---------------------Delete Student Data--------------------------");
            System.out.println("     3.----------------------Display Student Data--------------------------");
            System.out.println("    4.---------------------Check Admission Eligibility----------------------");
            System.out.println("   5.-----------------------Check Student Fee Status-------------------------");
            System.out.println("  6.----------------------------Search the record-----------------------------");
            System.out.println("7.----------------------------------Exit---------------------------------------");

            System.out.println("\n\t\t\t\t\t\tChoose desired option: ");
            int inp = sc.nextInt();
            if (inp == 1) {
                this.insertFunction();
            } else if (inp == 2) {
                if (this.deleteRecord() == -1) {
                    System.out.println("Record Not found");
                }
                mainMenu();
            } else if (inp == 3) {
                this.Display();
            } else if (inp == 4) {
                this.checkAdmissionEligibility();
            } else if (inp == 5) {
                this.feeDeposit();
            } else if (inp == 6) {
                if (this.searchRecord() == -1) {
                    System.out.println("Record Not found");
                }
            } else if (inp == 7) {
                System.exit(0);
            }

        }

        public void insertFunction()   //method for inserting data of the students
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Name:");
            this.array[this.record_count][0] = sc.nextLine();
            System.out.println("ID:");
            this.array[this.record_count][1] = sc.nextLine();
            System.out.println("Department:");
            this.array[this.record_count][2] = sc.nextLine();
            System.out.println("Semester:");
            this.array[this.record_count][3] = sc.nextLine();
            System.out.println("Section:");
            this.array[this.record_count][4] = sc.nextLine();
            System.out.println("Data is saved!");
            this.record_count++;
            Scanner sca = new Scanner(System.in);
            System.out.println("Press 1 to add more data.");
            System.out.println("Press 2 to return main menu.");
            System.out.println("Press 3 to Exit.");
            int inp = sca.nextInt();
            if (inp == 1) {
                insertFunction();
            } else if (inp == 2) {
                mainMenu();
            } else if (inp == 3) {
                System.exit(0);
            }
        }
        public int deleteRecord()  //method for deleting the student data
        {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter ID to delete:");
            int record = s.nextInt();
            for (int i = 0; i < record_count; i++) {
                if (array[i][1].equals(String.valueOf(record))) {
                    for (int j = i; j < record_count; j++) {
                        array[j] = array[j + 3];
                    }
                    System.out.println("Record has been deleted");
                    record_count--;
                    return 1;
                }
            }
            return 1;
        }

        public int searchRecord()  //method for searching the student data
        {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter ID to search:");
            int record = s.nextInt();
            for (int i = 0; i < record_count; i++) {
                if (array[i][1].equals(String.valueOf(record))) {
                    System.out.println("Record found:\n " + array[i][0] + " " + array[i][1] + " " + array[i][2] + " " + array[i][3] + " " + array[i][4]);
                    return 1;
                }
            }
            return -1;
        }

        public void checkAdmissionEligibility()   //method for checking the admission eligibility.
        {

            System.out.println("Enter your marks to check admission eligibility: ");
            Scanner sca = new Scanner(System.in);
            int marks = sca.nextInt();
            if (marks >= 55 && marks < 100) {
                System.out.println("You are eligible.");
                System.out.println("Press 1 to check again.");
                System.out.println("Press 2 to go back to Main Menu.");
                int inp = sca.nextInt();
                if (inp == 1) {
                    checkAdmissionEligibility();
                } else {
                    mainMenu();
                }
            } else if (marks < 55 && marks > 0) {
                System.out.println("You are not eligible");
            } else {
                System.out.println("Invalid Marks. Try again");
                checkAdmissionEligibility();
            }

            System.out.println("Press 1 to check again.");
            System.out.println("Press 2 to go back to Main Menu.");
            int inp = sca.nextInt();
            if (inp == 1) {
                checkAdmissionEligibility();
            } else {
                mainMenu();
            }
        }

        public void feeDeposit()   //method for checking if the fee is pending or cleared.
        {

            System.out.println("Enter the fee given by the student");
            Scanner sca = new Scanner(System.in);
            int fee = sca.nextInt();
            if (fee > 500) {
                System.out.println("Fee is cleared");
                System.out.println("Press 1 to check again.");
                System.out.println("Press 2 to go back to Main Menu.");
                int inp = sca.nextInt();
                if (inp == 1) {
                    feeDeposit();
                } else {
                    mainMenu();
                }
            } else {
                System.out.println("Your fee is pending");
                System.out.println("Press 1 to check again.");
                System.out.println("Press 2 to go back to Main Menu.");

                int inp = sca.nextInt();
                if (inp == 1) {
                    feeDeposit();
                } else {
                    mainMenu();
                }
            }

        }


        public void Display()   //method for printing the data of the students
        {
            System.out.println("Entered display function");

            for (int i = 0; i < this.record_count; i++) {
                System.out.println("Name: " + this.array[i][0]);
                System.out.println("ID: " + this.array[i][1]);
                System.out.println("Department: " + this.array[i][2]);
                System.out.println("Semester: " + this.array[i][3]);
                System.out.println("Section: " + this.array[i][4]);
            }
            for (int i = 0; i < record_count; i++) {

            }
            Scanner sca = new Scanner(System.in);
            System.out.println("Press 1 to go back to Main Menu.");
            System.out.println("Press 2 to Exit.");
            int inp = sca.nextInt();
            if (inp == 1) {
                mainMenu();
            } else {
                System.exit(0);
            }
        }
    }
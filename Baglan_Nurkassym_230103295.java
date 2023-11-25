import java.util.*;
public class Baglan_Nurkassym_230103295{
public static Scanner scan = new Scanner (System.in);
	public static List<String> studentnameList = new ArrayList<>();
	public static List<Integer> studentIDList = new ArrayList<>();
	public static List<Double> testscoreList = new ArrayList<>();
	public static int total = 0;
	public static double average = 0;
	public static double Highest;
	public static double Lowest;
	public static int localcheckrecord = 0;
	public static boolean checker = true;
public static void AddStudent(){
		System.out.print("Enter student name: ");
		String studentname = scan.nextLine();
	String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	boolean normalname = true;
	for (int i = 0; i < studentname.length(); i++) {
    char oneWord = Character.toUpperCase(studentname.charAt(i));

    	if (Alphabet.indexOf(oneWord) == -1) {
    	    normalname = false;
    	    break;
    	}
	}
		if (normalname){
			System.out.print("Enter student ID: ");
			int studentID;
				do {
            		try { //замена hasNextInt
               			studentID = scan.nextInt();
         				break;
       				} catch (java.util.InputMismatchException e) {
            			System.out.print("Enter a valid ID: ");
                		scan.nextLine();
            		}
        		} while (true);

            	int indexID = studentIDList.indexOf(studentID);
				if (indexID == -1){

					boolean checkIN = false;
					double testscore = 0;
					System.out.print("Enter test score: ");
					while (checkIN == false){
							do {
            					try {
               		 				testscore = scan.nextDouble();
                					break;
            					} catch (java.util.InputMismatchException e) {
            						System.out.print("Enter a valid test score: ");
                					scan.nextLine();
            					}
        					} while (true);

						if (testscore >= 0 && testscore <=100){
							checkIN = true;
						} else {
							System.out.print("Try again. Enter a number from 0 to 100: ");
						}
					}
				studentnameList.add(studentname);
				studentIDList.add(studentID);
				testscoreList.add(testscore);
				System.out.println("Student added succesfully");
				checker = true;
				scan.nextLine();

				} else {
					System.out.println("This ID already exists, try to write another ID for this student");
					scan.nextLine();
				}
		} else {
			System.out.println("There are non-standard characters in the student's name, enter 1 to try again");
		}
}
public static void ManageRecords(){
if (studentnameList.size() == 0){
            System.out.println("Your don't add student. Please add student first");
        } else{
            System.out.print("Enter student ID to edit: ");

            int editID;
            do {
                try {
                    editID = scan.nextInt();
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.print("Enter a valid ID: ");
                    scan.nextLine();
                }
            } while (true);

            int indexeditID = studentIDList.indexOf(editID);
            if (indexeditID != -1){
                boolean checkIN = false;
                double testscore = 0;
                while (checkIN == false){
                    System.out.print("Enter test score: ");

                    do {
                        try {
                            testscore = scan.nextDouble();
                            scan.nextLine();
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.print("Enter a valid test score: ");
                            scan.nextLine();
                        }
                    } while (true);

                    if (testscore >= 0 && testscore <=100){
                        checkIN = true;
                    } else {
                        System.out.println("Try again. Enter a number from 0 to 100;");
                    }
                }
                testscoreList.set(indexeditID, testscore);
                       checker = true;
            } else {
                System.out.println("This ID does not exist, enter 2 to try again");
                scan.nextLine();
            }
        }
}
public static void CalculateGrades() {
	if (studentnameList.size() == 0){
			System.out.println("Your don't add student. Please add student first");
	} else{	
		localcheckrecord = 1;
		total = studentIDList.size();
		if(total != 0){
			double overall = 0;
			for (int i = 0; i < total; i++){
				overall += testscoreList.get(i);
			}
			average = overall / total;
			Highest = testscoreList.get(0);
			for (int j = 1; j<total; j++){
				if (testscoreList.get(j) > Highest){
					Highest = testscoreList.get(j);
				}
			}
			Lowest = testscoreList.get(0);
			for (int k = 1; k < total; k++) {
    			if (testscoreList.get(k) < Lowest){
    		    	Lowest = testscoreList.get(k);
    			}
			}
			System.out.println("Grades calculated.");
			System.out.println("Grade Details added");
			checker=false;
		} else {
			total = 0;
			average = 0;
			Highest = 0;
			Lowest = 0;
			System.out.println("No students entered for calculation");
		}
	}
}
public static void ViewStatistics(){
	if (studentnameList.size() == 0){
		System.out.println("Your don't add student. Please add student first");
	} else{
		if (localcheckrecord == 0 || checker){
			System.out.println("Your don't calculate grades. Please calculate grades first");
		} else {
			System.out.println("Total students: " + total);
			System.out.println("Average Score: " + average);
			System.out.println("Highest Score: " + Highest);
			System.out.println("Lowest Score: " + Lowest);
		}
	}
}
public static void GenerateReports(){
	if (studentnameList.size() == 0){
		System.out.println("Your don't add student. Please add student first");
	} else{
		if (localcheckrecord == 0 || checker){
			System.out.println("Your don't calculate grades. Please calculate grades first");
		} else {
			System.out.print("Enter student ID to generate a report: ");

			int reportID;
			do {
            	try {
               		reportID = scan.nextInt();
         			break;
       			} catch (java.util.InputMismatchException e) {
           			System.out.print("Enter a valid ID: ");
               		scan.nextLine();
           		}
       		} while (true);
			
			int indexreportID = studentIDList.indexOf(reportID);
			if (testscoreList.size() == 0){
				System.out.println("No student entered for generate reports");
			} else {
				if (indexreportID != -1){
					double testscore = testscoreList.get(indexreportID);
					char grade;

						if (testscore >= 90 && 100 >= testscore){
						grade = 'A';
					} else if (testscore >= 80 && 89 >= testscore){
						grade = 'B';
					} else if (testscore >= 70 && 79 >= testscore){
						grade = 'C';
					} else if (testscore >= 60 && 69 >= testscore){
						grade = 'D';
					} else {
						grade = 'F';
					}	
					if (indexreportID != -1){
						System.out.println("Generating report for student with ID: " + reportID);
						System.out.println("Student Report");
						System.out.println("Name: " + studentnameList.get(indexreportID));
						System.out.println("Student ID: " + reportID);
						System.out.println("Test Score: " + testscore);
						System.out.println("Final Grade: " + grade);
						scan.nextLine();
					}
				} else {
					System.out.println("Student with this ID does not exist, enter 5 to try again");
				}
			}
		}
	}
}
public static void DeleteStudent(){
	if (studentnameList.size() == 0){
		System.out.println("Your don't add student. Please add student first");
	} else{
		System.out.print("Enter student ID to delete: ");

		int deleteID;
			do {
            	try {
               		deleteID = scan.nextInt();
         			break;
       			} catch (java.util.InputMismatchException e) {
           			System.out.print("Enter a valid ID: ");
               		scan.nextLine();
           		}
       		} while (true);

		int indexdeleteID = studentIDList.indexOf(deleteID);
		if (indexdeleteID != -1){

			studentnameList.remove(indexdeleteID);
			studentIDList.remove(indexdeleteID);
			testscoreList.remove(indexdeleteID);

			System.out.println("Student deleted succesfully");
			checker = true;
			scan.nextLine();

		} else {
			System.out.println("Student with this ID does not exist, enter 6 to try again");
			scan.nextLine();
		}
	}
}
public static void main(String[] args) {
		boolean login = false;
		while (login == false){
			System.out.print("Enter username: ");
			String username = scan.nextLine();
			System.out.print("Enter password: ");
			String password = scan.nextLine();
			if (username.equals("myusername") && password.equals("mypassword")){
				login = true;
			} else {
				System.out.println("Your password or login is incorrect. Try to write your nickname and password again");	
			}
		}
			String input = "1";
			do { System.out.println("Main menu \n1. Add Student \n2. Manage Record \n3. Calculate Grades \n4. View Statistics \n5. Generate Reports \n6. Delete Student \n7. Logout and exit");

			System.out.print("Enter your choice: ");

			input = scan.nextLine();

				switch(input){
					case "1" :
						AddStudent();
						break;
					case "2" :
						ManageRecords();
						break;
					case "3":
						CalculateGrades();
						break;
					case "4":
						ViewStatistics();
						break;
					case "5":
						GenerateReports();
						break;
					case "6":
						DeleteStudent();
						break;
					case "7":
						break;
					default:
						System.out.println("Wrong choice. Please enter a valid case");
				}
			} while (input.equals("7")!=true);
	}
}
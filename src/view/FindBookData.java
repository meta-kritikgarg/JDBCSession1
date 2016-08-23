package view;

import java.util.Scanner;
import dao.BookDao;

/**
 * 
 * @author Kritik Garg
 *
 */

// Given the name of the book, to be issued by an existing member.Return flag to
// indicate whether the the book has been issued or not.

public class FindBookData {

	public static void main(String[] args) {

		FindBookData findBookData = new FindBookData();

		BookDao ad = new BookDao();
		if (ad.isBookIssued(findBookData.getStringfromUser("Title Name"))) {
			System.out.println("Book is avaliable");
		} else {
			System.out.println("Book issued or Not avaliable");
		}

	}

	/**
	 * Method to read string data from standard input
	 * 
	 * @param Name
	 *            of variable to print
	 * @return String value input by user
	 */
	public String getStringfromUser(String Name) {
		Scanner s = new Scanner(System.in);
		String string = "";
		while (true) {
			try {
				System.out.println("Enter " + Name);
				string = s.nextLine();
				if (string.length() > 0) {
					break;
				} else {
					System.out.println("Invalid, Try Again");
				}
			} catch (Exception e) {
				System.out.println("Invalid, Try again");
				s.next();
			} finally {
				s.close();
			}
		}
		return string;
	}

}
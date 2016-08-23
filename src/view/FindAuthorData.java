package view;

import java.util.Scanner;

import dao.AuthorDao;
import entities.Author;

/**
 * 
 * @author Kritik Garg
 *
 */

// Fetch all the books published by author, given the name of the author. Return
// the books data (List of Titles).

public class FindAuthorData {

	public static void main(String[] args) {

		FindAuthorData findAuthorData = new FindAuthorData();

		AuthorDao ad = new AuthorDao();
		Author author = ad.findBooksByName(findAuthorData
				.getStringfromUser("Author Name"));

		if (author.getBooks() != null) {
			System.out.println(author.getBooks());
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

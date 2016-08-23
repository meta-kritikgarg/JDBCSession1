package view;

import dao.BookDao;

/**
 * 
 * @author Kritik Garg
 *
 */

/**
 * Delete all those books which were not issued in last 1 year. Return the
 * number of books deleted.
 * 
 * @author Kritik Garg
 *
 */
public class DeleteUnusedBooks {

	public static void main(String[] args) {

		BookDao ad = new BookDao();
		ad.deleteUnusedBooks();
		System.out.println("Unused Books deleted");
	}

}

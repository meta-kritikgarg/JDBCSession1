package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entities.Author;
import entities.Book;

/**
 * 
 * @author Kritik Garg
 *
 */
public class AuthorDao {

	/**
	 * Method to find books by author name
	 * 
	 * @param name
	 * @return
	 */
	public Author findBooksByName(String name) {
		// Connection creation
		Connection connection = DaoManager.getConnection();
		Author author = new Author();
		try {

			String query = "SELECT B.accession_no, B.price, T.title_nm, A.auther_nm, B.status,B.purchase_dt "
					+ "FROM books B LEFT JOIN titles T ON B.title_id= T.title_id "
					+ "LEFT JOIN title_auther TA ON TA.title_id = T.title_id "
					+ "LEFT JOIN authers A ON A.auther_id = TA.auther_id "
					+ "WHERE A.auther_nm = '" + name + "'";

			PreparedStatement st = connection.prepareStatement(query);
			ResultSet resultset = st.executeQuery();
			author.setAuthorName(name);

			// add all the data to list of books
			while (resultset.next()) {
				Book book = new Book();
				book.setAccession_no(resultset.getInt("B.accession_no"));
				book.setPrice(resultset.getInt("B.price"));
				book.setTitle(resultset.getString("T.title_nm"));
				book.setStatus(resultset.getString("B.status"));
				book.setPurchase_dt(resultset.getString("B.purchase_dt"));
				author.addBook(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return author;
	}

}

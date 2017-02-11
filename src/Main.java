import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
	// JDBC Database URI
	static final String DB_URL = "jdbc:mysql://localhost/wordpress";

	public static void main(String[] args) throws Exception {
		Connection conn = null;
		Statement stmt = null;

		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, "wordpress_u", "wordpress_p");

		// Execute a query
		stmt = conn.createStatement();
		String sql = "SELECT id, post_author, post_title from wp_posts";

		ResultSet rs = stmt.executeQuery(sql);

		// Extract data from result set
		while (rs.next()) {
			// Retrieve by column name
			int id = rs.getInt("id");
			String postAuthor = rs.getString("post_author");
			String postTitle = rs.getString("post_title");

			System.out.print("ID: " + id + ", Post Author: " + postAuthor + ", Post Title: " + postTitle + "\n");
		}
		// Clean-up
		rs.close();
		stmt.close();
		conn.close();
		System.out.println("Goodbye!");
	}
}
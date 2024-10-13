package productManagement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {
	Connection con;
	ProductDB()
	{
		try {
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/tekusco", "postgres", "kpkp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void save(Product p)
	{
		String Query="INSERT INTO product(name,type,place,warrenty) values(?,?,?,?);";
		try {
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, p.getName());
			ps.setString(2, p.getType());
			ps.setString(3, p.getPlace());
			ps.setInt(4, p.getWarrenty());
			ps.execute();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	List<Product> getall()
	{
		List<Product> l=new ArrayList<>();
		String Query="SELECT * FROM product;";
		try {
			PreparedStatement ps=con.prepareStatement(Query);
			
			ResultSet rs = ps.executeQuery();
		//	rs.next();
			while(rs.next())
			{
				Product p=new Product();
				p.setName(rs.getString(2));
				p.setType(rs.getString(3));
				p.setPlace(rs.getString(4));
				p.setWarrenty(Integer.parseInt(rs.getString(5)));
				l.add(p);
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	List<Product> getByName(String name)
	{
		List<Product> l=new ArrayList<>();
		String Query="SELECT * FROM product WHERE name=?;";
		try {
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
		//	rs.next();
			while(rs.next())
			{
				Product p=new Product();
				p.setName(rs.getString(2));
				p.setType(rs.getString(3));
				p.setPlace(rs.getString(4));
				p.setWarrenty(Integer.parseInt(rs.getString(5)));
				l.add(p);
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

}

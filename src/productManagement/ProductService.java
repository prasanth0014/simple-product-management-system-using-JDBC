package productManagement;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
	
	List<Product> l=new ArrayList<>();
	ProductDB pd=new ProductDB();
	void add(Product a)
	{
		//l.add(a);
		pd.save(a);
	}
	List<Product> getProducts()
	{
		return pd.getall();
	}
	Product getProductByName(String name)
	{
		for(Product p:pd.getByName(name))
		{
			if(p.getName().equals(name))
			{
				return p;
			}
		}
		return null;
	}
	List<Product> getProductByText(String text)
	{	text=text.toLowerCase();
		List<Product> t=new ArrayList<>();
		for(Product p:pd.getall())
		{
			String name=p.getName().toLowerCase();
			String type=p.getType().toLowerCase();
			String place=p.getPlace().toLowerCase();
			if(name.contains(text) || type.contains(text) || place.contains(text))
			{
				t.add(p);
			}
		}
		return t;
	}

}

package productManagement;

public class MAin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductService ps=new ProductService();
//		ps.add(new Product("note 8 pro","mobile","home",2022));
//		ps.add(new Product("note 10 pro","mobile","home",2023));
//		ps.add(new Product("realme 5s","mobile","home",2020));
//		ps.add(new Product("asus tuf a17","laptop","clg",2023));
		
		//System.out.println(ps.getProducts());
//		for(Product p:ps.getProducts())
//		{
//			System.out.println(p);
//		}
		System.out.println(ps.getProductByName("realme 5s"));
		
	//	System.out.println(ps.getProductByText("pro"));
		



	}

}

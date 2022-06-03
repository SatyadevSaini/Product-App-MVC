package com.incapp.repo;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.incapp.bean.Product;

@Repository
public class ProductRepo {
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//add product 
	
	public String addProduct(Product p , InputStream image) {
	
		try {
			final String query = "insert into detail values (?,?,?,?,?)";
			jdbcTemplate.update(query , new Object[] {p.getPid() , p.getPprice(), p.getPname(), p.getReview(), image});
			
			return "sucess";
		} catch (Exception e) {
			return "failed";
		}
	}
	
	
	// Get All Product 
	
	public List<Product> getAllProduct(){
		
	   class DataMapper implements RowMapper{

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product p = new Product();
			
			p.setPid(rs.getInt("pid"));
			p.setPprice(rs.getInt("pprice"));
			p.setPname(rs.getString("pname"));
			p.setReview(rs.getString("review"));
          			
			return p;	
		}   
	   }
	   
	   final String query = "select * from detail";
	  List<Product> data = jdbcTemplate.query(query , new DataMapper() );
	  
	  return data;
	   
	}
	
	
	//Get product by ID 
	
	public Product getProductById(int id) {
		
		class DataMapper implements RowMapper{

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Product p = new Product();
				
				p.setPid(rs.getInt("pid"));
				p.setPprice(rs.getInt("pprice"));
				p.setPname(rs.getString("pname"));
				p.setReview(rs.getString("review"));
				
				return p;
			}
		}
		    try {
		    	  final String query = "select * from detail where pid = ?";
			       Product data = (Product) jdbcTemplate.queryForObject(query,new DataMapper() ,new Object[] {id} );
			 
			       return data;
				
			} catch (Exception e) {
				
				return null;
			}
		     
	}
	
	
	
	// Get Product Name Like 
	
	    public List<Product> getProductByName(String name) {
	    	
	    	class DataMapper implements RowMapper{

				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					Product p = new Product();
					p.setPid(rs.getInt("pid"));
					p.setPprice(rs.getInt("pprice"));
					p.setPname(rs.getString("pname"));
					p.setReview(rs.getString("review"));
					
					return p;
				}
	    	}
	    	
	    	try {
	    		
	    		final	String query = "select * from detail where pname like ?";
		    	List<Product> p = jdbcTemplate.query(query, new DataMapper() , new Object[] {"%"+name+"%"} );
		    	
		    	return p;
				
			} catch (Exception e) {
				
				return null;
				
			}
	    }
	    
	    
	    
	    
	    
	    // delete the Product 
	    public String deleteProduct(int id) {
	    	
	    	try {
	    		String query = "delete from detail where pid = ?";
	    		int x =jdbcTemplate.update(query , new Object[] {id});
	    		
	    		if(x!=0) {
	    			return"sucess";
	    		}
	    		else {
					return"failed";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return"failed";
			}	
	  }
	    
	    
	    
	    
	    //update the Product 
	    
	    public String updateProduct(int id , Product p ) {
	    	
	    	try {
	    		String query = " update detail set pid=? , pprice=? , pname=? , review=? where pid=?";
		    	
		    	int x =  jdbcTemplate.update(query, new Object[] {p.getPid() , p.getPprice() , p.getPname() , p.getReview() ,id}  );
		    	
		    	if(x!=0) {
		    		 return "sucess";
		    	 }
		    	 else {
		    		 return"failed";
		    	 }
		    	
			} catch (Exception e) {
				e.printStackTrace();
				return"failed";
			}	
	    }
	    
	    
	    
	    //get Products Id 
	    
	    
	    public List<Integer> getProductsId() {
	    	
	     class DataMapper implements RowMapper {
        
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return rs.getInt("pid");
				
			} 
	     }
	     
	   final String query = "select * from detail";
	     
	     List<Integer> id = jdbcTemplate.query(query, new DataMapper() );
	     
	     return id;
	     
	     
	    }
	    
	    
	    
	    //getImage
	    
	    public byte[] getImage(int pid ) {
	    	
	    	class DataMapper implements RowMapper{

				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					return   rs.getBytes(pid);
				}	
	    	}
	    	
	    	try {
	    		
				 String query = "select image from detail where pid = ?";
				 
				 byte[] img = (byte[]) jdbcTemplate.queryForObject(query, new DataMapper(), new Object[] {pid} );
				 
				 return img;
				 
			} catch (Exception e) {
				return null;
			}	
	    }
	
	
	
	

	
	
	

	
	
	
	
	
	
}

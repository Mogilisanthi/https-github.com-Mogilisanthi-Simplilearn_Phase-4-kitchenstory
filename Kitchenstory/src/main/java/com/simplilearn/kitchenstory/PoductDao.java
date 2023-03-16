package com.simplilearn.kitchenstory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PoductDao {
	
	@Autowired
	ProductRepo repo;
	
	public Product insert(Product p) {
		return repo.save(p);
	}
		
		public List<Product> getall(){	//Method for select * from Shoes
			return repo.findAll();
		}
	
	public void deletebyId(Integer id) {
		repo.deleteById(id);
	}
	
	
	public Product getShoebyId(Integer id) {
		return repo.getReferenceById(id);
	}
	public Product editbyId(Product p)
	{
		Product existingProduct=repo.findById(p.getId()).orElse(null);
		existingProduct.setName(p.getName());
		existingProduct.setCategory(p.getCategory());
		existingProduct.setDescription(p.getDescription());
		existingProduct.setPrice(p.getPrice());
		
		repo.save(existingProduct);
		return existingProduct;
	}

}

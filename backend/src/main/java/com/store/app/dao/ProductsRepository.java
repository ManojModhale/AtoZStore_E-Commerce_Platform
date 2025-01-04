package com.store.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.store.app.bean.Products;
import com.store.app.bean.Vendor;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> 
{

	Optional<Products> findById(int productId);

	@Query("SELECT p.colors FROM Products p WHERE p.productid = :productId")
	List<String> findColorsByProductid(@Param("productId") int productId);

	@Query("SELECT p.sizes FROM Products p WHERE p.productid = :productId")
    List<String> findSizesByProductid(@Param("productId") int productId);
	
	List<Products> findByCategory(String Category);
	
	List<Products> findByProductname(String productname);
	
	@Query("from Products p where p.category=:category and p.price between :min and :max")
	List<Products> findByPriceRange(@Param(value = "min") double min,@Param(value = "max") double max, @Param(value = "category") String category);
    @Query("from Products p where p.offer!='null'")
	List<Products> getOfferedProducts();

    List<Products> findByProductnameContaining(String searchprod);

	List<Products> findByVendor(Vendor vendor);
	
	/*
    @Query("SELECT p FROM Products p LEFT JOIN FETCH p.imageFile WHERE p.productId = :productId")
    Optional<Products> findByIdWithImageFile(@Param("productId") int productId);
    */
	
	/*
    @Query("SELECT p FROM Product p WHERE p.id = :id")
    Optional<Products> findByIdWithImageFile(@Param("id") int id);
	*/
    
}

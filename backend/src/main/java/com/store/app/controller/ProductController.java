package com.store.app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.app.bean.Color;
import com.store.app.bean.Products;
import com.store.app.bean.Size;
import com.store.app.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin("http://localhost:4200")
public class ProductController 
{
	@Autowired
	private ProductService productService1;

	@PostMapping("/newproduct")
	public ResponseEntity<Products> addNewProducts(@RequestParam("productid") int productid,
			@RequestParam("category") String category, 
			@RequestParam("description") String description,
			@RequestParam("colors") String colorsJson, // Receive colors as JSON string
			@RequestParam("sizes") String sizesJson, // Receive sizes as JSON string
			@RequestParam("offer") String offer, 
			@RequestParam("price") double price,
			@RequestParam("productname") String productname, 
			@RequestParam("quantity") int quantity,
			@RequestParam("vendorid") String vendorid,
			@RequestParam("image") MultipartFile file) throws SQLException 
	{
		try {
			// Deserialize JSON arrays
			ObjectMapper mapper = new ObjectMapper();
			List<Color> colorList = mapper.readValue(colorsJson, new TypeReference<List<Color>>() {
			});
			List<String> colors = new ArrayList<>();
			for (Color col : colorList) {
				colors.add(col.getColor());
			}
			System.out.println("colours :" + colors);

			List<Size> sizeList = mapper.readValue(sizesJson, new TypeReference<List<Size>>() {
			});
			List<String> sizes = new ArrayList<>();
			for (Size si : sizeList) {
				sizes.add(si.getSize());
			}
			System.out.println("Size :" + sizes);

			Products products = new Products(productid, productname, category, price, description, offer, quantity);
			products.setColors(colors);
			products.setSizes(sizes);
			System.out.println();
			System.out.println(products);
			;

			return productService1.saveNewProduct(products, file,vendorid);
		} catch (IOException e) {
			// Handle JSON parsing errors
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			// Handle other unexpected errors
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getAll")
    public List<Products> getAllProducts() {
        return productService1.getAllProducts();
    }
	
	@GetMapping("/getProductById/{productId}")
    public ResponseEntity<Products> getProductById(@PathVariable int productId) 
    {
    	System.out.println("product Id :"+productId);
        Optional<Products> product = productService1.getProductById(productId);
        return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
	
	 @DeleteMapping("/deleteProductById/{productId}")
	 public ResponseEntity<Void> deleteProduct(@PathVariable int productId) 
	 {
	    	productService1.deleteProduct(productId);
	    	return ResponseEntity.noContent().build();
	 }
	 
	    @GetMapping("/{productId}/colors")
	    public List<String> getColorsByProductId(@PathVariable int productId) {
	        return productService1.getColorsByProductId(productId);
	    }

	    
	    @GetMapping("/{productId}/sizes")
	    public List<String> getProductSizes(@PathVariable int productId) {
	        return productService1.getProductSizes(productId);
	    }
	    
	    
	    @GetMapping("/getProductByCategory/{category}")
	    public List<Products> getProductsByCategory(@PathVariable("category") String category) {
	    	System.out.println("category : "+category);
	    	return productService1.getCategorizedProducts(category);
	    }
	    
	    
	    @GetMapping("/getbyName/{productname}")
		public List<Products> displayByName(@PathVariable("productname") String productname)
		{
	    	System.out.println(productname);
			return productService1.getProductByName(productname);
		}
		
		@PostMapping("/byPriceRange/{category}")
		public List<Products> displayByPriceRange(@PathVariable String  category,@RequestParam double min, @RequestParam double max)
		{
			System.out.println(min+" : "+max);
			return productService1.getByPriceRange(min, max,category);
		}
		
		//setImage
	    @PostMapping("/uploadImage/{productId}")
	    public ResponseEntity<Products> uploadImage(@PathVariable int productId, @RequestParam("image") MultipartFile file) throws IOException 
	    {
	    	System.out.println("adding image for product");
	        return productService1.uploadImage(productId, file);
	 
	    }
	    
	    // //getImage
	    // @GetMapping("/downloadImage/{productId}")
	    // public ResponseEntity<byte[]> getImage(@PathVariable int productId) throws IOException
	    // {
	    // 	byte[] imageData=productService1.downloadImage(productId);
	    // 	if (imageData != null && imageData.length > 0) 
	    // 	{
	    //         HttpHeaders headers = new HttpHeaders();
	    //         headers.setContentType(org.springframework.http.MediaType.IMAGE_JPEG); 

	    //         return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
	    //     } else {
	    //         return ResponseEntity.notFound().build();
	    //     }
	 
	    // }
	    
	    @GetMapping("/searchproducts/{searchprod}")
	    public List<Products> searchproducts(@PathVariable String searchprod){
	    	System.out.println(searchprod);
	    	return productService1.getSearchProducts(searchprod);
	    }
	    
	    
	    @PostMapping("/changepath/{productId}")
	    public void changeImagePath(@RequestParam String filePath,@PathVariable int productId)
	    {
	    	System.out.println("path"+filePath);
	    	System.out.println("id:"+productId);
	    	productService1.changeImagePath(filePath, productId);
	    }
	    @GetMapping("getOfferedProducts")
	    public List<Products> getOfferedProducts()
	    {
	    	return productService1.getOfferedProducts();
	       
	    }
		
}

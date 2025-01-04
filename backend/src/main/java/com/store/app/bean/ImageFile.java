package com.store.app.bean;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "image_files")
public class ImageFile 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	private long id;
	private String name;
	private String type;
	private String filePath;
	
	@OneToOne(mappedBy = "imageFile",fetch = FetchType.LAZY)
	private Products product;
	
	public ImageFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ImageFile(long id, String name, String type, String filePath) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.filePath = filePath;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	@Override
	public String toString() {
		return "ImageFile [id=" + id + ", name=" + name + ", type=" + type + ", filePath=" + filePath + "]";
	}
	

	// Manual Builder Pattern
    public static class ImageFileBuilder {
        private long id;
        private String name;
        private String type;
        private String filePath;

        public ImageFileBuilder() {
            // Default constructor
        }

        public ImageFileBuilder id(long id) {
            this.id = id;
            return this;
        }

        public ImageFileBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ImageFileBuilder type(String type) {
            this.type = type;
            return this;
        }

        public ImageFileBuilder filePath(String filePath) {
            this.filePath = filePath;
            return this;
        }

        public ImageFile build() {
            return new ImageFile(id, name, type, filePath);
        }
    }

    // Manual builder method
    public static ImageFileBuilder builder() {
        return new ImageFileBuilder();
    }
	
}

package com.store.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.app.bean.CartImageFile;

public interface CartImageFileRepository extends JpaRepository<CartImageFile, Long> 
{

}

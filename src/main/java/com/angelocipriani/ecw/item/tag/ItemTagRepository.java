package com.angelocipriani.ecw.item.tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemTagRepository 
	extends JpaRepository<ItemTag, String>{

}

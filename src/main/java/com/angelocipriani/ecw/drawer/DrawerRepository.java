package com.angelocipriani.ecw.drawer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrawerRepository 
	extends JpaRepository<Drawer, Long>{

}

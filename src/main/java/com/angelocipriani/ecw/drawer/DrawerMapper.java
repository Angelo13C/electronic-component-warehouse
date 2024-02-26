package com.angelocipriani.ecw.drawer;

import org.springframework.stereotype.Component;

@Component
public class DrawerMapper {
    public Drawer toDrawer(DrawerDTO drawerDTO) {
        Drawer drawer = new Drawer(drawerDTO.getX(), drawerDTO.getY());
        
        return drawer;
    }
}

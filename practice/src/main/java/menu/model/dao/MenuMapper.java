package menu.model.dao;

import menu.model.dto.MenuDTO;

import java.util.List;

public interface MenuMapper {
    int deleteMenu(String menuName);

    int insertMenu(MenuDTO menu);

    MenuDTO selectOneMenuByname(String menuName);

    int updateMenu(MenuDTO menuDTO);


    List<MenuDTO> selectAllMenu();
}

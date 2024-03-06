package menu.model.service;

import menu.model.dao.MenuMapper;
import menu.model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static practice.Template.getSqlSession;

public class MenuService {

    private MenuMapper menuMapper;
    public int deleteMenu(String menuName) {
        SqlSession session = getSqlSession();
        menuMapper = session.getMapper(MenuMapper.class);

        int result = menuMapper.deleteMenu(menuName);

        if(result > 0) {
            session.commit();
        } else {
            session.rollback();
        }

        session.close();

        return result;
    }

    public int insertMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.insertMenu(menu);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }

    public MenuDTO selectOneMenuByname(String menuName) {
        SqlSession sqlSession = getSqlSession();
        System.out.println("sqlSession : " + sqlSession);

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        MenuDTO selectedMenu = menuMapper.selectOneMenuByname(menuName);

        sqlSession.close();

        return selectedMenu;
    }

    public int updateMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.updateMenu(menuDTO);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }

    public List<MenuDTO> selectAllMenu() {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> empList = menuMapper.selectAllMenu();
        sqlSession.close();
        return empList;
    }
}

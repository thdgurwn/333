package menu.controller;

import menu.model.dto.MenuDTO;
import menu.model.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/menu/insert")
public class InsertMenuServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String menuCode = req.getParameter("menuCode");
        String menuName = req.getParameter("menuName");
        String menuPrice = req.getParameter("menuPrice");


        MenuDTO menu = new MenuDTO();
        menu.setMenuCode(Integer.parseInt(menuCode));
        menu.setMenuName(menuName);
        menu.setMenuPrice(Integer.parseInt(menuPrice));

        System.out.println("insert req menu : " + menu);

        MenuService menuService = new MenuService();
        int result = menuService.insertMenu(menu);

        if (result > 0){
            resp.sendRedirect(req.getContextPath() + "/menu/list");
        } else {
            req.setAttribute("message", "신규 메뉴 등록에 실패했습니다.");
            req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req,resp);
        }

    }
}

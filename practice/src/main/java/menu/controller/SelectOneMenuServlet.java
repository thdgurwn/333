package menu.controller;

import menu.model.dto.MenuDTO;
import menu.model.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/menu/select")
public class SelectOneMenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String menuName = req.getParameter("menuName");
        System.out.println("menuName : " + menuName);

        MenuService menuService = new MenuService();
        MenuDTO selectedMenu = menuService.selectOneMenuByname(menuName);
        System.out.println("selectedMenu : " + selectedMenu);

        String path = "";
        if (selectedMenu != null) {
            path = "/WEB-INF/views/menu/showEmpInfo.jsp";
            req.setAttribute("selectedMenu", selectedMenu);
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "해당 이름을 가진 메뉴가 없습니다.");
        }
        req.getRequestDispatcher(path).forward(req,resp);
    }
}
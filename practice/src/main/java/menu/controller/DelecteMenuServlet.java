package menu.controller;

import menu.model.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/menudb/delete")
public class DelecteMenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String menuName = req.getParameter("menuName");

        MenuService menuService = new MenuService();
        int result = menuService.deleteMenu(menuName);

        if (result>0){
            resp.sendRedirect(req.getContextPath()+"/menu/list");
        }else {
            req.setAttribute("message", "메뉴 정보 삭제에 실패하였습니다");
            req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req,resp);
        }
    }
}

package menu.controller;

import menu.model.dto.MenuDTO;
import menu.model.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/menu/update")
public class UpdateMenuServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String menuCode = req.getParameter("menuCode");
        String menuName = req.getParameter("menuName");
        String menuPrice = req.getParameter("menuPrice");

        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setMenuCode(Integer.parseInt(menuCode));
        menuDTO.setMenuName(menuName);
        menuDTO.setMenuPrice(Integer.parseInt(menuPrice));

        MenuService menuService = new MenuService();
        int result = menuService.updateMenu(menuDTO);

        if (result > 0) {
            resp.sendRedirect(req.getContextPath() + "/menu/select?empId="+ menuName);
        }else {
            req.setAttribute("message", "메뉴 정보 수정에 실패하였습니다.");
            req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req,resp);
        }
    }
}

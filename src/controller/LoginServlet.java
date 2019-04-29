package controller;

import entity.User;
import service.IUserService;
import service.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
        super();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("password");
        List<String> info = new ArrayList<>();
        if (name==null || "".equals(name)) {
            info.add("用户名不能为空");
            System.out.println("用户名不能为空");
        }

        if(pwd==null||"".equals(pwd)){//密码输入格式问题
            info.add("密码不能为空");
            System.out.println("密码不能为空");
        }
        if(info.size()==0){
            User user=new User();
            user.setName(name);
            user.setPassword(pwd);
            IUserService userService = new UserServiceImpl();
            boolean isSuccess = userService.loginSauth(user);
            if (isSuccess) info.add("用户登录成功，欢迎"+user.getName()+"光临！");
            else info.add("用户登录失败，错误的用户名和密码");
        }

        req.setAttribute("info", info);//保存错误信息
        req.getRequestDispatcher("login.jsp").forward(req,resp);//跳转
    }


}

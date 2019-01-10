package com.lr.fiction.servlet;

import com.lr.fiction.model.UserInfo;
import com.lr.fiction.service.UserServiceI;
import com.lr.fiction.service.UserServiceImp;
import com.lr.fiction.util.DataUtil;
import com.lr.fiction.util.JSONUtils;
import com.lr.fiction.util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Servlet
 * Created by ALTERUI on 2019/1/8 20:53
 */
public class UserServlet extends HttpServlet {
    private UserServiceImp userServiceImp = new UserServiceImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");

            String path = req.getServletPath();
            switch (path) {
                case "/login":
                    login(req,resp);
                    break;
                case "/register":
                    register(req, resp);
                    break;
                case "/logout":
                    logout(req,resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        doPost(req, resp);
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        UserInfo userInfo = new UserInfo();

        String uaccount = req.getParameter("uaccout");
        String upwd = req.getParameter("upwd");


        userInfo.setUaccount(uaccount);
        userInfo.setUpwd(upwd);


        List<UserInfo> loginUser = userServiceImp.selectByUser(userInfo);
        if (loginUser.size() != 0) {
            System.out.println("登录成功");
            PrintWriter pw = resp.getWriter();
            DataUtil data = new DataUtil();
            data.setResult(true);
            data.setMsg("登录成功");
            for (UserInfo user : loginUser) {
               // req.setAttribute("loginUser",user);
                System.out.println(user.getNickname());
                HttpSession session = req.getSession();
                session.setAttribute("flag", 1);
                session.setAttribute("loginUser",user);
            }


            JSONUtils.writeJSON(pw, data);


        }


    }

    /**
     * 注册
     * @param req
     * @param resp
     * @throws Exception
     */
    public void register(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        UserInfo userInfo = new UserInfo();

        String uaccount = req.getParameter("uaccout");
        String upwd = req.getParameter("password");
        Timestamp timestamp = new Timestamp(new Date().getTime());
        String nickname = req.getParameter("nickname");
        String member = req.getParameter("member");

        userInfo.setUaccount(uaccount);
        userInfo.setUpwd(upwd);
        userInfo.setNickname(nickname);
        userInfo.setCreatetime(timestamp);
        userInfo.setLasttime(timestamp);

        boolean result = userServiceImp.insert(userInfo);

        DataUtil data = new DataUtil();
        data.setResult(result);

        PrintWriter pw = resp.getWriter();
        JSONUtils.writeJSON(pw, data);


    }

    /**
     * 退出登录
     * @param req
     * @param resp
     * @throws Exception
     */
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        HttpSession session = req.getSession();
        session.setAttribute("flag", 0);
        session.removeAttribute("loginUser");
        resp.sendRedirect("/index.jsp");

    }



}

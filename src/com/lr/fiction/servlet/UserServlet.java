package com.lr.fiction.servlet;

import com.lr.fiction.model.UserInfo;
import com.lr.fiction.service.UserServiceImp;
import com.lr.fiction.util.DataUtil;
import com.lr.fiction.util.JSONUtils;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * User Servlet
 * Created by ALTERUI on 2019/1/8 20:53
 */
public class UserServlet extends HttpServlet {
    private UserServiceImp userServiceImp = new UserServiceImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");

            //根据path，调用方法
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

    /**
     * 登录
     * @param req
     * @param resp
     * @throws Exception
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws Exception{

        //接收前端传来的用户名和密码
        String uaccount = req.getParameter("uaccout");
        String upwd = req.getParameter("upwd");

        //存入userInfo对象中
        UserInfo userInfo = new UserInfo();
        userInfo.setUaccount(uaccount);
        userInfo.setUpwd(upwd);

        //查询数据库是否有这个用户
        List<UserInfo> loginUser = userServiceImp.selectByUser(userInfo);

        PrintWriter pw = resp.getWriter();
        DataUtil data = new DataUtil();
        if (loginUser.size() != 0) {//表明有这个用户

            data.setResult(true);
            data.setMsg("登录成功");
            //用户登录后，将用户名显示在页面上
            for (UserInfo user : loginUser) {
                HttpSession session = req.getSession();
                //表明用户已经登录
                session.setAttribute("flag", 1);
                //登录用户的信息
                session.setAttribute("loginUser", user);
            }

        } else {//没有这个用户
            data.setResult(false);
            data.setMsg("用户名或密码输入错误！请重新输入");
        }

        //把json格式的信息返回到前端
        JSONUtils.writeJSON(pw, data);



    }

    /**
     * 注册
     * @param req
     * @param resp
     * @throws Exception
     */
    public void register(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        //用户存放前端注册页面传来的值
        UserInfo userInfo = new UserInfo();

        //接收值
        String uaccount = req.getParameter("uaccout");
        String upwd = req.getParameter("password");
        Timestamp timestamp = new Timestamp(new Date().getTime());
        String nickname = req.getParameter("nickname");
        String member = req.getParameter("member");
        //返回到前端的数据
        DataUtil data = new DataUtil();

        //存放
        userInfo.setUaccount(uaccount);
        userInfo.setUpwd(upwd);
        userInfo.setNickname(nickname);
        userInfo.setCreatetime(timestamp);
        userInfo.setLasttime(timestamp);
        //判断数据库是否有
        if (userServiceImp.selectByAccout(uaccount) == null) {
            boolean result = userServiceImp.insert(userInfo);
            data.setResult(result);
        } else {
            data.setResult(false);
            data.setMsg("用户名已存在");
        }

        //传入到前端
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
        //表明用户没有登录
        session.setAttribute("flag", 0);
        //移除用户
        session.removeAttribute("loginUser");
        //跳转到首页
        resp.sendRedirect("/index.jsp");

    }



}

package fiction.servlet;

import fiction.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by ALTERUI on 2019/1/8 20:53
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String uaccount = req.getParameter("uaccount");
        String upwd = req.getParameter("upwd");
        String nickname = req.getParameter("nickname");
        Timestamp timestamp = new Timestamp(new Date().getTime());
        String sql = "INSERT INTO user_info(uaccout,upwd,createtime,nickname,lasttime,member) " +
                "VALUES('"+uaccount+"','"+upwd+"'," +
                "'"+timestamp+"','"+nickname+"'," +
                " '"+timestamp+"','"+1+"')";
        JDBCUtil.getConn();
        try {
            JDBCUtil.insert(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}

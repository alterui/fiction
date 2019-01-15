package com.lr.fiction.servlet;
/**
 * Book Servlet
 * Created by ALTERUI on 2019/1/14 14:26
 */
import com.lr.fiction.model.Chapter;
import com.lr.fiction.pojo.BookInfoP;
import com.lr.fiction.service.BookServiceImp;
import com.lr.fiction.util.OutWriterUtil;
import com.lr.fiction.util.ReaderTextUtil;
import com.lr.fiction.util.Voice;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookServlet extends HttpServlet {

	private BookServiceImp bookServiceI = new BookServiceImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String path = request.getServletPath();
		/*System.out.println(path);*/
		switch (path) {
			case "/showBook":
				selectAllBook(request,response);
				break;
			case "/bookDetail":
				bookDetail(request,response);
				break;
			case "/chapter":
				chapterDetail(request, response);
				break;
			case "/speak":
				 speak(request, response);
				 break;
		}

	}

	/**
	 * 小说详情
	 * @param request
	 * @param response
	 */
	private void bookDetail(HttpServletRequest request, HttpServletResponse response) {
		//通过URL参数获取bno
		String bno = request.getParameter("bno");
		BookInfoP bookInfo = bookServiceI.selectBookDetailByBno(bno);
		//将book传入前端
		request.setAttribute("book", bookInfo);
		try {
			request.getRequestDispatcher("/jsp/book/bookDetail.jsp").forward(request,response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 小说内容
	 * @param request
	 * @param response
	 */
	private void chapterDetail(HttpServletRequest request, HttpServletResponse response) {
        //bno=1&chno=1
        String bno = request.getParameter("bno");
        String chno = request.getParameter("chno");
        Chapter chapter = bookServiceI.selectChapterByVnoChno(bno, chno);
        BookInfoP book = bookServiceI.selectBookDetailByBno(bno);
        //小说在磁盘的位置
        String churl = chapter.getChurl();

        String lineTxt =null;

        //用集合的方式，便于前端小说的显示
        List<String> chapterList = new ArrayList<>();
        //得到读取小说的内容
        ReaderTextUtil.getReaderTxt(churl, chapterList);


		request.setAttribute("chapterList",chapterList);
        request.setAttribute("book", book);
        request.setAttribute("chapter", chapter);
        try {
            request.getRequestDispatcher("/jsp/book/showChapter.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

	/**
	 * 小说语音
	 * @param request
	 * @param response
	 */
	private void speak(HttpServletRequest request, HttpServletResponse response) {
		String url = request.getParameter("url");
		List<String> chapterList = new ArrayList<>();
        ReaderTextUtil.getReaderTxt(url, chapterList);
        StringBuffer sb = new StringBuffer();
        for (String txt : chapterList) {
            sb.append(txt);
        }
        //把文字转化为语音，并返回路径
        String output = Voice.getVoice(sb.toString());
        //输出文件流
        OutWriterUtil.getOutWriter(request, response, output);

    }

    /**
     * 查询所有的书
     * @param request
     * @param response
     */
    private void selectAllBook(HttpServletRequest request, HttpServletResponse response) {

		String sql = "select * from book_info ";
		List<BookInfoP> bookInfoList = bookServiceI.selectAllBook(sql);
		//将小说集合传入前端
		request.setAttribute("bookList", bookInfoList);
		try {
			request.getRequestDispatcher("/jsp/book/showSearch.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

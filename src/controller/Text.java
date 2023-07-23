package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TextDAO;
import model.TextBeen;
import model.flagBeen;

@WebServlet("/Text")
public class Text extends HttpServlet {
  private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	    // メイン画面にフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher
	            ("/WEB-INF/view/main.jsp");
	    dispatcher.forward(request, response);

	}

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    // リクエストパラメータの取得
    request.setCharacterEncoding("UTF-8");
    String text = request.getParameter("text");

    // textインスタンスの生成
    TextBeen text1 = new TextBeen(text);

    // text登録処理
    TextDAO sql = new TextDAO();
    boolean kekka = sql.insertText(text1);

    // 登録成功時の処理
    if (kekka) {
    	ArrayList<TextBeen> list = sql.selectAll();
      // textlistをリクエストスコープに保存
      request.setAttribute("list", list);
	  flagBeen flag = new flagBeen(1);
	  request.setAttribute("flag", flag);
      RequestDispatcher dispatcher = request.getRequestDispatcher
              ("/WEB-INF/view/main.jsp");
      dispatcher.forward(request, response);
    }else {
	    // 登録が失敗したら元の画面に戻す(リダイレクトする)
    	response.sendRedirect("http://localhost:8080/todo/index.jsp");
    }
  }

}
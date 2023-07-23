package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginLogic;
import model.flagBeen;
import model.user;

@WebServlet("/Login")
public class Login extends HttpServlet {
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
    String master_id = request.getParameter("master_id");
    String pass = request.getParameter("pass");

    // Userインスタンス（ユーザー情報）の生成
    user user = new user(master_id, pass);

    // ログイン処理
    LoginLogic loginLogic = new LoginLogic();
    user userDb = loginLogic.userDb(user);
    boolean isLogin = loginLogic.execute(userDb,user);

    // ログイン成功時の処理
    if (isLogin) {

      flagBeen flag = new flagBeen(0);
	  request.setAttribute("flag", flag);

      // ログインが成功したらmain.jspにフォワード
      RequestDispatcher dispatcher = request.getRequestDispatcher
              ("/WEB-INF/view/main.jsp");
      dispatcher.forward(request, response);
    }else {
	    // ログインが失敗したら元の画面に戻す(リダイレクトする)
    	response.sendRedirect("http://localhost:8080/todo/index.html");
    }
  }
}
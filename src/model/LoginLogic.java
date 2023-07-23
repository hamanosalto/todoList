package model;

import dao.LoginDAO;

public class LoginLogic {

	// 空のインスタンス生成
	user loginUser = new user();

	// データベースからとってきた情報をdbPassに入れてリターンし空で用意していたインスタンスを更新
	public user userDb(user user) {

		LoginDAO dao = new LoginDAO();
		user loginUser = new user();
		loginUser = dao.findAll(user);

		return loginUser;
	}

	public boolean execute(user userDb, user user) {

		if(userDb == null) {
			return false;
		}else if (userDb.getPass().equals(user.getPass())) {
			return true;
	    }else {
	    	return false;
	    }
	}
}
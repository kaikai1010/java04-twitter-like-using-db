package model;

import dao.TwitterDAO;

public class TwitterPostLogic {
	public void execute(Twitter t) {

		TwitterDAO dao = new TwitterDAO();
		dao.create(t);
	}
}

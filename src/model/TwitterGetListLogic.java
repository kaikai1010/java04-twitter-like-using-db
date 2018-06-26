package model;

import java.util.List;

import dao.TwitterDAO;

public class TwitterGetListLogic {
	public List<Twitter> execute() {

		TwitterDAO dao = new TwitterDAO();
		List<Twitter> tList = dao.findAll();
		return tList;
	}
}

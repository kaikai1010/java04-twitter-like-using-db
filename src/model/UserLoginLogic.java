package model;

public class UserLoginLogic {
	public boolean execute(User u) {

		String name = u.getName();
		String pass = u.getPass();

		if(name != null && name.length() != 0) {
			if(pass.equals("1234")) {
				return true;
			}
		}

		return false;

	}
}

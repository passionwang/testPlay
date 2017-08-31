package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import util.User;

import views.html.index;
import java.util.List;
import java.util.ArrayList;

public class Application extends Controller {

    public static Result index() {
		List<String> lines = new ArrayList<String>();
		lines.add("one");
		lines.add("two");
		lines.add("three");
        return ok(views.html.index.render("Plat","Hello world Pass!",lines));
    }
	public static Result form(){
		return ok(views.html.form.render());
	}
	
	//public static Result postForm(){
	//	DynamicForm in = Form.form().bindFromRequest();
	//	String result = in.get("content");
	//	return ok(result);
	//}
	
	public static Result postForm(){
		Form<User> userForm = Form.form(User.class);
		User user = userForm.bindFromRequest().get();
		return ok(user.email + " " + user.password);
	}
	
    public static Result somePost(){
    	return ok("you had post something!");
    }
    public static Result record(Long re){
    	return ok("your record is : " + re);
    }
    public static Result newRecord(String name){
    	return ok("the newRecord is:" + name);
    }

}

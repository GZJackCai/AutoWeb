package com.care.wink;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.care.config.Constant;
import com.care.mybatis.bean.User;
import com.care.service.RoleService;
import com.care.service.RoleServiceImpl;
import com.care.service.UserOpenIDService;
import com.care.service.UserOpenIdServiceImpl;
import com.care.service.UserService;
import com.care.service.UserServiceImpl;

@Path("/user")
public class UserAction extends BaseAction {

	private Logger log = LoggerFactory.getLogger(UserAction.class);
	private UserService userService = getCtx().getBean(UserServiceImpl.class);
	private UserOpenIDService openIDService = getCtx().getBean(UserOpenIdServiceImpl.class);
	private RoleService roleService = getCtx().getBean(RoleServiceImpl.class);


	@POST
	@Path("logout")
	public String logout(@FormParam("email") String email, @FormParam("password") String password) {
		RetValue rv = getRetValue("logout");
		try {
			log.info("{}:email:{} password:{}", rv.getAction(), email, password);
			deleteFromSession(Constant.SESSION_openID);
			deleteFromSession(Constant.SESSION_USER);
			rv.setCode(1);
			rv.setMsg("success");
		} catch (Exception e) {
			rv.setCode(-1);
			rv.setMsg(e.getMessage());
		}
		return getRetValueJson(rv);
	}
	
	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public String login(@FormParam("email") String email, @FormParam("password") String password) {
		RetValue rv = getRetValue("login");
		try {
			log.info("{}:email:{} password:{}", rv.getAction(), email, password);
			User u = userService.login(email, password);
			if(u != null){
				rv.setCode(1);
				rv.setMsg(u.getNick());
			}else{
				rv.setCode(-1);
				rv.setMsg("fail");
			}
		} catch (Exception e) {
			rv.setCode(-1);
			rv.setMsg(e.getMessage());
		}
		return getRetValueJson(rv);
	}

	@GET
	@Path("toUserProfile")
	public void toUserProfile() {
		try {
			// 获取角色
			saveToRequest("roles", roleService.getAllRoles());
			forward("/WEB-INF/user/user_profile.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("toUserProfile", e);
		}
	}

	@POST
	@Path("saveUserProfile")
	public String saveUserProfile(@FormParam("userId") int id, @FormParam("email") String email, @FormParam("name") String name,
			@FormParam("phone") String phone, @FormParam("password") String password, @FormParam("roleId") int roleId) {
		RetValue rv = getRetValue("saveUserProfile");
		log.info("saveUserProfile:{} {}", email, name);
		try {
			User user = new User();
			user.setName(name);
			user.setPhone(phone);
			user.setRoleId(roleId);
			user.setEmail(email);
			user.setId(id);
			user.setPassword(password);
			int i = id == 0 ? userService.saveUser(user) : userService.updateUser(user);
			if (i == 1) {
				rv.setCode(1);
				rv.setMsg("success");
			} else {
				rv.setCode(0);
				rv.setMsg("failed");
			}
		} catch (Exception e) {
			rv.setCode(-1);
			rv.setMsg(e.getMessage());
			log.error(rv.getAction(), e);
		}
		return getRetValueJson(rv);

	}

}

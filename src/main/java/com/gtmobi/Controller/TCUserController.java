package com.gtmobi.Controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gtmobi.Model.Ds_token;
import com.gtmobi.Model.Ds_admin;
import com.gtmobi.Model.tc_users;
import com.gtmobi.Service.TCUserService;
import com.gtmobi.Service.TimeService;

@RestController
@CrossOrigin
@RequestMapping("/tcUser")
public class TCUserController {

	@Autowired
	TCUserService tcUserService;

	@CrossOrigin
	@PostMapping("/logInAdmin")
	private Map<String, Object> logInAdmin(@RequestBody String st) {
		Map<String, Object> map = new HashMap<String, Object>();

		String user_name = null;
		String password = null;
		Ds_admin tc_admin = null;

		try {
			JSONObject js = new JSONObject(st);
			if (js.has("userName") && !js.getString("userName").equals(null) && js.getString("userName") != null
					&& js.getString("userName") != "" && !js.getString("userName").equals("")) {
				user_name = js.getString("userName");
			} else {
				map.put("message", "please provide userName...!!");
				map.put("error", "Username not found...!!");
				map.put("status", "error");
				return map;
			}
			if (js.has("password") && !js.getString("password").equals(null) && js.getString("password") != null
					&& js.getString("password") != "" && !js.getString("password").equals("")) {
				String pw = js.getString("password");
				password = this.passwordEncoder(pw);
			} else {
				map.put("message", "Please provide password...!!");
				map.put("error", "Password not found...!!");
				map.put("status", "error...!!");
				return map;
			}

			tc_admin = tcUserService.getBybusinessIdAndUserName(user_name, password);
			if (tc_admin != null) {

				UUID token = UUID.randomUUID();
				Ds_token tc_token = new Ds_token();

				tc_token.setAdmin_id(tc_admin.getAdmin_id());
				tc_token.setIs_active(true);
				tc_token.setIs_deleted(false);
				tc_token.setLogin_time(TimeService.getUTCTime2());
				tc_token.setToken(token.toString());
				tcUserService.saveTCToken(tc_token);

				map.put("token", token.toString());
				map.put("message", "You have sign in into application successfully!");
				map.put("status", "success");
				return map;
			} else {
				map.put("message", "Invalid Username or Password");
				map.put("status", "success");
				return map;
			}

		} catch (Exception e) {
			map.put("message", "Unable to login");
			map.put("error", "Something went wrong...!!");
			map.put("status", "error");
			return map;
		}
	}

	@GetMapping("/getuserforDropdown")
	private Map<String, Object> getuserforDropdown() {
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> map1 = null;
		List<tc_users> tclist = new ArrayList<tc_users>();

		ArrayList<Map<String, Object>> user_list = new ArrayList<Map<String, Object>>();

		try {
			tclist = tcUserService.getAdminUser();
			if (!tclist.isEmpty() && tclist.size() != 0) {
				for (tc_users t : tclist) {
					map1 = new HashMap<String, Object>();
					map1.put("id", t.getId());
					map1.put("name", t.getName());
					user_list.add(map1);
				}
			}

			map.put("tc_user", user_list);
			map.put("status", "success");
			return map;
		} catch (Exception e) {
			map.put("message", "Unable to fetch tc_user list...!!");
			map.put("error", "something went wrong...!!");
			map.put("status", "error");
			return map;
		}
	}

	String passwordEncoder(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] messageDigest = md.digest(password.getBytes());
		BigInteger bigInt = new BigInteger(1, messageDigest);
		return bigInt.toString(16);
	}

}

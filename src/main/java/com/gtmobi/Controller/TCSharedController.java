package com.gtmobi.Controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gtmobi.Model.Ds_share_data;
import com.gtmobi.Model.tc_users;
import com.gtmobi.Service.TCSharedService;
import com.gtmobi.Service.TCUserService;
import com.gtmobi.Service.TimeService;

@RestController
@CrossOrigin
public class TCSharedController {

	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	@Autowired
	TCSharedService sharedService;

	@Autowired
	TCUserService tcUserService;

	@PostMapping("/addSharedInformation")
	private Map<String, Object> addSharedInformation(@RequestBody String st, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();

		int tcUserId;
		Ds_share_data tc_share_data = new Ds_share_data();
		tc_users tc_users = null;

		JSONObject jsonData = new JSONObject(st);

		try {
			Timestamp from_time = null;
			Timestamp to_time = null;

			if (jsonData.has("user_id") && jsonData.getInt("user_id") != 0 && !jsonData.get("user_id").equals("")
					&& jsonData.get("user_id") != null && jsonData.get("user_id") != ""
					&& !jsonData.get("user_id").equals(null)) {

				tcUserId = jsonData.getInt("user_id");

				tc_users = tcUserService.findUserbyId(tcUserId);

				if (tc_users == null) {
					map.put("message", "User not found...");
					map.put("error", "not_found");
					map.put("status", "error");
					return map;
				} else if (tc_users.isDisabled().booleanValue() == true) {
					map.put("message", "Currently this User is Inactive...");
					map.put("error", "not_found");
					map.put("status", "error");
					return map;
				} else if (tc_users.isAdministrator().booleanValue() == false) {
					map.put("message", "This is not admin user..");
					map.put("error", "not_found");
					map.put("status", "error");
					return map;
				}

			} else {
				map.put("message", "Please provide user_id...!!");
				map.put("error", "required_filed");
				map.put("status", "error");
				return map;
			}

			if (jsonData.has("from_date") && !jsonData.get("from_date").equals("")
					&& jsonData.get("from_date") != null) {
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat(TimeService.YYYY_MM_DD_HH_MM_SS);
					Date parsedDate = dateFormat.parse(jsonData.getString("from_date").trim());
//					from_time = TimeService.getUTCTime(new Timestamp(parsedDate.getTime()));
					from_time = new Timestamp(parsedDate.getTime());

				} catch (Exception e) {
					e.printStackTrace();
					map.put("status", "error");
					map.put("error", "require_field");
					map.put("message", "Please, enter valid calendar 'from_date' format (YY_MM_DD_HH_MM_SS).");
					return map;
				}
			} else {
				map.put("status", "error");
				map.put("error", "require_field");
				map.put("message", "Please, provide 'from_date'");
				return map;
			}

			if (jsonData.has("to_date") && !jsonData.get("to_date").equals("") && jsonData.get("to_date") != null) {
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat(TimeService.YYYY_MM_DD_HH_MM_SS);
					Date parsedDate = dateFormat.parse(jsonData.getString("to_date").trim());
//					to_time = TimeService.getUTCTime(new Timestamp(parsedDate.getTime()));
					to_time = new Timestamp(parsedDate.getTime());

				} catch (Exception e) {
					e.printStackTrace();
					map.put("status", "error");
					map.put("error", "require_field");
					map.put("message", "Please, enter valid calendar 'to_date' format (YY_MM_DD_HH_MM_SS).");
					return map;
				}
			} else {
				map.put("status", "error");
				map.put("error", "required_field");
				map.put("message", "Please, provide 'to_date'");
				return map;
			}

			Ds_share_data share_data1 = sharedService.getByUserId(tcUserId);

			if (share_data1 != null) {
				map.put("status", "error");
				map.put("error", "already_exist!");
				map.put("message", "Already sharedata link generated!!");
				return map;
			}

			UUID uuid = UUID.randomUUID();
			tc_share_data.setCreated_time(TimeService.getUTCTime2());
			tc_share_data.setUser_id(tcUserId);
			tc_share_data.setFrom_time(from_time);
			tc_share_data.setTo_time(to_time);
			tc_share_data.setIs_active(true);
			tc_share_data.setIs_deleted(false);
			tc_share_data.setIp_address(request.getRemoteAddr());
			tc_share_data.setSalt(uuid.toString());
			sharedService.saveTCShareData(tc_share_data);

			map.put("status", "success");
			map.put("message", "Information saved successfully.");
			return map;

		} catch (Exception e) {
			map.put("message", "Unable to add share_information!!");
			map.put("error", "Something went wrong...!!");
			map.put("status", "error");
			return map;
		}
	}

	@PostMapping("/updateSharedInformation")
	private Map<String, Object> updateSharedInformation(@RequestBody String st, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();

		int tcUserId;

		JSONObject jsonData = new JSONObject(st);
		Integer share_data_id = 0;
		Ds_share_data tc_share_data = null;

		try {
			Timestamp from_time = null;
			Timestamp to_time = null;

			if (jsonData.has("share_data_id") && jsonData.getInt("share_data_id") != 0
					&& !jsonData.get("share_data_id").equals("") && jsonData.get("share_data_id") != null
					&& jsonData.get("share_data_id") != "" && !jsonData.get("share_data_id").equals(null)) {
				share_data_id = jsonData.getInt("share_data_id");
				tc_share_data = sharedService.getById(share_data_id);
				if (tc_share_data == null) {
					map.put("status", "error");
					map.put("error", "not_found");
					map.put("message", "Sharedata link not found!!");
					return map;
				}

			} else {
				map.put("message", "Please provide share_data_id...!!");
				map.put("error", "require_field");
				map.put("status", "error");
				return map;
			}

			if (jsonData.has("user_id") && jsonData.getInt("user_id") != 0 && !jsonData.get("user_id").equals("")
					&& jsonData.get("user_id") != null && jsonData.get("user_id") != ""
					&& !jsonData.get("user_id").equals(null)) {
				tcUserId = jsonData.getInt("user_id");

			} else {
				map.put("message", "Please provide user_id...!!");
				map.put("error", "require_field");
				map.put("status", "error");
				return map;
			}

			if (jsonData.has("from_date") && !jsonData.get("from_date").equals("")
					&& jsonData.get("from_date") != null) {
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat(TimeService.YYYY_MM_DD_HH_MM_SS);
					Date parsedDate = dateFormat.parse(jsonData.getString("from_date").trim());
//					from_time = TimeService.getUTCTime(new Timestamp(parsedDate.getTime()));
					from_time = new Timestamp(parsedDate.getTime());

				} catch (Exception e) {
					e.printStackTrace();
					map.put("status", "error");
					map.put("error", "require_field");
					map.put("message", "Please, enter valid calendar 'from_date' format (YY_MM_DD_HH_MM_SS).");
					return map;
				}
			} else {
				map.put("status", "error");
				map.put("error", "require_field");
				map.put("message", "Please, provide 'from_date'");
				return map;
			}

			if (jsonData.has("to_date") && !jsonData.get("to_date").equals("") && jsonData.get("to_date") != null) {
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat(TimeService.YYYY_MM_DD_HH_MM_SS);
					Date parsedDate = dateFormat.parse(jsonData.getString("to_date").trim());
//					to_time = TimeService.getUTCTime(new Timestamp(parsedDate.getTime()));
					to_time = new Timestamp(parsedDate.getTime());

				} catch (Exception e) {
					e.printStackTrace();
					map.put("status", "error");
					map.put("error", "require_field");
					map.put("message", "Please, enter valid calendar 'to_date' format (YY_MM_DD_HH_MM_SS).");
					return map;
				}
			} else {
				map.put("status", "error");
				map.put("error", "require_field");
				map.put("message", "Please, provide 'to_date'");
				return map;
			}

			tc_share_data.setUpdated_time(TimeService.getUTCTime(to_time));
//			tc_share_data.setUser_id(tcUserId);
			tc_share_data.setUpdate_info("sharedata time info changed");
			tc_share_data.setFrom_time(from_time);
			tc_share_data.setTo_time(to_time);
			tc_share_data.setIs_active(true);
			tc_share_data.setIs_deleted(false);
			sharedService.updateTCShareData(tc_share_data);

			map.put("status", "success");
			map.put("message", "Information updated successfully.");
			return map;

		} catch (Exception e) {
			map.put("message", "Unable to add share_information!!");
			map.put("error", "Something went wrong...!!");
			map.put("status", "error");
			return map;
		}
	}

	@PostMapping("/activeInActiveUpdate")
	private Map<String, Object> activeInActiveUpdate(@RequestBody String st, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean active_status = true;
		JSONObject jsonData = new JSONObject(st);
		Integer share_data_id = 0;
		Ds_share_data tc_share_data = null;
		try {
			Timestamp to_time = null;

			if (jsonData.has("share_data_id") && jsonData.getInt("share_data_id") != 0
					&& !jsonData.get("share_data_id").equals("") && jsonData.get("share_data_id") != null
					&& jsonData.get("share_data_id") != "" && !jsonData.get("share_data_id").equals(null)) {
				share_data_id = jsonData.getInt("share_data_id");
				tc_share_data = sharedService.getByIdAll(share_data_id);
				if (tc_share_data == null) {
					map.put("status", "error");
					map.put("error", "not_found");
					map.put("message", "Sharedata not found!!");
					return map;
				}

			} else {
				map.put("message", "Please provide share_data_id...!!");
				map.put("error", "require_field");
				map.put("status", "error");
				return map;
			}

			if (jsonData.has("status") && !jsonData.get("status").equals("") && jsonData.get("status") != null) {
				active_status = jsonData.getBoolean("status");
				tc_share_data.setIs_active(active_status);
				tc_share_data.setUpdate_info("sharedata status changed");
			} else {
				map.put("status", "error");
				map.put("error", "require_field");
				map.put("message", "Please, provide 'status'");
				return map;
			}

			tc_share_data.setUpdated_time(TimeService.getUTCTime(to_time));
			sharedService.updateTCShareData(tc_share_data);

			map.put("status", "success");
			map.put("message", "Information updated successfully.");
			return map;

		} catch (Exception e) {
			map.put("message", "Unable to add share_information!!");
			map.put("error", "Something went wrong...!!");
			map.put("status", "error");
			return map;
		}
	}

	@Value("${data.dataUrl}")
	private String dataURL;

	@GetMapping("/getShareDataList")
	private Map<String, Object> getShareDataList() {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = null;
		List<Ds_share_data> tc_share_data_list = new ArrayList<Ds_share_data>();
		ArrayList<Map<String, Object>> tc_share_datas = null;

		tc_users tc_users = null;
		try {
			tc_share_datas = new ArrayList<Map<String, Object>>();

			tc_share_data_list = sharedService.getShareDataList();
			if (!tc_share_data_list.isEmpty() && tc_share_data_list.size() != 0) {
				for (Ds_share_data tc_share_data : tc_share_data_list) {
					map1 = new HashMap<String, Object>();

					tc_users = tcUserService.findUserbyId(tc_share_data.getUser_id());

					map1.put("share_data_id", tc_share_data.getShare_data_id());
					map1.put("user_name", tc_users.getName());
					map1.put("from_date", String.valueOf(tc_share_data.getFrom_time()));
					map1.put("to_date", String.valueOf(tc_share_data.getTo_time()));
					map1.put("salt", tc_share_data.getSalt());
					map1.put("created_time", String.valueOf(tc_share_data.getCreated_time()));
					map1.put("is_deleted", tc_share_data.getIs_deleted());
					map1.put("is_active", tc_share_data.getIs_active());
					map1.put("user_id", tc_share_data.getUser_id());

					if (dataURL != null && !dataURL.equals("") && dataURL != "")
						map1.put("dataUrl", dataURL + "/getSharedData?salt=" + tc_share_data.getSalt() + "&user_id="
								+ tc_share_data.getUser_id());
					else
						map1.put("dataUrl", "/getSharedData?salt=" + tc_share_data.getSalt() + "&user_id="
								+ tc_share_data.getUser_id());

					if (tc_share_data.getUpdate_info() != null && tc_share_data.getUpdate_info() != "")
						map1.put("update_info", tc_share_data.getUpdate_info());
					if (tc_share_data.getUpdated_time() != null)
						map1.put("updated_time", String.valueOf(tc_share_data.getUpdated_time()));

					tc_share_datas.add(map1);
				}
			}

			map.put("status", "success");
			map.put("tc_share_data", tc_share_datas);
			return map;

		} catch (Exception e) {
			map.put("message", "Something went wrong...!!");
			map.put("error", "Something went wrong...!!");
			map.put("status", "error");
			return map;
		}
	}

	@GetMapping("/getSharedData")
	private Map<String, Object> getDeviceById(@RequestParam(name = "salt", required = true) String salt,
			@RequestParam(name = "user_id", required = true) Integer user_id) {
		Map<String, Object> map = new HashMap<String, Object>();

		tc_users tc_user = null;
		Ds_share_data share_data = null;

		Map<String, Object> device_info_map = null;
		Map<String, Object> position_info_map = null;

		ArrayList<Map<String, Object>> tc_user_shared_data = new ArrayList<Map<String, Object>>();

		List<Object> list2 = new ArrayList<Object>();

		try {
			if (salt == "" || salt == null) {
				map.put("status", "error");
				map.put("message", "Please provide salt");
				map.put("error", "required_field");
				return map;
			}

			if (user_id != 0) {
				tc_user = tcUserService.findUserbyId(user_id);
				if (tc_user == null) {
					map.put("message", "User not found...");
					map.put("error", "not_found");
					map.put("status", "error");
					return map;
				} else if (tc_user.isDisabled().booleanValue() == true) {
					map.put("message", "Currently this User is Inactive...");
					map.put("error", "not_found");
					map.put("status", "error");
					return map;
				} else if (tc_user.isAdministrator().booleanValue() == false) {
					map.put("message", "This is not admin user..");
					map.put("error", "not_found");
					map.put("status", "error");
					return map;
				}

			} else {
				map.put("status", "error");
				map.put("message", "Please provide user_id");
				map.put("error", "required_field");
				return map;
			}

			if (salt != null && salt != "" && !salt.equals(null)) {
				share_data = sharedService.getBySaltAndUserId(salt, user_id);

				if (share_data != null) {

					Timestamp from_date = share_data.getFrom_time();
					Timestamp to_date = share_data.getTo_time();
					Timestamp current_date = new Timestamp(System.currentTimeMillis());
					if ((current_date.getTime() >= from_date.getTime())
							&& (current_date.getTime() <= to_date.getTime())) {
						List<Object> tc_device_postion_data = sharedService.getDevicePostionData(user_id);
						if (tc_device_postion_data.size() != 0) {

							for (int i = 0; i < tc_device_postion_data.size(); i++) {
								Object[] dd = (Object[]) tc_device_postion_data.get(i);

								device_info_map = new HashMap<String, Object>();

								device_info_map.put("device_id", dd[1]);
								device_info_map.put("device_name", dd[2]);
								device_info_map.put("imei", dd[3]);

								position_info_map = new HashMap<String, Object>();
								position_info_map.put("position_id", dd[4]);
								position_info_map.put("servertime", dd[5]);
								position_info_map.put("devicetime", dd[6]);
								position_info_map.put("fixtime", dd[7]);
								position_info_map.put("latitude", dd[8]);
								position_info_map.put("longitude", dd[9]);
								position_info_map.put("altitude", dd[10]);
								position_info_map.put("speed", dd[11]);
								position_info_map.put("course", dd[12]);
								position_info_map.put("address", dd[13]);
								device_info_map.put("position_info", position_info_map);
								tc_user_shared_data.add(device_info_map);
							}
						}
						map.put("user_id", tc_user.getId());
						map.put("user_name", tc_user.getName());
						map.put("user_device_info", tc_user_shared_data);
						map.put("status", "success");
						return map;
					} else {
						map.put("message", "Currently link not available...");
						map.put("error", "not_found");
						map.put("status", "error");
						return map;
					}
				} else {
					map.put("message", "Please enter valid authentication...!!");
					map.put("error", "invalid_authentication");
					map.put("status", "error");
					return map;
				}

			} else {
				map.put("message", "Please enter valid authentication...!!");
				map.put("error", "required_field");
				map.put("status", "error");
				return map;
			}
		} catch (Exception e) {
			map.put("message", "Unable to get device list...!!");
			map.put("error", "something went wrong...!!");
			map.put("status", "error");
			return map;
		}
	}

}
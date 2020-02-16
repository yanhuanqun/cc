package com.parking.common;

import java.util.HashMap;
import java.util.Map;

public class Response {

	/**
	 * return: success
	 * */
	public static final Map<String, Boolean> SUCCESS = new HashMap<String, Boolean>(8) {{
		put("res", true);
	}};

	/**
	 * return: failed
	 * */
	public static final Map<String, Boolean> FAILED = new HashMap<String, Boolean>(8) {{
		put("res", false);
	}};

}

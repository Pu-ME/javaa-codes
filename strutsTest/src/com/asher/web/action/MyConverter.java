package com.asher.web.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class MyConverter extends StrutsTypeConverter {
	private DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	@Override
	public Object convertFromString(Map arg0, String[] values, Class toClass) {
		if(values[0]==null||values.length==0){
			return null;
		}
		String date = values[0];
		if(toClass == java.util.Date.class){
			try {
				return df.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object o) {
		if(o instanceof Date){
			Date date = (Date) o;
			return df.format(date);
		}
		return null;
	}

}

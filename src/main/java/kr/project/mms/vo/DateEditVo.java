package kr.project.mms.vo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

@Service
public class DateEditVo {
	
	DateFormat fulldate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat oldletter = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat nearletter = new SimpleDateFormat("hh:mm:ss");
	
	@SuppressWarnings("deprecation")
	public String printdate(Date date) {
		
		Date checkdate = Calendar.getInstance(TimeZone.getTimeZone("GMT+09:00")).getTime();
		
		Integer hour = date.getHours() - 9;
		date.setHours(hour);
		
		checkdate.setDate(checkdate.getDate()-1);
		boolean timing = date.after(checkdate);
		String newdate = null;
		if(timing) {
			newdate = nearletter.format(date).toString();
		} else {
			newdate = oldletter.format(date).toString();
		}	
		return newdate;
	}
	
	@SuppressWarnings("deprecation")
	public String printfulldate(Date date) {
		Integer hour = date.getHours() - 9;
		date.setHours(hour);
		
		String newdate = fulldate.format(date).toString();				
		return newdate;
	}	
	
	public Date regsiterdate() {
		Date now = Calendar.getInstance(TimeZone.getTimeZone("GMT+09:00")).getTime();
		Date regdate = null;
		String stdate = fulldate.format(now).toString();
		try {
			regdate = fulldate.parse(stdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return regdate;
	}
	
	public Date regsiterdate(String input) {
		Date regdate = null;
		try {
			regdate = fulldate.parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return regdate;
	}
}

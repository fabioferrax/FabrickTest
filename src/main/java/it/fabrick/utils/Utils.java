package it.fabrick.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.fabrick.exception.FabrickException;

public class Utils {

	private static final Logger logger = LoggerFactory.getLogger(Utils.class);


	public static String formatDate(String pattern, Date data) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(data);
	}

	public static boolean validateDate(String pattern, String strDate) {
		logger.debug("START - validateDate pattern[{}] strDate[{}]", pattern, strDate);
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			Date d = sdf.parse(strDate);
			logger.debug("END - date is valid -> [{}]",d);
			return true;
		} catch (ParseException e) {
			throw new FabrickException("VL", "Errore formato date errato [yyyy-MM-dd]");
		}
	}
	

	public static boolean validateString(String regex, String str) {
		return str.matches(regex);
	}
}

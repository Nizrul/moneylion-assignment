package moneylion.assignment.common.helper;

import java.util.List;
import java.util.stream.Collectors;

public class StringHelper {
	public static String joinList(List<String> list) {
		if (list.size() == 0) {
			return "";
		}
		return list.stream().collect(Collectors.joining(","));
	}
	
	public static String joinList(List<String> list, String joiner) {
		if (list.size() == 0) {
			return "";
		}
		return list.stream().collect(Collectors.joining(joiner));
	}
}

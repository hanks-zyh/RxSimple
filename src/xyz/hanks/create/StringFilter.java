package xyz.hanks.create;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class StringFilter {

	public static void main(String[] args) {
		String oldUsername = "阿斯顿*sd+sa  dsa ##@asd ";
 

		String str = "*adCVs*34_a _09_b5*[/435^*&城池()💩^$$&*).{}+.|.)%%*(*.中国}34{45[]12.fd'*&999下面是中文的字符￥……{}【】。，；’“‘”？";
		System.out.println(stringFilter(oldUsername));
		System.out.println(stringFilter(str));
	}

	public static String stringFilter(String str) throws PatternSyntaxException {
		// 只允许字母和数字
		// String regEx = "[^a-zA-Z0-9]";
		// 清除掉所有特殊字符
		String regEx = "[^a-zA-Z0-9\u4e00-\u9fa5_]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}
}

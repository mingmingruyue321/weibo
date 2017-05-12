package mmry.weibo;

import org.apache.commons.lang3.StringEscapeUtils;

import us.codecraft.xsoup.Xsoup;

public class Test {
	public static void main(String[] args) {
		String ss = "\u8fd4\u56de\u9996\u9875sdfs";
		ss = StringEscapeUtils.unescapeJava(ss);
		ss = ss.replaceAll("\"http", "\\\\\"http");
		System.err.println(ss);
	}
}

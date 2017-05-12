package mmry.weibo.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.jsoup.nodes.Element;

import us.codecraft.xsoup.Xsoup;

public class FansUtils {
	public static List<String> getHtmls(List<String> views){
		List<String> htmls = new ArrayList<>();
		for(String view :views){
			String viewjson = view.substring(8,view.lastIndexOf("}")+1);
			//System.err.println(viewjson);
			viewjson = StringEscapeUtils.unescapeJava(viewjson);
			if(viewjson.indexOf("\"ns\":\"pl.content.followTab.index")>-1&&viewjson.indexOf("\"html\":\"")>-1){
				viewjson = viewjson.substring(viewjson.indexOf("\"html\":\"")+8,viewjson.length()-2 );
				htmls.add(viewjson);
				//System.err.println(viewjson);
			}
		}
		return htmls;
	}
	public static List<String> getFansList (String html){
		List<String> fans = new ArrayList<>();
		List<String> views = new ArrayList<>();
		List<Element> elements = Xsoup.select(html, "script").getElements();
		for(Element element :elements){
			String view = element.childNodes().get(0).toString();
			if(view!=null && view.startsWith("FM.view")){
				views.add(view);
			}
		}
		List<String> htmls = getHtmls(views);
		for(String div :htmls){
			elements = Xsoup.select(div, "li[@class='follow_item S_line2']").getElements();
			for(Element element :elements){
				String fansid = element.attr("action-data");
				fansid = fansid.substring(4,fansid.indexOf("&"));
				//System.err.println(fansid);
				////2775577381
				fans.add("https://m.weibo.cn/api/container/getIndex?containerid=230283"+fansid+"_-_INFO");
			}
		}
		//下一页
		for(String div :htmls){
			elements = Xsoup.select(div, "a[@class='page S_txt1']").getElements();
			for(Element element :elements){
				String pageno = element.text();
				String pagehref = element.attr("href");
				//http://weibo.com/p/1005052046390745/follow?relate=fans&page=1#Pl_Official_HisRelation__60
				fans.add(pagehref+"follow?relate=fans&page="+pageno+"#Pl_Official_HisRelation__60");
			}
		}
		
		return fans;
	}
	public static List<String> getUserinfo (String html){
		return null;
	}
}

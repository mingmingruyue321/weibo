package mmry.weibo;

import java.util.ArrayList;
import java.util.List;

import mmry.weibo.util.FansUtils;

import org.apache.commons.lang3.StringEscapeUtils;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Hello world!
 * 
 */
public class App implements PageProcessor {
	public static int count=0;
	private String pageRegex = "(\\/p\\\\\\/[\\d]*\\\\\\/follow\\?pids=Pl_Official_HisRelation__60&relate=fans&page=[\\d]*#Pl_Official_HisRelation__60)";
	private List<String> translateUrl(List<String> url){
		String baseUrl = "http://weibo.com";
		List<String> newUrl = new ArrayList<>();
		if(url==null) return newUrl;
		for(String oldurl:url){
			newUrl.add(baseUrl+StringEscapeUtils.unescapeJava(oldurl));
		}
		return url;
	}

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000)
    						.addCookie("Cookie", "SINAGLOBAL=1261975649007.8916.1493700312624; YF-Ugrow-G0=8751d9166f7676afdce9885c6d31cd61; login_sid_t=c633572a8fb2c79a8499e65eafbb774f; YF-V5-G0=55fccf7be1706b6814a78384fa94e30c; _s_tentry=-; Apache=2473941583273.0605.1494558368422; ULV=1494558369504:5:5:1:2473941583273.0605.1494558368422:1493946592061; UOR=www.csdn.net,widget.weibo.com,www.baidu.com; YF-Page-G0=0acee381afd48776ab7a56bd67c2e7ac; SCF=AiWLrI7xhKopF7DFlss7jQXLXXR3igakI8jd9AbeGMbaSrmgtH79m98Y6ArHkn6pfG0E8q7Yaug9o3PAgp28se0.; SUB=_2A250EVsUDeThGeRH7lYT9i_Fwz2IHXVXZ8vcrDV8PUNbmtANLWHckW9urTaKg3wtMd7piLEJW3WT1rVuQQ..; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WFKOSjIuVEayJOlV0ncx4x65JpX5K2hUgL.Foz4SKBESo241h22dJLoIEMLxKqL1KnL12-LxKqL1KnL12-LxK-LBKqL1hzLxKqL1-eL1hn0eo2t; SUHB=02M_QvsonJdonc; ALF=1526095555; SSOLoginState=1494559556; un=984173648@qq.com")
    						.setDomain("weibo.com")
    						.setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36");

    @Override
    public void process(Page page) {
    	if(page.getUrl().toString().indexOf("follow?relate")>-1){//
    		List<String> targetRequests = FansUtils.getFansList(page.getHtml().get());
    		page.addTargetRequests(targetRequests);
    		page.setSkip(true);
    	}
    	if(page.getUrl().toString().indexOf("container/getIndex?containerid")>-1){
    		String userinfo = StringEscapeUtils.unescapeJava(page.getRawText());
    		//System.err.println(userinfo);
    		page.putField("userinfo", userinfo);
    	}
    } 

    @Override
    public Site getSite() {//婧瑄-
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new App())
        	  .addUrl("http://weibo.com/p/1005055743580104/follow?relate=fans&page=1#Pl_Official_HisRelation__60")
        	  .addPipeline(new ConsolePipeline())
        	  .thread(10).run();
    }
}

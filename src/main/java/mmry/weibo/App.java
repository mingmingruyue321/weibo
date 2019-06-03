package mmry.weibo;

import java.util.ArrayList;
import java.util.List;

import mmry.weibo.util.FansUtils;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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
	public static ApplicationContext tx = new FileSystemXmlApplicationContext("classpath:spring-servlet.xml");
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
    						.addCookie("Cookie", "")
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
    		page.putField("fansid", page.getUrl().toString().split("userid=")[1]);
    	}
    } 

    @Override
    public Site getSite() {//婧瑄-
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new App())
        	  .addUrl("http://weibo.com/p/1005052046390745/follow?relate=fans&page=1#Pl_Official_HisRelation__60")
        	  .addPipeline(new ConsolePipeline())
        	  .thread(10).run();
    }
}

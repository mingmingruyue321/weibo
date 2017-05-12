package mmry.weibo;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ConsolePipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
    	String userinfo = resultItems.get("userinfo");
    	JSONObject parseObject = JSON.parseObject(userinfo);
    	JSONObject card = parseObject.getJSONArray("cards").getJSONObject(0);
    	JSONArray jsonArray = card.getJSONArray("card_group");
    	//for(int i=0;i<jsonArray.size();i++){
    		JSONObject obj = jsonArray.getJSONObject(0);
    		System.err.println( App.count+"  "+obj.getString("item_name")+":"+obj.getString("item_content"));
    	//}
       // System.out.println("----------------------------------------------");
        App.count++;
    }
}

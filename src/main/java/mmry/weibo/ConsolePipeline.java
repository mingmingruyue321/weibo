package mmry.weibo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import mmry.weibo.data.domain.UserInfoDto;
import mmry.weibo.data.mapper.UserInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
public class ConsolePipeline implements Pipeline {
	private UserInfoMapper infoMapper = App.tx.getBean(UserInfoMapper.class);
    @Override
    public void process(ResultItems resultItems, Task task) {
    	String userinfo = resultItems.get("userinfo");
    	String fansid = resultItems.get("fansid");
    	UserInfoDto userInfoDto = new UserInfoDto();
    	userInfoDto.setUserId(fansid);
    	JSONObject parseObject = JSON.parseObject(userinfo);
    	JSONArray cards = parseObject.getJSONArray("cards");
    	for(int j=0;j<cards.size();j++){
    		JSONObject card = cards.getJSONObject(j);
    		JSONArray jsonArray = card.getJSONArray("card_group");
    		for(int i=0;i<jsonArray.size();i++){
    			JSONObject obj = jsonArray.getJSONObject(i);
    			if("昵称".equals(obj.getString("item_name"))){
    				userInfoDto.setName(obj.getString("item_content"));
    			}
    			if("性别".equals(obj.getString("item_name"))){
    				userInfoDto.setSex(obj.getString("item_content"));
    			}
    			if("所在地".equals(obj.getString("item_name"))){
    				userInfoDto.setAddress(obj.getString("item_content"));
    			}
    			if("简介".equals(obj.getString("item_name"))){
    				userInfoDto.setIntroduce(obj.getString("item_content"));
    			}
    			if("标签".equals(obj.getString("item_name"))){
    				userInfoDto.setTag(obj.getString("item_content"));
    			}
    			if("备注".equals(obj.getString("item_name"))){
    				userInfoDto.setRemark(obj.getString("item_content"));
    			}
    			if("公司".equals(obj.getString("item_name"))){
    				userInfoDto.setCompany(obj.getString("item_content"));
    			}
    			if("等级".equals(obj.getString("item_name"))){
    				userInfoDto.setLevel(obj.getString("item_content"));
    			}
    			if("注册时间".equals(obj.getString("item_name"))){
    				DateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
    				Date date = null;
    				try {
    					date = fm.parse(obj.getString("item_content"));
    				} catch (ParseException e) {
    				}
    				userInfoDto.setRegisterDate(date);
    			}
    		}
    	}
    	infoMapper.insert(userInfoDto);
       System.out.println("----------------------"+App.count+++"------------------------");
    }
}

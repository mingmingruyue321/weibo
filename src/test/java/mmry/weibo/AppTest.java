package mmry.weibo;

import mmry.weibo.data.domain.UserInfoDto;
import mmry.weibo.data.mapper.UserInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest {
	static{
		ApplicationContext tx = new FileSystemXmlApplicationContext("classpath:spring-servlet.xml");
	}
	@Autowired
	private static UserInfoMapper infoMapper ;
	public static void main(String[] args) {
		UserInfoDto infoDto = new UserInfoDto();
		infoDto.setUserId("001");
		infoDto.setName("zs");
		infoMapper.insert(infoDto);
	}
}

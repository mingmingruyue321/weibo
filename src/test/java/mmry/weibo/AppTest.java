package mmry.weibo;

import mmry.weibo.data.domain.UserInfoDto;
import mmry.weibo.data.mapper.UserInfoMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest {
	public static void main(String[] args) {
		ApplicationContext tx = new FileSystemXmlApplicationContext("classpath:spring-servlet.xml");
		UserInfoMapper bean = tx.getBean(UserInfoMapper.class);
		UserInfoDto infoDto = new UserInfoDto();
		infoDto.setUserId("001");
		infoDto.setName("zs");
		bean.insert(infoDto);
		System.err.println(bean);
	}
}

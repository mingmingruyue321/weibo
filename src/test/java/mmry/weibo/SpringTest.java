package mmry.weibo;

import mmry.weibo.data.domain.UserInfoDto;
import mmry.weibo.data.mapper.UserInfoMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-servlet.xml"})
public class SpringTest {
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Test
	public void insert(){
		UserInfoDto infoDto = new UserInfoDto();
		infoDto.setUserId("001");
		infoDto.setName("zs");
		userInfoMapper.insert(infoDto);
	}
}

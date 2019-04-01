package cn.rep.cloud.cloudui;

import cn.rep.cloud.cloudui.common.ShiroRealm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClouduiApplicationTests {

	@Test
	public void contextLoads() {

		ShiroRealm shiroRealm=new ShiroRealm();
		shiroRealm.getMd5();
	}

}


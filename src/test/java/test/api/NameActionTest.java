package test.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
@ContextConfiguration(locations = { 
		"file:src/main/resources/applicationContext-dao.xml" ,
		"file:src/main/resources/applicationContext-mvc.xml" ,
		"file:src/main/resources/applicationContext.xml" 
	})
public class NameActionTest {
	@Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;
    
    @Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
    @Test
    public void test() {
		
	}
}

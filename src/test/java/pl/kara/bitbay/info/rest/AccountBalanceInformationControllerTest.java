package pl.kara.bitbay.info.rest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import pl.kara.bitbay.BitbayApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BitbayApplication.class)
@WebAppConfiguration
public class AccountBalanceInformationControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAccountBalanceInformation() throws Exception {

        LinkedMultiValueMap<Object, Object> objectObjectLinkedMultiValueMap = new LinkedMultiValueMap<>();

        //TODO FEATURE zrobic testy

//        mockMvc.perform(get(AccountBalanceInformationController.PATH).params())


    }

}
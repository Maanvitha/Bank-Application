package com.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.app.controller.AccountController;
import com.app.controller.AccountService;
import com.app.model.Account;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(AccountController.class)
class AccountControllerTest {
	
	@Mock
	   private AccountService accService;
	   private List<Account> acclist;
	   
	   @Autowired
	   private ObjectMapper objectMapper;
	   
	   @Autowired
	   private MockMvc mockMvc;
	   
	   
	   @Test
	   public void GetAllAccounts() throws Exception {
		   acclist.add(new Account("savings",23456));
		   acclist.add(new Account("current",20005));
		   acclist.add(new Account("savings",300000));
		   acclist.add(new Account("current",400000));
	       Mockito.when(accService.getAllAccount()).thenReturn(acclist);
	       
	       String url="/getAllAccountDetails";
	       MvcResult mvsresult=mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
	  
	       String actualJsonResponse= mvsresult.getResponse().getContentAsString();
	       System.out.println(actualJsonResponse);
	       
	       String expectedJsonResponse= objectMapper.writeValueAsString(acclist);
	       
	       assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
	   }
}
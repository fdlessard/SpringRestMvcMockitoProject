package io.fdlessard.codebites.order;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;


/**
 * Unit test for simple OrderController.
 */

public class OrderControllerTest {

	private MockMvc mockMvc;

    @Mock
    private OrderDao orderDao;

	@Before
	public void setup() {

        MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(new OrderController(orderDao)).build();
        Mockito.when(orderDao.getOrderById("0")).thenReturn(new Order("0", "Order 0"));

        List<Order> orderList = new ArrayList<Order>();

        orderList.add(new Order("0", "Order 0"));
        orderList.add(new Order("1", "Order 1"));
        orderList.add(new Order("2", "Order 2"));

        Mockito.when(orderDao.getAllOrders()).thenReturn( orderList );
	}

	@Test
	public void testHello() throws Exception{

		mockMvc.perform(get("/hello")).andExpect(status().isOk())
				.andExpect(content().string("Hello World"));
		
	}

	@Test
	public void testOrder() throws Exception{

		mockMvc.perform(get("/order/0")).andExpect(status().isOk()).
                andExpect(content().contentType(MediaType.APPLICATION_JSON)).
                andExpect( jsonPath("$.id").value("0")   ) .
                andExpect( jsonPath("$.description").value("Order 0")   ) ;
	}

    @Test
    public void testOrders() throws Exception{

        mockMvc.perform(get("/orders")).andExpect(status().isOk()).
                andExpect(content().contentType(MediaType.APPLICATION_JSON)).
                andExpect( jsonPath("$", hasSize(3)  )).
                andExpect( jsonPath("$.[0].id").value("0")  ) .
                andExpect( jsonPath("$.[0].description").value("Order 0")  ) .
                andExpect( jsonPath("$.[1].id").value("1")  ) .
                andExpect( jsonPath("$.[1].description").value("Order 1")  ) .
                andExpect( jsonPath("$.[2].id").value("2")  ).
                andExpect( jsonPath("$.[2].description").value("Order 2")  ) ;


    }


}

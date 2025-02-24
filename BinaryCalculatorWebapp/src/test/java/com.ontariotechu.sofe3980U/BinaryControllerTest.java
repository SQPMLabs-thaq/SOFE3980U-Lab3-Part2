package com.ontariotechu.sofe3980U;

/** Name: Nuha Tahnia Haq
 *  Student ID: 100867378 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.*;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void getDefault() throws Exception {
        this.mvc.perform(get("/"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
			.andExpect(model().attribute("operand1", ""))
			.andExpect(model().attribute("operand1Focused", false));
    }

	    @Test
    public void getParameter() throws Exception {
        this.mvc.perform(get("/").param("operand1","111"))
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
			.andExpect(model().attribute("operand1", "111"))
			.andExpect(model().attribute("operand1Focused", true));
    }
	@Test
	    public void postParameter() throws Exception {
        this.mvc.perform(post("/").param("operand1","111").param("operator","+").param("operand2","111"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "1110"))
			.andExpect(model().attribute("operand1", "111"));
    }


    // Add three more test cases for already implemented functions - Binary web application, initial version.
    // Changed operand2 to 1010. Operand1 was kept the same. Results were calculated to be: 10001 (17).
    @Test
    public void postAdd1() throws Exception {
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "+").param("operand2", "1010"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "10001"));
    }
    // Changed operand2 to 0. Operand1 was kept the same. Results were calculated to be: 111 (7).
    @Test
    public void postAdd2WithZero() throws Exception {
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "+").param("operand2", ";0"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "111"));
    }
    // Changed operand2 to 1. Operand1 was kept the same. Results were calculated to be: 111 (7).
    @Test
    public void postAdd3WithCarry() throws Exception {
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "+").param("operand2", "1"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "1000"));
    }


    // Test Cases #1: The following two test cases implement the operator: '|'. 
    // OR-ing the operands 1010 and 1100. The result is 1110.
    @Test
    public void postOr1() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1010").param("operator", "|").param("operand2", "1100"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "1110"));
    }
    // OR-ing the operands 101 and 111. The result is 111.
    @Test
    public void postOr2() throws Exception {
        this.mvc.perform(post("/").param("operand1", "101").param("operator", "|").param("operand2", "111"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "111"));
    }


    // Test Cases #2: The following two test cases implement the operator: '&'. 
    // AND-ing the operands 1010 and 1100. The result is 1000.
    @Test
    public void postAnd1() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1010").param("operator", "&").param("operand2", "1100"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "1000"));
    }
    // AND-ing the operands 101 and 111. The result is 101.
    @Test
    public void postAnd2() throws Exception {
        this.mvc.perform(post("/").param("operand1", "101").param("operator", "&").param("operand2", "111"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "101"));
    }


    // Test Cases #3: The following two test cases implement the operator: '*'. 
    // Multiplying the operands 10 (2) and 11 (3). The result is 6 or 110.
    @Test
    public void postMultiply1() throws Exception {
        this.mvc.perform(post("/").param("operand1", "10").param("operator", "*").param("operand2", "11"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "110"));
    }
    // Multiplying the operands 110 (6) and 1010 (10). The result is 60 or 111100.
    @Test
    public void postMultiply2() throws Exception {
        this.mvc.perform(post("/").param("operand1", "110").param("operator", "*").param("operand2", "1010"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "111100"));
    }
}
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("10001"));
    }
	@Test
    public void add2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    // Add three more test cases for already implemented functions - Binary API Service, initial version.
    
    // Changed operand1 to 110 (6) in add3, add4. Operand2 was kept the same. Results were calculated to be: 10000 (16).
    // Changed operand1 to 101 (5) in add5, add6. Operand2 was kept the same. Results were calculated to be: 1111 (15).
    @Test
    public void add3() throws Exception {
        this.mvc.perform(get("/add").param("operand1","110").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("10000"));
    }
	@Test
    public void add4() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","110").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(110))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10000))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }
    @Test
    public void add5() throws Exception {
        this.mvc.perform(get("/add").param("operand1","101").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("1111"));
    }
	@Test
    public void add6() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","101").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(101))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    // Test Cases #1: The following two test cases implement the operator: '*'. 
    // Multiplying the operands 110 (6) and 1010 (10). The result is 60 or 111100.
    @Test
    public void multiply1() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1","110").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("111100"));
    }
	@Test
    public void multiply2() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1","110").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(110))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(111100))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }

    // Test Cases #2: The following two test cases implement the operator: '&'. 
    // AND-ing the operands 100 and 110. The result is 100.
    @Test
    public void and1() throws Exception {
        this.mvc.perform(get("/and").param("operand1","100").param("operand2","110"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("100"));
    }
	@Test
    public void and2() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1","100").param("operand2","110"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(100))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(110))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(100))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }

    // Test Cases #3: The following two test cases implement the operator: '|'. 
    // OR-ing the operands 100 and 110. The result is 110.
    @Test
    public void or1() throws Exception {
        this.mvc.perform(get("/or").param("operand1","100").param("operand2","110"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("110"));
    }
	@Test
    public void or2() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1","100").param("operand2","110"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(100))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(110))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(110))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }
}
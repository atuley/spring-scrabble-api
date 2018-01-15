/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hello;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ScoreControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void invalid_character_returns_value_of_zero() throws Exception {
        this.mockMvc.perform(get("/score").param("word", "!"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.score").value("0"));
    }

    @Test
    public void invalid_character_with_word_returns_score_of_word() throws Exception {
        this.mockMvc.perform(get("/score").param("word", "?hello"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.score").value("8"));
    }

    @Test
    public void param_should_return_score_inside_of_json_object() throws Exception {
        this.mockMvc.perform(get("/score").param("word", "hello"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.score").value("8"));
    }

}

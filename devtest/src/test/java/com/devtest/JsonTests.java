package com.devtest;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * desc
 *
 * @author agony
 * @date 2020/4/23 23:31
 */
@RunWith(SpringRunner.class)
@JsonTest
public class JsonTests {
    @Autowired
    JacksonTester<Book> jacksonTester;

    @Test
    public void testSerialize() throws Exception {
        Book book = new Book();
        book.setId(1L);
        book.setName("sanguoyanyi");
        book.setAuthor("luoguanzhong");
        Assertions.assertThat(jacksonTester.write(book)).isEqualToJson("book.json");
        Assertions.assertThat(jacksonTester.write(book)).hasJsonPathStringValue("@.name");
        Assertions.assertThat(jacksonTester.write(book)).extractingJsonPathStringValue("@.name")
                .isEqualTo("sanguoyanyi");
    }

    @Test
    public void testDeserialize() throws Exception {
        String content = "{\"id\": 1,\"name\": \"sanguoyanyi\",\"author\": \"luoguanzhong\"}";
        Assertions.assertThat(jacksonTester.parseObject(content).getName()).isEqualTo("sanguoyanyi");
    }
}

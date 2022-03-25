package com.hackerrank.stocktrade.requests;

import com.hackerrank.test.utility.Order;
import com.hackerrank.test.utility.OrderedTestRunner;
import com.hackerrank.test.utility.ResultMatcher;
import com.hackerrank.test.utility.TestWatchman;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(OrderedTestRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TradesControllerTest {

    @ClassRule
    public static final SpringClassRule springClassRule = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();
    
    @Rule
    public TestWatcher watchman = TestWatchman.watchman;
    
    @Autowired
    private MockMvc mockMvc;

    @BeforeClass
    public static void setUpClass() {
        TestWatchman.watchman.registerClass(TradesControllerTest.class);
    }

    @AfterClass
    public static void tearDownClass() {
        TestWatchman.watchman.createReport(TradesControllerTest.class);
    }

    /**
     *
     * @throws Exception
     *
     * It tests creating trade
     */
    @Test
    @Order(1)
    public void createTrade() throws Exception {
        /**
         *
         * Create trade with id 1
         *
         * The request body is:
         * {
         *     "id": 1,
         *     "type": "buy",
         *     "user": {
         *         "id": 4,
         *         "name": "Derrick Garcia"
         *     },
         *     "symbol": "ZAYO",
         *     "shares": 11,
         *     "price": 154.77,
         *     "timestamp": "2016-12-28 11:44:37"
         * }
         */
        String json = "{\"id\": 1, \"type\": \"buy\", \"user\": {\"id\": 4, \"name\": \"Derrick Garcia\"}, \"symbol\": \"ZAYO\", \"shares\": 11, \"price\": 154.77, \"timestamp\": \"2016-12-28 11:44:37\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 2
         *
         * The request body is:
         * {
         *     "id": 2,
         *     "type": "buy",
         *     "user": {
         *         "id": 1,
         *         "name": "Jennifer Long"
         *     },
         *     "symbol": "A",
         *     "shares": 19,
         *     "price": 153.57,
         *     "timestamp": "2016-12-28 13:15:52"
         * }
         */
        json = "{\"id\": 2, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"A\", \"shares\": 19, \"price\": 153.57, \"timestamp\": \"2016-12-28 13:15:52\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 3
         *
         * The request body is:
         * {
         *     "id": 3,
         *     "type": "buy",
         *     "user": {
         *         "id": 4,
         *         "name": "Derrick Garcia"
         *     },
         *     "symbol": "A",
         *     "shares": 12,
         *     "price": 135.89,
         *     "timestamp": "2016-12-28 13:18:18"
         * }
         */
        json = "{\"id\": 3, \"type\": \"buy\", \"user\": {\"id\": 4, \"name\": \"Derrick Garcia\"}, \"symbol\": \"A\", \"shares\": 12, \"price\": 135.89, \"timestamp\": \"2016-12-28 13:18:18\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 4
         *
         * The request body is:
         * {
         *     "id": 4,
         *     "type": "buy",
         *     "user": {
         *         "id": 2,
         *         "name": "Daniel Cortez"
         *     },
         *     "symbol": "MMS",
         *     "shares": 15,
         *     "price": 183.45,
         *     "timestamp": "2016-12-28 15:15:50"
         * }
         */
        json = "{\"id\": 4, \"type\": \"buy\", \"user\": {\"id\": 2, \"name\": \"Daniel Cortez\"}, \"symbol\": \"MMS\", \"shares\": 15, \"price\": 183.45, \"timestamp\": \"2016-12-28 15:15:50\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 5
         *
         * The request body is:
         * {
         *     "id": 5,
         *     "type": "buy",
         *     "user": {
         *         "id": 2,
         *         "name": "Daniel Cortez"
         *     },
         *     "symbol": "WEX",
         *     "shares": 10,
         *     "price": 190.73,
         *     "timestamp": "2016-12-29 09:05:23"
         * }
         */
        json = "{\"id\": 5, \"type\": \"buy\", \"user\": {\"id\": 2, \"name\": \"Daniel Cortez\"}, \"symbol\": \"WEX\", \"shares\": 10, \"price\": 190.73, \"timestamp\": \"2016-12-29 09:05:23\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 6
         *
         * The request body is:
         * {
         *     "id": 6,
         *     "type": "buy",
         *     "user": {
         *         "id": 4,
         *         "name": "Derrick Garcia"
         *     },
         *     "symbol": "ZAYO",
         *     "shares": 30,
         *     "price": 137.86,
         *     "timestamp": "2016-12-30 11:42:40"
         * }
         */
        json = "{\"id\": 6, \"type\": \"buy\", \"user\": {\"id\": 4, \"name\": \"Derrick Garcia\"}, \"symbol\": \"ZAYO\", \"shares\": 30, \"price\": 137.86, \"timestamp\": \"2016-12-30 11:42:40\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 7
         *
         * The request body is:
         * {
         *     "id": 7,
         *     "type": "buy",
         *     "user": {
         *         "id": 2,
         *         "name": "Daniel Cortez"
         *     },
         *     "symbol": "MMS",
         *     "shares": 19,
         *     "price": 183.45,
         *     "timestamp": "2016-12-30 12:35:21"
         * }
         */
        json = "{\"id\": 7, \"type\": \"buy\", \"user\": {\"id\": 2, \"name\": \"Daniel Cortez\"}, \"symbol\": \"MMS\", \"shares\": 19, \"price\": 183.45, \"timestamp\": \"2016-12-30 12:35:21\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 8
         *
         * The request body is:
         * {
         *     "id": 8,
         *     "type": "buy",
         *     "user": {
         *         "id": 4,
         *         "name": "Derrick Garcia"
         *     },
         *     "symbol": "WEX",
         *     "shares": 11,
         *     "price": 172.35,
         *     "timestamp": "2016-12-30 13:07:19"
         * }
         */
        json = "{\"id\": 8, \"type\": \"buy\", \"user\": {\"id\": 4, \"name\": \"Derrick Garcia\"}, \"symbol\": \"WEX\", \"shares\": 11, \"price\": 172.35, \"timestamp\": \"2016-12-30 13:07:19\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 9
         *
         * The request body is:
         * {
         *     "id": 9,
         *     "type": "buy",
         *     "user": {
         *         "id": 3,
         *         "name": "Connie Palmer"
         *     },
         *     "symbol": "ZAYO",
         *     "shares": 25,
         *     "price": 154.77,
         *     "timestamp": "2016-12-30 13:36:20"
         * }
         */
        json = "{\"id\": 9, \"type\": \"buy\", \"user\": {\"id\": 3, \"name\": \"Connie Palmer\"}, \"symbol\": \"ZAYO\", \"shares\": 25, \"price\": 154.77, \"timestamp\": \"2016-12-30 13:36:20\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 10
         *
         * The request body is:
         * {
         *     "id": 10,
         *     "type": "buy",
         *     "user": {
         *         "id": 1,
         *         "name": "Jennifer Long"
         *     },
         *     "symbol": "MMS",
         *     "shares": 28,
         *     "price": 152.93,
         *     "timestamp": "2016-12-30 14:48:14"
         * }
         */
        json = "{\"id\": 10, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"MMS\", \"shares\": 28, \"price\": 152.93, \"timestamp\": \"2016-12-30 14:48:14\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 11
         *
         * The request body is:
         * {
         *     "id": 11,
         *     "type": "buy",
         *     "user": {
         *         "id": 3,
         *         "name": "Connie Palmer"
         *     },
         *     "symbol": "ZAYO",
         *     "shares": 30,
         *     "price": 154.77,
         *     "timestamp": "2016-12-31 09:59:16"
         * }
         */
        json = "{\"id\": 11, \"type\": \"buy\", \"user\": {\"id\": 3, \"name\": \"Connie Palmer\"}, \"symbol\": \"ZAYO\", \"shares\": 30, \"price\": 154.77, \"timestamp\": \"2016-12-31 09:59:16\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 12
         *
         * The request body is:
         * {
         *     "id": 12,
         *     "type": "buy",
         *     "user": {
         *         "id": 2,
         *         "name": "Daniel Cortez"
         *     },
         *     "symbol": "WEX",
         *     "shares": 18,
         *     "price": 172.35,
         *     "timestamp": "2016-12-31 12:01:56"
         * }
         */
        json = "{\"id\": 12, \"type\": \"buy\", \"user\": {\"id\": 2, \"name\": \"Daniel Cortez\"}, \"symbol\": \"WEX\", \"shares\": 18, \"price\": 172.35, \"timestamp\": \"2016-12-31 12:01:56\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 13
         *
         * The request body is:
         * {
         *     "id": 13,
         *     "type": "buy",
         *     "user": {
         *         "id": 3,
         *         "name": "Connie Palmer"
         *     },
         *     "symbol": "A",
         *     "shares": 22,
         *     "price": 135.89,
         *     "timestamp": "2016-12-31 13:27:40"
         * }
         */
        json = "{\"id\": 13, \"type\": \"buy\", \"user\": {\"id\": 3, \"name\": \"Connie Palmer\"}, \"symbol\": \"A\", \"shares\": 22, \"price\": 135.89, \"timestamp\": \"2016-12-31 13:27:40\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 14
         *
         * The request body is:
         * {
         *     "id": 14,
         *     "type": "buy",
         *     "user": {
         *         "id": 1,
         *         "name": "Jennifer Long"
         *     },
         *     "symbol": "A",
         *     "shares": 30,
         *     "price": 136.68,
         *     "timestamp": "2016-12-31 15:29:15"
         * }
         */
        json = "{\"id\": 14, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"A\", \"shares\": 30, \"price\": 136.68, \"timestamp\": \"2016-12-31 15:29:15\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 15
         *
         * The request body is:
         * {
         *     "id": 15,
         *     "type": "buy",
         *     "user": {
         *         "id": 1,
         *         "name": "Jennifer Long"
         *     },
         *     "symbol": "MMS",
         *     "shares": 29,
         *     "price": 168.67,
         *     "timestamp": "2016-12-31 15:47:40"
         * }
         */
        json = "{\"id\": 15, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"MMS\", \"shares\": 29, \"price\": 168.67, \"timestamp\": \"2016-12-31 15:47:40\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 16
         *
         * The request body is:
         * {
         *     "id": 16,
         *     "type": "sell",
         *     "user": {
         *         "id": 1,
         *         "name": "Jennifer Long"
         *     },
         *     "symbol": "A",
         *     "shares": 25,
         *     "price": 149.35,
         *     "timestamp": "2017-01-03 11:59:32"
         * }
         */
        json = "{\"id\": 16, \"type\": \"sell\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"A\", \"shares\": 25, \"price\": 149.35, \"timestamp\": \"2017-01-03 11:59:32\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 17
         *
         * The request body is:
         * {
         *     "id": 17,
         *     "type": "sell",
         *     "user": {
         *         "id": 1,
         *         "name": "Jennifer Long"
         *     },
         *     "symbol": "MMS",
         *     "shares": 25,
         *     "price": 182.01,
         *     "timestamp": "2017-01-03 14:27:42"
         * }
         */
        json = "{\"id\": 17, \"type\": \"sell\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"MMS\", \"shares\": 25, \"price\": 182.01, \"timestamp\": \"2017-01-03 14:27:42\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 18
         *
         * The request body is:
         * {
         *     "id": 18,
         *     "type": "sell",
         *     "user": {
         *         "id": 1,
         *         "name": "Jennifer Long"
         *     },
         *     "symbol": "MMS",
         *     "shares": 19,
         *     "price": 171.17,
         *     "timestamp": "2017-01-05 15:43:00"
         * }
         */
        json = "{\"id\": 18, \"type\": \"sell\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"MMS\", \"shares\": 19, \"price\": 171.17, \"timestamp\": \"2017-01-05 15:43:00\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());
    }

    /**
     *
     * @throws Exception
     *
     * It tests creating trade
     */
    @Test
    @Order(2)
    public void createTradeWithExistingId() throws Exception {
        /**
         *
         * Create trade with existing id 1
         *
         * The request body is:
         * {
         *     "id": 1,
         *     "type": "buy",
         *     "user": {
         *         "id": 4,
         *         "name": "Derrick Garcia"
         *     },
         *     "symbol": "ZAYO",
         *     "shares": 11,
         *     "price": 154.77,
         *     "timestamp": "2016-12-28 11:44:37"
         * }
         */
        String json = "{\"id\": 1, \"type\": \"buy\", \"user\": {\"id\": 4, \"name\": \"Derrick Garcia\"}, \"symbol\": \"ZAYO\", \"shares\": 11, \"price\": 154.77, \"timestamp\": \"2016-12-28 11:44:37\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isBadRequest());
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding trade
     */
    @Test
    @Order(3)
    public void findTradeById() throws Exception {
        /**
         *
         * Find trade by id 1
         *
         * The request response is:
         * {
         *     "id": 1,
         *     "type": "buy",
         *     "user": {
         *         "id": 4,
         *         "name": "Derrick Garcia"
         *     },
         *     "symbol": "ZAYO",
         *     "shares": 11,
         *     "price": 154.77,
         *     "timestamp": "2016-12-28 11:44:37"
         * }
         */
        String res = "{\"id\": 1, \"type\": \"buy\", \"user\": {\"id\": 4, \"name\": \"Derrick Garcia\"}, \"symbol\": \"ZAYO\", \"shares\": 11, \"price\": 154.77, \"timestamp\": \"2016-12-28 11:44:37\"}";

        assertTrue(
                ResultMatcher.matchJson(
                        mockMvc.perform(get("/trades/1"))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        res,
                        true));
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding trade
     */
    @Test
    @Order(4)
    public void findTradeByNonExistingId() throws Exception {
        /**
         *
         * Find trade by non-existing id 19
         */
        mockMvc.perform(get("/trades/19"))
                .andExpect(status().isNotFound());
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding trades by user id
     */
    @Test
    @Order(5)
    public void findAllTradesByUserId() throws Exception {
        /**
         *
         * Find all the trades by user id 1
         *
         * The request response is:
         * [
         *     {
         *         "id": 2,
         *         "type": "buy",
         *         "user": {
         *             "id": 1,
         *             "name": "Jennifer Long"
         *         },
         *         "symbol": "A",
         *         "shares": 19,
         *         "price": 153.57,
         *         "timestamp": "2016-12-28 13:15:52"
         *     },
         *     {
         *         "id": 10,
         *         "type": "buy",
         *         "user": {
         *             "id": 1,
         *             "name": "Jennifer Long"
         *         },
         *         "symbol": "MMS",
         *         "shares": 28,
         *         "price": 152.93,
         *         "timestamp": "2016-12-30 14:48:14"
         *     },
         *     {
         *         "id": 14,
         *         "type": "buy",
         *         "user": {
         *             "id": 1,
         *             "name": "Jennifer Long"
         *         },
         *         "symbol": "A",
         *         "shares": 30,
         *         "price": 136.68,
         *         "timestamp": "2016-12-31 15:29:15"
         *     },
         *     {
         *         "id": 15,
         *         "type": "buy",
         *         "user": {
         *             "id": 1,
         *             "name": "Jennifer Long"
         *         },
         *         "symbol": "MMS",
         *         "shares": 29,
         *         "price": 168.67,
         *         "timestamp": "2016-12-31 15:47:40"
         *     },
         *     {
         *         "id": 16,
         *         "type": "sell",
         *         "user": {
         *             "id": 1,
         *             "name": "Jennifer Long"
         *         },
         *         "symbol": "A",
         *         "shares": 25,
         *         "price": 149.35,
         *         "timestamp": "2017-01-03 11:59:32"
         *     },
         *     {
         *         "id": 17,
         *         "type": "sell",
         *         "user": {
         *             "id": 1,
         *             "name": "Jennifer Long"
         *         },
         *         "symbol": "MMS",
         *         "shares": 25,
         *         "price": 182.01,
         *         "timestamp": "2017-01-03 14:27:42"
         *     },
         *     {
         *         "id": 18,
         *         "type": "sell",
         *         "user": {
         *             "id": 1,
         *             "name": "Jennifer Long"
         *         },
         *         "symbol": "MMS",
         *         "shares": 19,
         *         "price": 171.17,
         *         "timestamp": "2017-01-05 15:43:00"
         *     }
         * ]
         */
        String res = "[{\"id\": 2, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"A\", \"shares\": 19, \"price\": 153.57, \"timestamp\": \"2016-12-28 13:15:52\"}, {\"id\": 10, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"MMS\", \"shares\": 28, \"price\": 152.93, \"timestamp\": \"2016-12-30 14:48:14\"}, {\"id\": 14, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"A\", \"shares\": 30, \"price\": 136.68, \"timestamp\": \"2016-12-31 15:29:15\"}, {\"id\": 15, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"MMS\", \"shares\": 29, \"price\": 168.67, \"timestamp\": \"2016-12-31 15:47:40\"}, {\"id\": 16, \"type\": \"sell\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"A\", \"shares\": 25, \"price\": 149.35, \"timestamp\": \"2017-01-03 11:59:32\"}, {\"id\": 17, \"type\": \"sell\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"MMS\", \"shares\": 25, \"price\": 182.01, \"timestamp\": \"2017-01-03 14:27:42\"}, {\"id\": 18, \"type\": \"sell\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"MMS\", \"shares\": 19, \"price\": 171.17, \"timestamp\": \"2017-01-05 15:43:00\"}]";

        assertTrue(
                ResultMatcher.matchJsonArray(
                        mockMvc.perform(get("/trades/users/1"))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        res,
                        true));
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding trades by non-existing user id
     */
    @Test
    @Order(6)
    public void findAllTradesByNonExistingUserId() throws Exception {
        /**
         *
         * Find all the trades by user id 5
         */
        mockMvc.perform(get("/trades/users/5"))
                .andExpect(status().isNotFound());
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding trades by stock symbol and trade type in given date range
     */
    @Test
    @Order(7)
    public void findAllTradesByStockSymbolAndTradeTypeInDateRange() throws Exception {
        /**
         *
         * Find all the trades by stock symbol A and trade type sell in given date range 2016-12-28 and 2017-01-03 inclusive
         *
         * The request response is:
         * [
         *     {
         *         "id": 16,
         *         "type": "sell",
         *         "user": {
         *             "id": 1,
         *             "name": "Jennifer Long"
         *         },
         *         "symbol": "A",
         *         "shares": 25,
         *         "price": 149.35,
         *         "timestamp": "2017-01-03 11:59:32"
         *     }
         * ]
         */
        String res = "[{\"id\": 16, \"type\": \"sell\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"A\", \"shares\": 25, \"price\": 149.35, \"timestamp\": \"2017-01-03 11:59:32\"}]";

        assertTrue(
                ResultMatcher.matchJsonArray(
                        mockMvc.perform(get("/trades/stocks/A?type=sell&start=2016-12-28&end=2017-01-03"))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        res,
                        true));

        /**
         *
         * Find all the trades by stock symbol MMS and trade type sell in given date range 2016-12-29 and 2016-12-31 inclusive
         *
         * The request response is:
         * []
         */
        res = "[]";

        assertTrue(
                ResultMatcher.matchJsonArray(
                        mockMvc.perform(get("/trades/stocks/MMS?type=sell&start=2016-12-29&end=2016-12-31"))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        res,
                        true));

        /**
         *
         * Find all the trades by stock symbol WEX and trade type buy in given date range 2016-12-28 and 2017-01-02 inclusive
         *
         * The request response is:
         * [
         *     {
         *         "id": 5,
         *         "type": "buy",
         *         "user": {
         *             "id": 2,
         *             "name": "Daniel Cortez"
         *         },
         *         "symbol": "WEX",
         *         "shares": 10,
         *         "price": 190.73,
         *         "timestamp": "2016-12-29 09:05:23"
         *     },
         *     {
         *         "id": 8,
         *         "type": "buy",
         *         "user": {
         *             "id": 4,
         *             "name": "Derrick Garcia"
         *         },
         *         "symbol": "WEX",
         *         "shares": 11,
         *         "price": 172.35,
         *         "timestamp": "2016-12-30 13:07:19"
         *     },
         *     {
         *         "id": 12,
         *         "type": "buy",
         *         "user": {
         *             "id": 2,
         *             "name": "Daniel Cortez"
         *         },
         *         "symbol": "WEX",
         *         "shares": 18,
         *         "price": 172.35,
         *         "timestamp": "2016-12-31 12:01:56"
         *     }
         * ]
         */
        res = "[{\"id\": 5, \"type\": \"buy\", \"user\": {\"id\": 2, \"name\": \"Daniel Cortez\"}, \"symbol\": \"WEX\", \"shares\": 10, \"price\": 190.73, \"timestamp\": \"2016-12-29 09:05:23\"}, {\"id\": 8, \"type\": \"buy\", \"user\": {\"id\": 4, \"name\": \"Derrick Garcia\"}, \"symbol\": \"WEX\", \"shares\": 11, \"price\": 172.35, \"timestamp\": \"2016-12-30 13:07:19\"}, {\"id\": 12, \"type\": \"buy\", \"user\": {\"id\": 2, \"name\": \"Daniel Cortez\"}, \"symbol\": \"WEX\", \"shares\": 18, \"price\": 172.35, \"timestamp\": \"2016-12-31 12:01:56\"}]";

        assertTrue(
                ResultMatcher.matchJsonArray(
                        mockMvc.perform(get("/trades/stocks/WEX?type=buy&start=2016-12-28&end=2017-01-02"))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        res,
                        true));

        /**
         *
         * Find all the trades by stock symbol ZAYO and trade type buy in given date range 2016-12-29 and 2017-01-01 inclusive
         *
         * The request response is:
         * [
         *     {
         *         "id": 6,
         *         "type": "buy",
         *         "user": {
         *             "id": 4,
         *             "name": "Derrick Garcia"
         *         },
         *         "symbol": "ZAYO",
         *         "shares": 30,
         *         "price": 137.86,
         *         "timestamp": "2016-12-30 11:42:40"
         *     },
         *     {
         *         "id": 9,
         *         "type": "buy",
         *         "user": {
         *             "id": 3,
         *             "name": "Connie Palmer"
         *         },
         *         "symbol": "ZAYO",
         *         "shares": 25,
         *         "price": 154.77,
         *         "timestamp": "2016-12-30 13:36:20"
         *     },
         *     {
         *         "id": 11,
         *         "type": "buy",
         *         "user": {
         *             "id": 3,
         *             "name": "Connie Palmer"
         *         },
         *         "symbol": "ZAYO",
         *         "shares": 30,
         *         "price": 154.77,
         *         "timestamp": "2016-12-31 09:59:16"
         *     }
         * ]
         */
        res = "[{\"id\": 6, \"type\": \"buy\", \"user\": {\"id\": 4, \"name\": \"Derrick Garcia\"}, \"symbol\": \"ZAYO\", \"shares\": 30, \"price\": 137.86, \"timestamp\": \"2016-12-30 11:42:40\"}, {\"id\": 9, \"type\": \"buy\", \"user\": {\"id\": 3, \"name\": \"Connie Palmer\"}, \"symbol\": \"ZAYO\", \"shares\": 25, \"price\": 154.77, \"timestamp\": \"2016-12-30 13:36:20\"}, {\"id\": 11, \"type\": \"buy\", \"user\": {\"id\": 3, \"name\": \"Connie Palmer\"}, \"symbol\": \"ZAYO\", \"shares\": 30, \"price\": 154.77, \"timestamp\": \"2016-12-31 09:59:16\"}]";

        assertTrue(
                ResultMatcher.matchJsonArray(
                        mockMvc.perform(get("/trades/stocks/ZAYO?type=buy&start=2016-12-29&end=2017-01-01"))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        res,
                        true));
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding trades by non-existing stock symbol and trade type in given date range
     */
    @Test
    @Order(8)
    public void findAllTradesByNonExistingStockSymbolAndTradeTypeInDateRange() throws Exception {
        /**
         *
         * Find all the trades by stock symbol AB and trade type buy in given date range 2016-12-28 and 2016-12-29 inclusive
         */
        mockMvc.perform(get("/trades/stocks/AB?type=buy&start=2016-12-28&end=2016-12-29"))
                .andExpect(status().isNotFound());
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding all the trades
     */
    @Test
    @Order(9)
    public void findAllTrades() throws Exception {
        /**
         *
         * Find all the trades
         *
         * The request response is:
         * [
         *     {
         *         "id": 1,
         *         "type": "buy",
         *         "user": {
         *             "id": 4,
         *             "name": "Derrick Garcia"
         *         },
         *         "symbol": "ZAYO",
         *         "shares": 11,
         *         "price": 154.77,
         *         "timestamp": "2016-12-28 11:44:37"
         *     },
         *     {
         *         "id": 2,
         *         "type": "buy",
         *         "user": {
         *             "id": 1,
         *             "name": "Jennifer Long"
         *         },
         *         "symbol": "A",
         *         "shares": 19,
         *         "price": 153.57,
         *         "timestamp": "2016-12-28 13:15:52"
         *     },
         *     {
         *         "id": 3,
         *         "type": "buy",
         *         "user": {
         *             "id": 4,
         *             "name": "Derrick Garcia"
         *         },
         *         "symbol": "A",
         *         "shares": 12,
         *         "price": 135.89,
         *         "timestamp": "2016-12-28 13:18:18"
         *     },
         *     {
         *         "id": 4,
         *         "type": "buy",
         *         "user": {
         *             "id": 2,
         *             "name": "Daniel Cortez"
         *         },
         *         "symbol": "MMS",
         *         "shares": 15,
         *         "price": 183.45,
         *         "timestamp": "2016-12-28 15:15:50"
         *     },
         *     {
         *         "id": 5,
         *         "type": "buy",
         *         "user": {
         *             "id": 2,
         *             "name": "Daniel Cortez"
         *         },
         *         "symbol": "WEX",
         *         "shares": 10,
         *         "price": 190.73,
         *         "timestamp": "2016-12-29 09:05:23"
         *     },
         *     {
         *         "id": 6,
         *         "type": "buy",
         *         "user": {
         *             "id": 4,
         *             "name": "Derrick Garcia"
         *         },
         *         "symbol": "ZAYO",
         *         "shares": 30,
         *         "price": 137.86,
         *         "timestamp": "2016-12-30 11:42:40"
         *     },
         *     {
         *         "id": 7,
         *         "type": "buy",
         *         "user": {
         *             "id": 2,
         *             "name": "Daniel Cortez"
         *         },
         *         "symbol": "MMS",
         *         "shares": 19,
         *         "price": 183.45,
         *         "timestamp": "2016-12-30 12:35:21"
         *     },
         *     {
         *         "id": 8,
         *         "type": "buy",
         *         "user": {
         *             "id": 4,
         *             "name": "Derrick Garcia"
         *         },
         *         "symbol": "WEX",
         *         "shares": 11,
         *         "price": 172.35,
         *         "timestamp": "2016-12-30 13:07:19"
         *     },
         *     {
         *         "id": 9,
         *         "type": "buy",
         *         "user": {
         *             "id": 3,
         *             "name": "Connie Palmer"
         *         },
         *         "symbol": "ZAYO",
         *         "shares": 25,
         *         "price": 154.77,
         *         "timestamp": "2016-12-30 13:36:20"
         *     },
         *     {
         *         "id": 10,
         *         "type": "buy",
         *         "user": {
         *             "id": 1,
         *             "name": "Jennifer Long"
         *         },
         *         "symbol": "MMS",
         *         "shares": 28,
         *         "price": 152.93,
         *         "timestamp": "2016-12-30 14:48:14"
         *     },
         *     {
         *         "id": 11,
         *         "type": "buy",
         *         "user": {
         *             "id": 3,
         *             "name": "Connie Palmer"
         *         },
         *         "symbol": "ZAYO",
         *         "shares": 30,
         *         "price": 154.77,
         *         "timestamp": "2016-12-31 09:59:16"
         *     },
         *     {
         *         "id": 12,
         *         "type": "buy",
         *         "user": {
         *             "id": 2,
         *             "name": "Daniel Cortez"
         *         },
         *         "symbol": "WEX",
         *         "shares": 18,
         *         "price": 172.35,
         *         "timestamp": "2016-12-31 12:01:56"
         *     },
         *     {
         *         "id": 13,
         *         "type": "buy",
         *         "user": {
         *             "id": 3,
         *             "name": "Connie Palmer"
         *         },
         *         "symbol": "A",
         *         "shares": 22,
         *         "price": 135.89,
         *         "timestamp": "2016-12-31 13:27:40"
         *     },
         *     {
         *         "id": 14,
         *         "type": "buy",
         *         "user": {
         *             "id": 1,
         *             "name": "Jennifer Long"
         *         },
         *         "symbol": "A",
         *         "shares": 30,
         *         "price": 136.68,
         *         "timestamp": "2016-12-31 15:29:15"
         *     },
         *     {
         *         "id": 15,
         *         "type": "buy",
         *         "user": {
         *             "id": 1,
         *             "name": "Jennifer Long"
         *         },
         *         "symbol": "MMS",
         *         "shares": 29,
         *         "price": 168.67,
         *         "timestamp": "2016-12-31 15:47:40"
         *     },
         *     {
         *         "id": 16,
         *         "type": "sell",
         *         "user": {
         *             "id": 1,
         *             "name": "Jennifer Long"
         *         },
         *         "symbol": "A",
         *         "shares": 25,
         *         "price": 149.35,
         *         "timestamp": "2017-01-03 11:59:32"
         *     },
         *     {
         *         "id": 17,
         *         "type": "sell",
         *         "user": {
         *             "id": 1,
         *             "name": "Jennifer Long"
         *         },
         *         "symbol": "MMS",
         *         "shares": 25,
         *         "price": 182.01,
         *         "timestamp": "2017-01-03 14:27:42"
         *     },
         *     {
         *         "id": 18,
         *         "type": "sell",
         *         "user": {
         *             "id": 1,
         *             "name": "Jennifer Long"
         *         },
         *         "symbol": "MMS",
         *         "shares": 19,
         *         "price": 171.17,
         *         "timestamp": "2017-01-05 15:43:00"
         *     }
         * ]
         */
        String res = "[{\"id\": 1, \"type\": \"buy\", \"user\": {\"id\": 4, \"name\": \"Derrick Garcia\"}, \"symbol\": \"ZAYO\", \"shares\": 11, \"price\": 154.77, \"timestamp\": \"2016-12-28 11:44:37\"}, {\"id\": 2, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"A\", \"shares\": 19, \"price\": 153.57, \"timestamp\": \"2016-12-28 13:15:52\"}, {\"id\": 3, \"type\": \"buy\", \"user\": {\"id\": 4, \"name\": \"Derrick Garcia\"}, \"symbol\": \"A\", \"shares\": 12, \"price\": 135.89, \"timestamp\": \"2016-12-28 13:18:18\"}, {\"id\": 4, \"type\": \"buy\", \"user\": {\"id\": 2, \"name\": \"Daniel Cortez\"}, \"symbol\": \"MMS\", \"shares\": 15, \"price\": 183.45, \"timestamp\": \"2016-12-28 15:15:50\"}, {\"id\": 5, \"type\": \"buy\", \"user\": {\"id\": 2, \"name\": \"Daniel Cortez\"}, \"symbol\": \"WEX\", \"shares\": 10, \"price\": 190.73, \"timestamp\": \"2016-12-29 09:05:23\"}, {\"id\": 6, \"type\": \"buy\", \"user\": {\"id\": 4, \"name\": \"Derrick Garcia\"}, \"symbol\": \"ZAYO\", \"shares\": 30, \"price\": 137.86, \"timestamp\": \"2016-12-30 11:42:40\"}, {\"id\": 7, \"type\": \"buy\", \"user\": {\"id\": 2, \"name\": \"Daniel Cortez\"}, \"symbol\": \"MMS\", \"shares\": 19, \"price\": 183.45, \"timestamp\": \"2016-12-30 12:35:21\"}, {\"id\": 8, \"type\": \"buy\", \"user\": {\"id\": 4, \"name\": \"Derrick Garcia\"}, \"symbol\": \"WEX\", \"shares\": 11, \"price\": 172.35, \"timestamp\": \"2016-12-30 13:07:19\"}, {\"id\": 9, \"type\": \"buy\", \"user\": {\"id\": 3, \"name\": \"Connie Palmer\"}, \"symbol\": \"ZAYO\", \"shares\": 25, \"price\": 154.77, \"timestamp\": \"2016-12-30 13:36:20\"}, {\"id\": 10, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"MMS\", \"shares\": 28, \"price\": 152.93, \"timestamp\": \"2016-12-30 14:48:14\"}, {\"id\": 11, \"type\": \"buy\", \"user\": {\"id\": 3, \"name\": \"Connie Palmer\"}, \"symbol\": \"ZAYO\", \"shares\": 30, \"price\": 154.77, \"timestamp\": \"2016-12-31 09:59:16\"}, {\"id\": 12, \"type\": \"buy\", \"user\": {\"id\": 2, \"name\": \"Daniel Cortez\"}, \"symbol\": \"WEX\", \"shares\": 18, \"price\": 172.35, \"timestamp\": \"2016-12-31 12:01:56\"}, {\"id\": 13, \"type\": \"buy\", \"user\": {\"id\": 3, \"name\": \"Connie Palmer\"}, \"symbol\": \"A\", \"shares\": 22, \"price\": 135.89, \"timestamp\": \"2016-12-31 13:27:40\"}, {\"id\": 14, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"A\", \"shares\": 30, \"price\": 136.68, \"timestamp\": \"2016-12-31 15:29:15\"}, {\"id\": 15, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"MMS\", \"shares\": 29, \"price\": 168.67, \"timestamp\": \"2016-12-31 15:47:40\"}, {\"id\": 16, \"type\": \"sell\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"A\", \"shares\": 25, \"price\": 149.35, \"timestamp\": \"2017-01-03 11:59:32\"}, {\"id\": 17, \"type\": \"sell\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"MMS\", \"shares\": 25, \"price\": 182.01, \"timestamp\": \"2017-01-03 14:27:42\"}, {\"id\": 18, \"type\": \"sell\", \"user\": {\"id\": 1, \"name\": \"Jennifer Long\"}, \"symbol\": \"MMS\", \"shares\": 19, \"price\": 171.17, \"timestamp\": \"2017-01-05 15:43:00\"}]";

        assertTrue(
                ResultMatcher.matchJsonArray(
                        mockMvc.perform(get("/trades"))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        res,
                        true));
    }
}

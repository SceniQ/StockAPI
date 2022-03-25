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
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(OrderedTestRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StocksControllerTest {

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
        TestWatchman.watchman.registerClass(StocksControllerTest.class);
    }

    @AfterClass
    public static void tearDownClass() {
        TestWatchman.watchman.createReport(StocksControllerTest.class);
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding highest and lowest price by stock symbol in given date range
     */
    @Test
    @Order(1)
    public void findHighestAndLowestPriceByStockSymbolInDateRange() throws Exception {
        /**
         *
         * Find highest and lowest price by stock symbol A in given date range 2016-12-29 and 2017-01-03 inclusive
         *
         * The request response is:
         * {
         *     "symbol": "A",
         *     "highest": 149.35,
         *     "lowest": 135.89
         * }
         */
        String res = "{\"symbol\": \"A\", \"highest\": 149.35, \"lowest\": 135.89}";

        assertTrue(
                ResultMatcher.matchJson(
                        mockMvc.perform(get("/stocks/A/price?start=2016-12-29&end=2017-01-03"))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        res,
                        true));

        /**
         *
         * Find highest and lowest price by stock symbol MMS in given date range 2016-12-30 and 2017-01-03 inclusive
         *
         * The request response is:
         * {
         *     "symbol": "MMS",
         *     "highest": 183.45,
         *     "lowest": 152.93
         * }
         */
        res = "{\"symbol\": \"MMS\", \"highest\": 183.45, \"lowest\": 152.93}";

        assertTrue(
                ResultMatcher.matchJson(
                        mockMvc.perform(get("/stocks/MMS/price?start=2016-12-30&end=2017-01-03"))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        res,
                        true));

        /**
         *
         * Find highest and lowest price by stock symbol WEX in given date range 2016-12-30 and 2017-01-03 inclusive
         *
         * The request response is:
         * {
         *     "symbol": "WEX",
         *     "highest": 172.35,
         *     "lowest": 172.35
         * }
         */
        res = "{\"symbol\": \"WEX\", \"highest\": 172.35, \"lowest\": 172.35}";

        assertTrue(
                ResultMatcher.matchJson(
                        mockMvc.perform(get("/stocks/WEX/price?start=2016-12-30&end=2017-01-03"))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        res,
                        true));

        /**
         *
         * Find highest and lowest price by stock symbol ZAYO in given date range 2017-01-05 and 2017-01-06 inclusive
         *
         * The request response is:
         * {
         *     "message": "There are no trades in the given date range"
         * }
         */
        res = "{\"message\": \"There are no trades in the given date range\"}";

        assertTrue(
                ResultMatcher.matchJson(
                        mockMvc.perform(get("/stocks/ZAYO/price?start=2017-01-05&end=2017-01-06"))
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
     * It tests finding highest and lowest price by stock symbol in given date range
     */
    @Test
    @Order(2)
    public void findHighestAndLowestPriceByNonExistingStockSymbolInDateRange() throws Exception {
        /**
         *
         * Find highest and lowest price by stock symbol AB in given date range 2016-12-28 and 2016-12-29 inclusive
         */
        mockMvc.perform(get("/stocks/AB/price?start=2016-12-28&end=2016-12-29"))
                .andExpect(status().isNotFound());
    }
}

package com.hackerrank.stocktrade.requests;

import com.hackerrank.test.utility.TestWatchman;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NoResourcesStocksControllerTest {

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
        TestWatchman.watchman.registerClass(NoResourcesStocksControllerTest.class);
    }

    @AfterClass
    public static void tearDownClass() {
        TestWatchman.watchman.createReport(NoResourcesStocksControllerTest.class);
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding highest and lowest price by stock symbol in given date range
     */
    @Test
    public void findHighestAndLowestPriceByNonExistingStockSymbolInDateRange() throws Exception {
        /**
         *
         * Find highest and lowest price by stock symbol A in given date range 2017-01-05 and 2017-01-06 inclusive
         */
        mockMvc.perform(get("/stocks/A/price?start=2017-01-05&end=2017-01-06"))
                .andExpect(status().isNotFound());
    }
}

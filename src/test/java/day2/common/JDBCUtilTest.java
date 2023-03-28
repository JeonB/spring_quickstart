package day2.common;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class JDBCUtilTest {

    @org.junit.jupiter.api.Test
    void getConnection() {

        Connection conn = JDBCUtil.getConnection();
        assertNotNull(conn);
    }

    @org.junit.jupiter.api.Test
    void close() {
    }

    @org.junit.jupiter.api.Test
    void testClose() {
    }
}
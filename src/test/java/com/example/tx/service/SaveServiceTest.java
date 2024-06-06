package com.example.tx.service;

import com.example.tx.domain.Customer;
import com.example.tx.domain.Point;
import com.example.tx.repository.PointRepository;
import com.example.tx.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;


@SpringBootTest
class SaveServiceTest {

    @Autowired
    private SaveService saveService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PointRepository pointRepository;
    @Test
    void 새로운_유저_저장() {
        /*
        saveService.createNewCustomer();

        // 사용자와 포인트 정보가 데이터베이스에 저장되었는지 검증
        Customer user = customerRepository.findByUserName("test").orElse(null);
        System.out.println("customer user name ======> " + user.getUserName());
        assertEquals("test", user.getUserName());

        Point point = pointRepository.findByUserId(user.getId()).orElse(null);
        System.out.println("point ===> " + point.getPoint());
        assertEquals(100, point.getPoint());
        */

        Exception thrown = assertThrows(RuntimeException.class, () -> {
            saveService.createNewCustomer();
        });

        String expectedMessage = "Intentional exception for rollback";
        String actualMessage = thrown.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        assertFalse(customerRepository.findByUserName("test").isPresent());
        assertTrue(pointRepository.findByUserId(anyLong()).isEmpty());

        System.out.println("im main");
        System.out.println("test");
        System.out.println("test-1");
        System.out.println("test-1-1");
        System.out.println("test2");
        System.out.println("test2");

        System.out.println("main~!");
        System.out.println("rb1");
        System.out.println("rb1-1");
        System.out.println("rb1");
        System.out.println("rb2");

        System.out.println("main!");
        System.out.println("test-rb1");
    }

}

package com.example.tx.service;

import com.example.tx.domain.Point;
import com.example.tx.domain.Customer;
import com.example.tx.repository.PointRepository;
import com.example.tx.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SaveService {

    private final CustomerRepository customerRepository;
    private final PointRepository pointRepository;

    public void createNewCustomer() {
        saveCustomer();
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveCustomer() {
        try {
            Customer savedCustomer = customerRepository.save(
                    Customer.builder().userName("test").build());
            savePoint(savedCustomer.getId());
        } catch (Exception e) {
            log.error("Error saving customer and point", e);
        }
    }

    public void savePoint(long userId) throws Exception {
        pointRepository.save(Point.builder()
                .userId(userId)
                .point(100)
                .build());

        throw new Exception("Intentional exception for rollback");
    }
}

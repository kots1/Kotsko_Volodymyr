package com.epam.homework.delivery.repository;

import com.epam.homework.delivery.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

    @Query(value ="select * from orders u where u.user_id = ?1",nativeQuery = true)
    List<Order> findAllByUserId(Long userId);
    List<Order> findAll();
    Page<Order> findAll(Pageable pageable);


    @Query(value ="select o from Order o where o.direction.id = ?1")
    List<Order> findAllByDirectionId(Long directionId);

    @Query(value ="select o from Order o where o.tariff.id = ?1")
    List<Order> findAllByTariffId(Long tariffId);

}

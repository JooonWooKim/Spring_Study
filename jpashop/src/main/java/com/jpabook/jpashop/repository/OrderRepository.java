package com.jpabook.jpashop.repository;

import com.jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Order order){
        em.persist(order);
    }

    public Order findOne(Long id){
        return em.find(Order.class, id);
    }

    /**
     * Querydsl로 처리
     */
//    public List<Order> findAll(OrderSearch orderSearch){
//        QOrder order = Qorder.order;
//        QMember member = QMember.meber;
//
//        return query
//                .select(order)
//                .
//        String jpql = "select o from Order o join o.member m";
//
//        return em.createQuery(jpql, Order.class)
//                .setMaxResults(1000)    //최대 1000건
//                .getResultList();
//    }
}

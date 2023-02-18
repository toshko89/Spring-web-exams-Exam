package com.example.exam.repository;

import com.example.exam.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OfferRepo extends JpaRepository<Offer,Long> {
    Set<Offer> findAllBySellerId(long id);

    Set<Offer> findAllPostsBySellerIdNot(long id);
}

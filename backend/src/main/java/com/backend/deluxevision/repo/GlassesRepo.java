package com.backend.deluxevision.repo;

import com.backend.deluxevision.model.Glasses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GlassesRepo extends JpaRepository<Glasses, Long> {
    void deleteGlassesById(Long id);
    Optional<Glasses> findGlassesById(Long id);
    Optional<Glasses> findGlassesByName(String name);
//    List<Glasses> getTopTenGlasses();
    List<Glasses> getGlassesByCategory(String category);
/*
  @Query(value = "select glasses.id, name, shape, brand, glasses.price, category, sum(qty) as quantity, sum(qty * glasses.price) as totalprice from glasses, pi where book.bid = pi.bid group by book.bid, title, author, book.price, category", nativeQuery = true)
    List getGlassesReport();

    @Query(value = "select book.bid, title, sum(qty) as quantity, sum(qty * book.price) as totalsales from book, pi where book.bid = pi.bid group by book.bid, title order by quantity DESC LIMIT 10", nativeQuery = true)
    List getTopTenGlasses();

    @Query(value = "select * from book where bid=:bid", nativeQuery = true)
    List<Book> getProductInfo(@Param("bid") String bid);*/
}

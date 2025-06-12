package com.stok.takipstok;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Product, Long> ile hem sınıf türünü hem ID türünü belirtiyoruz
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Ekstra bir şey yazmana gerek yok, tüm CRUD işlemleri otomatik!
}

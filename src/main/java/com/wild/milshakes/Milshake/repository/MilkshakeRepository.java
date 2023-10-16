package com.wild.milshakes.Milshake.repository;

import com.wild.milshakes.Milshake.entity.Milkshake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MilkshakeRepository extends JpaRepository<Milkshake, Long> {

}

package com.escalab.repo;

import com.escalab.model.ResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResetTokenRepo extends JpaRepository<ResetToken, Integer> {

    ResetToken findByToken(String token);
}

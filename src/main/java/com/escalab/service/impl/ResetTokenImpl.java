package com.escalab.service.impl;

import com.escalab.model.ResetToken;
import com.escalab.repo.IResetTokenRepo;
import com.escalab.service.IResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;

public class ResetTokenImpl implements IResetTokenService {

    @Autowired
    private IResetTokenRepo repo;

    @Override
    public ResetToken findByToken(String token) {
        return repo.findByToken(token);
    }

    @Override
    public void guardar(ResetToken token) {
        repo.save(token);
    }

    @Override
    public void eliminar(ResetToken token) {
        repo.delete(token);
    }
}

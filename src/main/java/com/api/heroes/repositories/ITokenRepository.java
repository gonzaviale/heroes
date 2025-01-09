package com.api.heroes.repositories;

import com.api.heroes.models.TokenModel;
import com.api.heroes.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ITokenRepository extends JpaRepository<TokenModel, Long> {
    List<TokenModel> findAllValidTokenByUser(UserModel user);
    Optional<TokenModel> findByToken(String token);
}

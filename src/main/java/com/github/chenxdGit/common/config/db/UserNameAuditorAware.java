package com.github.chenxdGit.common.config.db;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import com.github.chenxdGit.common.util.UserInfoUtil;

@Component
public class UserNameAuditorAware implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
        return Optional.of(UserInfoUtil.getCommonId());
    }
}
package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.RegisterDto;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface RegisterService {

    void register(RegisterDto register) throws Exception;

    int init(String user_id) throws Exception;
}

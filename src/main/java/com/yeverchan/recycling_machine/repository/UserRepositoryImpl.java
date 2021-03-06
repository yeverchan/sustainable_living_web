package com.yeverchan.recycling_machine.repository;

import com.yeverchan.recycling_machine.domain.RegisterDto;
import com.yeverchan.recycling_machine.domain.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    SqlSession sqlSession;

    String namespace = "com.yeverchan.recycling_machine.repository.BoardMapper.";

    @Override
    public UserDto select(String id) throws Exception {
        return sqlSession.selectOne(namespace + "select", id);
    }

    @Override
    public UserDto selectUser(String id) throws Exception {
        return sqlSession.selectOne(namespace + "selectUser", id);
    }

    @Override
    public UserDto selectEmail(String email) throws Exception {
        return sqlSession.selectOne(namespace + "selectEmail", email);
    }

    @Override
    public int insert(RegisterDto register) throws Exception {
        UserDto user = new UserDto();
        user.setId(register.getId());
        user.setPassword(register.getPassword());
        user.setEmail(register.getEmail());
        user.setName(register.getName());
        return sqlSession.insert(namespace + "insert", user);
    }

    @Override
    public void updateName(Map<String, String> name) {
        sqlSession.update(namespace + "updateName", name);
    }

    @Override
    public void updateEmail(Map<String, String> email) {
        sqlSession.update(namespace + "updateEmail", email);
    }

    @Override
    public void updatePwd(Map<String, String> pwd) {
        sqlSession.update(namespace + "updatePwd", pwd);
    }
}

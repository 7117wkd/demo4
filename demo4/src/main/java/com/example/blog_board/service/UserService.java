package com.example.blog_board.service;

import com.example.blog_board.domain.User;
import com.example.blog_board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService implements userDetailsService {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);

    private final BoardMapper userMapper;

    @Transactional
    public void joinUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setUserPw(passwordEncoder.encode(user.getPassword()));
        user.setUserAuth("USER");
        user.setAppendDate(localTime);
        user.setUpdateDate(localTime);
        userMapper.saveUser(user);
    }

    @Override
    public User loadUserByUsername(String userId) throws UsernameNotFoundException {
        //여기서 받은 유저 패스워드와 비교하여 로그인 인증
        User userVo = userMapper.getUserAccount(userId);
        if (userVo == null) {
            throw new UsernameNotFoundException("User not authorized.");
        }
        return userVo;
    }
}

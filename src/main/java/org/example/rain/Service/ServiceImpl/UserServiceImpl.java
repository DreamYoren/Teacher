package org.example.rain.Service.ServiceImpl;

import org.example.rain.Entity.Admin;
import org.example.rain.Entity.User;
import org.example.rain.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper AdminMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = AdminMapper.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), admin.getPassword(), AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
    }

    public int updatePassword(Long userId, String oldPassword, String newPassword) {
        Admin admin = AdminMapper.selectById(userId);
        if (admin == null) {
            throw new RuntimeException("用户不存在");
        }
        if (!passwordEncoder().matches(oldPassword, admin.getPassword())) {
            throw new RuntimeException("旧密码错误");
        }
        admin.setPassword(passwordEncoder().encode(newPassword));
        return AdminMapper.updateById(admin);
    }
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

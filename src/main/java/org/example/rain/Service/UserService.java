package org.example.rain.Service;

import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    void updatePassword(Long id, String oldPassword, String newPassword);
}

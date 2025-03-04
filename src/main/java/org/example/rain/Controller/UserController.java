package org.example.rain.Controller;

import org.example.rain.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        // Spring Security会自动处理登录验证
        return ResponseEntity.ok("登录成功");
    }

    @PostMapping("/updatePassword")
    public ResponseEntity<?> updatePassword(@RequestParam Long id,
                                            @RequestParam String oldPassword,
                                            @RequestParam String newPassword) {
        adminService.updatePassword(id, oldPassword, newPassword);
        return ResponseEntity.ok("密码修改成功");
    }
}

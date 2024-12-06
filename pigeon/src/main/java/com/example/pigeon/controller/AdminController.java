package com.example.pigeon.controller;


import com.example.pigeon.dto.UtilisateurDto;
import com.example.pigeon.entity.Role;
import com.example.pigeon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public ResponseEntity<List<UtilisateurDto>> getAllUtilisateurs() {
        List<UtilisateurDto> utilisateurs = userService.getAllUtilisateurs()
                .stream()
                .map(UtilisateurDto::toDto)
                .toList();
        return ResponseEntity.ok(utilisateurs);
    }


    @PutMapping("/users/{userId}/role")
    public ResponseEntity<UtilisateurDto> changeUserRole(
            @PathVariable Long userId,
            @RequestBody Role newRole) {
        UtilisateurDto updatedUser = userService.changeUserRole(userId, newRole);
        return ResponseEntity.ok(updatedUser);
    }
}

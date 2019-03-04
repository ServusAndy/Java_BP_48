package com.telran.controllers;

import com.telran.data.entity.ProfileEntity;
import com.telran.data.entity.Role;
import com.telran.data.entity.UserEntity;
import com.telran.data.managers.UserManager;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class UserControllerImpl implements UserController {
    private UserManager manager;

    public UserControllerImpl(UserManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean changePassword(String email, String oldPassword, String newPassword) {
        return false;
    }

    @Override
    public boolean changePasswordForUser(String adminEmail, String userEmail, String newPassword) {
        return false;
    }

    @Override
    public List<UserEntity> getAllUsers(String adminEmail) {
        if (isAdmin(adminEmail)) {
            try {
                return manager.getAllUsers();
            } catch (IOException e) {
                e.printStackTrace();
                return Collections.emptyList();
            }
        }
        return Collections.emptyList();
    }

    @Override
    public boolean addUser(String adminEmail, UserEntity user) {
        Objects.requireNonNull(user);
        Objects.requireNonNull(adminEmail);
        if (isAdmin(adminEmail)) {
            ProfileEntity empty = new ProfileEntity.Builder().build();
            try {
                manager.addProfile(empty);
                UserEntity forSave = UserEntity.of(user.getEmail(),
                        user.getPassword(),
                        user.getRole(),
                        empty.getUuid());
                manager.addUser(forSave);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public UserEntity removeUser(String adminEmail, String userEmail) {
        return null;
    }

    @Override
    public boolean updateProfile(String email, ProfileEntity profile) {
        return false;
    }

    @Override
    public ProfileEntity removeProfileById(String adminEmail, String profileUuid) {
        return null;
    }

    @Override
    public ProfileEntity getProfileById(String adminEmail, String profileUuid) {
        return null;
    }

    private boolean isAdmin(String email) {
        Objects.requireNonNull(email);
        try {
            UserEntity user = manager.getUserByEmail(email);
            if (user.getRole() != Role.ADMIN) {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

package com.example.sensusapp.Model;

public class User {
    private int id_user;
    private String created_at;
    private String updated_at;
    private String name;
    private String username;
    private String password;
    private String email;
    private boolean is_active;
    private String role_id;
    private String kecamatan_id;
    private String desa_id;

    public User(int id_user, String created_at, String updated_at, String name, String username, String password, String email, boolean is_active, String role_id, String kecamatan_id, String desa_id) {
        this.id_user = id_user;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.is_active = is_active;
        this.role_id = role_id;
        this.kecamatan_id = kecamatan_id;
        this.desa_id = desa_id;
    }

    public User(int id_user, String username, String password, String kecamatan_id) {
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.kecamatan_id = kecamatan_id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getkecamatan_id() {
        return kecamatan_id;
    }

    public void setkecamatan_id(String kecamatan_id) {
        this.kecamatan_id = kecamatan_id;
    }

    public String getdesa_id() {
        return desa_id;
    }

    public void setdesa_id(String desa_id) {
        this.desa_id = desa_id;
    }
}

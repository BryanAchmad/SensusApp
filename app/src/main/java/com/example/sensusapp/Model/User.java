package com.example.sensusapp.Model;

public class User {
    private String id_user;
    private String created_at;
    private String updated_at;
    private String name;
    private String username;
    private String password;
    private String email;
    private String is_active;
    private String role_id;
    private String id_kecamatan;
    private String id_desa;

    public User(String id_user, String created_at, String updated_at, String name, String username, String password, String email, String is_active, String role_id, String id_kecamatan, String id_desa) {
        this.id_user = id_user;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.is_active = is_active;
        this.role_id = role_id;
        this.id_kecamatan = id_kecamatan;
        this.id_desa = id_desa;
    }

    public User(String id_user, String name, String username, String password, String email, String is_active, String role_id, String id_kecamatan, String id_desa) {
        this.id_user = id_user;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.is_active = is_active;
        this.role_id = role_id;
        this.id_kecamatan = id_kecamatan;
        this.id_desa = id_desa;
    }

    public User(String id_user, String name, String username, String password, String email) {
        this.id_user = id_user;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
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

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getId_kecamatan() {
        return id_kecamatan;
    }

    public void setId_kecamatan(String id_kecamatan) {
        this.id_kecamatan = id_kecamatan;
    }

    public String getId_desa() {
        return id_desa;
    }

    public void setId_desa(String id_desa) {
        this.id_desa = id_desa;
    }
}

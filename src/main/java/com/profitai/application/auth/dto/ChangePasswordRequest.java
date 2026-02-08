package com.profitai.application.auth.dto;

public record ChangePasswordRequest(String currentPassword, String newPassword) {
}

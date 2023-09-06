package dev.joaonovais.blog.dtos;

import java.time.Instant;

public record PostDTO(String title, Instant date, String content) {



}

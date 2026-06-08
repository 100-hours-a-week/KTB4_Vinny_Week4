package com.vinny.project.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserSummary {
    private String nickname;
    private String profileImageUrl;
}

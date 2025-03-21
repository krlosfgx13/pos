package com.project.pos.request;

import lombok.Builder;

@Builder
public class GetTokenRequest {
    private String userName;
    private String password;
}

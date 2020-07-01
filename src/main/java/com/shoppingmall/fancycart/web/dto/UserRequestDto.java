package com.shoppingmall.fancycart.web.dto;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import static com.shoppingmall.fancycart.utils.ExceptionUtils.INPUT_EXCEPTION_MESSAGE;

@Builder
@Getter
public class UserRequestDto {

    @Getter
    public static class Post {
        @NotBlank
        @Length(max = 50)
        private String name;
        @Email
        @Length(max = 50)
        private String email;
        @NotBlank
        @Length(max = 50, message = INPUT_EXCEPTION_MESSAGE)
        private String password;
        private Boolean agreeMessageByEmail;
        @NotBlank
        @Length(max = 100)
        private String roadAddr;
        @NotBlank
        @Length(max = 100)
        private String buildingName;
        @NotBlank
        @Length(max = 100)
        private String detailAddr;

        @Builder
        public Post(String name, String email, String password, Boolean agreeMessageByEmail,
                    String roadAddr, String buildingName, String detailAddr) {
            this.name = name;
            this.email = email;
            this.password = password;
            this.agreeMessageByEmail = agreeMessageByEmail;
            this.roadAddr = roadAddr;
            this.buildingName = buildingName;
            this.detailAddr = detailAddr;
        }
    }
}
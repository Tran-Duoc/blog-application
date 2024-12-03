package com.blog_app.rest_api.dto.request;

import com.blog_app.rest_api.enums.users.PostStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDTO implements Serializable {

    @NotBlank(message = "title must be not blank")
    private String title;

    @NotNull(message = "content must be not null")
    private String content;

    private String featuredImage;

    private  Integer user_id;

    private  Integer category_id;

    private  PostStatus status;
}

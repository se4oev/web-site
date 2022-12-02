package ru.se4oev.auth.data;

import lombok.Value;

/**
 * Created by karpenko on 02.12.2022.
 * Description:
 */
@Value
public class User {

    String clientId;
    String clientSecret;

}

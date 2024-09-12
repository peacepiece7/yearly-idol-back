package com.yearly.idol.api.yearly_idol.Common.annotation;

import jakarta.validation.Payload;

public @interface Password {
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    String regex() default "^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z]{8,20}"; // 전체
    String message() default "뭔가 잘못되었음을 감지함";

    String regexpLength() default "^{8,20}";
    String messageLength() default "8-20자 사이로";

    String regexpUpperCase() default "^[A-Z]{8,20}";
    String messageUpperCase() default "대문자 하나 이상";



    String regexpLowerCase() default "^[a-z]{8,20}";
    String messageLowerCase() default "소문자 하나 이상";

}

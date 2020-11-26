package com.keqi.springbootmvcparam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Border {

    // [{"latitude": "3214.14","longitude": "3214.14"}]

    private String latitude;

    private String longitude;
}

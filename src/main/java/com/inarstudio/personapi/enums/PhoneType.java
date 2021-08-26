package com.inarstudio.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {
    HOME("Home"),
    Mobile("Mobile"),
    COMMERCIAL  ("Commercial");

    private final String description;
}

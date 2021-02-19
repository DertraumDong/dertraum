package com.d.main.relation.model;

/**
 * 2021/2/19
 *
 * @author DerTraum
 * @since 1.0.0
 */
public enum HumanRelationType {
    FAMILY(0,"家人"),
    FRIENDS(1,"朋友"),
    RELATIVE(2,"亲戚"),
    CUSTOMER(3,"客户");

    private int type;
    private String value;

    HumanRelationType(int type, String value) {
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

}

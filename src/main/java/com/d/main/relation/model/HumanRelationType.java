package com.d.main.relation.model;

import java.util.HashMap;

/**
 * 2021/2/19
 *
 * @author DerTraum
 * @since 1.0.0
 */
public class HumanRelationType {
    private String humanId;
    private String tagType;

    private static HashMap<String,String> typeMap ;

    static{
        typeMap = new HashMap<>();
        HumanRelationTypeEnum[] humanRelationTypeEnums = HumanRelationTypeEnum.values();
        for (HumanRelationTypeEnum typeEnum:humanRelationTypeEnums) {
            System.out.println(typeEnum);
            typeMap.put(typeEnum.getType()+"",typeEnum.getValue());
        }
    }

    public static HashMap<String,String> getTypeMap(){
        return typeMap;
    }

    public String getHumanId() {
        return humanId;
    }

    public void setHumanId(String humanId) {
        this.humanId = humanId;
    }

    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

    public static boolean exsits(){

        return false;
    }

    public enum HumanRelationTypeEnum{
        FAMILY(0,"家人"),
        FRIENDS(1,"朋友"),
        RELATIVE(2,"亲戚"),
        CUSTOMER(3,"客户");

        private int type;
        private String value;

        HumanRelationTypeEnum(int type, String value) {
            this.type = type;
            this.value = value;
        }

        public int getType() {
            return type;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "HumanRelationTypeEnum{ " +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}

package com.keqi.seed;

/**
 * @author keqi
 */
public class BaseEnum<T extends BaseEnum> {

    private String code;

    private String codeName;

    public BaseEnum(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    protected String getCode() {
        return code;
    }

    protected void setCode(String code) {
        this.code = code;
    }

    protected String getCodeName() {
        return codeName;
    }

    protected void setCodeName(String codeName) {
        this.codeName = codeName;
    }

//    protected T parse(String code) {
//        return this.instances.get(code);
//    }
}

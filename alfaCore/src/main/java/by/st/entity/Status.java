package by.st.entity;

public enum Status {
    CLOSE(0),
    OPEN(1);

    private int code;

    Status(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static Status inEnum(int code){
        for (Status status : Status.values()){
            if (status.code == code){
                return status;
            }
        }
        throw new RuntimeException("Not found status ");
    }
}

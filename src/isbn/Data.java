package isbn;

public class Data {

    private String valid;
    private String invalid;
    private String illegal;

    public Data() {
    }

    public Data(String valid, String invalid, String illegal) {
        this.valid = valid;
        this.invalid = invalid;
        this.illegal = illegal;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getInvalid() {
        return invalid;
    }

    public void setInvalid(String invalid) {
        this.invalid = invalid;
    }

    public String getIllegal() {
        return illegal;
    }

    public void setIllegal(String illegal) {
        this.illegal = illegal;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s",valid,invalid,illegal);
    }

    public void clear(){
        illegal="";
        valid="";
        invalid="";
    }
}

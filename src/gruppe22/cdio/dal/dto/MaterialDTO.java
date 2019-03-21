package gruppe22.cdio.dal.dto;

public class MaterialDTO {
    private int id;
    private String material;

    public void setId(int id) {
        this.id = id;
    }

    public void setMaterial(String mat) {
        this.material = mat;
    }

    public String getMaterial() {return this.material; };

    public class DALException extends Exception {
        public DALException(String msg, Throwable e) {
            super(msg,e);
        }
        public DALException(String msg) {
            super(msg);
        }
    }
}

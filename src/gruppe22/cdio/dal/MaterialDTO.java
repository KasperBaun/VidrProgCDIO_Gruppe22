package gruppe22.cdio.dal;

public class MaterialDTO {
    private int id;
    private String material;

    class DALException extends Exception {
        public DALException(String msg, Throwable e) {
            super(msg,e);
        }
        public DALException(String msg) {
            super(msg);
        }
    }
}

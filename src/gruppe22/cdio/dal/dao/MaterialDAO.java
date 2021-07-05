package gruppe22.cdio.dal.dao;

import gruppe22.cdio.dal.DummyData;
import gruppe22.cdio.dal.User;
import gruppe22.cdio.dal.dto.MaterialDTO;
import gruppe22.cdio.dal.dto.UserDTO;

import java.io.IOException;

public class MaterialDAO implements IMaterialDAO {

    public MaterialDAO() throws IOException, ClassNotFoundException {
    }

    class DALException extends Exception {
        public DALException(String msg, Throwable e) {
            super(msg,e);
        }
        public DALException(String msg) {
            super(msg);
        }
    }

    private DummyData data = new DummyData();

    @Override
    public MaterialDTO getMaterial(int materialId) throws MaterialDTO.DALException {
        MaterialDTO material = data.getMaterial(materialId);
        return material;
    }
}

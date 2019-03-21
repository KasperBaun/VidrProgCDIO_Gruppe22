package gruppe22.cdio.business;

import gruppe22.cdio.dal.dao.IBatchDAO;
import gruppe22.cdio.dal.dto.MaterialDTO;
import gruppe22.cdio.dal.dto.UserDTO;

public interface IWeightLogic {
    MaterialDTO getMaterial(int batchId);

    void saveBatch(double tareweight, double netweight, double bruttoweight, int material, UserDTO user) throws IBatchDAO.DALException;
}

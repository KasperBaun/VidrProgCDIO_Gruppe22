package gruppe22.cdio.business;

import gruppe22.cdio.dal.dao.MaterialDAO;
import gruppe22.cdio.dal.dto.MaterialDTO;

import java.io.IOException;

public class WeightLogic implements IWeightLogic {
    private MaterialDAO materialDAO = new MaterialDAO();

    public WeightLogic() throws IOException, ClassNotFoundException {
    }

    @Override
    public MaterialDTO getMaterial(int batchId) {
        try {
            return materialDAO.getMaterial(batchId);
        } catch (MaterialDTO.DALException e) {
            e.printStackTrace();
        }
        return null;
    }
}

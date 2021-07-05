package gruppe22.cdio.business;

import gruppe22.cdio.dal.dao.BatchDAO;
import gruppe22.cdio.dal.dao.IBatchDAO;
import gruppe22.cdio.dal.dao.MaterialDAO;
import gruppe22.cdio.dal.dto.BatchDTO;
import gruppe22.cdio.dal.dto.MaterialDTO;
import gruppe22.cdio.dal.dto.UserDTO;

import java.io.IOException;
import java.time.LocalTime;

public class WeightLogic implements IWeightLogic {
    private MaterialDAO materialDAO = new MaterialDAO();
    private BatchDAO batchDAO = new BatchDAO();

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

    @Override
    public void saveBatch(double tareweight, double netweight, double bruttoweight, int material, UserDTO user) throws IBatchDAO.DALException {
        BatchDTO dto = new BatchDTO();
        dto.setTareWeight(tareweight);
        dto.setNetWeight(netweight);
        dto.setGrossWeight(bruttoweight);
        dto.setMaterial(getMaterial(material));
        dto.setDateTime(LocalTime.now());
        dto.setOperator(user);
        batchDAO.createBatch(dto);
    }
}

package gruppe22.cdio.dal.dao;

import gruppe22.cdio.dal.dto.BatchDTO;

public interface IBatchDAO {
    BatchDTO getBatch(int batchId) throws IBatchDAO.DALException;

    void createBatch(BatchDTO batch) throws IBatchDAO.DALException;
    void updateBatch(BatchDTO batch) throws IBatchDAO.DALException;
    void deleteBatch(BatchDTO batch) throws IBatchDAO.DALException;

    class DALException extends Exception {
        public DALException(String msg, Throwable e) {
            super(msg,e);
        }
        public DALException(String msg) {
            super(msg);
        }
    }
}

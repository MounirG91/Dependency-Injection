package metier;

import dao.DaoImpl;
import dao.IDao;

public class MetierImpl implements IMetier {
    private IDao dao;

    public void setDao(IDao dao) {
        this.dao = dao;
    }

    public double calcul(){
        return dao.getValue() * 2;
    }
}

package extension;

import dao.IDao;

public class DaoImplV2 implements IDao {
    public double getValue() {
        return 80;
    }

    // Si on veut ajouter ici d'autres méthodes, c à d que ce n'est plus un problème d'implémentation
    // Mais plutôt un problème de conception


    // Maintenant dans config.txt, on met ext.DaoImplV2
}

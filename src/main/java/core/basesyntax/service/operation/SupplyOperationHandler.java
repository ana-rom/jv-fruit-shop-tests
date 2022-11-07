package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public SupplyOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void getOperation(FruitTransaction fruitTransaction) {
        Fruit fruitFromDb = fruitDao.get(fruitTransaction);
        fruitDao.update(fruitTransaction,
                fruitFromDb.getAmountInShop() + fruitTransaction.getQuantity());
    }
}
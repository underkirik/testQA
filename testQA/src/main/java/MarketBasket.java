import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MarketBasket implements Basket{

    private HashMap<String, Integer> products;

    @Override
    public void addProduct(String product, int quantity) {
        products.put(product, quantity);
    }

    @Override
    public void removeProduct(String product) {
        products.remove(product);
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        if (!products.containsKey(product)){
            throw new IllegalArgumentException("This product don't exist");
        }else {
            addProduct(product, quantity);
        }
    }

    @Override
    public void clear() {
        products.clear();
    }

    @Override
    public List<String> getProducts() {
        List<String> productNames = new ArrayList<>();
        products.keySet().forEach(productNames::add);
        return productNames;
    }

    @Override
    public int getProductQuantity(String product) {
        return products.get(product);
    }
}

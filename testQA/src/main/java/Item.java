import java.util.Objects;

public class Item {
    private int weight;
    private int cost;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return weight == item.weight && cost == item.cost;
    }
}

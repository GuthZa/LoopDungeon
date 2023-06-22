package main.models;

public class GameItem {
    public enum ItemCategory {
        Miscellaneous,
        Weapon,
        Consumable
    }

    public ItemCategory Category;

    String Name;
    int ItemID;

    public GameItem(ItemCategory category, int itemID, String name) {
        this.Category = category;
        this.Name = name;
        this.ItemID = itemID;
    }

    public String getName() { return this.Name; }
    public int getItemID() { return this.ItemID; }
    public ItemCategory getCategory() { return this.Category; }
}

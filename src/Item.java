public class Item {
    private String name;
    private int weight;

    public Item(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    //Setters and Getters
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public int getWeight(){
        return this.weight;
    }
}

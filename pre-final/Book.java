public class Book {
    private String name;
    private douvle price;
    private String type;

    public Book(){
        this("", 0.0, "");
    }
    public Book(String name, double price, String type){
            this.name = name;
            this.price = price;
            this.type = type;
    }
}

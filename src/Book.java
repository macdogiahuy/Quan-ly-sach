class Book {
  String id;
  String title;
  String author;
  int quantity;

  // Constructor
  public Book(String id, String title, String author, int quantity) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.quantity = quantity;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  // Phương thức toString để in thông tin sách
  @Override
  public String toString() {
    return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Quantity: " + quantity;
  }
}
package main.products;

public class Book extends Product
{
        private String author;

        public Book()
        {
                author = "";
        }

        public void setAuthor(String author)
        {
                this.author = author;
        }

        public String getAuthor()
        {
                return author;
        }

        public String toString()
        {
                String s;
                s = super.toString();
                return (s + "Author:     " + author + "\n");
        }


}


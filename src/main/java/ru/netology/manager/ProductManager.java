package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add (Product item){
        repository.save (item);
    }

    public Product[] searchBy(String text)  {
        Product[] result = new Product[0];
        for (Product product: repository.findAll()) {
            if (this.matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                //result = new Product[tmp.length];
                //System.arraycopy(tmp, 0, result, 0, tmp.length);
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product item, String search) {
        if (item.getName().contains(search)) {
            return true;
        }
        if (item instanceof Book) {
            Book book = (Book) item;
            if (book.getAuthor().contains(search)) {
                return true;
            }
        }
        if (item instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) item;
            if (smartphone.getCompany().contains(search)) {
                return true;
            }
        }
        return false;
    }
}

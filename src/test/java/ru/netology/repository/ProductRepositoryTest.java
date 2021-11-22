package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    @Test
    void shouldRemoveById() {
        Book book1 = new Book(1,"Name", 100, "A");
        Book book2 = new Book(2,"B", 100, "B");
        Smartphone smartphone1 = new Smartphone(3,"C", 100, "D");
        Smartphone smartphone2 = new Smartphone(4,"A", 100, "s");
        repository.save(book1);
        repository.save(book2);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.removeById(1);
    }

    @Test
    void shouldRemoveByIdNotFound() {
        Book book1 = new Book(1,"Name", 100, "A");
        Book book2 = new Book(2,"B", 100, "B");
        Smartphone smartphone1 = new Smartphone(3,"C", 100, "D");
        Smartphone smartphone2 = new Smartphone(4,"A", 100, "s");
        repository.save(book1);
        repository.save(book2);
        repository.save(smartphone1);
        repository.save(smartphone2);
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(5);
        });
    }
}
package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book book1 = new Book(1, "Name", 100, "A");
    Book book2 = new Book(2, "B", 100, "B");
    Book book3 = new Book(3, "Kk", 100, "A");
    Smartphone smartphone1 = new Smartphone(3, "C", 100, "D");
    Smartphone smartphone2 = new Smartphone(4, "D", 100, "s");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    void shouldCheckSearchBookByAuthor() {
        Product[] expected = {book1, book3};
        Product[] actual = manager.searchBy("A");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldCheckSearchSmartphoneByCompany() {
        Product[] expected = {smartphone2};
        Product[] actual = manager.searchBy("s");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldCheckNotFound() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("G");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldCheckSearchBookByName() {
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Name");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldCheckSearchSmartphoneByName() {
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("C");
        assertArrayEquals(expected, actual);
    }
}

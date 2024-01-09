package com.example.bookstoremvc.controller;

import com.example.bookstoremvc.ds.CartItem;
import com.example.bookstoremvc.entity.Book;
import com.example.bookstoremvc.entity.BookStatus;
import com.example.bookstoremvc.service.BookService;
import com.example.bookstoremvc.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class BookStoreController {

    private final BookService bookService;
    private final CartService cartService;

    @GetMapping("/remove-cart-item")
    public String removeCartItem(@RequestParam("id") int id){
        cartService.removeCartItem(id);
        return "redirect:/view-cart";
    }

    @GetMapping("/list-all-books")
    public ModelAndView listBestSellers(@RequestParam("status") String status){
        BookStatus bookStatus = null;
        if (status.equalsIgnoreCase("bestsellers")){
            bookStatus =BookStatus.BESTSELLER;
        } else if (status.equalsIgnoreCase("recommended")) {
            bookStatus = BookStatus.RECOMMENDED;
        } else if (status.equalsIgnoreCase("promotions")){
            bookStatus = BookStatus.PROMOTION;
        } else if (status.equalsIgnoreCase("new")) {
            bookStatus = BookStatus.NEW;
        }

        List<Book> books = getBookByBookStatus(bookStatus);
        if (books.isEmpty()){

            return new ModelAndView("listbooks",
                    "books", Collections.emptyList());
        }
        else {
            return new ModelAndView("listbooks",
                    "books",books
            );
        }
    }

    private List<Book> getBookByBookStatus(BookStatus status) {
        return bookService.searchBookByBookStatus(status);
    }

    @GetMapping("/view-cart")
    public String viewCart(@ModelAttribute("cartItems") Set<CartItem> cartItems, Model model){
        model.addAttribute("cartItems", cartItems);
        return "viewCart";
    }

    @GetMapping("/add-to-cart") //details
    public String addToCart(@RequestParam("id") int id){
        cartService.addToCart(id);
        return "redirect:/book-details?id=" + id;
    }

    @GetMapping("/add-to-cart-index")
    public String addToCartIndex(@RequestParam("id") int id){
        cartService.addToCart(id);
        return "redirect:/";
    }

    @GetMapping("/add-to-cart-more")
    public String addToCartMore(@RequestParam("id")int id){
        cartService.addToCart(id);
        Book book = bookService.findBookById(id);
        return "redirect:/list-all-books?status="+ book.getBookStatus().name();
    }

    @GetMapping("/book-details")
    public String bookDetails(@RequestParam("id") int id, Model model){
        model.addAttribute("book", bookService.findBookById(id));
        return "bookDetails";
    }

    @GetMapping({"/", "/home"})
    public String landingPage(Model model){
        Set<Book> bestSellersBooks = getBookByBookStatus(BookStatus.BESTSELLER)
                        .stream()
                                .limit(3)
                                        .collect(Collectors.toSet());
        Set<Book> promotions = getBookByBookStatus(BookStatus.PROMOTION)
                .stream()
                        .limit(3)
                                .collect(Collectors.toSet());

        Set<Book> recommendeds =getBookByBookStatus(BookStatus.RECOMMENDED)
                .stream()
                .limit(3)
                        .collect(Collectors.toSet());
        Set<Book> newBooks =getBookByBookStatus(BookStatus.NEW)
                .stream()
                .limit(3)
                .collect(Collectors.toSet());

        model.addAttribute("recommendeds", recommendeds);
        model.addAttribute("bestSellers", bestSellersBooks);
        model.addAttribute("news",newBooks);
        if (promotions.isEmpty()){
            model.addAttribute("promotions", Collections.emptyList());
        }else {
            model.addAttribute("promotions", promotions);
        }
        return "index";
    }

    @ModelAttribute("cartSize")
    public Integer cartSize(){
        return cartService.cartSize();
    }

    @ModelAttribute("cartItems")
    public Set<CartItem> listCartItems(){
        return cartService.listCartItems();
    }

    @ModelAttribute("total")
    public Double totalPrice(){
        return cartService.listCartItems()
                .stream()
                .map(c -> c.getPrice())
                .mapToDouble(d -> d)
                .sum();
    }

}

package com.elect.service.impl;

import com.elect.dao.BookDao;
import com.elect.dao.ProductDao;
import com.elect.entity.Book;
import com.elect.entity.Product;
import com.elect.factory.DaoFactory;
import com.elect.service.MainService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainServiceImpl implements MainService {

//    注入相应dao对象
    private BookDao bookDao= (BookDao) DaoFactory.getDaoImpl("BookDao");
    private ProductDao productDao= (ProductDao) DaoFactory.getDaoImpl("ProductDao");
    @Override
    public List<Book> recommend() throws Exception {
        List<Book> list=new ArrayList<Book>();
        List<Book> books=bookDao.findBookAll();
        List<Product> products=productDao.findAll();
        while(true){
            int index=new Random().nextInt(books.size());
            books.get(index).setProduct(products.get(index));
            if(!list.contains(books.get(index))) {
                list.add(books.get(index));
            }
            if(list.size()==2){
                break;
            }
        }
        return list;
    }

    @Override
    public List<Product> hotBook() throws Exception {
        List<Product> list=new ArrayList<Product>();
        List<Product> products=productDao.findAll();
        while(true){
            int index=new Random().nextInt(products.size());
            if(!list.contains(products.get(index))) {
                list.add(products.get(index));
            }
            if(list.size()==4){
                break;
            }
        }
        return list;
    }

    @Override
    public List<Product> newBook() throws Exception {
        List<Product> list=new ArrayList<Product>();
        List<Product> products=productDao.findAll();
        while(true){
            int index=new Random().nextInt(products.size());
            Product product=products.get(index);
            if(!list.contains(product)) {
                list.add(products.get(index));
            }
            if(list.size()==4){
                break;
            }
        }
        return list;
    }

}

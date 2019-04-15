package com.elect.service.impl;

import com.elect.dao.BookDao;
import com.elect.dao.CategoryDao;
import com.elect.dao.ProductDao;
import com.elect.entity.Book;
import com.elect.entity.Category;
import com.elect.entity.Product;
import com.elect.factory.DaoFactory;
import com.elect.service.MainService;

import java.util.*;

public class MainServiceImpl implements MainService {

//    注入相应dao对象
    private BookDao bookDao= (BookDao) DaoFactory.getDaoImpl("BookDao");
    private ProductDao productDao= (ProductDao) DaoFactory.getDaoImpl("ProductDao");
    private CategoryDao categoryDao= (CategoryDao) DaoFactory.getDaoImpl("CategoryDao");
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

    @Override
    public List<Book> bookList() throws Exception {
        List<Book> list=new ArrayList<Book>();
        List<Book> books=bookDao.findBookAll();
        List<Product> products=productDao.findAll();
        for(int i=0;i<books.size();i++){
            books.get(i).setProduct(products.get(i));
            list.add(books.get(i));
        }
        return list;
    }

    @Override
    public Map<String,List<Category>> Category() throws Exception {
        Map<String,List<Category>> categoryMap=new HashMap<>();
        List<Category> list=categoryDao.findByParentId(1);
        for(int i=0;i<list.size();i++){
            List<Category> classify=categoryDao.findByParentId(i+2);
            categoryMap.put(list.get(i).getName(),classify);
        }
        return categoryMap;
    }

}

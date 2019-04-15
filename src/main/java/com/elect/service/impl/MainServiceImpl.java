package com.elect.service.impl;

import com.elect.dao.BookDao;
import com.elect.dao.CategoryDao;
import com.elect.dao.CategoryProductDao;
import com.elect.dao.ProductDao;
import com.elect.dao.impl.CategoryProductDaoImpl;
import com.elect.entity.Book;
import com.elect.entity.Category;
import com.elect.entity.Category_product;
import com.elect.entity.Product;
import com.elect.factory.DaoFactory;
import com.elect.service.MainService;

import java.util.*;

public class MainServiceImpl implements MainService {

//    注入相应dao对象
    private BookDao bookDao= (BookDao) DaoFactory.getDaoImpl("BookDao");
    private ProductDao productDao= (ProductDao) DaoFactory.getDaoImpl("ProductDao");
    private CategoryDao categoryDao= (CategoryDao) DaoFactory.getDaoImpl("CategoryDao");
    private CategoryProductDao categoryProductDao= (CategoryProductDao) DaoFactory.getDaoImpl("CategoryProductDao");
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
        Map<String,List<Category>> categoryMap=new LinkedHashMap<>();
        List<Category> list=categoryDao.findByParentId(1);
        for(int i=0;i<list.size();i++){
            List<Category> classify=categoryDao.findByParentId(i+2);
            for (int j=0;j<classify.size();j++){
                List<Category_product> category_products=categoryProductDao.findByCatId(classify.get(j).getId());
                classify.get(j).setCategory_products(category_products);
            }
            categoryMap.put(list.get(i).getName(),classify);
        }
        return categoryMap;
    }

    @Override
    public List<Book> CateList(int id) throws Exception {
        List<Book> list=new ArrayList<Book>();
        List<Category_product> category_products =categoryProductDao.findByCatId(id);
        System.out.println(category_products);
        for(int i=0;i<category_products.size();i++) {
            Book book = bookDao.findBookById(category_products.get(i).getProduct_id());
            System.out.println(book);
            Product product = productDao.findById(category_products.get(i).getProduct_id());
            System.out.println(product);
            book.setProduct(product);
            list.add(book);
        }
        return list;
    }

}

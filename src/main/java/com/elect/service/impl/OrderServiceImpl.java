package com.elect.service.impl;

import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.elect.dao.AddressDao;
import com.elect.dao.ItemDao;
import com.elect.dao.OrderDao;
import com.elect.entity.Cart;
import com.elect.entity.Item;
import com.elect.entity.Order;
import com.elect.entity.Receive_address;
import com.elect.factory.DaoFactory;
import com.elect.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao= (OrderDao) DaoFactory.getDaoImpl("OrderDao");
    private ItemDao itemDao= (ItemDao) DaoFactory.getDaoImpl("ItemDao");
    private AddressDao addressDao= (AddressDao) DaoFactory.getDaoImpl("AddressDao");

    @Override
    public int addOrder(List<Cart> carts,Order order) throws Exception {
        double total_price=0;
        for(Cart c:carts){
            total_price+=c.getDang_price()*c.getProduct_num();
        }
        int user_id=carts.get(0).getUser_id();
        String order_time=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());
        order.setUser_id(user_id);
        order.setTotal_price(total_price);
        order.setOrder_time(order_time);
        int order_id=orderDao.addOrder(order);
        return order_id;
    }

    @Override
    public void addItem(List<Cart> carts, int order_id) throws Exception {
        for(Cart c:carts){
            Item item=new Item(order_id,c.getProduct_id(),c.getProduct_name(),c.getDang_price(),c.getProduct_num(),c.getDang_price()*c.getProduct_num());
            itemDao.addItem(item);
        }
    }

    @Override
    public Order findOrder(int order_id) throws Exception {
        Order order=orderDao.findByOrderId(order_id);
        List<Item> items=itemDao.findByOrderId(order_id);
        order.setItems(items);
        return order;
    }

    @Override
    public void addAddress(Receive_address receive_address) throws Exception {
        List<Receive_address> list=addressDao.findByUserId(receive_address.getUser_id());
        if(!list.contains(receive_address)) {
            addressDao.addAddress(receive_address);
        }
    }

    @Override
    public List<Receive_address> findAllAddress(int user_id) throws Exception{
        List<Receive_address> list=addressDao.findByUserId(user_id);
        return list;
    }

    @Override
    public Receive_address findAddress(int id) throws Exception {
        Receive_address receive_address=addressDao.findById(id);
        return receive_address;
    }


}

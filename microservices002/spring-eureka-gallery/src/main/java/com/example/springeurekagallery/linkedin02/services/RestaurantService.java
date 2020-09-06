package com.example.springeurekagallery.linkedin02.services;

import com.example.springeurekagallery.linkedin02.entities.Restaurant;
import com.example.springeurekagallery.linkedin02.repositories.ReadOnlyRepository;
import com.example.springeurekagallery.linkedin02.repositories.Repository;
import com.example.springeurekagallery.linkedin02.repositories.RestaurantRepository;

import java.math.BigInteger;
import java.util.Collection;

public class RestaurantService extends BaseService<Restaurant, BigInteger> {

    private final RestaurantRepository<Restaurant, BigInteger> restaurantRepository;

    public RestaurantService(ReadOnlyRepository<Restaurant, BigInteger> repository, Repository<Restaurant, BigInteger> _repository, RestaurantRepository<Restaurant, BigInteger> restaurantRepository) {
        super(repository, _repository);
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void add(Restaurant entity) throws Exception {
        super.add(entity);
    }

    @Override
    public Collection<Restaurant> getAll() {
        return super.getAll();
    }
}

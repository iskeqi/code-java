package com.keqi.tdenginemybatisconnector.service;

import com.keqi.tdenginemybatisconnector.dao.WeatherMapper;
import com.keqi.tdenginemybatisconnector.domain.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {

    @Autowired
    private WeatherMapper weatherMapper;

    public boolean init() {
        weatherMapper.createDB();
        weatherMapper.createTable();
        return true;
    }

    public List<Weather> query(Long limit, Long offset) {
        return weatherMapper.select(limit, offset);
    }

    public int save(int temperature, float humidity) {
        Weather weather = new Weather();
        weather.setTemperature(temperature);
        weather.setHumidity(humidity);

        return weatherMapper.insert(weather);
    }

    public int save(List<Weather> weatherList) {
        return weatherMapper.batchInsert(weatherList);
    }

}
